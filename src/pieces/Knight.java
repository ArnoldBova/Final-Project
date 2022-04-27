package src.pieces;

import java.util.ArrayList;
import java.util.List;

import src.game.Tile;
import src.structures.Piece;

public class Knight extends Piece {


    public Knight(Tile tile, boolean isWhite) {
        super(tile, isWhite);
    }

    @Override
    public ArrayList<Tile> getValidMoves() {
        return null;
    }

    @Override
    public void run() {

    }

    // to set the piece for removal from the board
//    public Boolean setCaptured() {
//        captured = true;
//        return true;
//    }
//
//    // To help in determining if a move will end up being valid
//    public Tile getPosition() {
//        return position;
//    }
//
//    // To determine the validity of a move and to move the piece to
//    // said tile.
//    // thjis will undergo changes eventually.
//    public void moveTo(Tile end) {
//        position = end;
//    }

}