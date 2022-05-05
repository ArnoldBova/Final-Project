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

    public void movingThread(Piece piece, Tile startTile, Tile endTile, JPanel panel){
        this.piece = piece;
        this.startTile = startTile;
        this.endTile = endTile;
    }
    
    public void run(){
        int xMove = (startTile.location().x - endTile.location().x)/6;
        int yMove = (startTile.location().y - endTile.location().y)/6;

        while(!currPos.equals(endTile.location())){
            try {
                sleep(DELAY_TIME);
            } catch (InterruptedException e) {
            }

            currPos.translate(xMove, yMove);
            panel.repaint();
            
        }
    }
}
