package src.structures;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

import javax.swing.JComponent;

import src.game.Tile;

import java.awt.Image;

public abstract class Piece extends Thread implements ImageObserver {
    protected Tile tile;
    // could make this a boolean such as 'isWhite' which would determine its color
    protected boolean isWhite;

    protected boolean captured;

    protected Image image;

    protected JComponent container;

    protected static final int SIZE = 50;

    public Piece(Tile tile, boolean isWhite, JComponent container) {
        this.tile = tile;
        this.isWhite = isWhite;
        this.container = container;
    }

    // retuns an array of tiles representing the end point for all valid moves for
    // that piece
    public abstract ArrayList<Tile> getValidMoves();

    public Tile getTile() {
        return tile;
    }

    public void setTile(Tile tile) {
        this.tile = tile;
    }

    public boolean isWhite() {
        return isWhite;
    }

    public boolean isCaptured() {
        return captured;
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

    public abstract void run();

    /**
     * Displays a piece
     *
     * @param g The graphics object needed to display the piece
     */
    public void paint(Graphics g) {

        g.drawImage(this.image, tile.location().x * 50 + 40, tile.location().y * 50, this);

    };

    @Override
    public boolean imageUpdate(Image img, int infoflags, int x, int y,
                               int width, int height) {

        if ((infoflags & ImageObserver.ALLBITS) > 0) {
            container.repaint();
            return false;
        }
        return true;
    }

    public void setCapture(){
        this.captured = true;
    }
}
