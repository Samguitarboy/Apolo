package com.apolo.views;

import com.gluonhq.particle.annotation.ParticleView;
import com.gluonhq.particle.view.FXMLView;
import com.apolo.controllers.EnjoyPlatformController;

@ParticleView(name = "enjoyplatform", isDefault = false)
public class EnjoyPlatformView extends FXMLView {

    public EnjoyPlatformView() {
        super(EnjoyPlatformView.class.getResource("enjoyplatform.fxml"));
    }

    @Override
    public void start() {
        ((EnjoyPlatformController) getController()).postInit();
    }

    @Override
    public void stop() {
        ((EnjoyPlatformController) getController()).dispose();
    }
}
