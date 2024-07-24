package piece;

import main.Game;

public class King extends Piece{

	public King(int color, int col, int row) {
		super(color, col, row);
		
		//setting up the color
		if(color == Game.WHITE) {
		image = getImage("chess/W-King");
		} else {
		image = getImage("chess/B-King");
		}
	}
}
