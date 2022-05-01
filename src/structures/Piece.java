package src.structures;

import java.util.ArrayList;

import src.game.Tile;
import java.awt.Graphics;

import java.awt.Image;

public abstract class Piece extends Thread {
    protected Tile tile;
    // could make this a boolean such as 'isWhite' which would determine its color
    protected boolean isWhite;

    protected boolean captured;

    protected Image image;

    protected static final int SIZE = 50;

    public Piece(Tile tile, boolean isWhite) {
        this.tile = tile;
        this.isWhite = isWhite;
    }

    // retuns an array of tiles representing the end point for all valid moves for
    // that piece
    public abstract ArrayList<Tile> getValidMoves();

    public Tile getTile() {
        return tile;
    }

    public void setTile(Tile tile) {
        this.tile = tile;
    }

    public boolean isWhite() {
        return isWhite;
    }

    public boolean isCaptured() {
        return captured;
    }

    /**
     * Returns true if this piece and another piece are on opposite teams
     * 
     * @param other another piece
     * @return true if this piece and the other piece are on opposing teams
     */
    public boolean isOpponent(Piece other) {
        return other.isWhite() != this.isWhite();
    }

    public abstract void run();

    /**
     * Displays a piece
     * 
     * @param g The graphics object needed to display the piece
     */
    public void paint(Graphics g) {

    };

}
