package piece;

import main.Game;

public class Bishop extends Piece{

	public Bishop(int color, int col, int row) {
		super(color, col, row);
		
		//setting up the color
		if(color == Game.WHITE) {
			image = getImage("chess/W-Bishop");
		} else {
			image = getImage("chess/B-Bishop");
		}
	}

}
