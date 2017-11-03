package com.apolo.controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.gluonhq.particle.view.ViewManager;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javax.inject.Inject;

/**
 * FXML Controller class
 *
 * @author A_xian_xian
 */
public class EnjoyPlatformController {

    @Inject private ViewManager viewManager;
    
    @FXML
    private Button button;
    
    @FXML
    private ResourceBundle resources;
        
    public void initialize() {
        // TODO
        button.setText(resources.getString("button.text"));
        button.setOnAction(e -> viewManager.switchView("main"));
    }    
    public void postInit() {
        
    }
    
    public void dispose() {
        
    }
    
}
