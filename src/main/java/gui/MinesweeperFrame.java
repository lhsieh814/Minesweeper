package gui;

import game.Board;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import levels.Beginner;

public class MinesweeperFrame {

	private JFrame jFrame;
	private Image bombImg;
	private Image flagImg;
	private static CustomCellButton [][] grid;
	public static boolean gameOver = false;

    public static int bombCount;
    public static boolean[][] bombGuess;

	public static Board board;

	public MinesweeperFrame() {
		// Default to beginner level
		board = new Board(new Beginner());
		
		jFrame = new JFrame();
		jFrame.setTitle("Minesweeper");
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setSize(400, 450);
		jFrame.setBackground(Color.white);
		jFrame.setLayout(new BorderLayout());
		// jFrame.setResizable(false);


		jFrame.setJMenuBar(initMenuBar());

		initPanels();
//		initImages();

		jFrame.pack(); // Create frame from minimum needed size
		jFrame.setVisible(true);

        bombCount = 0;
        bombGuess = new boolean[board.getLength()][board.getHeight()];
	}

	/**
	 * Creates the menu bar.
	 * @return
	 */
	private JMenuBar initMenuBar() {
		JMenuBar menuBar = new JMenuBar();

		JMenu gameMenu = new JMenu("New Game");
		JMenu helpMenu = new JMenu("Help");

		// Game
		ButtonGroup levels = new ButtonGroup();
		JRadioButtonMenuItem beginner = new JRadioButtonMenuItem("Beginner");
		JRadioButtonMenuItem intermediate = new JRadioButtonMenuItem(
				"Intermediate");
		JRadioButtonMenuItem expert = new JRadioButtonMenuItem("Expert");
		JRadioButtonMenuItem custom = new JRadioButtonMenuItem("Custom");

		levels.add(beginner);
		levels.add(intermediate);
		levels.add(expert);
		levels.add(custom);

		gameMenu.add(beginner);
		gameMenu.add(intermediate);
		gameMenu.add(expert);
		gameMenu.add(custom);

		menuBar.add(gameMenu);
		menuBar.add(helpMenu);

		// Help
		JMenuItem howToPlay = new JMenuItem("How to play");
		helpMenu.add(howToPlay);

		menuBar.add(helpMenu);

		return menuBar;
	}

	/**
	 * Reads the image files.
	 */
	private void initImages() {
		try {
			bombImg = ImageIO.read(getClass().getClassLoader().getResource(
					"bomb.jpg"));
			flagImg = ImageIO.read(getClass().getClassLoader().getResource(
					"flag.jpg"));
		} catch (IOException e) {
			System.out.println("Can't get the image.");
		}

	}

	/**
	 * Initialize the panels.
	 */
	private void initPanels() {
		jFrame.getContentPane().add(createTopPanel(), BorderLayout.NORTH);
		jFrame.getContentPane().add(createGridPanel(), BorderLayout.CENTER);
	}

	/**
	 * Creates the status panel.
	 * @return
	 */
	private JPanel createTopPanel() {
		JPanel jPanel = new JPanel();
		jPanel.add(new JLabel("Start playing..."));
		return jPanel;
	}

	/**
	 * Creates the grid panel.
	 * @return
	 */
	private JPanel createGridPanel() {
		JPanel jPanel = new JPanel(new GridLayout(board.getLength(), board.getHeight()));
		jPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

		grid = new CustomCellButton [board.getLength()][board.getHeight()];
		
		for (int j = 0; j < board.getHeight(); j++) {
			for (int i = 0; i < board.getLength(); i++) {
				grid[i][j] = new CustomCellButton(i, j, board.getNumber(i, j));
				jPanel.add(grid[i][j]);
			}

		}

		return jPanel;
	}
	
	/**
	 * Display the bombs.
	 */
	public static void explodeBombs() {
		gameOver = true;
        Point[] points = board.getBombList();

        for (int i = 0; i < points.length; i++) {
            int x = (int) points[i].getX();
            int y = (int) points[i].getY();
            grid[x][y].setBackground(Color.RED);

        }
	}

    /**
     * Won the game. Display the bombs.
     */
    public static void win() {
        gameOver = true;
        Point[] points = board.getBombList();

        for (int i = 0; i < points.length; i++) {
            int x = (int) points[i].getX();
            int y = (int) points[i].getY();
            grid[x][y].setBackground(Color.GREEN);

        }
    }
}