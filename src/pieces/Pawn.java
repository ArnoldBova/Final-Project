package src.pieces;

import src.game.Tile;
import src.structures.Piece;

import javax.swing.*;
import java.sql.Array;
import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.Image;

/**
 * @authors Arnold Bova, Nicky Morgan, Ethan Tubia, Emma Flatland
 * @assignment Final project for CSIS 225
 *             A pawn playing piece used during a game of chess.
 */
public class Pawn extends Piece {

    boolean hasMoved;

    /**
     * Constructs a new pawn object
     *
     * @param tile    the position of the piece
     *
     * @param isWhite the color of the piece
     *
     */

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

    /**
     * returns an array of tiles containing
     * all of the valid moves for the piece
     *
     * @returns array list of possible moves
     *          according to the rules of the piece
     */

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

            if (tile.up() != null && !tile.up().hasPiece()) {
                nonCaptureTile1 = tile.up();
                outcomes.add(nonCaptureTile1);
            }

            if (!hasMoved && nonCaptureTile1 != null) {
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

            if (captureTileLeft != null && captureTileLeft.hasPiece() && captureTileLeft.piece().isOpponent(this)) {
                outcomes.add(captureTileLeft);
            }

            if (captureTileRight != null && captureTileRight.hasPiece() && captureTileRight.piece().isOpponent(this)) {
                outcomes.add(captureTileRight);
            }

            if (tile.up() != null && !tile.down().hasPiece()) {
                nonCaptureTile1 = tile.down();
                outcomes.add(nonCaptureTile1);
            }

            if (!hasMoved && nonCaptureTile1 != null) {
                nonCaptureTile2 = nonCaptureTile1.down();
            }

            if (nonCaptureTile2 != null && !nonCaptureTile2.hasPiece()) {
                outcomes.add(nonCaptureTile2);
            }
        }

        return outcomes;
    }

    /**
     * does not do much of anything
     */

    @Override
    public void run() {

    }

    /**
     * finds the potential captures available to
     * the piece
     *
     * @return ArrayList of tiles containing potential capture
     *         tiles
     */

    public ArrayList<Tile> getPossibleCaptureTiles() {
        ArrayList<Tile> outcomes = new ArrayList<>();

        Tile captureTile1, captureTile2;

        if (isWhite) {
            captureTile1 = tile.up();
            if (captureTile1 != null) {
                captureTile1 = captureTile1.left();
                captureTile2 = tile.up().right();
                outcomes.add(captureTile1);
                outcomes.add(captureTile2);
            }
        } else {
            captureTile1 = tile.down();
            if (captureTile1 != null) {
                captureTile1 = captureTile1.left();
                captureTile2 = tile.down().right();
                outcomes.add(captureTile1);
                outcomes.add(captureTile2);
            }
        }

        return outcomes;
    }

    /**
     * returns true if the pawn has moved
     *
     * @return boolean the value stored in the hasMoved
     *         instance variable
     */

    public void moved() {
        this.hasMoved = true;
    }

}
