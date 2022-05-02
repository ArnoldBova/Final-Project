package src.pieces;

import java.util.ArrayList;

import javax.swing.JComponent;

import src.game.Tile;
import src.structures.Piece;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.Image;

public class Bishop extends Piece {
    // instance variables that are unanimous among all pieces are in the Pieces
    // abstract class. There may be relevant
    // 'per piece' instance variables that can be defined, such as hasMoved for a
    // rook to check for castling.

    public Bishop(Tile tile, boolean isWhite, JComponent container) {
        super(tile, isWhite, container);
        // do any other calculations per piece here if needed
    }

    // saving this implementation as a comment for reference later

    // public list getMovements(int moves){
    // if(moves > 0) {
    // movemnts.remove(0);
    // return movements;
    // }else{
    // return moves;
    // }
    // }

    @Override
    public ArrayList<Tile> getValidMoves() {
        ArrayList<Tile> outcomes = new ArrayList<>();

        // create a new arraylist and add the end position tile of valid moves to it
        // doesn't need to be an instance variable because we don't care about old
        // possible moves
        // only ones based on the current position.

        Tile captureTileUpR;
        Tile captureTileUpL;
        Tile captureTileDL;
        Tile captureTileDR;
        Tile nonCaptureTile1 = null;
        Tile nonCpatureTile2 = null;
        boolean wall = false;
        if (tile.up() != null) {
            captureTileUpR = tile.up();
            if (captureTileUpR.right() != null) {
                captureTileUpR = captureTileUpR.right();
            } else {
                captureTileUpR = null;
            }

        } else {
            captureTileUpR = null;
        }

        if (tile.up() != null) {
            captureTileUpL = tile.up();
            if (captureTileUpL.left() != null) {
                captureTileUpL = captureTileUpL.left();
            } else {
                captureTileUpL = null;
            }
        } else {
            captureTileUpL = null;
        }

        if (tile.down() != null) {
            captureTileDL = tile.down();
            if (captureTileDL.left() != null) {
                captureTileDL = captureTileDL.left();
            } else {
                captureTileDL = null;
            }

        } else {
            captureTileDL = null;
        }
        if (tile.down() != null) {
            captureTileDR = tile.down();
            if (captureTileDR.right() != null) {
                captureTileDR = captureTileDR.right();
            } else {
                captureTileDR = null;
            }
        } else {
            captureTileDR = null;
        }

        if (isWhite) {
            wall = false;
            while (captureTileUpR != null && wall == false) {
                if (captureTileUpR.hasPiece() && !captureTileUpR.piece().isWhite()) {
                    outcomes.add(captureTileUpR);
                    wall = true;
                } else {
                    if (!captureTileUpR.hasPiece()) {
                        wall = true;
                    } else {
                        outcomes.add(captureTileUpR);
                        if (captureTileUpR.right() != null) {
                            captureTileUpR = captureTileUpR.right();
                            if (captureTileUpR.up() != null) {
                                captureTileUpR = captureTileUpR.up();
                            } else {
                                wall = true;
                            }
                        } else {
                            wall = true;
                        }
                    }
                }
            }

            wall = false;
            while (captureTileUpL != null && wall == false) {
                if (captureTileUpL.hasPiece() && !captureTileUpL.piece().isWhite()) {
                    outcomes.add(captureTileUpL);
                    wall = true;
                } else {
                    if (captureTileUpL.hasPiece()) {
                        wall = true;
                    } else {
                        outcomes.add(captureTileUpL);
                        if (captureTileUpL.left() != null) {
                            captureTileUpL = captureTileUpL.left();
                            if (captureTileUpL.up() != null) {
                                captureTileUpL = captureTileUpL.up();
                            } else {
                                wall = true;
                            }
                        } else {
                            wall = true;
                        }
                    }
                }
            }

            wall = false;
            while (captureTileDR != null && wall == false) {
                if (captureTileDR.hasPiece() && !captureTileDR.piece().isWhite()) {
                    outcomes.add(captureTileDR);
                    wall = true;
                } else {
                    if (captureTileDR.hasPiece()) {
                        wall = true;
                    } else {
                        outcomes.add(captureTileDR);
                        if (captureTileDR.right() != null) {
                            captureTileDR = captureTileDR.left();
                            if (captureTileDR.down() != null) {
                                captureTileDR = captureTileDR.down();
                            } else {
                                wall = true;
                            }
                        } else {
                            wall = true;
                        }
                    }
                }
            }

            wall = false;
            while (captureTileDL != null && wall == false) {
                if (captureTileDL.hasPiece() && !captureTileDL.piece().isWhite()) {
                    outcomes.add(captureTileDL);
                    wall = true;
                } else {
                    if (captureTileDR.hasPiece()) {
                        wall = true;
                    } else {
                        outcomes.add(captureTileDL);
                        if (captureTileDL.left() != null) {
                            captureTileDL = captureTileDL.left();
                            if (captureTileDL.down() != null) {
                                captureTileDL = captureTileDL.down();
                            } else {
                                wall = true;
                            }
                        } else {
                            wall = true;
                        }
                    }
                }
            }

        } else {
            wall = false;
            while (captureTileUpR != null && wall == false) {
                if (captureTileUpR.hasPiece() && captureTileUpR.piece().isWhite()) {
                    outcomes.add(captureTileUpR);
                    wall = true;
                } else {
                    if (captureTileUpR.hasPiece()) {
                        wall = true;
                    } else {
                        outcomes.add(captureTileUpR);
                        if (captureTileUpR.right() != null) {
                            captureTileUpR = captureTileUpR.right();
                            if (captureTileUpR.up() != null) {
                                captureTileUpR = captureTileUpR.up();
                            } else {
                                wall = true;
                            }
                        } else {
                            wall = true;
                        }
                    }
                }
            }

            wall = false;
            while (captureTileUpL != null && wall == false) {
                if (captureTileUpL.hasPiece() && captureTileUpL.piece().isWhite()) {
                    outcomes.add(captureTileUpL);
                    wall = true;
                } else {
                    if (captureTileUpL.hasPiece()) {
                        wall = true;
                    } else {
                        outcomes.add(captureTileUpL);
                        if (captureTileUpL.left() != null) {
                            captureTileUpL = captureTileUpL.left();
                            if (captureTileUpL.up() != null) {
                                captureTileUpL = captureTileUpL.up();
                            } else {
                                wall = true;
                            }
                        } else {
                            wall = true;
                        }
                    }
                }
            }

            wall = false;
            while (captureTileDR != null && wall == false) {
                if (captureTileDR.hasPiece() && captureTileDR.piece().isWhite()) {
                    outcomes.add(captureTileDR);
                    wall = true;
                } else {
                    if (captureTileDR.hasPiece()) {
                        wall = true;
                    } else {
                        outcomes.add(captureTileDR);
                        if (captureTileDR.right() != null) {
                            captureTileDR = captureTileDR.left();
                            if (captureTileDR.down() != null) {
                                captureTileDR = captureTileDR.down();
                            } else {
                                wall = true;
                            }
                        } else {
                            wall = true;
                        }
                    }
                }
            }

            wall = false;
            while (captureTileDL != null && wall == false) {
                if (captureTileDL.hasPiece() && captureTileDL.piece().isWhite()) {
                    outcomes.add(captureTileDL);
                    wall = true;
                } else {
                    if (captureTileDR.hasPiece()) {
                        wall = true;
                    } else {
                        outcomes.add(captureTileDL);
                        if (captureTileDL.left() != null) {
                            captureTileDL = captureTileDL.left();
                            if (captureTileDL.down() != null) {
                                captureTileDL = captureTileDL.down();
                            } else {
                                wall = true;
                            }
                        } else {
                            wall = true;
                        }
                    }
                }
            }

        }

        return outcomes;
    }

    @Override
    public void run() {
        // this is here for animation things
    }

    @Override
    public void paint(Graphics g) {

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image pieceImage;
        if (this.isWhite) {
            pieceImage = toolkit.getImage("../Images/WhitePieces/WhiteBishop.png");
        } else {
            pieceImage = toolkit.getImage("../Images/WhitePieces/BlackBishop.png");
        }

        // we will need to include x coordinates within the correct tile
        g.drawImage(pieceImage, 0, 0, null);

    }

}
