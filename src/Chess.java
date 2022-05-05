package src;

import src.pieces.*;
import src.structures.Piece;
import src.structures.MovingThread;
import src.game.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Chess extends MouseAdapter implements Runnable, ActionListener {
    JButton restartGame;
    JLabel playerOne;
    JLabel playerTwo;
    ChessTimer whitePlayerTimer;
    ChessTimer blackPlayerTimer;
    JPanel boardPanel;
    JFrame frame;
    Board board;

    boolean blackCheck;
    boolean whiteCheck;

    boolean isWhitePlayerTurn;
    Player whitePlayer;
    Player blackPlayer;
    Player currentTurn;

    boolean currentlySelectingMove;
    ArrayList<Tile> moves = null;
    Tile currTile = null;

    MovingThread mover;


    public void run() {

        restartGame = new JButton("Restart Game");
        playerOne = new JLabel("White Player: 10:00");
        playerTwo = new JLabel("Black Player: 10:00");

        whitePlayerTimer = new ChessTimer(600, playerOne, true);
        blackPlayerTimer = new ChessTimer(600, playerTwo, false);

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
        mover.start();

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

    @Override
    public void mouseClicked(MouseEvent e) {

        Point clickedPoint = e.getPoint();

//        if ()
        try {

            Tile tileOnClick = board.getTile(clickedPoint);

            if (currentlySelectingMove) {
                if (moves.contains(tileOnClick)) {
                    if(currentTurn == whitePlayer){
                        whitePlayerTimer.pause();
                        blackPlayerTimer.unPause();
                    }else {
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
                    //mover = new movingThread(currTile.piece(), currTile, tileOnClick, boardPanel);
                    tileOnClick.setPiece(currTile.piece());
                    tileOnClick.piece().setTile(tileOnClick);
                    currTile.setPiece(null);
                    if (tileOnClick.piece() instanceof Pawn) {
                        if (tileOnClick.piece().isWhite()) {
                            if (tileOnClick.location().y == 0) {
                                String input = JOptionPane.showInputDialog(frame, "Enter which Piece you want");
                                boolean inputIsValid = false;
                                while (!inputIsValid) {
                                    input = input.toLowerCase();
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
                            } else if (tileOnClick.location().y == 7) {
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
                }
                currentlySelectingMove = false;
                currTile = null;
                for (Tile tile : moves) {
                    tile.unHighlight();
                }
                moves = null;
            } else {

                if (currentTurn.isInCheck()) {
                    King king = board.getKing(currentTurn.isWhite());
                    ArrayList<Tile> validMoves = king.getValidMoves();
                    ArrayList<Piece> outOfCheckPieces = king.getOutOfCheckPieces();
                    if (validMoves.size() == 0 && outOfCheckPieces.size() == 0) {
                        //handle player loosing
                    }
                    if (tileOnClick.hasPiece() && ((tileOnClick.piece() instanceof King) || (outOfCheckPieces.contains(tileOnClick.piece()))) && tileOnClick.piece().isWhite() == currentTurn.isInCheck()) {
                        // each piece in outofcheckpieces should return a list of valid moves to get the king out of check
                    }

                }
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

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Chess());
    }
}
