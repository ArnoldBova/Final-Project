package src.structures;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

import javax.swing.JComponent;

import src.game.Tile;

import java.awt.Image;

/**
 * @authors Arnold Bova, Nicky Morgan, Ethan Tubia, Emma Flatland
 * @assignment Final project for CSIS 225
 *             A chess piece class
 */
public abstract class Piece extends Thread implements ImageObserver {
    protected Tile tile;
    // could make this a boolean such as 'isWhite' which would determine its color
    protected boolean isWhite;

    protected boolean captured;

    protected Image image;

    private static final int DELAY_TIME = 33;

    protected JComponent container;

    protected static final int SIZE = 50;

    protected Point position;

    /**
     *
     * constructs a new piece
     *
     * @param tile    is where the piece is
     *
     * @param isWhite is the color of the piece
     */

    public Piece(Tile tile, boolean isWhite, JComponent container) {
        this.tile = tile;
        this.isWhite = isWhite;
        this.container = container;
        position = new Point(tile.location().x * 50 + 40, tile.location().y * 50);
    }

    /**
     * retuns an array of tiles representing the end point for all valid moves for
     * that piece
     * 
     * @return ArrayList of tiles that are valid moves for the piece
     */
    public abstract ArrayList<Tile> getValidMoves();

    /**
     * returns the tile instance variable
     * 
     * @return tile
     */

    public Tile getTile() {
        return tile;
    }

    /**
     *
     * sets the value to the tile instance variable
     *
     * @param tile is the value being assigned to the instance
     *             variable tile
     */

    public void setTile(Tile tile) {
        this.tile = tile;
    }

    /**
     * returns true if the piece is white
     * and false if the piece is black
     *
     * @returns boolean value stored in isWhite instance variable
     */

    public boolean isWhite() {
        return isWhite;
    }

    /**
     * returns true if the piece is captured
     * and false if not.
     *
     * @returns boolean the value stored in captured instance variable
     */

    public boolean isCaptured() {
        return captured;
    }

    /**
     * returns the position of the piece
     *
     * @return Point that the piece is at
     */

    public Point getPosition() {
        return position;
    }

    /**
     * Returns true if this piece and another piece are on opposite teams
     * 
     * @param other another piece
     * @return true if this piece and the other piece are on opposing teams
     */
    public boolean isOpponent(Piece other) {
        return other.isWhite() != this.isWhite();
    }

    // public void run(){
    // while(!captured){
    // try {
    // sleep(DELAY_TIME);
    // } catch (InterruptedException e) {
    // }

    // }
    // }

    /**
     * Displays a piece
     *
     * @param g The graphics object needed to display the piece
     */
    public void paint(Graphics g) {

        g.drawImage(this.image, position.x, position.y, this);

    };

    /**
     * Required method by the ImageObserver
     * ensures the image for the piece is loaded and ready
     * to be drawn to the screen
     */

    @Override
    public boolean imageUpdate(Image img, int infoflags, int x, int y,
            int width, int height) {

        if ((infoflags & ImageObserver.ALLBITS) > 0) {
            container.repaint();
            return false;
        }
        return true;
    }

    /**
     * sets the captured instance
     * variable to true
     */

    public void setCapture() {
        this.captured = true;
    }
}
