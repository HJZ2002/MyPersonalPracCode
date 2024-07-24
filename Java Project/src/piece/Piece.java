package piece;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.Board;

public class Piece {
	
	public BufferedImage image;
	public int x,y;
	public int col,row,preCol,preRow;
	public int color;
	// row and col for each piece
	public Piece(int color , int col,int row) {
		this.color = color;
		this.col = col;
		this.row = row;
		x = getx(col);
		y = gety(col);
		preCol = col;
		preRow = row;
	}
	
	private int getx(int col) {
		return col * Board.SQUARE_SIZE;
	}

	private int gety(int row) {
		return row * Board.SQUARE_SIZE;
	}
	
}
