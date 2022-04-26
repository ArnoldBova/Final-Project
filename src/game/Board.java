package src.game;

import src.pieces.*;
import src.structures.Piece;

/**
 * Implementation of an object representing a board. Will be the overall
 * structure that contains all the
 * moving game components
 */
public class Board {
    Tile[][] tiles;

    /**
     * constructs a new board, populating the 2d array of tile objects with each
     * piece in the correct place to start a new game.
     * 
     * The board will be oriented such that the white piece player will be at the bottom of the screen.
     */
    public Board() {
        tiles = new Tile[8][8];
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
                        String color = (j % 2 == 0) ? "white" : "black";
                        tiles[i][j] = createTile(j, color, "black");
                    }
                    break;
                // Generating black pawn line
                case 1:
                    for (int j = 0; j < tiles[i].length; j++) {
                        String color = (j % 2 == 0) ? "black" : "white";
                        Tile tile = new Tile(color);
                        Piece piece = new Pawn(tile, "black");
                        tile.setPiece(piece);
                    }
                    break;
                case 2:
                case 4:
                    for (int j = 0; j < tiles[i].length; j++) {
                        String color = (j % 2 == 0) ? "white" : "black";
                        tiles[i][j] = new Tile(color);
                    }
                    break;
                case 3:
                case 5:
                    for (int j = 0; j < tiles[i].length; j++) {
                        String color = (j % 2 == 0) ? "black" : "white";
                        tiles[i][j] = new Tile(color);
                    }
                    break;
                case 6:
                    for (int j = 0; j < tiles[i].length; j++) {
                        String color = (j % 2 == 0) ? "white" : "black";
                        Tile tile = new Tile(color);
                        Piece piece = new Pawn(tile, "white");
                        tile.setPiece(piece);
                    }
                    break;
                case 7:
                    for (int j = 0; j < tiles[i].length; j++) {
                        String color = (j % 2 == 0) ? "black" : "white";
                        tiles[i][j] = createTile(j, color, "white");
                    }
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * Helper method that creates a tile and will create a piece if it is necessary for the current pos
     * @param pos The position within a given row
     * @param tileColor The color of the tile
     * @param pieceColor The color of the piece
     * @return A tile with a piece bound to it if necessary
     */
    private Tile createTile(int pos, String tileColor, String pieceColor) {
        Piece piece;
        Tile tile = new Tile(tileColor);
        // determine which piece should be generated
        piece = switch (pos) {
            // rook case
            case 0 -> new Rook(tile, pieceColor);
            // Knight case
            case 1 -> new Knight(tile, pieceColor);
            // Bishop case
            case 2 -> new Bishop(tile, pieceColor);
            // Queen case
            case 3 -> new Queen(tile, pieceColor);
            // King case
            case 4 -> new King(tile, pieceColor);
            // rest of the case are the same just mirrored;
            case 5 -> new Bishop(tile, pieceColor);
            case 6 -> new Knight(tile, pieceColor);
            case 7 -> new Rook(tile, pieceColor);
            default -> null;
        };

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
                    tile.setUp(tiles[i-1][j]);
                }
                if(!(i + 1 <= tiles.length)) {
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

    //will be responsible for painting the board on the panel.
}
