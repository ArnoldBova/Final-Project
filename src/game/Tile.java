package src.game;

import java.awt.Color;

import src.structures.Piece;

import java.awt.Graphics;

import java.awt.Point;

/**
 * Implementation of a Tile on a chess board.
 * Stores knowledge of the tiles around it and what piece is on it.
 *
 * @version 1.0
 * @author Arnold Bova
 */
public class Tile {
    private Piece piece;
    protected boolean isWhite;
    // each of these represent tiles around this one, each corresponding to their
    // respective direction
    private Tile up;
    private Tile down;
    private Tile left;
    private Tile right;
    protected Point location;
    private boolean highlighted;
    private boolean highlightedForCapture;

    /**
     *
     * Constructs a new tile, setting all the surrounding tiles to null
     * and the piece to null, as a tile will not always have a piece on it.
     *
     * @param isWhite the color of the tile, either black or white
     */
    public Tile(boolean isWhite, int x, int y) {
        this.piece = null;
        this.up = null;
        this.down = null;
        this.right = null;
        this.left = null;
        this.isWhite = isWhite;
        this.location = new Point(x, y);
        this.highlighted = false;
        this.highlightedForCapture = false;
    }

    /**
     * Setter for the instance variable piece
     * 
     * @param piece the piece to be stored
     */
    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    /**
     * Setter for the instance variable up
     * 
     * @param up The tile above this
     */
    void setUp(Tile up) {
        this.up = up;
    }

    /**
     * Setter for the instance variable down
     * 
     * @param down The tile below this
     */
    void setDown(Tile down) {
        this.down = down;
    }

    /**
     * Setter for the instance variable left
     * 
     * @param left The tile to the left of this
     */
    void setLeft(Tile left) {
        this.left = left;
    }

    /**
     * Setter for the instance variable right
     * 
     * @param right The tile to the right of this
     */
    void setRight(Tile right) {
        this.right = right;
    }

    /**
     * Getter for the instance variable up
     * 
     * @return The tile above this
     */
    public Tile up() {
        return up;
    }

    /**
     * Getter for the instance variable down
     * 
     * @return The tile below this
     */
    public Tile down() {
        return down;
    }

    /**
     * Getter for the instance variable left
     * 
     * @return The tile to the left of this
     */
    public Tile left() {
        return left;
    }

    /**
     * Getter for the instance variable right
     * 
     * @return The tile to the right of this
     */
    public Tile right() {
        return right;
    }

    public boolean hasPiece() {
        return piece != null;
    }

    public Piece piece() {
        return piece;
    }

    public Point location() {
        return location;
    }

    public boolean isHighlighted() {
        return highlighted;
    }

    public void highlight() {
        this.highlighted = true;
    }

    public void highlightForCapture() {
        this.highlightedForCapture = true;
    }

    public boolean isHighlightedForCapture() {
        return highlightedForCapture;
    }

    public void unHighlight(){
        this.highlighted = false;
        this.highlightedForCapture = false;
    }
}
