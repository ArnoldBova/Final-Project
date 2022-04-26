package src.game;

import src.structures.Piece;

public class Player {
    // Indicates if the player has lost
    protected boolean hasLost;

    // This player's pieces
    protected Piece[] pieces;

    // The board the player is playing on
    protected Board board;

    // The timer that tracks how much time this player has used
    Timer timer;

    // Returns true if the player has lost, and false otherwise
    public boolean hasLost() {
        return hasLost;
    }

    // Moves one of the player's pieces to a new location on the board
    // (This could be a random piece, or we could make subclasses that play moves at
    // varying levels of difficulty)
    public void movePiece() {

    }

}
