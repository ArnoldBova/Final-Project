package src.pieces;

import java.util.ArrayList;
import java.util.List;

import src.game.Tile;
import src.structures.Piece;

import javax.print.attribute.standard.DialogOwner;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.Image;

/**
 * @authors Arnold Bova, Nicky Morgan, Ethan Tubia, Emma Flatland
 * 
 *          A rook used during a game of chess.
 */
public class Rook extends Piece {

    /**
     * Constructs a new Rook object
     *
     * @param tile    the position of the piece
     *
     * @param isWhite the color of the piece
     *
     */

    public Rook(Tile tile, boolean isWhite, JComponent container) {
        super(tile, isWhite, container);
        try {
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            if (isWhite) {
                this.image = toolkit.getImage("src/pieces/WhiteCastle.png");
            } else {
                this.image = toolkit.getImage("src/pieces/BlackCastle.png");
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
        boolean white = this.isWhite();
        Tile up = tile.up();
        Tile down = tile.down();
        Tile left = tile.left();
        Tile right = tile.right();
        boolean loopDone = false;
        while (!loopDone && up != null) {
            if (up.hasPiece()) {
                if (up.piece().isWhite() != white) {
                    outcomes.add(up);
                }
                loopDone = true;
            } else {
                outcomes.add(up);
                up = up.up();
            }
        }
        loopDone = false;
        while (!loopDone && down != null) {
            if (down.hasPiece()) {
                if (down.piece().isWhite() != white) {
                    outcomes.add(down);
                }
                loopDone = true;
            } else {
                outcomes.add(down);
                down = down.down();
            }
        }
        loopDone = false;
        while (!loopDone && right != null) {
            if (right.hasPiece()) {
                if (right.piece().isWhite() != white) {
                    outcomes.add(right);
                }
                loopDone = true;
            } else {
                outcomes.add(right);
                right = right.right();
            }
        }
        loopDone = false;
        while (!loopDone && left != null) {
            if (left.hasPiece()) {
                if (left.piece().isWhite() != white) {
                    outcomes.add(left);
                }
                loopDone = true;
            } else {
                outcomes.add(left);
                left = left.left();
            }
        }

        return outcomes;
    }

    /**
     * Determines if any already valid moves would
     * put the opposing King in check
     *
     * @return ArrayList of tiles that would be dangerous
     *         to the opposing player's king
     */

    public ArrayList<Tile> getValidMovesAgainstKing() {
        ArrayList<Tile> outcomes = new ArrayList<>();
        boolean white = this.isWhite();
        Tile up = tile.up();
        Tile down = tile.down();
        Tile left = tile.left();
        Tile right = tile.right();
        boolean loopDone = false;
        while (!loopDone && up != null) {
            if (up.hasPiece()) {
                if (up.piece().isWhite() != white) {
                    outcomes.add(up);

                    if (!(up.piece() instanceof King)) {
                        loopDone = true;
                    } else {
                        up = up.up();
                    }
                } else {
                    loopDone = true;
                }
            } else {
                outcomes.add(up);
                up = up.up();
            }
        }
        loopDone = false;
        while (!loopDone && down != null) {
            if (down.hasPiece()) {
                if (down.piece().isWhite() != white) {
                    outcomes.add(down);

                    if (!(down.piece() instanceof King)) {
                        loopDone = true;
                    } else {
                        down = down.down();
                    }
                } else {
                    loopDone = true;
                }
            } else {
                outcomes.add(down);
                down = down.down();
            }
        }
        loopDone = false;
        while (!loopDone && right != null) {
            if (right.hasPiece()) {
                if (right.piece().isWhite() != white) {
                    outcomes.add(up);

                    if (!(right.piece() instanceof King)) {
                        loopDone = true;
                    } else {
                        right = right.right();
                    }
                } else {
                    loopDone = true;
                }
            } else {
                outcomes.add(right);
                right = right.right();
            }
        }
        loopDone = false;
        while (!loopDone && left != null) {
            if (left.hasPiece()) {
                if (left.piece().isWhite() != white) {
                    outcomes.add(left);

                    if (!(left.piece() instanceof King)) {
                        loopDone = true;
                    } else {
                        left = left.left();
                    }
                } else {
                    loopDone = true;
                }
            } else {
                outcomes.add(left);
                left = left.left();
            }
        }

        return outcomes;
    }

    /**
     * Does not do much of anything
     */

    @Override
    public void run() {

    }
}
