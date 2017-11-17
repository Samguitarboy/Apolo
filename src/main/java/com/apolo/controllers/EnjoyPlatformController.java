package com.apolo.controllers;

import com.gluonhq.particle.view.ViewManager;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javax.inject.Inject;

public class EnjoyPlatformController {

    @Inject
    private ViewManager viewManager;

    @FXML
    private Button button;

    @FXML
    private ResourceBundle resources;

    public void initialize() {
        // TODO
        button.setText(resources.getString("button.text"));
    }

    public void postInit() {
        button.setOnAction(e -> viewManager.switchView("main"));
    }

    public void dispose() {

    }

}
