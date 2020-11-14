package inicio.collection.ajedrez.pieces;

import inicio.collection.ajedrez.Color;
import inicio.collection.ajedrez.Figure;
import inicio.collection.ajedrez.Position;

public abstract class Piece {

	private Color color;
	private Figure figure;
	private int num;

	public abstract boolean validateMove(Position origin, Position dest);

	public abstract boolean move(Position origin, Position dest);

	public Piece(Figure figure, Color color, int num) {
		this.figure = figure;
		this.color = color;
		this.num = num;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Figure getFigure() {
		return figure;
	}

	public void setFigure(Figure figure) {
		this.figure = figure;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return "Piece {name='" + figure + "', color='" + color + "', num=" + num + "}";
	}
}
