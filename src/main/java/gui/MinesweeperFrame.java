package gui;


import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

public class MinesweeperFrame {

    private JFrame jFrame;
    private Image bombImg;
    private Image flagImg;

    public MinesweeperFrame() {
        jFrame = new JFrame();
        jFrame.setTitle("Minesweeper");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(400, 450);
        jFrame.setBackground(Color.white);
        jFrame.setLayout(new BorderLayout());
//        jFrame.setResizable(false);

        jFrame.setJMenuBar(initMenuBar());

        initPanels();
        initImages();

//        jFrame.pack();    // Create frame from minimum needed size
        jFrame.setVisible(true);

    }

    // Create the menu bar
    private JMenuBar initMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu gameMenu = new JMenu("New Game");
        JMenu helpMenu = new JMenu("Help");

        // Game
        ButtonGroup levels = new ButtonGroup();
        JRadioButtonMenuItem beginner = new JRadioButtonMenuItem("Beginner");
        JRadioButtonMenuItem intermediate = new JRadioButtonMenuItem("Intermediate");
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

    // Reads the image files
    private void initImages() {
        try {
            bombImg = ImageIO.read(getClass().getClassLoader().getResource("bomb.jpg"));
            flagImg = ImageIO.read(getClass().getClassLoader().getResource("flag.jpg"));
        } catch (IOException e) {
            System.out.println("Can't get the image.");
        }

    }

    // Adds each panel to the frame
    private void initPanels() {
        jFrame.getContentPane().add(createTopPanel(), BorderLayout.NORTH);
        jFrame.getContentPane().add(createGridPanel(), BorderLayout.CENTER);
    }

    // Creates the top panel
    private JPanel createTopPanel() {
        JPanel jPanel = new JPanel();
        jPanel.add(new JLabel("Start playing..."));
        return jPanel;
    }

    // Creates the playing grid panel
    private JPanel createGridPanel() {
        JPanel jPanel = new JPanel(new GridLayout(9, 9));
        jPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        for (int i = 0; i < 81; i++) {
            final CustomCellButton cellButton = new CustomCellButton();
            cellButton.setBackground(Color.lightGray);

            cellButton.addMouseListener(new MouseListener() {

                public void mouseClicked(MouseEvent mouseEvent) {
                    System.out.println("CLICK");

                    if (SwingUtilities.isRightMouseButton(mouseEvent)) {
                        // Right-click

                        cellButton.setIcon(new ImageIcon(flagImg));
                    } else {
                        // Left-click
                        cellButton.setIcon(new ImageIcon(bombImg));

                    }



                }

                public void mousePressed(MouseEvent mouseEvent) {
                    System.out.println("PRESSED");
                }

                public void mouseReleased(MouseEvent mouseEvent) {
                    System.out.println("RELEASED");
                }

                public void mouseEntered(MouseEvent mouseEvent) {
                }

                public void mouseExited(MouseEvent mouseEvent) {
                }

            });

            jPanel.add(cellButton);
        }

        return jPanel;
    }

}
