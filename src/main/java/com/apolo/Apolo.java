package com.apolo;

import com.gluonhq.particle.application.ParticleApplication;
import javafx.scene.Scene;
import static org.controlsfx.control.action.ActionMap.actions;

public class Apolo extends ParticleApplication {

    public Apolo() {
        super("Gluon Desktop Application");
    }

    @Override
    public void postInit(Scene scene) {
        scene.getStylesheets().add(Apolo.class.getResource("style.css").toExternalForm());

        setTitle("Apolo");

        getParticle().buildMenu("File -> [exit]", "Help -> [about]");
        
        getParticle().getToolBarActions().addAll(actions("---", "about", "exit"));
    }
}