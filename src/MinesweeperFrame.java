import javax.swing.*;
import java.awt.*;

public class MinesweeperFrame {

    private JFrame jFrame;

    public MinesweeperFrame(){
        jFrame = new JFrame();
        jFrame.setTitle("Minesweeper");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(500, 500);
        jFrame.setBackground(Color.white);
        jFrame.setLayout(new BorderLayout());

        initPanels();

        jFrame.pack();
        jFrame.setVisible(true);

    }

    // Adds each panel to the frame
    private void initPanels(){
        jFrame.getContentPane().add(createTopPanel(), BorderLayout.NORTH);
        jFrame.getContentPane().add(createGridPanel(), BorderLayout.CENTER);
    }

    // Creates the top panel
    private JPanel createTopPanel(){
        JPanel jPanel = new JPanel();
        jPanel.add(new JLabel("Start playing..."));
        return jPanel;
    }

    // Creates the playing grid panel
    private JPanel createGridPanel(){
        JPanel jPanel = new JPanel(new GridLayout(9,9,0,0));

//        for (int i = 0; i<81; i++){
//            jPanel.add(new JButton(""+i));
//        }

        return jPanel;
    }

}
