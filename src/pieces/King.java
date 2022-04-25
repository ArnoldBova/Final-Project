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
        return null;
    }

    @Override
    public void run() {

    }

    /*    public int getMoves(){
        return moves;
    }
    public list getMovements(int moves){
        if(moves > 0) {
            movemnts.remove(0);
            return movements;
        }else{
            return moves;
        }
    }

    public boolean getCaptured(){
        return captured;
    
    }

    public Tile getPostion(){
        return position;
    }

    

    public void setCaptured(){
        captured = true;
    }
    public void moveTo(Tile end){
        position = end;
    }*/

    
}
