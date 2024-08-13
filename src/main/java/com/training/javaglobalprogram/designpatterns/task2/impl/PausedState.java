package com.training.javaglobalprogram.designpatterns.task2.impl;

import com.training.javaglobalprogram.designpatterns.task2.MusicPlayer;
import com.training.javaglobalprogram.designpatterns.task2.PlayerState;

import static com.training.javaglobalprogram.designpatterns.task2.MusicPlayer.logInfo;

public class PausedState implements PlayerState {
    private MusicPlayer player;

    public PausedState(MusicPlayer player) {
        this.player = player;
    }

    @Override
    public void playOrPause() {
        logInfo("Playing: " + player.getTracks().get(player.getCurrentTrackIndex()));
        player.setState(new PlayingState(player));
    }

    @Override
    public void stop() {
        logInfo("Stopped: " + player.getTracks().get(player.getCurrentTrackIndex()));
        player.setState(new StoppedState(player));
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
