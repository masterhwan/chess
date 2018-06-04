package chess;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import piece.Piece;
import piece.Piece.Color;
import piece.Piece.Type;

public class ChessGameTest {

	private ChessGame chessGame;
	private Board board;

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

	private void addPiece(Piece piece) {
		chessGame.move(piece.getPosition(), piece);
	}

	@Test
	public void move() throws Exception {
		board.initialize();
		String sourcePosition = "b2";
		String targetPosition = "b3";

		chessGame.move(sourcePosition, targetPosition);

		assertEquals(Piece.createBlank(new Position(sourcePosition)), chessGame.findPiece(sourcePosition));
		assertEquals(Piece.createWhitePawn(new Position(targetPosition)), chessGame.findPiece(targetPosition));

	}

	@Test
	public void countPieceByColorAndType() throws Exception {
		board.initialize();
		assertEquals(8, chessGame.countPieceByColorAndType(Color.WHITE, Type.PAWN));
		assertEquals(2, chessGame.countPieceByColorAndType(Color.BLACK, Type.KNIGHT));
		assertEquals(1, chessGame.countPieceByColorAndType(Color.BLACK, Type.KING));
	}

	@Test
	public void find_piece() throws Exception {
		board.initialize();
		assertEquals(Piece.createBlackRook(new Position("a8")), chessGame.findPiece("a8"));
		assertEquals(Piece.createBlackRook(new Position("h8")), chessGame.findPiece("h8"));
		assertEquals(Piece.createWhiteRook(new Position("a1")), chessGame.findPiece("a1"));
		assertEquals(Piece.createWhiteRook(new Position("h1")), chessGame.findPiece("h1"));
		assertEquals(Piece.createBlank(new Position("c4")), chessGame.findPiece("c4"));
	}
}
