package src.structures;

import java.util.ArrayList;

import src.game.Tile;

public abstract class Piece extends Thread {
    protected Tile tile;
    // could make this a boolean such as 'isWhite' which would determine its color
    protected boolean isWhite;

    protected boolean captured;

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

    public boolean isWhite() {return isWhite;}

    public boolean isCaputured() {
        return captured;
    }

    public abstract void run();

}
