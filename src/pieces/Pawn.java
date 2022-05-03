package src.pieces;

import src.game.Tile;
import src.structures.Piece;

import javax.swing.*;
import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.Image;


public class Pawn extends Piece {

    boolean hasMoved;

    public Pawn(Tile tile, boolean isWhite, JComponent container) {
        super(tile, isWhite, container);
        try {
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            if (isWhite) {
                this.image = toolkit.getImage("src/pieces/WhitePawn.png");
            } else {
                this.image = toolkit.getImage("src/pieces/BlackPawn.png");
            }
            this.image = this.image.getScaledInstance(SIZE, SIZE, Image.SCALE_DEFAULT);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Tile> getValidMoves() {
        ArrayList<Tile> outcomes = new ArrayList<>();

        Tile captureTileRight;
        Tile captureTileLeft;
        Tile nonCaptureTile1 = null;
        Tile nonCaptureTile2 = null;

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
                outcomes.add(nonCaptureTile1);
            }

            if (!hasMoved) {
                nonCaptureTile2 = nonCaptureTile1.up();
            }

            if (nonCaptureTile2 != null && !nonCaptureTile2.hasPiece()) {
                outcomes.add(nonCaptureTile2);
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
                nonCaptureTile2 = nonCaptureTile1.down();
                outcomes.add(nonCaptureTile1);
            }

            if (nonCaptureTile2 != null && !nonCaptureTile2.hasPiece()) {
                outcomes.add(nonCaptureTile2);
            }
        }

        return outcomes;
    }

    @Override
    public void run() {

    }

    public void moved () {
        this.hasMoved = true;
    }

}
