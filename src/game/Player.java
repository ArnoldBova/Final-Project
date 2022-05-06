package src.game;

import src.structures.Piece;

/**
 * @authors Arnold Bova, Nicky Morgan, Ethan Tubia, Emma Flatland
 * 
 *          A player who plays chess
 */

public class Player {
    boolean inCheck;
    boolean isWhite;

    /**
     * Constructs a player and assigns
     * the player a color of piece
     * 
     * @param isWhite a boolean that determines color
     */

    public Player(boolean isWhite) {
        inCheck = false;
        this.isWhite = isWhite;
    }

    /**
     * returns the value stored in
     * isWhite
     * 
     * @return isWhite a boolean value that is true
     *         when the player has the white pieces
     */

    public boolean isWhite() {
        return isWhite;
    }

    /**
     * returns the value stored in
     * inCheck
     * 
     * @return inCheck a boolean value that
     *         is true when the player's king is in
     *         check
     */

    public boolean isInCheck() {
        return inCheck;
    }

    /**
     * sets the inCheck instance
     * variable for the player it
     * is called on to true.
     */

    public void inCheck() {
        inCheck = true;
    }

    /**
     * sets the inCheck instance
     * variable for the player it
     * is called on to false.
     */

    public void outOfCheck() {
        inCheck = false;
    }

    /**
     * returns a the color the player
     * it is called on in a string
     * 
     * @returns String consisting of
     *          the player's color, and the word player
     */

    @Override
    public String toString() {
        if (isWhite) {
            return "White Player";
        }
        return "Black Player";
    }
}
