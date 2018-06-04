package chess;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import piece.Piece;
import piece.Piece.Color;

public class ChessGameTest {

	ChessGame chessGame;
	Board board;

	@Before
	public void setUp() {
		board = new Board();
		chessGame = new ChessGame(board.getRanks());

	}

	@Test
	public void calculate_point() throws Exception {
		board.emptyInitialize();
		addPiece(Piece.createBlackPawn(new Position("b6")));
		addPiece(Piece.createBlackQueen(new Position("e6")));
		addPiece(Piece.createBlackKing(new Position("b8")));
		addPiece(Piece.createBlackRook(new Position("c8")));

		addPiece(Piece.createWhitePawn(new Position("f2")));
		addPiece(Piece.createWhitePawn(new Position("g2")));
		addPiece(Piece.createWhiteRook(new Position("e1")));
		addPiece(Piece.createWhiteKing(new Position("f1")));
		assertEquals(15, chessGame.calculatePoint(Color.BLACK), 0.01);
		assertEquals(7, chessGame.calculatePoint(Color.WHITE), 0.01);
	}

	private void addPiece(Piece piece) {
		board.move(piece.getPosition(), piece);
	}

	@Test
	public void calculate_point_pawn() throws Exception {
		board.emptyInitialize();

		addPiece(Piece.createBlackPawn(new Position("b1")));
		addPiece(Piece.createBlackPawn(new Position("b2")));
		addPiece(Piece.createBlackPawn(new Position("b3")));
		addPiece(Piece.createBlackPawn(new Position("b4")));
		addPiece(Piece.createBlackPawn(new Position("b5")));
		addPiece(Piece.createBlackPawn(new Position("b6")));
		addPiece(Piece.createBlackPawn(new Position("b7")));
		addPiece(Piece.createBlackPawn(new Position("b8")));

		assertEquals(4, chessGame.calculatePoint(Color.BLACK), 0.01);
	}
}
