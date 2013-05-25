import javax.swing.JButton;
import java.awt.*;

public class CustomCellButton extends JButton {

    public CustomCellButton(String label) {
        super(label);
        setPreferredSize(new Dimension(10,10));
        setContentAreaFilled(false);

    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.BLUE);

        GradientPaint paint = new GradientPaint(getWidth()/2, getHeight()/2, g.getColor(),
                getWidth()/2, 0, Color.GREEN, true);

        Graphics2D g2 = (Graphics2D) g;
        g2.setPaint(paint);
        g2.fillRect(0, 0, getSize().width-1, getSize().height-1);
        super.paintComponent(g);
    }
}
