package src.pieces;

import java.util.ArrayList;

import src.game.Tile;
import src.structures.Piece;

public class Knight extends Piece {

    public Knight(Tile tile, boolean isWhite) {
        super(tile, isWhite);
    }

    @Override
    public ArrayList<Tile> getValidMoves() {
        ArrayList<Tile> outcomes = new ArrayList<>();

        Tile horizontalL1;
        Tile horizontalL2;
        Tile horizontalL3;
        Tile horizontalL4;
        Tile verticalL1;
        Tile verticalL2;
        Tile verticalL3;
        Tile verticalL4;

        // find horizontalL1 tile
        horizontalL1 = this.tile.up();
        if (horizontalL1 != null) {
            horizontalL1 = horizontalL1.right();
            if (horizontalL1 != null) {
                horizontalL1 = horizontalL1.right();
                if (horizontalL1 != null) {
                    if ((horizontalL1.hasPiece() && horizontalL1.piece().isOpponent(this)) || (!horizontalL1.hasPiece())) {
                        outcomes.add(horizontalL1);
                    }
                }
            }
        }

            // find horizontalL2 tile
        horizontalL2 = this.tile.down();
        if (horizontalL2 != null) {
            horizontalL2 = horizontalL2.right();
            if (horizontalL2 != null) {
                horizontalL2 = horizontalL2.right();
                if (horizontalL2 != null) {
                    if ((horizontalL2.hasPiece() && horizontalL2.piece().isOpponent(this)) || (!horizontalL2.hasPiece())) {
                        outcomes.add(horizontalL2);
                    }
                }
            }
        }

        // find horizontalL3 tile
        horizontalL3 = this.tile.down();
        if (horizontalL3 != null) {
            horizontalL3 = horizontalL3.left();
            if (horizontalL3 != null) {
                horizontalL3 = horizontalL3.left();
                if (horizontalL3 != null) {
                    if ((horizontalL3.hasPiece() && horizontalL3.piece().isOpponent(this)) || (!horizontalL3.hasPiece())) {
                        outcomes.add(horizontalL3);
                    }
                }
            }
        }

        // find horizontalL4 tile
        horizontalL4 = this.tile.up();
        if (horizontalL4 != null) {
            horizontalL4 = horizontalL4.left();
            if (horizontalL4 != null) {
                horizontalL4 = horizontalL4.left();
                if (horizontalL4 != null) {
                    if ((horizontalL4.hasPiece() && horizontalL4.piece().isOpponent(this)) || (!horizontalL4.hasPiece())) {
                        outcomes.add(horizontalL4);
                    }
                }
            }
        }

        // find verticalL1 tile
        verticalL1 = this.tile.up();
        if (verticalL1 != null) {
            verticalL1 = verticalL1.up();
            if (verticalL1 != null) {
                verticalL1 = verticalL1.right();
                if (verticalL1 != null) {
                    if ((verticalL1.hasPiece() && verticalL1.piece().isOpponent(this)) || (!verticalL1.hasPiece())) {
                        outcomes.add(verticalL1);
                    }
                }
            }
        }

        // find verticalL2 tile
        verticalL2 = this.tile.down();
        if (verticalL2 != null) {
            verticalL2 = verticalL2.down();
            if (verticalL2 != null) {
                verticalL2 = verticalL2.right();
                if (verticalL2 != null) {
                    if ((verticalL2.hasPiece() && verticalL2.piece().isOpponent(this)) || (!verticalL2.hasPiece())) {
                        outcomes.add(verticalL2);
                    }
                }
            }
        }

        // find verticalL3 tile
        verticalL3 = this.tile.down();
        if (verticalL3 != null) {
            verticalL3 = verticalL3.down();
            if (verticalL3 != null) {
                verticalL3 = verticalL3.left();
                if (verticalL3 != null) {
                    if ((verticalL3.hasPiece() && verticalL3.piece().isOpponent(this)) || (!verticalL3.hasPiece())) {
                        outcomes.add(verticalL3);
                    }
                }
            }
        }

        verticalL4 = this.tile.up();
        if (verticalL4 != null) {
            verticalL4 = verticalL4.up();
            if (verticalL4 != null) {
                verticalL4 = verticalL4.left();
                if (verticalL4 != null) {
                    if ((verticalL4.hasPiece() && verticalL4.piece().isOpponent(this)) || (!verticalL4.hasPiece())) {
                        outcomes.add(verticalL4);
                    }
                }
            }
        }
        return outcomes;
    }

    @Override
    public void run() {
    }
}
