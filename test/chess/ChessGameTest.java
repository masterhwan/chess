package chess;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import piece.Blank;
import piece.King;
import piece.Pawn;
import piece.Piece;
import piece.Position;
import piece.Piece.Color;
import piece.Piece.Type;
import piece.Queen;
import piece.Rook;

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
		addPiece(Pawn.createBlack(new Position("b6")));
		addPiece(Queen.createBlack(new Position("e6")));
		addPiece(King.createBlack(new Position("b8")));
		addPiece(Rook.createBlack(new Position("c8")));

		addPiece(Pawn.createWhite(new Position("f2")));
		addPiece(Pawn.createWhite(new Position("g2")));
		addPiece(Rook.createWhite(new Position("e1")));
		addPiece(King.createWhite(new Position("f1")));
		assertEquals(15, chessGame.calculatePoint(Color.BLACK), 0.01);
		assertEquals(7, chessGame.calculatePoint(Color.WHITE), 0.01);
	}

	@Test
	public void calculate_point_pawn() throws Exception {
		board.emptyInitialize();

		addPiece(Pawn.createBlack(new Position("b1")));
		addPiece(Pawn.createBlack(new Position("b2")));
		addPiece(Pawn.createBlack(new Position("b3")));
		addPiece(Pawn.createBlack(new Position("b4")));
		addPiece(Pawn.createBlack(new Position("b5")));
		addPiece(Pawn.createBlack(new Position("b6")));
		addPiece(Pawn.createBlack(new Position("b7")));
		addPiece(Pawn.createBlack(new Position("b8")));

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

		assertEquals(Blank.create(new Position(sourcePosition)), chessGame.findPiece(sourcePosition));
		assertEquals(Pawn.createWhite(new Position(targetPosition)), chessGame.findPiece(targetPosition));

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
		assertEquals(Rook.createBlack(new Position("a8")), chessGame.findPiece("a8"));
		assertEquals(Rook.createBlack(new Position("h8")), chessGame.findPiece("h8"));
		assertEquals(Rook.createWhite(new Position("a1")), chessGame.findPiece("a1"));
		assertEquals(Rook.createWhite(new Position("h1")), chessGame.findPiece("h1"));
		assertEquals(Blank.create(new Position("c4")), chessGame.findPiece("c4"));
	}

	@Test
	public void check_king_movement() throws Exception {
		board.initialize();
		Piece piece = chessGame.findPiece("e1");
		assertEquals(Type.KING, piece.getType());
		List<Position> positions = piece.getPosition().getKingMovementAble();
		String targetPosition = "e2";
		assertTrue(positions.contains(new Position(targetPosition)));
		targetPosition = "e8";
		assertFalse(positions.contains(new Position(targetPosition)));
	}

	@Test
	public void check_queen_movement() throws Exception {
		board.emptyInitialize();
		addPiece(Queen.createBlack(new Position("d5")));
		Piece piece = chessGame.findPiece("d5");
		assertEquals(Type.QUEEN, piece.getType());
		List<Position> positions = piece.getPosition().getQueenMovementAble();
		String targetPosition = "d8";
		assertTrue(positions.contains(new Position(targetPosition)));
		targetPosition = "d1";
		assertTrue(positions.contains(new Position(targetPosition)));
		targetPosition = "a2";
		assertTrue(positions.contains(new Position(targetPosition)));
		targetPosition = "a5";
		assertTrue(positions.contains(new Position(targetPosition)));
		targetPosition = "h5";
		assertTrue(positions.contains(new Position(targetPosition)));
		targetPosition = "a8";
		assertTrue(positions.contains(new Position(targetPosition)));
		targetPosition = "h1";
		assertTrue(positions.contains(new Position(targetPosition)));
		targetPosition = "g8";
		assertTrue(positions.contains(new Position(targetPosition)));
	}

}
