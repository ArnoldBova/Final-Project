package src.pieces;

import java.util.ArrayList;

import javax.swing.JComponent;

import src.game.Tile;
import src.structures.Piece;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.Image;

public class Bishop extends Piece {
    // instance variables that are unanimous among all pieces are in the Pieces
    // abstract class. There may be relevant
    // 'per piece' instance variables that can be defined, such as hasMoved for a
    // rook to check for castling.

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

    @Override
    public void run() {
        // this is here for animation things
    }
}
