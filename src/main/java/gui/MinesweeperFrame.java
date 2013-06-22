package gui;

import game.Board;
import game.Status;
import levels.Beginner;
import levels.Custom;
import levels.Expert;
import levels.Intermediate;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MinesweeperFrame {

	private JFrame jFrame;
	private Image bombImg;
	private Image flagImg;
	private static CustomCellButton [][] grid;
	public static boolean gameOver = false;

    public static int bombCount;
    public static boolean[][] bombGuess;

	public static Board board;
    public static Status status;

	public MinesweeperFrame() {
		// Default to beginner level
		board = new Board(new Beginner());
        status = new Status(board);
		
		jFrame = new JFrame();
		jFrame.setTitle("Minesweeper");
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		jFrame.setSize(400, 450);
		jFrame.setBackground(Color.white);
		jFrame.setLayout(new BorderLayout());
		// jFrame.setResizable(false);


		jFrame.setJMenuBar(initMenuBar());

		initPanels();
//		initImages();

		jFrame.pack(); // Create frame from minimum needed size
		jFrame.setVisible(true);

        bombCount = board.getBombs();
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

        ActionListener radioButtonListener = new AbstractAction() {
            
            public void actionPerformed(ActionEvent actionEvent) {
                String selectedLevel = actionEvent.getActionCommand();
                System.out.println(selectedLevel);

                if (selectedLevel.equals("Beginner")) {
                    board = new Board(new Beginner());
                } else if (selectedLevel.equals("Intermediate")) {
                    board = new Board(new Intermediate());
                } else if (selectedLevel.equals("Expert")) {
                    board = new Board(new Expert());
                } else {
                    board = new Board(new Custom());
                }

            }
        };

		// Game
		ButtonGroup levels = new ButtonGroup();
		JRadioButtonMenuItem beginner = new JRadioButtonMenuItem("Beginner", true);
        beginner.addActionListener(radioButtonListener);
		JRadioButtonMenuItem intermediate = new JRadioButtonMenuItem("Intermediate");
        intermediate.addActionListener(radioButtonListener);
		JRadioButtonMenuItem expert = new JRadioButtonMenuItem("Expert");
        expert.addActionListener(radioButtonListener);
		JRadioButtonMenuItem custom = new JRadioButtonMenuItem("Custom");
        custom.addActionListener(radioButtonListener);

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

    /**
     * Activate the adjacent 0's.
     * Looks at the left, right, top and bottom cells.
     */
    public static void activateZeros(int x, int y) {

        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (i >= 0 && i != board.getLength() && j >= 0 && j != board.getHeight()) {
                	if (grid[i][j].getText().isEmpty()) {
                		setTextForZeros(i, j);
                	}
                }
            }
        }
    }

    private static void setTextForZeros(int x, int y) {
    	Status.numCount--;
    	
        if (board.isZero(x, y)) {
            grid[x][y].setText("0");
            activateZeros(x, y);
        } else {
            grid[x][y].setText("" + board.getNumber(x, y));
        }
    }
}