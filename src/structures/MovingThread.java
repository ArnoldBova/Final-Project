package src.structures;

import src.pieces.*;
import src.structures.Piece;
import src.game.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MovingThread extends Thread {
    Piece piece;
    Tile startTile;
    Tile endTile;
    Point currPos;
    JPanel panel;
    private static final int DELAY_TIME = 33;

    /**
    *Constructs the MovingThread object
    */
    
    public MovingThread(Piece piece, Tile startTile, Tile endTile, JPanel panel){
        this.piece = piece;
        this.startTile = startTile;
        this.endTile = endTile;
        this.panel = panel;
    }
    
    /**
    * Animates the piece movement
    */
    
    public void run(){
        int xMove = ((startTile.location().x * 50 + 40) - (endTile.location().x * 50 + 40))/6;
        int yMove = ((startTile.location().y * 50) - (endTile.location().y * 50))/6;

        while(piece.getPosition().distance(endTile.location().x * 50 + 40, endTile.location().y * 50) > 10){
            //System.out.println(piece.getPosition().distance(endTile.location().x * 50 + 40, endTile.location().y * 50));
            try {
                sleep(DELAY_TIME);
            } catch (InterruptedException e) {
            }

            piece.getPosition().translate(-xMove, -yMove);
            panel.repaint();
            
        }
        piece.getPosition().setLocation(endTile.location().x * 50 + 40, endTile.location().y * 50);
        panel.repaint();
    }
}
