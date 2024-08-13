package com.training.javaglobalprogram.designpatterns.task2;

import java.util.Arrays;
import java.util.List;

public class MusicPlayerMain {
    public static void main(String[] args) {
        List<String> tracks = Arrays.asList("Song 1", "Song 2", "Song 3");
        MusicPlayer player = new MusicPlayer(tracks);

        player.playOrPause();  // Playing: Song 1
        player.next();         // Playing next track: Song 2
        player.next();         // Playing next track: Song 3
        player.next();         // Already on the last track
        player.repeatOnOrOff();// Repeat on
        player.next();         // Replaying first track: Song 1
        player.previous();     // Already on the first track
        player.stop();         // Stopping: Song 1
        player.stop();         // Already stopped
        player.playOrPause();  // Playing: Song 1
        player.repeatOnOrOff();// Repeat off
    }
}