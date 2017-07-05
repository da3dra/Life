package veniq.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

public class PaintLines extends JPanel {
	@Override
	public void paint(Graphics graphics) {

		// Отрисовка таблички
		graphics.setColor(new Color(0, 0, 0));

		drawLines(MainView.mas, graphics);

		// отисовка по клику в классе PaintLifes

		drawCircles(MainView.mas, graphics);

	}

	/**
	 * Painting lines
	 * 
	 */
	public void drawLines(boolean[][] mas, Graphics graphics) {
		for (int ii = 0, i = 0; i < MainView.x; i++, ii += MainView.xyWidthHeigth) {
			graphics.drawLine(ii, 0, ii, getHeight());
		}
		for (int ii = 0, i = 0; i < MainView.y; ii += MainView.xyWidthHeigth, i++) {
			graphics.drawLine(0, ii, getWidth(), ii);

		}
	}

	/**
	 * Painting circles with array
	 * 
	 */
	public void drawCircles(boolean[][] mas, Graphics graphics) {

		for (int i = MainView.x / 4, ii = 0; i < mas.length; i++, ii += MainView.xyWidthHeigth) {
			for (int j = MainView.x / 4, jj = 0; j < mas.length; j++, jj += MainView.xyWidthHeigth) {
				if (mas[i][j]) {
					// прорисовка

					graphics.fillOval(ii, jj, (int) (MainView.xyWidthHeigth * 0.8),
							(int) (MainView.xyWidthHeigth * 0.8));

				}
			}
		}

	}
}
