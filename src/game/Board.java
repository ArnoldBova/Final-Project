package src.game;

import src.pieces.*;
import src.structures.Piece;

import java.util.ArrayList;
import java.awt.Color;
import java.awt.Graphics;

/**
 * Implementation of an object representing a board. Will be the overall
 * structure that contains all the
 * moving game components
 *
 * @version 1.0
 * @author Arnold Bova
 */
public class Board {
    Tile[][] tiles;

    ArrayList<Piece> whitePieces;
    ArrayList<Piece> blackPieces;

    /**
     * constructs a new board, populating the 2d array of tile objects with each
     * piece in the correct place to start a new game.
     * 
     * The board will be oriented such that the white piece player will be at the
     * bottom of the screen.
     */
    public Board() {
        tiles = new Tile[8][8];
        whitePieces = new ArrayList<>();
        blackPieces = new ArrayList<>();
        populate();
        createLinks();
    }

    /**
     * Populates the Tiles 2d array with tiles and generates Pieces where needed
     */
    private void populate() {
        for (int i = 0; i < tiles.length; i++) {
            switch (i) {
                // generating black back line
                case 0:
                    for (int j = 0; j < tiles[i].length; j++) {
                        tiles[i][j] = createTile(j, j % 2 == 0, false, i, j);
                    }
                    break;
                // Generating black pawn line
                case 1:
                    for (int j = 0; j < tiles[i].length; j++) {
                        Tile tile = new Tile(j % 2 != 0, i, j);
                        Piece piece = new Pawn(tile, false);
                        tile.setPiece(piece);
                        tiles[i][j] = tile;
                    }
                    break;
                case 2:
                case 4:
                    for (int j = 0; j < tiles[i].length; j++) {
                        tiles[i][j] = new Tile(j % 2 == 0, i, j);
                    }
                    break;
                case 3:
                case 5:
                    for (int j = 0; j < tiles[i].length; j++) {
                        tiles[i][j] = new Tile(j % 2 != 0, i, j);
                    }
                    break;
                // Generating White pawn line
                case 6:
                    for (int j = 0; j < tiles[i].length; j++) {
                        Tile tile = new Tile(j % 2 == 0, i, j);
                        Piece piece = new Pawn(tile, true);
                        tile.setPiece(piece);
                        tiles[i][j] = tile;
                    }
                    break;
                // Generating White back line
                case 7:
                    for (int j = 0; j < tiles[i].length; j++) {
                        tiles[i][j] = createTile(j, j % 2 != 0, true, i, j);
                    }
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * Helper method that creates a tile and will create a piece if it is necessary
     * for the current pos
     * 
     * @param pos          The position within a given row
     * @param isWhiteTile  The color of the tile represented as a boolean
     * @param isWhitePiece The color of the piece represented as a boolean
     * @return A tile with a piece bound to it if necessary
     */
    private Tile createTile(int pos, boolean isWhiteTile, boolean isWhitePiece, int x, int y) {
        Piece piece;
        Tile tile = new Tile(isWhiteTile, x, y);
        // determine which piece should be generated
        switch (pos) {
            // rook case
            case 0:
                piece = new Rook(tile, isWhitePiece);
                // Knight case
            case 1:
                piece = new Knight(tile, isWhitePiece);
                // Bishop case
            case 2:
                piece = new Bishop(tile, isWhitePiece);
                // Queen case
            case 3:
                piece = new Queen(tile, isWhitePiece);
                // King case
            case 4:
                piece = new King(tile, isWhitePiece);
                // rest of the case are the same just mirrored;
            case 5:
                piece = new Bishop(tile, isWhitePiece);
            case 6:
                piece = new Knight(tile, isWhitePiece);
            case 7:
                piece = new Rook(tile, isWhitePiece);
            default:
                piece = null;
        }
        ;

        if (piece != null) {
            if (isWhitePiece)
                whitePieces.add(piece);
            else
                blackPieces.add(piece);
        }

        tile.setPiece(piece);

        return tile;
    }

    /**
     * Links the tiles together
     */
    private void createLinks() {
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                Tile tile = tiles[i][j];
                if (!(i - 1 < 0)) {
                    tile.setUp(tiles[i - 1][j]);
                }
                if (!(i + 1 <= tiles.length)) {
                    tile.setDown(tiles[i + 1][j]);
                }
                if (!(j - 1 < 0)) {
                    tile.setLeft(tiles[i][j - 1]);
                }
                if (!(j + 1 <= tiles[i].length)) {
                    tile.setRight(tiles[i][j + 1]);
                }
            }
        }
    }

    public void paintComponent(Graphics g) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Tile drawingTile = tiles[i][j];
                if (drawingTile.isWhite) {
                    g.setColor(Color.WHITE);
                } else {
                    g.setColor(Color.BLACK);
                }
                g.fillRect(i * 50 + 40, j * 50, 50, 50);
                g.setColor(Color.BLACK);
                g.drawRect(i * 50 + 40, j * 50, 50, 50);

                if (drawingTile.hasPiece() && drawingTile.piece() instanceof King) {
                    drawingTile.piece().paint(g);
                    System.out.println("tile with king drawn");
                }
            }
        }
    }
}
