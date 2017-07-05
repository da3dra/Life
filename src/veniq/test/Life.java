package veniq.test;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JFrame;

import veniq.view.MainView;

public class Life {
	public static boolean[][][] states = new boolean[100][MainView.x][MainView.y];
	public static int population = 0;
	private static boolean hasLife;

	public static boolean[][] check(boolean[][] nextPopul) { 
		int count = 0;
		boolean[][] nextPopul2 = new boolean[MainView.x][MainView.y];
/*
		// Завершение игры если ни одна клетка не сдвинулась
		if (nextPopul.equals(states[population - 1])) {
			// gameOver();
			return null;
		}*/

		// Завершение игры если конфигурация повторилась
		for (int i = 0; i < population - 2; i++) {
			if (nextPopul.equals(states[i])) {
				// gameOver();
				return null;
			}
		}
		for (int i = 1; i < nextPopul.length - 1; i++) {
			for (int j = 1; j < nextPopul.length - 1; j++) {
				count = 0;
				// проверяем есть ли вообще живые клетки
				if (nextPopul[i][j] == true) {
					hasLife = true;
				}
				if (nextPopul[i - 1][j - 1] == true) {
					count += 1;
				}
				if (nextPopul[i - 1][j] == true) {
					count += 1;
				}
				if (nextPopul[i - 1][j + 1] == true) {
					count += 1;
				}
				if (nextPopul[i][j - 1] == true) {
					count += 1;
				}
				if (nextPopul[i][j + 1] == true) {
					count += 1;
				}
				if (nextPopul[i + 1][j - 1] == true) {
					count += 1;
				}
				if (nextPopul[i + 1][j] == true) {
					count += 1;
				}
				if (nextPopul[i + 1][j + 1] == true) {
					count += 1;
				}
				if (!nextPopul[i][j] && count == 3) {
					nextPopul2[i][j] = true;
				}
				if (nextPopul[i][j] && (count == 3 || count == 2)) {
					nextPopul2[i][j] = true;
				}
			}
		}
		// завершение игры если не осталось живых клеток
		if (hasLife = false) {
			// gameOver();
		}
		states[population] = nextPopul2;
		return nextPopul2;
	}

}
