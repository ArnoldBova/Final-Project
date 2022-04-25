package src.pieces;

import src.game.Tile;
import src.structures.Piece;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece {

    public Pawn(Tile tile, String color) {
        super(tile, color);
    }

    @Override
    public ArrayList<Tile> getValidMoves() {
        return null;
    }

    @Override
    public void run() {

    }

    //
//
//    public boolean getCaptured() {
//        return captured;
//
//    }
//
//    public Tile getPostion() {
//        return position;
//    }
//
//    public void setCaptured() {
//        captured = true;
//    }
//
//    public void moveTo(Tile end) {
//        position = end;
//    }

}
