package com.apolo.controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.apolo.MySQLConnector;
import com.apolo.config;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author Eddie.Lu
 */
public class SonglistController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TitledPane pane;
     
    @FXML
    private GridPane grid;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
            songDB();
    }    
    public void postInit() {
        //main1.setOnAction(e -> viewManager.switchView("main"));

    }

    public void dispose() {

    }
     private void songDB() {
        config con = new config();
        String connectionStr = "jdbc:mysql://" + con.getUrlstr() + "/" + con.getDBName() + "?user=" + con.getUserstr() + "&password=" + con.getPw();
        String songnum = "select  count(*) from Songlist";
        String sqlStr = "select  Song_Title from Songlist";
        MySQLConnector songnumber = new MySQLConnector(connectionStr, songnum);
        int count = Integer.valueOf(songnumber.getResult().toString().trim());
        MySQLConnector list = new MySQLConnector(connectionStr, sqlStr);
        pane.setText("Songlist");
        for (int i = 0; i < count; i++) {
            songlist(list.getResult().toString().split("\n")[i],i);
        }
        pane.setContent(grid);
    }

    public void songlist(String result, int i) {
        grid.add(new Button(result), 0, i);
    }
    
}
