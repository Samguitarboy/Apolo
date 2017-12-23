package com.apolo.controllers;

import com.gluonhq.particle.application.ParticleApplication;
import com.gluonhq.particle.view.ViewManager;
import java.io.File;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javax.inject.Inject;

public class MainController {
    @Inject
    private ViewManager viewManager;

    @FXML
    private Button start, about ,download ,credit;

    public void initialize() {

    }

    public void postInit() {
        String Path =System.getProperty("user.dir") + "/src/main/resources/Apolo_change.mp3";
        Media hit = new Media(new File(Path).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(hit);
        start.setOnAction(e -> {mediaPlayer.play();viewManager.switchView("gamepage");});
        credit.setOnAction(e -> {mediaPlayer.play();viewManager.switchView("chooselevel");});
        about.setOnAction(e -> about());
        download.setOnAction(e -> {mediaPlayer.play();viewManager.switchView("enjoyplatform");});
    }
    
    public void dispose() {
    }

    private void about() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Apolo");
        alert.setHeaderText("About Apolo");
        alert.setGraphic(new ImageView(new Image(MainController.class.getResource("/Sun.png").toExternalForm(), 48, 48, true, true)));
        alert.setContentText("Designed by Sam.Chen & Eddie.Lu");
        alert.showAndWait();
    }

}
