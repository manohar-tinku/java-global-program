# Music Player Implementation

This project implements a Music Player based on the following interface:

```java
interface Player {
    void playOrPause();
    void stop();
    void next();
    void previous();
    void repeatOnOrOff();
}
```
The interface imitates a set of buttons of a software or hardware player. The Play/Pause button should start or pause playback, depending on what the player is doing. The Stop button should stop playback, so if the Play button is pressed, the current track starts from the beginning. The Next button should skip the current track to the next one, if available. It should also consider if repeat is enabled or disabled. Show warning messages if stop is pressed when the track is already stopped, or next is pressed and the player is already on the last track.

### Constructor

The constructor of the implementation class accepts a list of track names (List<String>).

### Actions

* Pressing the "Play" button should display the message: "Playing: [current track name]".<br>
* Pressing the "Stop" button should display the message: "Stopping: [current track name]" or "Already stopped" (as appropriate).<br>
* Pressing the "Next" button should display the message: "Playing next track: [name of the next track]" or "Replaying first track: [name of the first track]" or "Already on the last track" (as appropriate).<br>
* Pressing the "Previous" button should display the message: "Playing previous track: [name of the previous track]" or "Already on the first track" (as appropriate).<br>
* Pressing the "Repeat" button should display the message: "Repeat on" or "Repeat off" (depending on the situation).<br>

### Scenario Example

Skip to Next Track<br>
Press the "Next" button.<br>
If there is a next track, it will play and display the message: "Playing next track: [name of the next track]".<br>
If the current track is the last one and repeat is enabled, the first track is played and the message: "Replaying first track: [name of the first track]" is displayed.<br>
If the current track is the last one and repeat is turned off, the message: "Already on the last track" is displayed.<br>