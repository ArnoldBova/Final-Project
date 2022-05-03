package src.pieces;

import src.game.Board;
import src.game.Tile;
import src.structures.Piece;
import javax.swing.*;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.Arrays;

import javax.imageio.ImageIO;

import java.io.File;
import java.io.IOException;

/**
 * The King class models the King piece in the game of Chess
 * 
 * @author Emma Flatland, Arnold Bova, Ethan Tubia, Nicholas Morgan
 */
public class King extends Piece {

    // The board the king is on
    protected Board board;

    // True if the king has been put into check
    protected boolean inCheck;

    /**
     * Constructs a King object
     * 
     * @param tile    The tile that the king starts on
     * @param isWhite Whether the king is white or not
     */
    public King(Tile tile, boolean isWhite, JComponent container, Board board) {
        super(tile, isWhite, container);

        // Try to read in the piece's image, and scale it to the proper size
        try {
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            if (isWhite) {
                this.image = toolkit.getImage("src/pieces/WhiteKing.png");
            } else {
                this.image = toolkit.getImage("src/pieces/BlackKing.png");
            }
            this.image = this.image.getScaledInstance(SIZE, SIZE, Image.SCALE_DEFAULT);

        } catch (Exception e) {
            e.printStackTrace();
        }

        this.board = board;

    }

    /**
     * Determines the tiles that the king could move to
     * 
     * @return the tiles that the king could move to
     */
    @Override
    public ArrayList<Tile> getValidMoves() {

        // the array of valid moves that will be returned
        ArrayList<Tile> validMoves = new ArrayList<>();

        // all tiles neighboring the king
        ArrayList<Tile> potentialMoves = new ArrayList<>(
                Arrays.asList(tile.left(), tile.right(), tile.down(), tile.up()));
        if (tile.left() != null) {
            potentialMoves.add(tile.left().up());
        }
        if (tile.right() != null) {
            potentialMoves.add(tile.right().up());
        }
        if (tile.down() != null) {
            potentialMoves.add(tile.down().right());
            potentialMoves.add(tile.down().left());
        }

        // Go through the neighboring tiles and filter out the ones that are valid next
        // moves
        for (Tile tile : potentialMoves) {
            if (isValidMove(tile))
                validMoves.add(tile);
        }
        return validMoves;
    }

    public boolean isValidMove(Tile tile) {
        return tile != null && !this.isCheck(tile) && (tile.piece() == null || this.isOpponent(tile.piece()));
    }

    /**
     * Returns true if a move will put the King into check
     * 
     * @return true if a move will put the king into check
     */

    public boolean isCheck(Tile tile) {
        boolean isCheck = false;

        // Go through each tile on the board, and get the piece that is on it
        // (we would need a reference to the board before this will work)
        Tile[][] tiles = board.getTiles();
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                Piece nextPiece = tiles[i][j].piece();
                // Go through the valid moves of each opposing piece
                // Determine if any valid move would kill the king

                if (!(nextPiece instanceof King) && nextPiece != null && this.isOpponent(nextPiece)) {
                    ArrayList<Tile> validMoves = nextPiece.getValidMoves();
                    if (validMoves.contains(tile)) {
                        isCheck = true;
                        break;
                    }
                }
                // If the next piece is the other king, the getValidMoves cannot be called
                // because it
                // would cause infinite recursion
                else if (nextPiece != this && nextPiece != null && this.isOpponent(nextPiece)) {
                    ArrayList<Tile> validMoves = new ArrayList();
                    Tile left = nextPiece.getTile().left();
                    if (left != null) {
                        validMoves.add(left);
                        if (left.up() != null) {
                            validMoves.add(left.up());
                        }
                        if (left.down() != null) {
                            validMoves.add(left.down());
                        }
                    }

                    Tile right = nextPiece.getTile().right();
                    if (right != null) {
                        validMoves.add(right);
                        if (right.up() != null) {
                            validMoves.add(right.up());
                        }
                        if (right.down() != null) {
                            validMoves.add(right.down());
                        }
                    }
                    Tile up = nextPiece.getTile().up();
                    if (up != null) {
                        validMoves.add(up);
                    }
                    Tile down = nextPiece.getTile().down();
                    if (down != null) {
                        validMoves.add(down);
                    }
                    if (validMoves.contains(tile)) {
                        isCheck = true;
                    }
                }

            }
        }
        return isCheck;
    }

    @Override
    public void run() {

    }
}
