package src.game;

import src.structures.Piece;

public class Player {
    // Indicates if the player has lost
    protected boolean hasLost;

    // Indicates if the player has won
    protected boolean hasWon;

    // This player's pieces
    protected Piece[] pieces;

    // The board the player is playing on
    protected Board board;

    // The timer that tracks how much time this player has used
    ChessTimer timer;

    /**
     * Constructs a new Player
     * 
     * @param board  The board the player will use
     * @param pieces The pieces the player will use
     * @param timer  The timer the player will use
     */
    public Player(Board board, Piece[] pieces, ChessTimer timer) {
        this.board = board;
        this.pieces = pieces;
        this.timer = timer;

        this.hasWon = false;
        this.hasLost = false;
    }

    /**
     * Returns true if the player has lost, and false otherwise
     * 
     * @return Whether the player has lost
     */
    public boolean hasLost() {
        return hasLost;
    }

    /**
     * Returns true if the player has won
     * 
     * @return Whether the player has won
     */
    public boolean hasWon() {
        return hasWon;
    }

    /**
     * Moves one of the player's pieces to a new location on the board
     * (This could be a random piece, or we could make subclasses that play moves at
     * varying levels of difficulty)
     */
    public void movePiece() {

    }

}
