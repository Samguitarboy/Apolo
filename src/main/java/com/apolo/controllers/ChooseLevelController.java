package com.apolo.controllers;

import com.gluonhq.particle.application.ParticleApplication;
import com.gluonhq.particle.view.ViewManager;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javax.inject.Inject;
import org.controlsfx.control.action.Action;
import org.controlsfx.control.action.ActionProxy;

public class ChooseLevelController {

    @Inject ParticleApplication app;
    
    @Inject private ViewManager viewManager;

    @FXML
    private Button play;
    
    @FXML
    private ResourceBundle resources;
    
    private Action actionHome;
    
    public void initialize() {
        
        play.setText(resources.getString("button.text"));
        play.setOnAction(e -> viewManager.switchView("enjoyplatform"));
    }
    
    public void postInit() {

    }
    
    public void dispose() {

    }
    
    @ActionProxy(text = "Back")
    private void goHome() {
        viewManager.switchView("main");
    }
    
}
