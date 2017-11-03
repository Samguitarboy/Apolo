package com.apolo.views;

import com.apolo.controllers.Youtube_url_inputController;
import com.gluonhq.particle.annotation.ParticleView;
import com.gluonhq.particle.view.FXMLView;

@ParticleView(name = "youtubedownloader", isDefault = false)
public class Youtube_url_inputView extends FXMLView {
    
    public Youtube_url_inputView() {
        super(Youtube_url_inputView.class.getResource("youtubeurlinput.fxml"));
    }
    
    @Override
    public void start() {
        ((Youtube_url_inputController) getController()).postInit();
    }
    
    @Override
    public void stop() {
        ((Youtube_url_inputController) getController()).dispose();
    }
    
}
