package piece;

import main.Game;

public class Pawn extends Piece{

	public Pawn(int color, int col, int row) {
		super(color, col, row);
		
		if(color == Game.WHITE) {
			image = getImage("/chess/W-Pawn");
		} else {
			image = getImage("/chess/B-Pawn");
		}
	}
}
