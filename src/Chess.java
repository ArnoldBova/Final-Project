package src;

import src.pieces.*;
import src.structures.Piece;
import src.game.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Chess extends MouseAdapter implements Runnable, ActionListener {
    JButton restartGame = new JButton("Restart Game");
    JButton pause = new JButton("Pause");
    JLabel playerOne = new JLabel("Player One: WhiteTime Remaining: ");
    JLabel playerTwo = new JLabel("Player Two: BlackTime Remaining: ");
    boolean paused = false;
    JPanel boardPanel;
    JFrame frame;
    Board board;

    boolean isWhitePlayerTurn = true;

    boolean currentlySelectingMove = false;
    ArrayList<Tile> moves = null;
    Tile currTile = null;

    public void run() {

        frame = new JFrame("Chess");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JFrame.setDefaultLookAndFeelDecorated(true);
        frame.setPreferredSize(new Dimension(500, 550));
        frame.setResizable(false);

        JPanel container = new JPanel(new BorderLayout());

        JPanel playContainer = new JPanel();
        playContainer.add(playerOne);
        playContainer.add(playerTwo);

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
        pause.addActionListener(this);
        buttonContainer.add(restartGame);
        buttonContainer.add(pause);

        container.add(boardPanel, BorderLayout.CENTER);
        container.add(playContainer, BorderLayout.NORTH);
        container.add(buttonContainer, BorderLayout.SOUTH);

        frame.add(container);

        frame.pack();
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == pause) {
            paused = !paused;
            // String input = JOptionPane.showInputDialog(frame, "Enter which Piece you
            // want");
            // boolean inputIsValid = false;
            // while(!inputIsValid){
            // input = input.toLowerCase();
            // if(input.equals("queen")){
            // inputIsValid = true;
            // }else if(input.equals("bishop")){
            // inputIsValid = true;
            // }else if(input.equals("rook")){
            // inputIsValid = true;
            // }else if(input.equals("knight")){
            // inputIsValid = true;
            // }else{
            // input = JOptionPane.showInputDialog(frame, "Please Enter a Valid Piece
            // Name");
            // }
            // }
            // add or remove chess clock labels
        }
        if (e.getSource() == restartGame) {
            this.board = new Board(this.boardPanel);
            currentlySelectingMove = false;
            currTile = null;
            moves = null;
            boardPanel.repaint();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        Point clickedPoint = e.getPoint();
        try {

            Tile tileOnClick = board.getTile(clickedPoint);

            if (currentlySelectingMove) {
                if (moves.contains(tileOnClick)) {
                    if (currTile.piece() instanceof Pawn) {
                        ((Pawn) currTile.piece()).moved();
                    }
                    if (tileOnClick.hasPiece()) {
                        tileOnClick.piece().setCapture();
                        tileOnClick.removePiece();
                    }
                    tileOnClick.setPiece(currTile.piece());
                    currTile.piece().setTile(tileOnClick);
                    currTile.setPiece(null);
                    isWhitePlayerTurn = !isWhitePlayerTurn;
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
                            }
                        } else {
                            if (tileOnClick.location().y == 7) {
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
                    boardPanel.repaint();
                }
                currentlySelectingMove = false;
                currTile = null;
                for (Tile tile : moves) {
                    tile.unHighlight();
                }
                moves = null;
            } else {
                if (tileOnClick.hasPiece() && tileOnClick.piece().isWhite() == isWhitePlayerTurn) {
                    Piece currentPiece = tileOnClick.piece();
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
            boardPanel.repaint();
        } catch (ArrayIndexOutOfBoundsException error) {
            if (currentlySelectingMove) {
                currentlySelectingMove = false;
                currTile = null;
                for (Tile tile : moves) {
                    tile.unHighlight();
                }
                moves = null;
                boardPanel.repaint();
            }
        }

    }

    /**
     * Checks if the king has been put into check
     */
    public void inCheck() {

        // Determine which king may have been put into check
        if (isWhitePlayerTurn) {
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
