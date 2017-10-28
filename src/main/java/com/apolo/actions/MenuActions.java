package com.apolo.actions;

import com.gluonhq.particle.annotation.ParticleActions;
import com.gluonhq.particle.application.ParticleApplication;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.inject.Inject;
import org.controlsfx.control.action.ActionProxy;

@ParticleActions
public class MenuActions {

    @Inject ParticleApplication app;

    @ActionProxy(text="Exit", accelerator="alt+F4")
    private void exit() {
        app.exit();
    }
    
    @ActionProxy(text="About")
    private void about() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Apolo");
        alert.setHeaderText("About Apolo");
        alert.setGraphic(new ImageView(new Image(MenuActions.class.getResource("/Sun.png").toExternalForm(), 48, 48, true, true)));
        alert.setContentText("Designed by Sam.Chen & Eddie,Lu");
        alert.showAndWait();
    }
        
}