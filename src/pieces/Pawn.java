package src.pieces;

import src.game.Tile;
import src.structures.Piece;

import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.Image;


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

            if (captureTileLeft != null && captureTileLeft.hasPiece() && captureTileLeft.piece().isOpponent(this)) {
                outcomes.add(captureTileLeft);
            }

            if (captureTileRight != null && captureTileRight.hasPiece() && captureTileRight.piece().isOpponent(this)) {
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

            if (captureTileRight != null && captureTileRight.hasPiece() && !captureTileRight.piece().isWhite()) {
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

    @Override
    public void paint(Graphics g) {

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image pieceImage;
        if (this.isWhite) {
            pieceImage = toolkit.getImage("../Images/WhitePieces/WhitePawn.png");
        } else {
            pieceImage = toolkit.getImage("../Images/WhitePieces/BlackPawn.png");
        }

        // we will need to include x coordinates within the correct tile
        g.drawImage(pieceImage, 0, 0, null);

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
