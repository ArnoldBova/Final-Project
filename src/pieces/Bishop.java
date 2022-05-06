package src.pieces;

import java.util.ArrayList;

import javax.swing.JComponent;

import src.game.Tile;
import src.structures.Piece;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.Image;

/**
 * @authors Arnold Bova, Nicky Morgan, Ethan Tubia, Emma Flatland
 * 
 *          A bishop used during a game of chess.
 */
public class Bishop extends Piece {
    // instance variables that are unanimous among all pieces are in the Pieces
    // abstract class. There may be relevant
    // 'per piece' instance variables that can be defined, such as hasMoved for a
    // rook to check for castling.

    /**
     * Constructs a new Bishop object
     *
     * @param tile    the position of the piece
     *
     * @param isWhite the color of the piece
     *
     */

    public Bishop(Tile tile, boolean isWhite, JComponent container) {
        super(tile, isWhite, container);
        try {
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            if (isWhite) {
                this.image = toolkit.getImage("src/pieces/WhiteBishop.png");
            } else {
                this.image = toolkit.getImage("src/pieces/BlackBishop.png");
            }
            this.image = this.image.getScaledInstance(SIZE, SIZE, Image.SCALE_DEFAULT);

        } catch (Exception e) {
            e.printStackTrace();
        }
        // do any other calculations per piece here if needed
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
        Tile up = this.getTile().up();
        Tile down = this.getTile().down();
        Tile upLeft = null;
        Tile upRight = null;
        Tile downLeft = null;
        Tile downRight = null;
        if (up != null) {
            upLeft = up.left();
            upRight = up.right();
        }
        if (down != null) {
            downLeft = down.left();
            downRight = down.right();
        }
        boolean loopDone = false;
        loopDone = false;
        while (!loopDone && upLeft != null) {
            if (upLeft.hasPiece()) {
                if (upLeft.piece().isWhite() != white) {
                    outcomes.add(upLeft);
                }
                loopDone = true;
            } else {
                outcomes.add(upLeft);
                upLeft = upLeft.up();
                if (upLeft != null) {
                    upLeft = upLeft.left();
                }
            }
        }
        loopDone = false;
        while (!loopDone && upRight != null) {
            if (upRight.hasPiece()) {
                if (upRight.piece().isWhite() != white) {
                    outcomes.add(upRight);
                }
                loopDone = true;
            } else {
                outcomes.add(upRight);
                upRight = upRight.up();
                if (upRight != null) {
                    upRight = upRight.right();
                }
            }
        }
        loopDone = false;
        while (!loopDone && downLeft != null) {
            if (downLeft.hasPiece()) {
                if (downLeft.piece().isWhite() != white) {
                    outcomes.add(downLeft);
                }
                loopDone = true;
            } else {
                outcomes.add(downLeft);
                downLeft = downLeft.down();
                if (downLeft != null) {
                    downLeft = downLeft.left();
                }
            }
        }
        loopDone = false;
        while (!loopDone && downRight != null) {
            if (downRight.hasPiece()) {
                if (downRight.piece().isWhite() != white) {
                    outcomes.add(downRight);
                }
                loopDone = true;
            } else {
                outcomes.add(downRight);
                downRight = downRight.down();
                if (downRight != null) {
                    downRight = downRight.right();
                }
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
        Tile up = this.getTile().up();
        Tile down = this.getTile().down();
        Tile upLeft = null;
        Tile upRight = null;
        Tile downLeft = null;
        Tile downRight = null;
        if (up != null) {
            upLeft = up.left();
            upRight = up.right();
        }
        if (down != null) {
            downLeft = down.left();
            downRight = down.right();
        }
        boolean loopDone = false;
        loopDone = false;
        while (!loopDone && upLeft != null) {
            if (upLeft.hasPiece()) {
                if (upLeft.piece().isWhite() != white) {
                    outcomes.add(upLeft);

                    if (!(upLeft.piece() instanceof King)) {
                        loopDone = true;
                    } else {
                        upLeft = upLeft.up();
                        if (upLeft != null) {
                            upLeft = upLeft.left();
                        }
                    }
                }

            } else {
                outcomes.add(upLeft);
                upLeft = upLeft.up();
                if (upLeft != null) {
                    upLeft = upLeft.left();
                }
            }
        }
        loopDone = false;
        while (!loopDone && upRight != null) {
            if (upRight.hasPiece()) {
                if (upRight.piece().isWhite() != white) {
                    outcomes.add(upRight);

                    if (!(upRight.piece() instanceof King)) {
                        loopDone = true;
                    } else {
                        upRight = upRight.up();
                        if (upRight != null) {
                            upRight = upRight.right();
                        }
                    }
                }

            } else {
                outcomes.add(upRight);
                upRight = upRight.up();
                if (upRight != null) {
                    upRight = upRight.right();
                }
            }
        }
        loopDone = false;
        while (!loopDone && downLeft != null) {
            if (downLeft.hasPiece()) {
                if (downRight.piece().isWhite() != white) {
                    outcomes.add(downLeft);

                    if (!(downLeft.piece() instanceof King)) {
                        loopDone = true;
                    } else {
                        downLeft = downRight.down();
                        if (downLeft != null) {
                            downLeft = downLeft.left();
                        }
                    }
                }

            } else {
                outcomes.add(downLeft);
                downLeft = downLeft.down();
                if (downLeft != null) {
                    downLeft = downLeft.left();
                }
            }
        }
        loopDone = false;
        while (!loopDone && downRight != null) {
            if (downRight.hasPiece()) {
                if (downRight.piece().isWhite() != white) {
                    outcomes.add(downRight);

                    if (!(downRight.piece() instanceof King)) {
                        loopDone = true;
                    } else {
                        downRight = downRight.down();
                        if (downRight != null) {
                            downRight = downRight.right();
                        }
                    }
                }

            } else {
                outcomes.add(downRight);
                downRight = downRight.down();
                if (downRight != null) {
                    downRight = downRight.right();
                }
            }
        }

        return outcomes;
    }

    // while (!loopDone && left != null) {
    // if (left.hasPiece()) {
    // if (left.piece().isWhite() != white) {
    // outcomes.add(left);

    // if(!(left.piece() instanceof King)){
    // loopDone = true;
    // } else {
    // left = left.left();
    // }
    // }else{
    // loopDone = true;
    // }
    // } else {
    // outcomes.add(left);
    // left = left.left();
    // }
    // }
    /**
     * Does not do much of anything
     */
    @Override
    public void run() {
        // this is here for animation things
    }
}
