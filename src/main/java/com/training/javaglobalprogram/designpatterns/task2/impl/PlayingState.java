package com.training.javaglobalprogram.designpatterns.task2.impl;

import com.training.javaglobalprogram.designpatterns.task2.MusicPlayer;
import com.training.javaglobalprogram.designpatterns.task2.PlayerState;

import static com.training.javaglobalprogram.designpatterns.task2.MusicPlayer.logInfo;

public class PlayingState implements PlayerState {
    private MusicPlayer player;

    public PlayingState(MusicPlayer player) {
        this.player = player;
    }

    @Override
    public void playOrPause() {
        logInfo("Paused: " + player.getTracks().get(player.getCurrentTrackIndex()));
        player.setState(new PausedState(player));
    }

    @Override
    public void stop() {
        logInfo("Stopped: " + player.getTracks().get(player.getCurrentTrackIndex()));
        player.setState(new StoppedState(player));
    }

    @Override
    public void next() {
        if (player.getCurrentTrackIndex() < player.getTracks().size() - 1) {
            player.setCurrentTrackIndex(player.getCurrentTrackIndex() + 1);
            logInfo("Playing next track: " + player.getTracks().get(player.getCurrentTrackIndex()));
        } else {
            if (player.isRepeatOn()) {
                player.setCurrentTrackIndex(0);
                logInfo("Replaying first track: " + player.getTracks().get(player.getCurrentTrackIndex()));
            } else {
                logInfo("Already on the last track");
            }
        }
    }

    @Override
    public void previous() {
        if (player.getCurrentTrackIndex() > 0) {
            player.setCurrentTrackIndex(player.getCurrentTrackIndex() - 1);
            logInfo("Playing previous track: " + player.getTracks().get(player.getCurrentTrackIndex()));
        } else {
            logInfo("Already on the first track");
        }
    }
}
