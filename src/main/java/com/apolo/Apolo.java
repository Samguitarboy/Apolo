package com.apolo;

import com.gluonhq.particle.application.ParticleApplication;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import static org.controlsfx.control.action.ActionMap.action;

public class Apolo extends ParticleApplication {

    public Apolo() {
        super("Apolo");
    }
    public void initialize() {
        //scene.getStylesheets().add(Apolo.class.getResource("style.css").toExternalForm());
        setTitle("Apolo");
    }
    @Override
    public void postInit(Scene scene) {
        scene.windowProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                scene.getWindow().setOnCloseRequest(e -> {
                    e.consume();
                    action("exit").handle(new ActionEvent());
                });

                scene.windowProperty().removeListener(this);
            }
        });
    }
}
