package com.apolo.controllers;

import com.apolo.MySQLConnector;
import com.apolo.config;
import javafx.fxml.FXML;
import com.gluonhq.particle.view.ViewManager;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.GridPane;
import javax.inject.Inject;

public class GamepageController {

    @Inject
    private ViewManager viewManager;

    @FXML
    private Button main1;

    @FXML
    private Accordion accordion;


    public void initialize() {
        // TODO
    }

    public void postInit() {
        main1.setOnAction(e -> viewManager.switchView("main"));

    }

    public void dispose() {

    }
}