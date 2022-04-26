package src.game;

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
    public void paint() {

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

    // Converts a time in seconds to its equivalent time in minutes and seconds
    // (This is the format that the timer will display)
    public String convertToMinutes() {
        return "";
    }

}
