package com.training.javaglobalprogram.designpatterns.task2.impl;

import com.training.javaglobalprogram.designpatterns.task2.MusicPlayer;
import com.training.javaglobalprogram.designpatterns.task2.PlayerState;
import com.training.javaglobalprogram.designpatterns.task2.impl.PlayingState;

import static com.training.javaglobalprogram.designpatterns.task2.MusicPlayer.logInfo;

public class StoppedState implements PlayerState {
    private MusicPlayer player;
    public StoppedState(MusicPlayer musicPlayer) {
        this.player = musicPlayer;
    }

    @Override
    public void playOrPause() {
        logInfo("Playing: "+player.getTracks().get(player.getCurrentTrackIndex()));
        player.setState(new PlayingState(player));
    }

    @Override
    public void stop() {
        logInfo("Already Stopped");
    }

    @Override
    public void next() {
        player.getState().next();
    }

    @Override
    public void previous() {
        player.getState().previous();
    }
}
