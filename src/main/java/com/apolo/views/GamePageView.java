package com.apolo.views;

import com.gluonhq.particle.annotation.ParticleView;
import com.gluonhq.particle.view.FXMLView;
import com.apolo.controllers.GamepageController;

@ParticleView(name = "gamepage", isDefault = false)
public class GamePageView extends FXMLView {

    public GamePageView() {
        super(GamePageView.class.getResource("gamepage.fxml"));
    }

    @Override
    public void start() {
        ((GamepageController) getController()).postInit();
    }

    @Override
    public void stop() {
        ((GamepageController) getController()).dispose();
    }
}
