package chess;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Exception.InvalidMovePositionException;
import piece.Blank;
import piece.King;
import piece.Pawn;
import piece.Piece;
import piece.Piece.Color;
import piece.Piece.Type;
import piece.Position;
import piece.Queen;
import piece.Rook;

public class BoardTest {
	private String returnLine = System.getProperty("line.separator");

	private Board board;
	private ChessView chessView;

	@Before
	public void setup() {
		board = new Board();
		chessView = new ChessView();
	}

	@Test
	public void create() throws Exception {
		board.initialize();
		String blankRank = appendNewLine("........");
		assertEquals(appendNewLine("RNBQKBNR") + appendNewLine("PPPPPPPP") + blankRank + blankRank + blankRank
				+ blankRank + appendNewLine("pppppppp") + appendNewLine("rnbqkbnr"), chessView.view(board));
	}

	private String appendNewLine(String string) {
		return string + returnLine;
	}

	@Test
	public void print() throws Exception {
		board.initialize();
		System.out.println(chessView.view(board));
	}

	@Test
	public void countPieceByColorAndType() throws Exception {
		board.initialize();

		assertEquals(8, board.countPieceByColorAndType(Color.WHITE, Type.PAWN));
		assertEquals(2, board.countPieceByColorAndType(Color.BLACK, Type.KNIGHT));
		assertEquals(1, board.countPieceByColorAndType(Color.BLACK, Type.KING));
	}

	@Test
	public void findPiece() throws Exception {
		board.initialize();

		assertFindPiece(Rook.createBlack(new Position("a8")));
		assertFindPiece(Rook.createBlack(new Position("h8")));
		assertFindPiece(Rook.createWhite(new Position("a1")));
		assertFindPiece(Rook.createWhite(new Position("h1")));
	}

	private void assertFindPiece(Piece piece) {
		assertEquals(piece, board.findPiece(piece.getPosition()));
	}

	@Test
	public void addPiece() throws Exception {
		board.emptyInitialize();

		Position position = new Position("b5");
		Rook piece = Rook.createBlack(position);
		board.replacePiece(piece);

		System.out.println(chessView.view(board));
		assertEquals(piece, board.findPiece(position));
	}

	@Test
	public void caculcatePoint() throws Exception {
		board.emptyInitialize();

		addPiece(Pawn.createBlack(new Position("b6")));
		addPiece(Queen.createBlack(new Position("e6")));
		addPiece(King.createBlack(new Position("b8")));
		addPiece(Rook.createBlack(new Position("c8")));

		addPiece(Pawn.createWhite(new Position("f2")));
		addPiece(Pawn.createWhite(new Position("g2")));
		addPiece(Rook.createWhite(new Position("e1")));
		addPiece(King.createBlack(new Position("f1")));

		assertEquals(15.0, board.caculcatePoint(Color.BLACK), 0.01);
		assertEquals(7.0, board.caculcatePoint(Color.WHITE), 0.01);

		System.out.println(chessView.view(board));
	}

	@Test
	public void caculcatePoint_pawn() throws Exception {
		board.emptyInitialize();

		addPiece(Pawn.createBlack(new Position("b6")));
		addPiece(Pawn.createBlack(new Position("b5")));
		addPiece(Pawn.createBlack(new Position("b4")));

		assertEquals(1.5, board.caculcatePoint(Color.BLACK), 0.01);
	}

	@Test
	public void move_valid() throws Exception {
		board.initialize();

		Position sourcePosition = new Position("b2");
		Position targetPosition = new Position("b3");
		board.move(sourcePosition, targetPosition);
		assertEquals(Blank.create(sourcePosition), board.findPiece(sourcePosition));
		assertEquals(Pawn.createWhite(targetPosition), board.findPiece(targetPosition));
	}

	private void addPiece(Piece piece) {
		board.replacePiece(piece);
	}

	@Test(expected = InvalidMovePositionException.class)
	public void same_position_move() throws Exception {
		board.initialize();

		Position sourcePosition = new Position("b2");
		Position targetPosition = new Position("b2");
		board.move(sourcePosition, targetPosition);
		assertEquals(Blank.create(sourcePosition), board.findPiece(sourcePosition));
		assertEquals(Pawn.createWhite(targetPosition), board.findPiece(targetPosition));
	}
}
