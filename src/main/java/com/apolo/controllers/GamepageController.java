package com.apolo.controllers;

import com.apolo.MySQLConnector;
import com.apolo.config;
import javafx.fxml.FXML;
import com.gluonhq.particle.view.ViewManager;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javax.inject.Inject;

public class GamepageController {

    @Inject
    private ViewManager viewManager;

    @FXML
    private Button main1;
    @FXML
    private Circle node1,node2;
    @FXML
    private Accordion accordion;

    public void initialize() {
        // TODO

    }

    public void postInit() {
        main1.setOnAction(e -> {

            Timer timer = new Timer(); //建立一個Timer物件
            TimerTask nodemove = new TimerTask() {//也可以用匿名類別的方式，
            int count = -420;
            int temp;

                @Override
                public void run() {
                    // TODO Auto-generated method stub
                    node1.setTranslateY(count);//輸出時間
                    
                    if (count<350)
                        temp = count-50;
                    
                    node2.setTranslateY(temp);
                    count += 1;
                    if(count == 350)
                        timer.cancel();
                }
            };
            timer.schedule(nodemove, 0, 2);
            // TimeUnit.MICROSECONDS.sleep(100);
        });
        // node1.setCenterY(100);
    }

    public void dispose() {

    }

}
