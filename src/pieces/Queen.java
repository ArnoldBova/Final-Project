package src.pieces;

import java.lang.reflect.Array;
import java.util.ArrayList;
import src.game.Tile;
import src.structures.Piece;

import javax.swing.*;
import java.awt.Toolkit;
import java.awt.Image;

/**
 * @authors Arnold Bova, Nicky Morgan, Ethan Tubia, Emma Flatland
 * 
 *          A Queen piece used during a game of chess.
 */
public class Queen extends Piece {

    /**
     * Constructs a new Queen object
     *
     * @param tile    the position of the piece
     *
     * @param isWhite the color of the piece
     *
     */

    public Queen(Tile tile, boolean isWhite, JComponent container) {
        super(tile, isWhite, container);
        try {
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            if (isWhite) {
                this.image = toolkit.getImage("src/pieces/WhiteQueen.png");
            } else {
                this.image = toolkit.getImage("src/pieces/BlackQueen.png");
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
        // these can return null leading to null pointer exception
        Tile up = this.getTile().up();
        Tile down = this.getTile().down();
        Tile left = this.getTile().left();
        Tile right = this.getTile().right();
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
     * determines if the queen has any valid
     * moves against the opposing king
     *
     * @return ArrayList of tiles that would lead to
     *         putting the opposing King in check
     */

    public ArrayList<Tile> getValidMovesAgainstKing() {
        ArrayList<Tile> outcomes = new ArrayList<>();
        boolean white = this.isWhite();
        // these can return null leading to null pointer exception
        Tile up = this.getTile().up();
        Tile down = this.getTile().down();
        Tile left = this.getTile().left();
        Tile right = this.getTile().right();
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

    /**
     * Does not do much of anything
     */

    @Override
    public void run() {
    }

    /**
     * generates a string consisting of
     * the color and name of the piece
     * 
     * @return String consisting of color and
     *         name of the piece
     */

    @Override
    public String toString() {
        String color = (isWhite) ? "White" : "Black";
        return color + " Queen";
    }
}
