package src.structures;

import java.util.ArrayList;

import src.game.Tile;

public abstract class Piece extends Thread {
    private Tile tile;
    // could make this a boolean such as 'isWhite' which would determine its color
    private String color;

    private boolean captured;

    public Piece(Tile tile, String color) {
        this.tile = tile;
        this.color = color;
    }

    // retuns an array of tiles representing the end point for all valid moves for
    // that piece
    public abstract ArrayList<Tile> getValidMoves();

    public Tile getTile() {
        return tile;
    }

    public String getColor() {
        return color;
    }

    public boolean isCaputured() {
        return captured;
    }

}
