package inicio.collection.ajedrez.pieces;

import inicio.collection.ajedrez.Color;
import inicio.collection.ajedrez.Figure;
import inicio.collection.ajedrez.Position;

public class Bishop extends Piece {

	public Bishop(Figure figure, Color color, int num) {
		super(figure, color, num);
	}

	@Override
	public boolean validateMove(Position origin, Position dest) {
		// Origin position color EQUALS TO destiny position color
		if (origin.getColor().equals(dest.getColor())) {
			// Destiny position empty (without piece) AND
			// Color of the piece in the destiny position EQUALS TO color of the piece in
			// the origin position
			if (dest.getPiece() != null && !dest.getPiece().getColor().equals(origin.getPiece().getColor())) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	@Override
	public boolean move(Position origin, Position dest) {
		return false;
	}

}
