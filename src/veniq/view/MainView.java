package veniq.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Random;
import veniq.view.*;
import javax.swing.*;
import java.awt.*;

//!TODO сдвинуть прорисовку массива не сдвигая панель!? гениально

public class MainView {
	public static final int x = 1000;
	public static final int y = x;

	public static final int xy = 1;
	public static final int xyWidthHeigth = xy * 10;

	static Graphics2D g2d;

	public static PaintLines gamePane;
	public static JFrame frame;
	public static Timer mainTimer;
	// тестовый массив
	static boolean[][] mas = new boolean[x][y];

	public static void main(String[] args) {
		// frame
		frame = new JFrame("Main frame");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(900, 900);

		// main pane
		JPanel contentPane = new JPanel();
		frame.setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		// button pane
		JPanel buttonPane = new JPanel();
		buttonPane.setBackground(new Color(100, 100, 100));
		contentPane.add(buttonPane, BorderLayout.SOUTH);

		// game pane
		gamePane = new PaintLines();
		gamePane.setBackground(new Color(255, 255, 255));
		contentPane.add(gamePane, BorderLayout.CENTER);

		// start game button
		JButton startButton = new JButton("Start");
		buttonPane.add(startButton);

		// pause game button
		JButton pouseButton = new JButton("Pause");
		buttonPane.add(pouseButton);

		// step button
		JButton stepButton = new JButton("Step");
		buttonPane.add(stepButton);

		// clear button
		JButton clearButton = new JButton("Clear");
		buttonPane.add(clearButton);

		// random button
		JButton randomButton = new JButton("Random");
		buttonPane.add(randomButton);

		// !TODO painting with mouse
		gamePane.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseDragged(MouseEvent e) {

				PaintLifes p = new PaintLifes(e);
				frame.repaint();
			}
		});

		gamePane.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				PaintLifes p = new PaintLifes(e);

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				PaintLifes p = new PaintLifes(e);
				frame.repaint();
			}

		});

		// clear button click
		clearButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				clearButtonPress(mas);
			}
		});

		// random button click
		randomButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				randomButtonPress(mas);

				// repainting frame (can't just use in methods, it causes
				// multiple errors)
			}
		});

		// start button click
		startButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				startButtonPress();
			}
		});

		// pouse button click
		pouseButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pauseButtonPress();
			}
		});

		// step button click
		stepButton.addActionListener(stepButtonPress());

		frame.setVisible(true);
	}

	private static void startButtonPress() {
		GenerationGenerator gen = new GenerationGenerator();
		mainTimer = new Timer(500, gen);

		if (mainTimer.isRunning()) {
			mainTimer.stop();
		} else {
			mainTimer.start();
		}

		repaintFrame();
	}

	private static void pauseButtonPress() {
		if (mainTimer.isRunning()) {
			mainTimer.stop();
		}
		repaintFrame();
	}

	private static GenerationGenerator stepButtonPress() {
		GenerationGenerator gen = new GenerationGenerator();
		repaintFrame();
		return gen;
	}

	/**
	 * Зарандомить массив
	 * 
	 */
	private static void randomButtonPress(boolean[][] mas) {
		Random r = new Random();
		for (int i = MainView.x / 4 + 20; i < MainView.x / 4 + 70; i++) {
			for (int j = MainView.x / 4 + 20; j < MainView.x / 4 + 70; j++) {
				if (r.nextInt(500) > 300)
					mas[i][j] = r.nextBoolean();
			}
		}
		repaintFrame();
	}

	/**
	 * Очистить массив
	 * 
	 */
	private static void clearButtonPress(boolean[][] mas) {
		for (int i = 0; i < mas.length; i++) {
			for (int j = 0; j < mas.length; j++) {
				mas[i][j] = false;
			}
		}
		if (mainTimer.isRunning()) {
			mainTimer.stop();
		}
		// перересовываем поле
		repaintFrame();
	}

	
	
	/*
	 * private static void clearAll() { for (int i = 0; i < mas.length; i++) {
	 * for (int j = 0; j < mas.length; j++) { mas[i][j] = false; } } if
	 * (mainTimer.isRunning()) { mainTimer.stop(); } // перересовываем поле
	 * repaintFrame(); }
	 */
	public static void repaintFrame() {
		frame.repaint();
	}

	private static void generateNextGeneration() {

	}

}
