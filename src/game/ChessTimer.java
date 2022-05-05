package src.game;

import javax.swing.*;
import java.awt.Graphics;
import java.lang.Math;

public class ChessTimer extends Thread {
    // True only if the timer is running
    boolean running;

    // The amount of time (in seconds) the timer can run before the game is over
    int gameLength;

    // True if the timer is on, and false if it is off

    // The time that the timer will display (how long the player has spent on their
    // turns so far)
    int timeElapsed;
    Boolean messageSent;
    String time;
    JLabel label;
    boolean isWhitePlayer;
    JFrame frame;

    // The number of milliseconds the program waits before changing animation frames
    public static final int DELAY_TIME = 1000;

    public ChessTimer(int gameLength, JLabel label, boolean isWhitePlayer, JFrame frame) {
        this.timeElapsed = 0;
        this.running = false;
        this.gameLength = gameLength;
        this.label = label;
        this.isWhitePlayer = isWhitePlayer;
        this.frame = frame;
        messageSent = false;
    }

    // Keeps track of the current time, and updates the elapsed time every second
    @Override
    public void run() {
        while (true) {

            try {
                sleep(DELAY_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (running) {
                timeElapsed++;
                int minutes = (gameLength - timeElapsed)/60;
                int seconds = (gameLength - timeElapsed) - minutes * 60;
                if (seconds < 10) {
                    this.label.setText(((isWhitePlayer) ? "White Player: " : "Black Player: ") + minutes + ":0" + seconds);

                } else {
                    this.label.setText(((isWhitePlayer) ? "White Player: " : "Black Player: ") + minutes + ":" + seconds);
                }
                //System.out.println(minutes + ":" + seconds);
                label.repaint();
            }
            if (timeElapsed == gameLength) {
                running = false;
                if(messageSent == false){
                    if(isWhitePlayer){
                        JOptionPane.showMessageDialog(frame, "White Player lost due to Time");
                    }else{
                        JOptionPane.showMessageDialog(frame, "Black Player lost due to Time");
                    }
                    messageSent = true;
                }
            }
        }
    }

    // Resets the elapsed time to zero
    public void reset() {
        this.timeElapsed = 0;
        this.label.setText(((isWhitePlayer) ? "White Player: " : "Black Player: ") + "10:00");
        this.label.repaint();

    }
    // Temporarily pauses the timer
    public void pause() {
        this.running = false;
    }

    public void unPause() {
        this.running = true;
        //System.out.println("Unpause");
    }
}