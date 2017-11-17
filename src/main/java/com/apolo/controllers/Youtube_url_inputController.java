/*http://www.c-sharpcorner.com/blogs/youtube-downloader-in-java*/
package com.apolo.controllers;

import com.apolo.actions.mp3_decoder;
import com.gluonhq.particle.application.ParticleApplication;
import com.gluonhq.particle.view.ViewManager;
import javafx.fxml.FXML;
import javax.inject.Inject;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URLDecoder;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.net.URL;
import javafx.scene.control.ProgressBar;
import javax.swing.JOptionPane;

public class Youtube_url_inputController {

    @Inject
    ParticleApplication app;

    @Inject
    private ViewManager viewManager;

    @FXML
    private Button downloadBtn, main;

    @FXML
    private TextField youtubeUrlField;

    @FXML
    private ProgressBar pbar;

    private URL downloadURL;

    private String songtitle = "";

    public void initialize() {
        youtubeUrlField.setText("");
    }

    public void postInit() {
        main.setOnAction(e -> viewManager.switchView("main"));

        /*Event is triggered when we press the download button*/
        downloadBtn.setOnAction(e -> {
            sendHTTPRequest.restart();
        });

        /*Event is triggered when the sendHTTP request service completed successfully*/
        sendHTTPRequest.setOnSucceeded((WorkerStateEvent we) -> {
            try {
                //System.setProperty("http.agent", "Chrome");
                downloadURL = new URL(getURLS(sendHTTPRequest.getValue()));
                System.out.println(sendHTTPRequest.getValue() + "~~~~~~");
                //pbar.progressProperty().unbind();
                pbar.setProgress(0);
                pbar.progressProperty().bind(VideoDownload.progressProperty());
                pbar.setVisible(true);
                //System.out.println("YO");
                /*if everything goes right then it will start a new service to download the video*/
                VideoDownload.restart();

            } catch (MalformedURLException ex) {
                JOptionPane.showMessageDialog(null, "Invalid Url or Copyright problem", "Message from Youtube Downloader", JOptionPane.ERROR_MESSAGE);
                System.out.println("GOD!!!!");
                downloadBtn.setDisable(true);
            }
        });

        /*Event is fired when videDownload service is completed successfully*/
        VideoDownload.setOnSucceeded((WorkerStateEvent we) -> {
            boolean val = VideoDownload.getValue();
            System.out.println(val);
            if (val) {
                JOptionPane.showMessageDialog(null, "Download complete", "Message from Youtube Downloader", JOptionPane.INFORMATION_MESSAGE);
                viewManager.switchView("main");
            } else {
                JOptionPane.showMessageDialog(null, "Download Failed", "Message from Youtube Downloader", JOptionPane.ERROR_MESSAGE);
                downloadBtn.setDisable(true);
            }
            pbar.setVisible(false);
        });

    }

    public void dispose() {
        //dbcn();
    }

    /*
    private void dbcn() {
        DBconnection db = new DBconnection();
        db.loadProperties();
        String driver = db.getProperties("driver");
        String url = db.getProperties("url");
        String user = db.getProperties("username");
        String password = db.getProperties("password");
        try {
            Class.forName(driver);
            Connection conn
                    = DriverManager.getConnection(url,
                            user, password);
            if (conn != null && !conn.isClosed()) {
                System.out.println("Connected !");
                conn.close();
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Can't find driver !");
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     */
    private String getVideoTitle(String infoData) throws UnsupportedEncodingException {
        String title = "";
        int start = infoData.indexOf("&title=") + 7;
        title = infoData.substring(start, infoData.indexOf("&", start));
        return URLDecoder.decode(title, "UTF-8");
    }

