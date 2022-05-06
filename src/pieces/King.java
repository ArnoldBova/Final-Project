package src.pieces;

import src.game.Board;
import src.game.Tile;
import src.structures.Piece;
import javax.swing.*;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.lang.reflect.Array;
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

        if (inCheck) {
            // add code so the only valid moves are the ones that get the king out of check

        } else {
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

        }

        return validMoves;
    }

    /**
    * Determins if moving to the selected tile is 
    * a valid move
    * @return boolean true if the move is valid
    */
    
    public boolean isValidMove(Tile tile) {
        return tile != null && !this.isCheck(tile) && (tile.piece() == null || this.isOpponent(tile.piece()));
    }

    /**
     * Returns true if a move will put the King into check
     * 
     * @return true if a move will put the king into check
     */

    public boolean isCheck(Tile tile) {
        ArrayList<Piece> whitePieces = board.getWhitePieces();
        ArrayList<Piece> blackPieces = board.getBlackPieces();
        if (isWhite) {
            for (Piece piece : blackPieces) {
                if (!(piece instanceof King)) {
                    if (piece instanceof Pawn) {
                        ArrayList<Tile> possiblePawnMoves = ((Pawn) piece).getPossibleCaptureTiles();
                        if (possiblePawnMoves.contains(tile)) {
                            return true;
                        }
                    } else if(piece instanceof Rook){
                        ArrayList<Tile> possibleRookMoves = ((Rook) piece).getValidMovesAgainstKing();
                        if (possibleRookMoves.contains(tile)) {
                            return true;
                        }
                    } 
                    else {
                        ArrayList<Tile> validMovesFromOpposingPiece = piece.getValidMoves();
                        if (validMovesFromOpposingPiece.contains(tile)) {
                            return true;
                        }
                    }

                }
            }
        } else {
            for (Piece piece : whitePieces) {
                if (!(piece instanceof King)) {
                    if (piece instanceof Pawn) {
                        ArrayList<Tile> possiblePawnMoves = ((Pawn) piece).getPossibleCaptureTiles();
                        if (possiblePawnMoves.contains(tile)) {
                            return true;
                        }
                    }else if(piece instanceof Rook){
                        ArrayList<Tile> possibleRookMoves = ((Rook) piece).getValidMovesAgainstKing();
                        if (possibleRookMoves.contains(tile)) {
                            return true;
                        }
                    } 
                    else {
                        ArrayList<Tile> validMovesFromOpposingPiece = piece.getValidMoves();
                        if (validMovesFromOpposingPiece.contains(tile)) {
                            return true;
                        }
                    }

                }
            }
        }
        return false;
    }

    /**
    * @return ArrayList of pieces that would 
    * bring the King out of check
    */
    
    public ArrayList<Piece> getOutOfCheckPieces() {
        ArrayList<Piece> outOfCheckMoves = new ArrayList<>();

        // there is a tile within the arraylist of moves for the passed piece that hits
        // the king
        // our goal is to determine which piece can block that square

        for (Piece piece : board.getWhitePieces()) {

        }

        return outOfCheckMoves;
    }

    /**
     * Sees if the king is currently in check (incomplete)
     *
     * @return boolean value true if the king is in check
     */
    public boolean seeIfInCheck() {

        return isCheck(this.tile);
    }

    /**
    * Does not do much of anything
    */
    
    @Override
    public void run() {

    }
}
