package com.apolo.controllers;

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
        main.setOnAction(e -> viewManager.switchView("main"));

    }

    public void postInit() {
        youtubeUrlField.setText("");
        /*Event is triggered when we press the download button*/
        downloadBtn.setOnAction(e -> {
            sendHTTPRequest.restart();
        });

        /*Event is triggered when the sendHTTP request service completed successfully*/
        sendHTTPRequest.setOnSucceeded((WorkerStateEvent we) -> {
            try {
                downloadURL = new URL(getURLS(sendHTTPRequest.getValue()));
                System.out.println(downloadURL);
                pbar.progressProperty().unbind();
                pbar.setProgress(0);
                pbar.progressProperty().bind(VideoDownload.progressProperty());
                pbar.setVisible(true);
                //System.out.println("YO");
                /*if everything goes right then it will start a new service to download the video*/
                VideoDownload.restart();

            } catch (MalformedURLException ex) {
                JOptionPane.showMessageDialog(null, "Invalid Ur", "Message from Youtube Downloader", JOptionPane.ERROR_MESSAGE);
                System.out.println("GOD!!!!");
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
            }
            pbar.setVisible(false);
        });
    }

    public void dispose() {

    }

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
                        System.out.print(url.toString() + " ");
                        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                        conn.setRequestMethod("GET");
                        System.out.println(conn.getResponseMessage());
                        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                        while ((response = in.readLine()) != null) {
                            res.append(response);
                        }
                        songtitle = getVideoTitle(res.toString());
                        System.out.println(songtitle);
                        refinedres.append(URLDecoder.decode(URLDecoder.decode(res.toString(), "UTF-8"), "UTF-8"));
                        in.close();
                        return refinedres;
                    } catch (MalformedURLException ex) {
                    } catch (IOException ex) {
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
                    try (BufferedInputStream bis = new BufferedInputStream(downloadURL.openStream()); FileOutputStream fos = new FileOutputStream("songlist/"+songtitle+".mp3")) {
                        length = downloadURL.openConnection().getContentLength();
                        int i = 0;
                        final byte[] data = new byte[1024];
                        while ((count = bis.read(data)) != -1) {
                            i += count;
                            fos.write(data, 0, count);
                            updateProgress(i, length);
                        }
                        completed = true;
                    } catch (IOException ex) {
                    }
                    return completed;
                }
            };
        }
    };

    /*This methid receives refined response as a paramter and extract the url from the 
    response which will be used to download the video from the youtube*/
    private String getURLS(StringBuilder response) {
        StringBuilder temp1 = new StringBuilder();
        String[] temp2, temp3, temp4;
        try {
            int index = response.indexOf("url_encoded_fmt_stream_map");
        
            for (int i = index; i < response.length(); i++) {
                temp1.append(response.charAt(i));
            }
            temp2 = temp1.toString().split("&url=");
            if (temp2.length > 0) {
                temp3 = temp2[1].split(";");
                if (temp3.length > 0) {
                    temp4 = temp3[0].split(",");
                    if (temp4.length > 0) {
                        return temp4[0];
                    } else {
                        return temp3[0];
                    }
                } else {
                    return temp2[1];
                }
            }
        } catch (Exception e) {
            Alert msg = new Alert(Alert.AlertType.INFORMATION);
            msg.setTitle("Message form youtube Downloader");
            msg.setContentText("Error in downloading");
            msg.showAndWait();
        }
        return null;
    }
}
