import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.GridLayout;

public class MinesweeperFrame {

    private JFrame jFrame;

    public MinesweeperFrame(){
        jFrame = new JFrame();
        jFrame.setTitle("Minesweeper");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(400, 400);
        jFrame.setBackground(Color.white);
        jFrame.setLayout(new BorderLayout());
        jFrame.setResizable(false);

        initPanels();

//        jFrame.pack();    // Create frame from minimum needed size
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
        JPanel jPanel = new JPanel(new GridLayout(9,9,-5,-5));
        jPanel.setBorder(new EmptyBorder(10,10,10,10));

        for (int i = 0; i<81; i++){
//            JButton jButton = new JButton(""+i);
//            jPanel.add(jButton);
            CustomCellButton cellButton = new CustomCellButton("b");
            jPanel.add(cellButton);
        }

        return jPanel;
    }

}
