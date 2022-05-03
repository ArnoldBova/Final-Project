package src;

import src.pieces.*;
import src.structures.Piece;
import src.game.*;
import javax.swing.*;
import javax.swing.Timer;
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

    Board board;

    Timer test = new Timer(1000, this);


    boolean currentlySelectingMove = false;
    ArrayList<Tile> moves = null;
    Tile currTile = null;

    public void run() {

        JFrame frame = new JFrame("Chess");
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
            };
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
        test.start();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == pause) {
            paused = !paused;
            // add or remove chess clock labels
        }
        if (e.getSource() == restartGame) {
            this.board = new Board(this.boardPanel);
            boardPanel.repaint();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        Point clickedPoint = e.getPoint();

        Tile tileOnClick = board.getTile(clickedPoint);

        if (currentlySelectingMove) {
            if (moves.contains(tileOnClick)) {
                tileOnClick.setPiece(currTile.piece());
                currTile.setPiece(null);
            }
            currentlySelectingMove = false;
            currTile = null;
            for(Tile tile : moves) {
                tile.unHighlight();
            }
            moves = null;
        } else {
            if (tileOnClick.hasPiece()) {
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





    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Chess());
    }
}
