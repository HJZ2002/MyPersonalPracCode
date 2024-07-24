package piece;

import main.Game;

public class Queen extends Piece{

	public Queen(int color, int col, int row) {
		super(color, col, row);
		
		//setting up the color
		if(color == Game.WHITE) {
			image = getImage("chess/W-Queen");
		} else {
			image = getImage("chess/B-Queen");
		}
	}

}