    /*Method to extract the video id from the url. 
    if the url does not contain 'v=' parameter 
    then it will not work. It will accept only 
    standard url*/
    private String getVideoID(String url) {
        int index = url.indexOf("v=");
        String id = "";
        index += 2;
        for (int i = index; i < url.length(); i++) {
            id += url.charAt(i);
        }
        return id;
    }
    /*This service send the HTTP Request to the youtube server. In response the youtube server 
    sends the video information. This information contains the url in the encoded format. This 
    method decode the url return it as a StringBuilder Object*/
    final private Service< StringBuilder> sendHTTPRequest = new Service< StringBuilder>() {
        @Override
        protected Task< StringBuilder> createTask() {
            return new Task< StringBuilder>() {
                @Override
                protected StringBuilder call() {
                    String response;
                    StringBuilder res = new StringBuilder();
                    StringBuilder refinedres = new StringBuilder();
                    try {
                        URL url = new URL("https://www.youtube.com/get_video_info?&video_id=" + getVideoID(youtubeUrlField.getText()));
                        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                        conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
                        System.out.println(url.toString() + " ~~~~sendHTTPRequest");

                        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                        if (in.ready()) {
                            while ((response = in.readLine()) != null) {
                                System.out.println("readLine() can read~");
                                res.append(response);
                            }
                        }
                        songtitle = getVideoTitle(res.toString()).replace("|", "").replace("?", "");
                        System.out.println(songtitle);

                        refinedres.append(URLDecoder.decode(URLDecoder.decode(res.toString(), "UTF-8"), "UTF-8"));
                        //System.out.println(refinedres.toString());
                        in.close();
                        return refinedres;
                    } catch (MalformedURLException ex) {
                        System.out.println("sendHTTPRequest~" + ex);
                        downloadBtn.setDisable(true);
                    } catch (IOException ex) {
                        System.out.println("sendHTTPRequest~" + ex);
                        downloadBtn.setDisable(true);
                    }
                    return null;
                }
            };
        }
    };
    /*This service will download the videos using the URL*/
    Service< Boolean> VideoDownload = new Service< Boolean>() {
        @Override
        protected Task< Boolean> createTask() {
            return new Task< Boolean>() {
                @Override
                protected Boolean call() throws Exception {
                    long length;
                    boolean completed = false;
                    int count = 0;//youtubeUrlField.getText().concat(".mp3"))
                    HttpURLConnection httpcon = (HttpURLConnection) downloadURL.openConnection();
                    httpcon.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
                    try (BufferedInputStream bis = new BufferedInputStream(httpcon.getInputStream()); FileOutputStream fos = new FileOutputStream("songlist\\" + songtitle + ".mp3")) {
                        length = downloadURL.openConnection().getContentLength();
                        int i = 0;
                        final byte[] data = new byte[1024];
                        while ((count = bis.read(data)) != -1) {
                            i += count;
                            fos.write(data, 0, count);
                            updateProgress(i, length);
                        }
                        completed = true;
                        /*System.out.println("start");
                        mp3_decoder mp3 = new mp3_decoder();
                        mp3.mp3_decoder_to_Frequency(songtitle);
                        System.out.println("end");*/
                    } catch (IOException ex) {
                        System.out.println("VideoDownload~" + ex);
                    }
                    return completed;
                }
            };
        }
    };

    /*This methid receives refined response as a paramter and extract the url from the 
    response which will be used to download the video from the youtube*/
    private String getURLS(StringBuilder response) {

        StringBuilder temp1 = new StringBuilder("");
        String[] temp2, temp3;

        int guess = 0;
        try {
            int index = response.indexOf("url_encoded_fmt_stream_map");

            for (int i = index; i < response.length(); i++) {
                temp1.append(response.charAt(i));
            }
            //System.out.println(response.length());
            System.out.println("YYYYYYYYY");
            temp2 = (temp1.toString()).split("url=");
            for (int i = temp2.length - 1; i >= 0; i--) {
                guess = temp2[i].indexOf("video/3gpp");
                if (guess != -1) {
                    guess = i;
                    break;
                }
            }
            /*System.out.println(guess);
            System.out.println(temp2[guess]);*/

            /*String show_split_line = "";
            for (String s : temp2) {
                show_split_line = show_split_line + "[" + s + "]\n";
            }
            System.out.println(show_split_line);*/
            temp3 = temp2[guess].split(";");
            System.out.println(temp3[0]);
            return temp3[0];
        } catch (Exception e) {
            Alert msg = new Alert(Alert.AlertType.INFORMATION);
            msg.setTitle("Message form youtube Downloader");
            msg.setContentText("Error in downloading");
            msg.showAndWait();
            System.out.println("getURLS~" + e);
            downloadBtn.setDisable(true);
        }
        return null;
    }
}
