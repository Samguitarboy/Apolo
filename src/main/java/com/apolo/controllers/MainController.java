package com.apolo.controllers;

import com.apolo.actions.MenuActions;
import com.gluonhq.particle.application.ParticleApplication;
import com.gluonhq.particle.state.StateManager;
import com.gluonhq.particle.view.ViewManager;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.inject.Inject;
import org.controlsfx.control.action.Action;
import org.controlsfx.control.action.ActionMap;
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
    private Button start;

    @FXML
    private ResourceBundle resources;

    @FXML
    private Button about;

    private Action actionChangestyle;

    public void initialize() {
        ActionMap.register(this);

        //actionChangestyle =  ActionMap.action("changestyle");
        start.setOnAction(e -> viewManager.switchView("chooselevel"));
        about.setOnAction(e -> about());
    }

    public void postInit() {
        if (first) {
            stateManager.setPersistenceMode(StateManager.PersistenceMode.USER);
            addUser(stateManager.getProperty("UserName").orElse("").toString());
            first = false;
        }
        app.getParticle().getToolBarActions().add(0, actionChangestyle);
    }

    public void dispose() {
        app.getParticle().getToolBarActions().remove(actionChangestyle);
    }

    public void addUser(String userName) {
        label.setText(resources.getString("label.text"));
        stateManager.setProperty("UserName", userName);
    }

    private void about() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Apolo");
        alert.setHeaderText("About Apolo");
        alert.setGraphic(new ImageView(new Image(MainController.class.getResource("/Sun.png").toExternalForm(), 48, 48, true, true)));
        alert.setContentText("Designed by Sam.Chen & Eddie.Lu");
        alert.showAndWait();
    }

    @ActionProxy(text = "Changestyle")
    private void changestyle() {
        TextInputDialog input = new TextInputDialog(stateManager.getProperty("UserName").orElse("").toString());
        input.setTitle("User name");
        input.setHeaderText(null);
        input.setContentText("Input your name:");
        input.showAndWait().ifPresent(this::addUser);
    }

}
