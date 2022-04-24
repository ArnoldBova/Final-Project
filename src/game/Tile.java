package src.game;

import src.structures.Piece;

public class Tile {
    private Piece piece;
    private String color;

    public Tile(Piece piece, String color) {
        this.piece = piece;
        this.color = color;
    }
}
