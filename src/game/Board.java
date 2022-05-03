package src.game;

import src.pieces.*;
import src.structures.Piece;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Board {
    Tile[][] tiles;

    ArrayList<Piece> whitePieces;
    ArrayList<Piece> blackPieces;

    JComponent container;

    /**
     * constructs a new board, populating the 2d array of tile objects with each
     * piece in the correct place to start a new game.
     *
     * The board will be oriented such that the white piece player will be at the
     * bottom of the screen.
     */
    public Board(JComponent container) {
        tiles = new Tile[8][8];
        whitePieces = new ArrayList<>();
        blackPieces = new ArrayList<>();
        this.container = container;
        generateBoard();
        createLinks();
    }

    private void generateBoard() {
        for (int y = 0; y < 8; y++) {
            switch (y) {
                case 0:
                    for (int x = 0; x < 8; x++) {
                        tiles[y][x] = createTile(x % 2 == 0, false, x, y);
                    }
                    break;
                case 1:
                    for (int x = 0; x < 8; x++) {
                        Tile tile = new Tile(x % 2 != 0, x, y);
                        Piece piece = new Pawn(tile, false, this.container);
                        blackPieces.add(piece);
                        tile.setPiece(piece);
                        tiles[y][x] = tile;
                    }
                    break;
                case 2:
                case 4:
                    for (int x = 0; x < 8; x++) {
                        tiles[y][x] = new Tile(x % 2 == 0, x, y);
                    }
                    break;
                case 3:
                case 5:
                    for (int x = 0; x < 8; x++) {
                        tiles[y][x] = new Tile(x % 2 != 0, x, y);
                    }
                    break;
                case 6:
                    for (int x = 0; x < 8; x++) {
                        Tile tile = new Tile(x % 2 == 0, x, y);
                        Piece piece = new Pawn(tile, true, this.container);
                        whitePieces.add(piece);
                        tile.setPiece(piece);
                        tiles[y][x] = tile;
                    }
                    break;
                case 7:
                    for (int x = 0; x < 8; x++) {
                        tiles[y][x] = createTile(x % 2 != 0, true, x, y);
                    }
                    break;
                default:
                    break;
            }
        }
    }

    private void createLinks() {
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                Tile currTile = tiles[y][x];

                // up
                if (!(y - 1 < 0)) {
                    currTile.setUp(tiles[y - 1][x]);
                }
                //down
                if (!(y + 1 >=8)) {
                    currTile.setDown(tiles[y + 1][x]);
                }
                //left
                if (!(x - 1 < 0)) {
                    currTile.setLeft(tiles[y][x - 1]);
                }
                //right
                if(!(x + 1 >=8)) {
                    currTile.setRight(tiles[y][x + 1]);
                }
            }
        }
    }

    private Tile createTile(boolean isWhiteTile, boolean isWhitePiece, int x, int y) {
        Piece piece;
        Tile tile = new Tile(isWhiteTile, x, y);
        switch (x) {
            case 0:
            case 7:
                piece = new Rook(tile, isWhitePiece, this.container);
                break;
            case 1:
            case 6:
                piece = new Knight(tile, isWhitePiece, this.container);
                break;
            case 2:
            case 5:
                piece = new Bishop(tile, isWhitePiece, this.container);
                break;
            case 3:
                piece = new Queen(tile, isWhitePiece, this.container);
                break;
            case 4:
                piece = new King(tile, isWhitePiece, this.container);
                break;
            default:
                piece = null;
                break;
        }

        if (piece != null) {
            if (isWhitePiece) {
                whitePieces.add(piece);
            } else {
                blackPieces.add(piece);
            }
        }

        tile.setPiece(piece);

        return tile;
    }

    public void paint(Graphics g) {
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                Tile drawingTile = tiles[y][x];
                if (drawingTile.isHighlighted()) {
                    g.setColor(Color.green);
                } else if (drawingTile.isHighlightedForCapture()) {
                    g.setColor(Color.red);
                } else if (drawingTile.isWhite) {
                    g.setColor(Color.white);
                } else {
                    g.setColor(Color.black);
                }

                g.fillRect(x * 50 + 40, y * 50, 50, 50);
                g.setColor(Color.BLACK);
                g.drawRect(x * 50 + 40, y * 50, 50, 50);
            }
        }
        for (int i = 0; i < whitePieces.size(); i++) {
            Piece piece = whitePieces.get(i);
            if(!piece.isCaptured()){
                    piece.paint(g);
           }else{
               whitePieces.remove(piece);
           }
        }

        for (int i = 0; i < blackPieces.size(); i++) {
            Piece piece = blackPieces.get(i);
            if(!piece.isCaptured()){
                     piece.paint(g);
            }else{
                blackPieces.remove(piece);
            }
         }
    }

    public Tile getTile(Point point) {
        Tile tile = null;

        int x = point.x, y = point.y;
        int tileX = (x + 10)/50 - 1;
        int tileY = y / 50;

        tile = tiles[tileY][tileX];


        return tile;
    }
}
