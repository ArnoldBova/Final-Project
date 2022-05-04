package src.structures;

import src.pieces.*;
import src.structures.Piece;
import src.game.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class movingThread {
    Piece piece;
    Tile startTile;
    Tile endTile;

    public void movingThread(Piece piece, Tile startTile, Tile endTile){
        this.piece = piece;
        this.startTile = startTile;
        this.endTile = endTile;
    }
    
    public void run(){
        
    }
}
