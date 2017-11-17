package com.apolo.controllers;

import javafx.fxml.FXML;
import com.gluonhq.particle.view.ViewManager;
import javafx.scene.control.Button;
import javax.inject.Inject;

public class GamepageController {
    
    @Inject
    private ViewManager viewManager;
    
    @FXML
    private Button main1;

    public void initialize() {
        // TODO
    }

    public void postInit() {
        main1.setOnAction(e -> viewManager.switchView("main"));
    }

    public void dispose() {

    }

}
