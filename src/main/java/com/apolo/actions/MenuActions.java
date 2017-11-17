package com.apolo.actions;

import com.gluonhq.particle.annotation.ParticleActions;
import com.gluonhq.particle.application.ParticleApplication;
//import java.util.Optional;
//import javafx.scene.control.Alert;
//import javafx.scene.control.ButtonType;
import javax.inject.Inject;
import org.controlsfx.control.action.ActionProxy;

@ParticleActions
public class MenuActions {

    @Inject
    ParticleApplication app;

    @ActionProxy(text = "Exit", accelerator = "alt+F4")
    private void exit() {
        // disable built-in dialog
        app.setShowCloseConfirmation(false);
        //exit game
        app.exit();
        // create a custom dialog
        /*Alert dialog = new Alert(Alert.AlertType.CONFIRMATION, "Custom exit Message");
        Optional<ButtonType> result = dialog.showAndWait();
        if (result.isPresent() && result.get().equals(ButtonType.OK)) {
            app.exit();
        }*/
    }
}
