package piece;

import main.Game;

public class Horse extends Piece{

	public Horse(int color, int col, int row) {
		super(color, col, row);
		
		//setting up the color
		if(color == Game.WHITE) {
		image = getImage("chess/W-Horse");
		} else {
		image = getImage("chess/B-Horse");
		}
	}

}
