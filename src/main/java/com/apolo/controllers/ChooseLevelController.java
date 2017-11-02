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
    private Button easy,normal,hard;
    
    @FXML
    private ResourceBundle resources;
    
    private Action actionHome;
    
    public void initialize() {
        
        easy.setText(resources.getString("easy.text"));
        easy.setOnAction(e -> viewManager.switchView("enjoyplatform"));
        normal.setText(resources.getString("normal.text"));
        normal.setOnAction(e -> viewManager.switchView("enjoyplatform"));
        hard.setText(resources.getString("hard.text"));
        hard.setOnAction(e -> viewManager.switchView("enjoyplatform"));
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
