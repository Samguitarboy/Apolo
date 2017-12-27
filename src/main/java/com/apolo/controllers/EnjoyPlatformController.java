package com.apolo.controllers;

import com.apolo.config;
import com.gluonhq.particle.view.ViewManager;
import com.mysql.jdbc.Connection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.fxml.FXML;
import javafx.scene.web.WebView;
import javafx.scene.web.WebEngine;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javax.inject.Inject;
import org.json.JSONObject;

public class EnjoyPlatformController {

    private String dloadurl;
    private String videoid;
    @Inject
    private ViewManager viewManager;

    @FXML
    private Button backtomain, download;

    @FXML
    private ResourceBundle resources;

    @FXML
    private TextField website, url;

    @FXML
    private WebView web;

    private WebEngine engine;

    public void initialize() {
    }

    public void postInit() {
        engine = web.getEngine();
        engine.load("https://www.youtube.com");
        website.setText("");
        backtomain.setOnAction(e -> {
            //engine.reload();
            viewManager.switchView("main");
        });

        download.setOnAction(e -> {
            String[] temp;
            temp = website.getText().split("v=");

            /*engine.loadContent("<iframe class=\"button-api-frame\" src=\"https://downloadmp.org/@api/button/videos/" + temp[1] + "\" width=\"100%\" height=\"100%\" allowtransparency=\"true\" scrolling=\"no\" style=\"border:none\"></iframe>\n"
                    + "\n"
                    + "<!-- Optional script that automatically makes iframe content responsive. -->\n"
                    + "<script src=\"https://cdnjs.cloudflare.com/ajax/libs/iframe-resizer/3.5.14/iframeResizer.min.js\"></script>\n"
                    + "<script>iFrameResize({}, '.button-api-frame');</script>");
            System.out.println(temp[1]);*/
            try {
                URL url = new URL("https://downloadmp.org/@api/json/videos/" + temp[1]);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
                con.setRequestMethod("GET");
                con.setConnectTimeout(5000);
                con.setReadTimeout(5000);
                int status = con.getResponseCode();
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer content = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
                System.out.println(unicodeToString(content.toString()));
                String jsonresult = unicodeToString(content.toString());
                songtoDB(dloadstring(jsonresult));

                in.close();
                con.disconnect();

            } catch (MalformedURLException urlex) {
                System.out.println(urlex);
            } catch (ProtocolException pex) {
                System.out.println(pex);
            } catch (IOException ioex) {
                System.out.println(ioex);
            }

            System.out.println(dloadurl);
            url.setText("https:" + dloadurl);
        });
    }

    public void dispose() {

    }

    public String dloadstring(String jsonresult) {
        JSONObject obj = new JSONObject(jsonresult);
        videoid = obj.getString("vidID");
        String title = obj.getString("vidTitle");
        JSONObject info = (JSONObject) obj.get("vidInfo");
        //String type = info.getString("ftype");
        //System.out.println(title);
        //System.out.println("info: " + info);
        for (int i = 0; i < 3; i++) {
            JSONObject pass = (JSONObject) info.get("" + i);
            //System.out.println(pass);
            String type = pass.getString("ftype");

            if (type.equals("mp4")) {
                dloadurl = pass.getString("dloadUrl");
            }
            break;
        }
        System.out.println(dloadurl);
        System.out.println(title);
        return title;
    }

    private void songtoDB(String title) {
        try {
            Connection conn = null;
            Statement stmt = null;
            ResultSet rs = null;

            config con = new config();
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://" + con.getUrlstr() + "/" + con.getDBName() + "?user=" + con.getUserstr() + "&password=" + con.getPw());
            System.out.println("Database Connection !");
            stmt = conn.createStatement();
            System.out.println(videoid);
            /*String insertsong = "insert into Songlist values(N'" + title + "',null,CURRENT_DATE,'" + videoid + "')";
            stmt.executeUpdate(insertsong);*/
            String SQL = "select * from Songlist";
            rs = stmt.executeQuery(SQL);

            ResultSetMetaData metaData = rs.getMetaData();
            int numCol = metaData.getColumnCount();
            while (rs.next()) {
                for (int i = 1; i <= numCol; i++) {
                    System.out.print("\t\t" + rs.getObject(i));
                }
                System.out.println();
            }
            System.out.println();
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException sqlex) {
            sqlex.printStackTrace();
        }
    }

    public static String unicodeToString(String str) {

        Pattern pattern = Pattern.compile("(\\\\u(\\p{XDigit}{4}))");

        Matcher matcher = pattern.matcher(str);

        char ch;

        while (matcher.find()) {

            ch = (char) Integer.parseInt(matcher.group(2), 16);

            str = str.replace(matcher.group(1), ch + "");

        }

        return str;

    }
}
