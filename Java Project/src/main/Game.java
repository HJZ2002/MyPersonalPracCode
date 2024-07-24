package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JPanel;

import piece.Pawn;
import piece.Piece;
public class Game extends JPanel implements Runnable {
	
	public static final int WIDTH = 1100;
	public static final int HEIGHT = 800;
	final int FPS = 100;
	Thread gameThread;
	Board board = new Board();
	
	
	//PIECES
	
	public static ArrayList<Piece> pieces = new ArrayList<>();
	public static ArrayList<Piece> simPieces = new ArrayList<>();
	
	// COLOR
	public static final int WHITE = 0;
	public static final int BLACK = 1;
	int currentColor = WHITE;
	
	public Game() {
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setBackground(Color.BLACK);
	}
	public void launchgame() {
		gameThread = new Thread(this);
		gameThread.start();
	}
	public void setPieces() {
		
	}
	@Override
	public void run() {
		
		//GAME LOOP
		double drawInterval = 1000000000/FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		
		while(gameThread != null) {
			currentTime = System.nanoTime();
			delta += (currentTime - lastTime)/drawInterval;
			lastTime = currentTime;
			
			if(delta>= 1) {
				Update();
				repaint();
				delta--;
			}
		}
	}
	private void Update() {
		
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;	
		
		board.draw(g2);
		
	}
	
}
