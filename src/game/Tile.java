package src.game;

import src.structures.Piece;

public class Tile {
    private Piece piece;
    private String color;

    public Tile(String color) {
        this.piece = null;
        this.color = color;
    }

    void setPiece(Piece piece) {
        this.piece = piece;
    }

}
