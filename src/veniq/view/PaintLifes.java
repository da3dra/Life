package veniq.view;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PaintLifes {
PaintLifes(MouseEvent e){
	if ((e.getModifiers() & MouseEvent.BUTTON1_MASK) != 0) {

		int xCord = e.getX();
		int yCord = e.getY();

		int i = xCord / MainView.xyWidthHeigth;
		int j = yCord / MainView.xyWidthHeigth;

		System.out.println("x:" + xCord + " y:" + yCord);
		System.out.println("i:" + i + " j:" + j);

		if (!MainView.mas[i + MainView.x/4][j + MainView.x/4])
			MainView.mas[i + MainView.x/4][j + MainView.x/4] = true;
		/*else
			MainView.mas[i][j] = false;*/

	}
}
}
