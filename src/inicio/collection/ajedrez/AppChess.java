package inicio.collection.ajedrez;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import inicio.collection.ajedrez.pieces.Bishop;
import inicio.collection.ajedrez.pieces.King;
import inicio.collection.ajedrez.pieces.Knight;
import inicio.collection.ajedrez.pieces.Piece;
import inicio.collection.ajedrez.pieces.Queen;
import inicio.collection.ajedrez.pieces.Rook;

public class AppChess {

	public static void main(String[] args) {

		Map<Piece, List<Position>> movsList = new HashMap<Piece, List<Position>>();
		Scanner scan = new Scanner(System.in);

		// Define pieces by deafult
		King kingW = new King(Figure.KING, Color.WHITE, 1);
		King kingB = new King(Figure.KING, Color.BLACK, 1);
		Queen queenW = new Queen(Figure.QUEEN, Color.WHITE, 1);
		Queen queenB = new Queen(Figure.QUEEN, Color.BLACK, 1);

		Rook rookW1 = new Rook(Figure.ROOK, Color.WHITE, 1);
		Rook rookW2 = new Rook(Figure.ROOK, Color.WHITE, 2);
		Rook rookB1 = new Rook(Figure.ROOK, Color.BLACK, 1);
		Rook rookB2 = new Rook(Figure.ROOK, Color.BLACK, 2);

		Knight knightW1 = new Knight(Figure.KNIGHT, Color.WHITE, 1);
		Knight knightW2 = new Knight(Figure.KNIGHT, Color.WHITE, 2);
		Knight knightB1 = new Knight(Figure.KNIGHT, Color.BLACK, 1);
		Knight knightB2 = new Knight(Figure.KNIGHT, Color.BLACK, 2);

		Bishop bishopW1 = new Bishop(Figure.BISHOP, Color.WHITE, 1);
		Bishop bishopW2 = new Bishop(Figure.BISHOP, Color.WHITE, 2);
		Bishop bishopB1 = new Bishop(Figure.BISHOP, Color.BLACK, 1);
		Bishop bishopB2 = new Bishop(Figure.BISHOP, Color.BLACK, 2);

		// The PAWNS are missing. Yet to be coded

		Position[][] board = new Position[8][8];
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				board[i][j] = new Position(i, j);
			}
		}

		/*
		 * Position position = board[6][7]; Piece piece = position.getPiece(); Position
		 * destiny = board[5][7];
		 * 
		 * if (piece.validateMove(position, destiny)) { piece.move(position, destiny); }
		 * else { System.out.println("Movimiento inválido"); }
		 */

		List<Position> list = new ArrayList<Position>();
		list.add(new Position(1, 1));

		movsList.put(kingW, list);
		movsList.put(kingB, list);
		movsList.put(queenW, list);
		movsList.put(queenB, list);

		movsList.put(rookW1, list);
		movsList.put(rookW2, list);
		movsList.put(rookB1, list);
		movsList.put(rookB2, list);

		movsList.put(knightW1, list);
		movsList.put(knightW2, list);
		movsList.put(knightB1, list);
		movsList.put(knightB2, list);

		movsList.put(bishopW1, list);
		movsList.put(bishopW2, list);
		movsList.put(bishopB1, list);
		movsList.put(bishopB2, list);

		/*
		 * movsList.forEach((k, v) -> { System.out.println(k); for (Position item : v) {
		 * System.out.println(item); } System.out.println(); });
		 */

		System.out.println(movsList);

	}

}
