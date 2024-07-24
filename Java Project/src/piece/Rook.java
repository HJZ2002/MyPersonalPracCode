package piece;

import main.Game;

public class Rook extends Piece{

	public Rook(int color, int col, int row) {
		super(color, col, row);
		
		//setting up the rook
		if(color == Game.WHITE) {
			image = getImage("/chess/W-Tower");
		} else {
			image = getImage("/chess/B-Tower");
		}
	}

}
