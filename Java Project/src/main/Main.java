package main;

import javax.swing.*;
public class Main {
	public static void main(String[] args) {
		
		JFrame window = new JFrame("Chess");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		
		//Main window for the chess
		Game game = new Game();
		window.add(game);
		window.pack();
		
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		game.launchgame();
	}
}
