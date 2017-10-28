package com.apolo.views;

import com.gluonhq.particle.annotation.ParticleView;
import com.gluonhq.particle.view.FXMLView;
import com.apolo.controllers.ChooseLevelController;

@ParticleView(name = "chooselevel", isDefault = false)
public class ChooseLevelView extends FXMLView {
    
    public ChooseLevelView() {
        super(ChooseLevelView.class.getResource("chooselevel.fxml"));
    }
    
    @Override
    public void start() {
        ((ChooseLevelController) getController()).postInit();
    }
    
    @Override
    public void stop() {
        ((ChooseLevelController) getController()).dispose();
    }
    
}