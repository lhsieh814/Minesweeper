package gui;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingUtilities;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CustomCellButton extends JButton {

	private final int x;
	private final int y;
	private final int num;

    public CustomCellButton(final int x, final int y, final int num) {
		this.x = x;
		this.y = y;
		this.num = num;

		setAttributes();

		addMouseListener(getMouseListener());

	}

	private void setAttributes() {
		setPreferredSize(new Dimension(41, 41));
		setContentAreaFilled(false);
		setFocusPainted(false);
		setBorderPainted(true);
		setOpaque(true);
		setContentAreaFilled(false);
		setBackground(Color.lightGray);

	}

	private MouseListener getMouseListener() {
		return new MouseListener() {

			public void mouseClicked(MouseEvent mouseEvent) {

				if (SwingUtilities.isRightMouseButton(mouseEvent)) {
					// Right-click
					if (!MinesweeperFrame.gameOver) {
						setBackground(Color.green);
					}

				} else {
					// Left-click
					System.out.println(MinesweeperFrame.gameOver);
					switch (num) {
					case -1:
                        MinesweeperFrame.gameOver = true;
   						MinesweeperFrame.explodeBombs();
						break;
					case 0:
						if (!MinesweeperFrame.gameOver) {
							setText("" + num);
						}
						break;
					default:
						if (!MinesweeperFrame.gameOver) {
                            setText("" + num);
                        }
						break;
					}

				}
			}

			public void mousePressed(MouseEvent mouseEvent) {
			}

			public void mouseReleased(MouseEvent mouseEvent) {
			}

			public void mouseEntered(MouseEvent mouseEvent) {
			}

			public void mouseExited(MouseEvent mouseEvent) {
			}

		};

	}

	// @Override
	// protected void paintComponent(Graphics g) {
	// g.setColor(Color.BLUE);
	//
	// // GradientPaint paint = new GradientPaint(getWidth(), getHeight(),
	// g.getColor(),
	// // getWidth(), getHeight(), Color.GREEN, false);
	//
	// Graphics2D g2 = (Graphics2D) g;
	// // g2.setPaint(paint);
	// // g2.fillRect(0,0,38,38);
	// super.paintComponent(g);
	// }

//	@Override
//	protected void paintBorder(Graphics g) {
//		g.setColor(Color.BLACK);
//		g.drawRect(0, 0, (int) getPreferredSize().getWidth(),
//				(int) getPreferredSize().getHeight());
//	}
}
