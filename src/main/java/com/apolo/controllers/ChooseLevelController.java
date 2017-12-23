package com.apolo.controllers;

import com.gluonhq.particle.application.ParticleApplication;
import com.gluonhq.particle.view.ViewManager;
import java.io.File;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javax.inject.Inject;
import org.controlsfx.control.action.ActionProxy;

public class ChooseLevelController {

    @Inject
    ParticleApplication app;

    @Inject
    private ViewManager viewManager;

    @FXML
    private Button easy, normal, hard;

    @FXML
    private ResourceBundle resources;

    public void initialize() {
        easy.setText(resources.getString("easy.text"));
        normal.setText(resources.getString("normal.text"));
        hard.setText(resources.getString("hard.text"));
    }

    public void postInit() {
        String Path =System.getProperty("user.dir") + "/src/main/resources/Apolo_change.mp3";
        Media hit = new Media(new File(Path).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(hit);
        easy.setOnAction(e -> {mediaPlayer.play();viewManager.switchView("enjoyplatform");});
        normal.setOnAction(e -> {mediaPlayer.play();viewManager.switchView("youtubedownloader");});
        hard.setOnAction(e -> {mediaPlayer.play();viewManager.switchView("songlist");});
    }

    public void dispose() {

    }

    @ActionProxy(text = "Back")
    private void goHome() {
        viewManager.switchView("main");
    }

}
