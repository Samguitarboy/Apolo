package com.apolo.controllers;

import com.gluonhq.particle.application.ParticleApplication;
import com.gluonhq.particle.state.StateManager;
import com.gluonhq.particle.view.ViewManager;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.inject.Inject;
import org.controlsfx.control.action.Action;
import org.controlsfx.control.action.ActionProxy;

public class MainController {

    @Inject
    ParticleApplication app;

    @Inject
    private ViewManager viewManager;

    @Inject
    private StateManager stateManager;

    private boolean first = true;

    @FXML
    private Label label;

    @FXML
    private Button start,about;

    public void initialize() {
        start.setOnAction(e -> viewManager.switchView("chooselevel"));
        about.setOnAction(e -> about());
    }

    public void postInit() {
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
