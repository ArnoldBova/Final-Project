package src.game;

public class Timer extends Thread {
    // True if the timer is stopped, and false if it is running
    boolean stopped;

    // True if the game is over, and false if the game is in progress
    boolean gameOver;

    // The amount of time the timer can run before the game is over
    int gameLength;

    // The time that the timer will display (how long the player has spent on their
    // turns so far)
    int timeElapsed;

    // Keeps track of the current time, and updates the elapsed time every second
    public void run() {

    }

    // Paints the current elapsed time
    public void paint() {

    }

    // Resets the elapsed time to zero
    public void reset() {

    }

    // Converts a time in seconds to its equivalent time in minutes and seconds
    // (This is the format that the timer will display)
    public String convertToMinutes() {
        return "";
    }

}
