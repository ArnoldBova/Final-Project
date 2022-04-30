package src.game;

import src.pieces.*;
import src.structures.Piece;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Chess extends MouseAdapter implements Runnable, ActionListener{
    JButton restartGame = new JButton("Restart Game");
    JButton speedChess = new JButton("Speed Chess Mode Toggle");
    JLabel playerOne = new JLabel("Player One: White");
    JLabel playerTwo = new JLabel("Player Two: Black");
    boolean speedChessMode = false;
    //these two labels aren't used yet but are there for speed chess mode
    JLabel playerOneClock = new JLabel("Time Remaining: ");
    JLabel playerTwoClock = new JLabel("Time Remaining: ");

    Board board;

    public void run(){
        JFrame frame = new JFrame("Chess");
        JFrame.setDefaultLookAndFeelDecorated(true);
        frame.setResizable(false);
        frame.setPreferredSize(new Dimension(500, 550));
        JPanel gamePanel = new JPanel(new BorderLayout());
	    frame.add(gamePanel);
        //the player panel will hold the players and if they are in speed chess mode, the timers
        JPanel playerPanel = new JPanel(new FlowLayout());
        gamePanel.add(playerPanel, BorderLayout.NORTH);
        playerPanel.add(playerOne);
        playerPanel.add(playerTwo);
        //the board panel will hold the game board that is being played on
        board = new Board();
        JPanel boardPanel = new JPanel(new FlowLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                board.paintComponent(g);
            }
        };
        gamePanel.add(boardPanel, BorderLayout.CENTER);
        //the button panel will hold the buttons, such as restart game, speed chess mode, and other buttons as needed
        JPanel buttonPanel = new JPanel(new FlowLayout());
        gamePanel.add(buttonPanel, BorderLayout.SOUTH);
        restartGame.addActionListener(this);
        speedChess.addActionListener(this);
        buttonPanel.add(restartGame);
        buttonPanel.add(speedChess);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
	    frame.setVisible(true);    
    }


    public void actionPerformed(ActionEvent e){
        if(e.getSource() == speedChess){
            speedChessMode = !speedChessMode;
            //add or remove chess clock labels
        }
        if(e.getSource() == restartGame){
            //Get the game to restart
        }
    }

    @Override
    public void mousePressed(MouseEvent e){
        /*TODO:
        *if the mouse is pressed on a tile with a piece of the active player's color, all the possible moves for that tile should be highlighted
        *if the mouse has already pressed on a piece, pressing on a tile that is a legal move should result in the move happening
        *if the mouse has already pressed on a piece, pressing on a new piece of the active player's color should unhighlight all the previously highlighted spots and highlight the new legal moves
        */
    }


    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Chess()); 
    }
}
