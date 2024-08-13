package com.training.javaglobalprogram.designpatterns.task2;

import java.util.ArrayList;
import java.util.List;

public class MusicPlayer implements Player {
    private List<String> tracks = new ArrayList<>();
    private boolean isPlaying;
    private boolean isStopped;
    private boolean isRepeatOn;
    private int currentTrackIndex;

    public MusicPlayer(List<String> tracks) {
        currentTrackIndex = 0;
        isPlaying = false;
        isStopped = true;
        isRepeatOn = false;
        this.tracks=tracks;
    }

    /**
     * Play/pause button should start or pause playback, depending on what the player is doing.
     * Pressing the "Play" button should display the message: "Playing: [current track name]".
     */
    @Override
    public void playOrPause() {
        if (isStopped) {
            isPlaying = true;
            isStopped = false;
            System.out.println("Playing: " + tracks.get(currentTrackIndex));
        } else {
            if (!isPlaying) {
                System.out.println("Playing: " + tracks.get(currentTrackIndex));
            } else {
                System.out.println("Paused: " + tracks.get(currentTrackIndex));
            }
        }
    }

    /**
     * Stop button should stop playback
     * Pressing the "Stop" button should display the message: "Stopping: [current track name]" or "Already stopped" (as appropriate).
     */
    @Override
    public void stop() {
        if (isStopped) {
            System.out.println("Already stopped");
        } else {
            isStopped = true;
            isPlaying = false;
            System.out.println("Stopping: " + tracks.get(currentTrackIndex));
        }
    }

    /**
     * Next button should skip the current track to the next one, if available. It also should consider if repeat is enabled or disabled.
     * Pressing the "Next" button should display the message: "Playing next track: [name of the next track]" or "Replaying first track: [name of the first track]" or "Already on the last track" (as appropriate).
     */
    @Override
    public void next() {
        if (currentTrackIndex < tracks.size() - 1) {
            currentTrackIndex++;
            isPlaying = true;
            isStopped = false;
            System.out.println("Playing next track: " + tracks.get(currentTrackIndex));
        } else if (isRepeatOn) {
            currentTrackIndex = 0;
            isPlaying = true;
            isStopped = false;
            System.out.println("Replaying first track: " + tracks.get(currentTrackIndex));
        } else {
            System.out.println("Already on the last track");
        }
    }

    /**
     * Pressing the "Previous" button should display the message: "Playing previous track: [name of the previous track]" or "Already on the first track" (as appropriate).
     */
    @Override
    public void previous() {
        if (currentTrackIndex > 0) {
            currentTrackIndex--;
            isPlaying = true;
            isStopped = false;
            System.out.println("Playing previous track: " + tracks.get(currentTrackIndex));
        } else {
            System.out.println("Already on the first track");
        }
    }

    /**
     * Pressing the "Repeat" button should display the message: "Repeat on" or "Repeat off" (depending on the situation).
     */
    @Override
    public void repeatOnOrOff() {
        if (!isRepeatOn) {
            isRepeatOn=true;
            System.out.println("Repeat on");
        } else {
            System.out.println("Repeat off");
        }
    }
}
