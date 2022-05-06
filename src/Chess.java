package src;

import src.pieces.*;
import src.structures.Piece;
import src.structures.MovingThread;
import src.game.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * @authors Arnold Bova, Nicky Morgan, Ethan Tubia, Emma Flatland
 * @assignment Final project for CSIS 225
 *             A chess game meant to be played between two people using the same
 *             computer.
 */
public class Chess extends MouseAdapter implements Runnable, ActionListener {

    // The timers for the players
    ChessTimer whitePlayerTimer;
    ChessTimer blackPlayerTimer;

    // GUI components
    JPanel boardPanel;
    JFrame frame;
    JButton restartGame;
    JLabel playerOne;
    JLabel playerTwo;
    Board board;

    // Whether the white or black player is in check
    boolean blackCheck;
    boolean whiteCheck;

    // The players
    Player whitePlayer;
    Player blackPlayer;
    Player currentTurn;

    // What point of the game it is
    boolean isWhitePlayerTurn;
    boolean currentlySelectingMove;

    // The moves a given piece can legally make
    ArrayList<Tile> moves = null;

    // The tile with the piece that the player wants to move
    Tile currTile = null;

    MovingThread mover;

    /**
     * creates the window for the game, and
     * calls the paint method for the board
     */

    public void run() {

        restartGame = new JButton("Restart Game");
        playerOne = new JLabel("White Player: 10:00");
        playerTwo = new JLabel("Black Player: 10:00");

        whitePlayerTimer = new ChessTimer(600, playerOne, true, frame);
        blackPlayerTimer = new ChessTimer(600, playerTwo, false, frame);

        isWhitePlayerTurn = true;
        currentlySelectingMove = false;

        whitePlayer = new Player(true);
        blackPlayer = new Player(false);
        currentTurn = whitePlayer;

        frame = new JFrame("Chess");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JFrame.setDefaultLookAndFeelDecorated(true);
        frame.setPreferredSize(new Dimension(500, 550));
        frame.setResizable(false);

        JPanel container = new JPanel(new BorderLayout());

        JPanel playContainer = new JPanel();
        playContainer.add(playerOne);
        playContainer.add(playerTwo);
        whitePlayerTimer.start();
        whitePlayerTimer.unPause();
        blackPlayerTimer.start();

        this.boardPanel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                board.paint(g);
            }
        };
        boardPanel.addMouseListener(this);
        board = new Board(boardPanel);

        JPanel buttonContainer = new JPanel();
        restartGame.addActionListener(this);
        buttonContainer.add(restartGame);

        container.add(boardPanel, BorderLayout.CENTER);
        container.add(playContainer, BorderLayout.NORTH);
        container.add(buttonContainer, BorderLayout.SOUTH);

        frame.add(container);

        frame.pack();
        frame.setVisible(true);
    }

    /**
     * provides functionality to the buttons in the window
     * restarts the game when restart is clicked
     * and pauses the game when pause is clicked
     * 
     * @param e the action event
     */

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == restartGame) {
            this.board = new Board(this.boardPanel);
            currentlySelectingMove = false;
            currTile = null;
            moves = null;
            blackPlayerTimer.pause();
            whitePlayerTimer.unPause();
            whitePlayerTimer.reset();
            blackPlayerTimer.reset();
            whitePlayer = new Player(true);
            blackPlayer = new Player(false);
            currentTurn = whitePlayer;
            boardPanel.repaint();
        }
    }

    /**
     * checks the piece being clicked, then checks the tile clicked
     * moving the piece only when the tile clicked is in the piece’s
     * valid moves array, and calls the repaint method of board
     * when a change is made
     *
     * @param e the mouse event
     */

    @Override
    public void mouseClicked(MouseEvent e) {

        Point clickedPoint = e.getPoint();

        // if ()
        try {

            Tile tileOnClick = board.getTile(clickedPoint);

            if (currentlySelectingMove) {
                if (moves.contains(tileOnClick)) {
                    // Pause the timer of the player who just went,
                    // & start the timer of the player whose turn it is now
                    if (currentTurn == whitePlayer) {
                        whitePlayerTimer.pause();
                        blackPlayerTimer.unPause();
                    } else {
                        blackPlayerTimer.pause();
                        whitePlayerTimer.unPause();
                    }
                    currentTurn = (currentTurn == whitePlayer) ? blackPlayer : whitePlayer;
                    if (currTile.piece() instanceof Pawn) {
                        ((Pawn) currTile.piece()).moved();
                    }
                    if (tileOnClick.hasPiece()) {
                        tileOnClick.piece().setCapture();
                    }
                    mover = new MovingThread(currTile.piece(), currTile, tileOnClick, boardPanel);
                    mover.start();
                    tileOnClick.setPiece(currTile.piece());
                    tileOnClick.piece().setTile(tileOnClick);
                    currTile.setPiece(null);
                    if (tileOnClick.piece() instanceof Pawn) {
                        // Display an input dialog where the player can specify the piece they want to
                        // replace their pawn with
                        // This occurs when the white player has reached the end of the board
                        if (tileOnClick.piece().isWhite()) {
                            if (tileOnClick.location().y == 0) {
                                String input = JOptionPane.showInputDialog(frame, "Enter which Piece you want");
                                boolean inputIsValid = false;
                                while (!inputIsValid) {
                                    if (input != null) {
                                        input = input.toLowerCase();
                                    }

                                    switch (input) {
                                        case "queen": {
                                            inputIsValid = true;
                                            tileOnClick.piece().setCapture();
                                            Piece newPiece = new Queen(tileOnClick, true, boardPanel);
                                            tileOnClick.setPiece(newPiece);
                                            board.addPiece(newPiece);
                                            break;
                                        }
                                        case "bishop": {
                                            inputIsValid = true;
                                            tileOnClick.piece().setCapture();
                                            Piece newPiece = new Bishop(tileOnClick, true, boardPanel);
                                            tileOnClick.setPiece(newPiece);
                                            board.addPiece(newPiece);
                                            break;
                                        }
                                        case "rook": {
                                            inputIsValid = true;
                                            tileOnClick.piece().setCapture();
                                            Piece newPiece = new Rook(tileOnClick, true, boardPanel);
                                            tileOnClick.setPiece(newPiece);
                                            board.addPiece(newPiece);
                                            break;
                                        }
                                        case "knight": {
                                            inputIsValid = true;
                                            tileOnClick.piece().setCapture();
                                            Piece newPiece = new Knight(tileOnClick, true, boardPanel);
                                            tileOnClick.setPiece(newPiece);
                                            board.addPiece(newPiece);
                                            break;
                                        }
                                        default:
                                            input = JOptionPane.showInputDialog(frame,
                                                    "Please Enter a Valid Piece Name");
                                    }
                                }
                            }

                        }

                        // Display an input dialog where the player can specify the piece they want to
                        // to replace their pawn with
                        // This occurs when the black player has reached the end of the board

                        else if (tileOnClick.location().y == 7) {
                            String input = JOptionPane.showInputDialog(frame, "Enter which Piece you want");
                            boolean inputIsValid = false;
                            while (!inputIsValid) {
                                input = input.toLowerCase();
                                switch (input) {
                                    case "queen": {
                                        inputIsValid = true;
                                        tileOnClick.piece().setCapture();
                                        Piece newPiece = new Queen(tileOnClick, false, boardPanel);
                                        tileOnClick.setPiece(newPiece);
                                        board.addPiece(newPiece);
                                        break;
                                    }
                                    case "bishop": {
                                        inputIsValid = true;
                                        tileOnClick.piece().setCapture();
                                        Piece newPiece = new Bishop(tileOnClick, false, boardPanel);
                                        tileOnClick.setPiece(newPiece);
                                        board.addPiece(newPiece);
                                        break;
                                    }
                                    case "rook": {
                                        inputIsValid = true;
                                        tileOnClick.piece().setCapture();
                                        Piece newPiece = new Rook(tileOnClick, false, boardPanel);
                                        tileOnClick.setPiece(newPiece);
                                        board.addPiece(newPiece);
                                        break;
                                    }
                                    case "knight": {
                                        inputIsValid = true;
                                        tileOnClick.piece().setCapture();
                                        Piece newPiece = new Knight(tileOnClick, false, boardPanel);
                                        tileOnClick.setPiece(newPiece);
                                        board.addPiece(newPiece);
                                        break;
                                    }
                                    default:
                                        input = JOptionPane.showInputDialog(frame,
                                                "Please Enter a Valid Piece Name");
                                }
                            }
                        }
                    }
                }
                currentlySelectingMove = false;
                currTile = null;

                // See if the king is in check
                King king = board.getKing(currentTurn.isWhite());
                if (king.isCheck(king.getTile())) {
                    System.out.println("seeing if king is in check");
                    currentTurn.inCheck();
                }
                // See if the King is in check mate
                if (currentTurn.isInCheck()) {
                    System.out.println("Seeing if king is in check mate");
                    ArrayList<Tile> validMoves = king.getValidMoves();

                    if (validMoves.size() == 0) {
                        JOptionPane.showMessageDialog(frame, currentTurn + " lost");
                    }

                }
                // remove the green & red coloring from the tiles
                for (Tile tile : moves) {
                    tile.unHighlight();
                }
                moves = null;
            } else {

                // if (currentTurn.isInCheck()) {
                // King king = board.getKing(currentTurn.isWhite());
                // ArrayList<Tile> validMoves = king.getValidMoves();
                // if (validMoves.size() == 0) {
                // JOptionPane.showMessageDialog(frame, currentTurn + "lost");
                // }

                // }

                if (tileOnClick.hasPiece() && tileOnClick.piece().isWhite() == currentTurn.isWhite()) {

                    // only be able to move the king in this case because it is in check
                    Piece currentPiece = tileOnClick.piece();
                    if (currentPiece instanceof King) {
                        currTile = tileOnClick;
                        currentlySelectingMove = true;
                        ArrayList<Tile> moves = currentPiece.getValidMoves();
                        this.moves = moves;
                        for (Tile tile : moves) {
                            if (tile.hasPiece()) {
                                tile.highlightForCapture();
                            } else {
                                tile.highlight();
                            }
                        }
                    } else {
                        currTile = tileOnClick;
                        currentlySelectingMove = true;
                        ArrayList<Tile> moves = currentPiece.getValidMoves();
                        this.moves = moves;
                        for (Tile tile : moves) {
                            if (tile.hasPiece()) {
                                tile.highlightForCapture();
                            } else {
                                tile.highlight();
                            }
                        }
                    }
                }
            }
        } catch (ArrayIndexOutOfBoundsException error) {
            if (currentlySelectingMove) {
                currentlySelectingMove = false;
                currTile = null;
                for (Tile tile : moves) {
                    tile.unHighlight();
                }
                moves = null;
            }
        }
        boardPanel.repaint();

    }

    /**
     * After each player's turn, this method checks if the opposing king has been
     * put into check
     * 
     * If the opposing king is in check, the opponent can only move the king on
     * their next turn
     */
    public void seeIfInCheck() {

        // Determine which king may have been put into check
        if (currentTurn == whitePlayer) {
            King king = board.getKing(true);
            king.seeIfInCheck();
        } else {
            King king = board.getKing(false);
            king.seeIfInCheck();
        }

    }

    /**
     * invokes the Chess class
     */

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Chess());
    }
}
