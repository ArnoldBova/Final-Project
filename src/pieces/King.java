package src.pieces;

import src.game.Tile;
import src.structures.Piece;

import java.util.ArrayList;
import java.util.List;

public class King extends Piece {

    public King(Tile tile, String color) {
        super(tile, color);
    }

    @Override
    public ArrayList<Tile> getValidMoves() {
        ArrayList<Tile> outcomes = new ArrayList<>();

        // if left tile contains an opposing piece or is empty, then add tile to the
        // list of outcomes
        Tile left = tile.left();

        Tile right;

        Tile top;
        Tile bottom;

        Tile topLeft;
        Tile topRight;

        Tile bottomLeft;
        Tile bottomRight;

        return null;
    }

    // public boolean isValidMove(Tile tile){
    // return !this.isCheck() && (tile.piece() == null || left.pieceisOpponent) ;
    // }

    /**
     * Returns true if a move will put the King into check
     * 
     * @return true if a move will put the king into check
     */
    public boolean isCheck() {
        return false;
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
