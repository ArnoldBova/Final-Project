package src.pieces;

import src.game.Tile;
import src.structures.Piece;

import java.util.ArrayList;
import java.util.Arrays;

public class King extends Piece {

    public King(Tile tile, boolean isWhite) {
        super(tile, isWhite);
    }

    @Override
    public ArrayList<Tile> getValidMoves() {

        // the array of valid moves that will be returned
        ArrayList<Tile> validMoves = new ArrayList<>();

        // all tiles neighboring the king
        ArrayList<Tile> potentialMoves = new ArrayList<>(
                Arrays.asList(tile.left(), tile.right(), tile.down(), tile.up(),
                        tile.left().up(), tile.right().up(), tile.down().left(), tile.down().right()));

        // Go through the neighboring tiles and filter out the ones that are valid next
        // moves
        for (Tile tile : potentialMoves) {
            if (isValidMove(tile))
                validMoves.add(tile);
        }
        return validMoves;
    }

    public boolean isValidMove(Tile tile) {
        return !this.isCheck() && (tile.piece() == null || this.isOpponent(tile.piece()));
    }

    /**
     * Returns true if a move will put the King into check
     * 
     * @return true if a move will put the king into check
     */
    public boolean isCheck() {
        return false;
    }

    @Override
    public void run() {

    }

    /*
     * public int getMoves(){
     * return moves;
     * }
     * public list getMovements(int moves){
     * if(moves > 0) {
     * movemnts.remove(0);
     * return movements;
     * }else{
     * return moves;
     * }
     * }
     * 
     * public boolean getCaptured(){
     * return captured;
     * 
     * }
     * 
     * public Tile getPostion(){
     * return position;
     * }
     * 
     * 
     * 
     * public void setCaptured(){
     * captured = true;
     * }
     * public void moveTo(Tile end){
     * position = end;
     * }
     */

}
