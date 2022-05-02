package src.pieces;

import src.game.Tile;
import src.structures.Piece;

import java.util.ArrayList;
import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * The King class models the King piece in the game of Chess
 * 
 * @author Emma Flatland, Arnold Bova, Ethan Tubia, Nicholas Morgan
 */
public class King extends Piece {

    /**
     * Constructs a King object
     * 
     * @param tile    The tile that the king starts on
     * @param isWhite Whether the king is white or not
     */
    public King(Tile tile, boolean isWhite) {
        super(tile, isWhite);
        this.image = new I
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
                Arrays.asList(tile.left(), tile.right(), tile.down(), tile.up(),
                        tile.left().up(), tile.right().up(), tile.down().left(), tile.down().right()));

        // Go through the neighboring tiles and filter out the ones that are valid next
        // moves
        for (Tile tile : potentialMoves) {
            if (isValidMove(tile))
                validMoves.add(tile);
        }
        return validMoves;
    }

    public boolean isValidMove(Tile tile) {
        return !this.isCheck(tile) && (tile.piece() == null || this.isOpponent(tile.piece()));
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
        ArrayList<Tile> tiles = new ArrayList<>();
        for (Tile currentTile : tiles) {
            Piece nextPiece = currentTile.piece();

            // Go through the valid moves of each opposing piece
            // Determine if any valid move would kill the king
            if (nextPiece != null && this.isOpponent(nextPiece)) {
                ArrayList<Tile> validMoves = nextPiece.getValidMoves();
                int i = 0;
                while (!isCheck && i < validMoves.size()) {
                    Tile validMove = validMoves.get(i);
                    if (validMove == tile) {
                        isCheck = true;
                    }
                    i++;
                }
            }
        }
        return isCheck;
    }

    @Override
    public void run() {

    }

    @Override
    public void paint(Graphics g) {

        Image pieceImage;
        if (this.isWhite) {
            // pieceImage = new ImageIcon("./WhitePieces/WhiteKing.png");
            // System.out.println("white king " + pieceImage.toString());
        } else {
            try {
                pieceImage = ImageIO.read(new File("/src/pieces/BlackKing.png"));
                // Image scaledImage = pieceImage.getScaledInstance(SIZE, SIZE,
                // Image.SCALE_DEFAULT);
                g.drawImage(pieceImage, 0, 0, null);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // we will need to include x coordinates within the correct tile

    }

    /*
     * public int getMoves(){
     * return moves;
     * }
     * public list getMovements(int moves){
     * if(moves > 0) {
     * movemnts.remove(0);
     * return movements;
     * }else{
     * return moves;
     * }
     * }
     * 
     * public boolean getCaptured(){
     * return captured;
     * 
     * }
     * 
     * public Tile getPostion(){
     * return position;
     * }
     * 
     * 
     * 
     * public void setCaptured(){
     * captured = true;
     * }
     * public void moveTo(Tile end){
     * position = end;
     * }
     */

}
