package src.pieces;

import java.util.ArrayList;
import java.util.List;

import src.game.Tile;
import src.structures.Piece;

public class Rook extends Piece {

    public Rook(Tile tile, boolean isWhite) {
        super(tile, isWhite);
    }

    @Override
    public ArrayList<Tile> getValidMoves() {
        ArrayList<Tile> outcomes = new ArrayList<>();

        Tile captureTileRight;
        Tile captureTileLeft;
        Tile captureTileUp;
        Tile captureTileDown;
        Tile nonCaptureTile1 = null;
        Tile nonCpatureTile2 = null;

        captureTileLeft = tile.left();
        captureTileRight = tile.right();
        boolean wall = false;
        if(isWhite){
        while(captureTileLeft != null && wall == false){
            if(captureTileLeft.hasPiece() && captureTileLeft.piece().isWhite()!= true){
                outcomes.add(captureTileLeft);
                wall = true;
            }else{
                if(!captureTileLeft.hasPiece()){
                    outcomes.add(captureTileLeft);
                    captureTileLeft = captureTileLeft.left();
                }else{
                    wall = true;
                }
            }
        }
        wall = false;
        while(captureTileRight != null && wall == false){
            if(captureTileRight.hasPiece() && captureTileRight.piece().isWhite() != true){
                outcomes.add(captureTileRight);
                wall = true;
            }else{
                if(!captureTileRight.hasPiece()){
                    outcomes.add(captureTileRight);
                    captureTileRight = captureTileRight.right();
                }
            }
        }
        wall = false;
        captureTileUp = tile.up();
        while(captureTileUp != null && wall == false){
            if(captureTileUp.hasPiece() && captureTileUp.piece().isWhite() != true){
                outcomes.add(captureTileUp);
                wall = true;
            }else{
                if(!captureTileUp.hasPiece()){
                    outcomes.add(captureTileUp);
                    captureTileUp = captureTileUp.up();
                }
            }
        }
        wall = false;
        captureTileDown = tile.down();
        while(captureTileDown != null && wall == false){
            if(captureTileDown.hasPiece() && captureTileDown.piece().isWhite() != true){
                outcomes.add(captureTileDown);
                wall = true;
            }else{
                if(!captureTileDown.hasPiece()){
                    outcomes.add(captureTileDown);
                    captureTileDown = captureTileDown.down();
                }
            }
        }
    }else{
    while(captureTileLeft != null && wall == false){
        if(captureTileLeft.hasPiece() && captureTileLeft.piece().isWhite()){
            outcomes.add(captureTileLeft);
            wall = true;
        }else{
            if(!captureTileLeft.hasPiece()){
                outcomes.add(captureTileLeft);
                captureTileLeft = captureTileLeft.left();
            }else{
                wall = true;
            }
        }
    }
    wall = false;
    while(captureTileRight != null && wall == false){
        if(captureTileRight.hasPiece() && captureTileRight.piece().isWhite()){
            outcomes.add(captureTileRight);
            wall = true;
        }else{
            if(!captureTileRight.hasPiece()){
                outcomes.add(captureTileRight);
                captureTileRight = captureTileRight.right();
            }
        }
    }
    wall = false;
    captureTileUp = tile.up();
    while(captureTileUp != null && wall == false){
        if(captureTileUp.hasPiece() && captureTileUp.piece().isWhite()){
            outcomes.add(captureTileUp);
            wall = true;
        }else{
            if(!captureTileUp.hasPiece()){
                outcomes.add(captureTileUp);
                captureTileUp = captureTileUp.up();
            }
        }
    }
    wall = false;
    captureTileDown = tile.down();
    while(captureTileDown != null && wall == false){
        if(captureTileDown.hasPiece() && captureTileDown.piece().isWhite()){
            outcomes.add(captureTileDown);
            wall = true;
        }else{
            if(!captureTileDown.hasPiece()){
                outcomes.add(captureTileDown);
                captureTileDown = captureTileDown.down();
            }
        }
    }
}

        

        return outcomes;
    }

    @Override
    public void run() {

    }

    //
//    public int getMoves() {
//        return moves;
//    }
//
//    public list getMovements(int moves) {
//        if (moves > 0) {
//            movemnts.remove(0);
//            return movements;
//        } else {
//            return moves;
//        }
//    }
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
