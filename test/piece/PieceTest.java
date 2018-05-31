package piece;

import static org.junit.Assert.*;

import org.junit.Test;

public class PieceTest {
	@Test
	public void create_piece() {
		verifyPiece(Piece.createWhitePawn(), Piece.WHITE_COLOR, Piece.WHITE_PAWN_REPRESENTATION);
		verifyPiece(Piece.createBlackPawn(), Piece.BLACK_COLOR, Piece.BLACK_PAWN_REPRESENTATION);
		verifyPiece(Piece.createWhiteRook(), Piece.WHITE_COLOR, Piece.WHITE_ROOK_REPRESENTATION);
		verifyPiece(Piece.createBlackRook(), Piece.BLACK_COLOR, Piece.BLACK_ROOK_REPRESENTATION);
		verifyPiece(Piece.createWhiteKnight(), Piece.WHITE_COLOR, Piece.WHITE_KNIGHT_REPRESENTATION);
		verifyPiece(Piece.createWhiteBishop(), Piece.WHITE_COLOR, Piece.WHITE_BISHOP_REPRESENTATION);
		verifyPiece(Piece.createWhiteQueen(), Piece.WHITE_COLOR, Piece.WHITE_QUEEN_REPRESENTATION);
		verifyPiece(Piece.createWhiteKing(), Piece.WHITE_COLOR, Piece.WHITE_KING_REPRESENTATION);
		verifyPiece(Piece.createBlackKnight(), Piece.BLACK_COLOR, Piece.BLACK_KNIGHT_REPRESENTATION);
		verifyPiece(Piece.createBlackBishop(), Piece.BLACK_COLOR, Piece.BLACK_BISHOP_REPRESENTATION);
		verifyPiece(Piece.createBlackQueen(), Piece.BLACK_COLOR, Piece.BLACK_QUEEN_REPRESENTATION);
		verifyPiece(Piece.createBlackKing(), Piece.BLACK_COLOR, Piece.BLACK_KING_REPRESENTATION);
	}

	private void verifyPiece(final Piece piece, final String color, final String representation) {
		assertEquals(color, piece.getColor());
		assertEquals(representation, piece.getRepresentation());
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
}
