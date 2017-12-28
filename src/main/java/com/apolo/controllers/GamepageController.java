package com.apolo.controllers;

import javafx.fxml.FXML;
import com.gluonhq.particle.view.ViewManager;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javax.inject.Inject;

public class GamepageController {

    @Inject
    private ViewManager viewManager;
    @FXML
    private Button main1;
    @FXML
    private Circle node1, node2;
    @FXML
    private StackPane scene;

    public void initialize() {
        // TODO
        scene.setOnKeyPressed((Event event) -> {
            System.out.println(event.toString().substring(181));
        });
    }

    public void postInit() {
        main1.setOnAction(e -> {
            viewManager.switchView("main");
        });
        Timer timer = new Timer();
        TimerTask nodemove = new TimerTask() {
            int count = -420;
            int temp;

            @Override
            public void run() {
                // TODO Auto-generated method stub   
                node1.setTranslateY(count);
                if (count < 350) {
                    temp = count - 50;
                }
                node2.setTranslateY(temp);
                count += 1;
                if (count == 350) {
                    timer.cancel();
                }
            }
        };
        timer.schedule(nodemove, 0, 2);

    }

    public void dispose() {

    }

}
