package com.training.javaglobalprogram.designpatterns.task2;

import com.training.javaglobalprogram.designpatterns.task2.impl.StoppedState;

import java.util.ArrayList;
import java.util.List;

public class MusicPlayer implements Player {
    private List<String> tracks = new ArrayList<>();
    private PlayerState state;
    private int currentTrackIndex;
    private boolean isRepeatOn;

    public MusicPlayer(List<String> tracks) {
        currentTrackIndex = 0;
        isRepeatOn = false;
        this.state = new StoppedState(this);
        this.tracks=tracks;
    }

    /**
     * Play/pause button should start or pause playback, depending on what the player is doing.
     * Pressing the "Play" button should display the message: "Playing: [current track name]".
     */
    @Override
    public void playOrPause() {
        state.playOrPause();
    }

    /**
     * Stop button should stop playback
     * Pressing the "Stop" button should display the message: "Stopping: [current track name]" or "Already stopped" (as appropriate).
     */
    @Override
    public void stop() {
       state.stop();
    }

    /**
     * Next button should skip the current track to the next one, if available. It also should consider if repeat is enabled or disabled.
     * Pressing the "Next" button should display the message: "Playing next track: [name of the next track]" or "Replaying first track: [name of the first track]" or "Already on the last track" (as appropriate).
     */
    @Override
    public void next() {
        state.next();
    }

    /**
     * Pressing the "Previous" button should display the message: "Playing previous track: [name of the previous track]" or "Already on the first track" (as appropriate).
     */
    @Override
    public void previous() {
       state.previous();
    }

    /**
     * Pressing the "Repeat" button should display the message: "Repeat on" or "Repeat off" (depending on the situation).
     */
    @Override
    public void repeatOnOrOff() {
        if (!isRepeatOn) {
            isRepeatOn=true;
            logInfo("Repeat on");
        } else {
            logInfo("Repeat off");
        }
    }

    public static void logInfo(String message) {
        System.out.println(message);
    }

    public List<String> getTracks() {
        return tracks;
    }

    public void setTracks(List<String> tracks) {
        this.tracks = tracks;
    }

    public PlayerState getState() {
        return state;
    }

    public void setState(PlayerState state) {
        this.state = state;
    }

    public int getCurrentTrackIndex() {
        return currentTrackIndex;
    }

    public void setCurrentTrackIndex(int currentTrackIndex) {
        this.currentTrackIndex = currentTrackIndex;
    }

    public boolean isRepeatOn() {
        return isRepeatOn;
    }

    public void setRepeatOn(boolean repeatOn) {
        isRepeatOn = repeatOn;
    }
}
