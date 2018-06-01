package piece;

import static org.junit.Assert.*;

import org.junit.Test;

import piece.Piece.Color;
import piece.Piece.Type;

public class PieceTest {
	@Test
	public void create_piece() {
		verifyPiece(Piece.createWhitePawn(), Piece.Color.WHITE, Piece.Type.PAWN);
		verifyPiece(Piece.createBlackPawn(), Piece.Color.BLACK, Piece.Type.PAWN);
		verifyPiece(Piece.createWhiteRook(), Piece.Color.WHITE, Piece.Type.ROOK);
		verifyPiece(Piece.createBlackRook(), Piece.Color.BLACK, Piece.Type.ROOK);
		verifyPiece(Piece.createWhiteKnight(), Piece.Color.WHITE, Piece.Type.KNIGHT);
		verifyPiece(Piece.createWhiteBishop(), Piece.Color.WHITE, Piece.Type.BISHOP);
		verifyPiece(Piece.createWhiteQueen(), Piece.Color.WHITE, Piece.Type.QUEEN);
		verifyPiece(Piece.createWhiteKing(), Piece.Color.WHITE, Piece.Type.KING);
		verifyPiece(Piece.createBlackKnight(), Piece.Color.BLACK, Piece.Type.KNIGHT);
		verifyPiece(Piece.createBlackBishop(), Piece.Color.BLACK, Piece.Type.BISHOP);
		verifyPiece(Piece.createBlackQueen(), Piece.Color.BLACK, Piece.Type.QUEEN);
		verifyPiece(Piece.createBlackKing(), Piece.Color.BLACK, Piece.Type.KING);

		verifyPiece(Piece.createWhitePawn(), Piece.createBlackPawn(), Type.PAWN);
		verifyPiece(Piece.createWhiteKnight(), Piece.createBlackKnight(), Type.KNIGHT);
		verifyPiece(Piece.createWhiteRook(), Piece.createBlackRook(), Type.ROOK);
		verifyPiece(Piece.createWhiteBishop(), Piece.createBlackBishop(), Type.BISHOP);
		verifyPiece(Piece.createWhiteQueen(), Piece.createBlackQueen(), Type.QUEEN);
		verifyPiece(Piece.createWhiteKing(), Piece.createBlackKing(), Type.KING);

		Piece blank = Piece.createBlank();
		assertFalse(blank.isWhite());
		assertFalse(blank.isBlack());
		assertEquals(Type.NO_PIECE, blank.getType());
	}

	private void verifyPiece(Piece piece, Color color, Type type) {
		assertEquals(color, piece.getColor());
		if (Piece.Color.WHITE.equals(color)) {
			assertEquals(type.getWhiteRepresentation(), piece.getRepresentation());
			return;
		}
		assertEquals(type.getBlackRepresentation(), piece.getRepresentation());
	}

	@Test
	public void check_piece_color() throws Exception {
		Piece blackRook = Piece.createBlackRook();
		Piece whiteRook = Piece.createWhiteRook();
		assertTrue(blackRook.isBlack());
		assertFalse(blackRook.isWhite());
		assertFalse(whiteRook.isBlack());
		assertTrue(whiteRook.isWhite());
	}

	@Test
	public void getRepresentationPerPiece() throws Exception {
		assertEquals('p', Piece.Type.PAWN.getWhiteRepresentation());
		assertEquals('P', Piece.Type.PAWN.getBlackRepresentation());
	}

	private void verifyPiece(final Piece whitePiece, final Piece blackPiece, final Type type) {
		assertTrue(whitePiece.isWhite());
		assertEquals(type, whitePiece.getType());

		assertTrue(blackPiece.isBlack());
		assertEquals(type, blackPiece.getType());
	}
}
