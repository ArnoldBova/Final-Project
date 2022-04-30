package src.game;

import java.awt.Graphics;
import java.lang.Math;

public class Timer extends Thread {
    // True only if the timer is running
    boolean running;

    // The amount of time (in seconds) the timer can run before the game is over
    int gameLength;

    // True if the timer is on, and false if it is off
    boolean on;

    // The time that the timer will display (how long the player has spent on their
    // turns so far)
    int timeElapsed;

    // The number of milliseconds the program waits before changing animation frames
    public static final int DELAY_TIME = 1000;

    public Timer(int gameLength) {
        this.timeElapsed = 0;
        this.running = false;
        this.gameLength = gameLength;
    }

    // Keeps track of the current time, and updates the elapsed time every second
    public void run() {
        while (on) {
            if (running) {
                try {
                    sleep(DELAY_TIME);
                    timeElapsed++;

                } catch (InterruptedException e) {
                }
            }
            if (timeElapsed == gameLength) {
                running = false;
            }
        }
    }

    // Paints the current elapsed time
    public void paint(Graphics g) {
        int minutes = (int) Math.floor(timeElapsed / 60);
        int seconds = timeElapsed - (int) (minutes * 60);
        String timeToDisplay = Integer.toString(minutes) + ":" + Integer.toString(seconds);
        g.drawString(timeToDisplay, 0, 0);

    }

    // Resets the elapsed time to zero
    public void reset() {
        this.timeElapsed = 0;

    }

    // Temporarily pauses the timer
    public void pause() {
        this.running = false;
    }

    // Starts the timer
    public void start() {
        this.running = true;
    }

    // Turns the timer on
    public void turnOn() {
        this.on = true;
    }

    // Turns the timer off
    public void turnOff() {
        this.on = false;
    }

}