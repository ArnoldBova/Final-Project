package src.pieces;

import java.util.ArrayList;

import src.game.Tile;
import src.structures.Piece;

public class Bishop extends Piece {
    // instance variables that are unanimous among all pieces are in the Pieces
    // abstract class. There may be relevant
    // 'per piece' instance variables that can be defined, such as hasMoved for a
    // rook to check for castling.

    public Bishop(Tile tile, boolean isWhite) {
        super(tile, isWhite);
        // do any other calculations per piece here if needed
    }

    // saving this implementation as a comment for reference later

    // public list getMovements(int moves){
    // if(moves > 0) {
    // movemnts.remove(0);
    // return movements;
    // }else{
    // return moves;
    // }
    // }

    @Override
    public ArrayList<Tile> getValidMoves() {
        ArrayList<Tile> outcomes = new ArrayList<>();

        // create a new arraylist and add the end position tile of valid moves to it
        // doesn't need to be an instance variable because we don't care about old
        // possible moves
        // only ones based on the current position.

        return outcomes;
    }

    @Override
    public void run() {
        // this is here for animation things
    }

}
