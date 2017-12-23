package com.apolo.views;

import com.gluonhq.particle.annotation.ParticleView;
import com.gluonhq.particle.view.FXMLView;
import com.apolo.controllers.SonglistController;

@ParticleView(name = "songlist", isDefault = false)
public class SongListView extends FXMLView {

    public SongListView() {
        super(SongListView.class.getResource("songlist.fxml"));
    }

    @Override
    public void start() {
        ((SonglistController) getController()).postInit();

    }
    @Override
    public void stop() {
        ((SonglistController) getController()).dispose();
    }
}
