package src.game;

import src.structures.Piece;

public class Player {
    boolean inCheck;
    boolean isWhite;

    public Player(boolean isWhite) {
        inCheck = false;
        this.isWhite = isWhite;
    }

    public boolean isWhite() {
        return isWhite;
    }

    public boolean isInCheck() {
        return inCheck;
    }
    public void inCheck () {
        inCheck = true;
    }
    public void outOfCheck() {
        inCheck = false;
    }
}
