package src.pieces;

import src.game.Tile;
import src.structures.Piece;

import java.util.ArrayList;

public class Pawn extends Piece {

    boolean hasMoved;

    public Pawn(Tile tile, boolean isWhite) {
        super(tile, isWhite);
        hasMoved = false;
    }

    @Override
    public ArrayList<Tile> getValidMoves() {
        ArrayList<Tile> outcomes = new ArrayList<>();

        Tile captureTileRight;
        Tile captureTileLeft;
        Tile nonCaptureTile1 = null;
        Tile nonCpatureTile2 = null;

        if (isWhite) {

            captureTileLeft = tile.left();
            if (captureTileLeft != null) {
                captureTileLeft = captureTileLeft.up();
            }

            captureTileRight = tile.right();
            if (captureTileRight != null) {
                captureTileRight = captureTileRight.up();
            }

            if (captureTileLeft != null && captureTileLeft.hasPiece()) {
                outcomes.add(captureTileLeft);
            }

            if (captureTileRight != null && captureTileRight.hasPiece()) {
                outcomes.add(captureTileRight);
            }

            if (tile.up() != null) {
                nonCaptureTile1 = tile.up();
            }

            if (!hasMoved && nonCaptureTile1 != null && !nonCaptureTile1.hasPiece()) {
                nonCpatureTile2 = nonCaptureTile1.up();
                outcomes.add(nonCaptureTile1);
            }

            if (nonCpatureTile2 != null && !nonCpatureTile2.hasPiece()) {
                outcomes.add(nonCaptureTile1);
            }
        } else {
            captureTileLeft = tile.left();
            if (captureTileLeft != null) {
                captureTileLeft = captureTileLeft.down();
            }

            captureTileRight = tile.right();
            if (captureTileRight != null) {
                captureTileRight = captureTileRight.down();
            }

            if (captureTileLeft != null && captureTileLeft.hasPiece()) {
                outcomes.add(captureTileLeft);
            }

            if (captureTileRight != null && captureTileRight.hasPiece()) {
                outcomes.add(captureTileRight);
            }

            if (tile.down() != null) {
                nonCaptureTile1 = tile.down();
            }

            if (!hasMoved && nonCaptureTile1 != null && !nonCaptureTile1.hasPiece()) {
                nonCpatureTile2 = nonCaptureTile1.down();
                outcomes.add(nonCaptureTile1);
            }

            if (nonCpatureTile2 != null && !nonCpatureTile2.hasPiece()) {
                outcomes.add(nonCaptureTile1);
            }
        }

        return outcomes;
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
