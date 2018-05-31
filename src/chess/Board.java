package chess;

import java.util.ArrayList;
import java.util.List;

import piece.Piece;

public class Board {
	String returnLine = System.getProperty("line.separator");
	String line = "........";
	File board;
	List<Piece> blackPieces = new ArrayList<>();
	List<Piece> blackPawns = new ArrayList<>();
	List<Piece> whitePawns = new ArrayList<>();
	List<Piece> whitePieces = new ArrayList<>();

	public Board() {
		createBoard();
	}

	private void createBoard() {
		File file = new File(8);
		board = file.getFile();
	}

	public String draw() {
		return board.show();
	}

	public void initialize() {
		addBlackPiece();
		addBlackPawns();
		addWhitePawns();
		addWhitePiece();
	}

	private void addWhitePiece() {
		whitePieces.add(Piece.createWhiteRook());
		whitePieces.add(Piece.createWhiteKnight());
		whitePieces.add(Piece.createWhiteBishop());
		whitePieces.add(Piece.createWhiteQueen());
		whitePieces.add(Piece.createWhiteKing());
		whitePieces.add(Piece.createWhiteBishop());
		whitePieces.add(Piece.createWhiteKnight());
		whitePieces.add(Piece.createWhiteRook());

	}

	private void addBlackPiece() {
		blackPieces.add(Piece.createBlackRook());
		blackPieces.add(Piece.createBlackKnight());
		blackPieces.add(Piece.createBlackBishop());
		blackPieces.add(Piece.createBlackQueen());
		blackPieces.add(Piece.createBlackKing());
		blackPieces.add(Piece.createBlackBishop());
		blackPieces.add(Piece.createBlackKnight());
		blackPieces.add(Piece.createBlackRook());
	}

	private void addBlackPawns() {
		for (int i = 0; i < 8; i++) {
			blackPawns.add(Piece.createBlackPawn());
		}
	}

	private void addWhitePawns() {
		for (int i = 0; i < 8; i++) {
			whitePawns.add(Piece.createWhitePawn());
		}
	}

	private String print() {
		initialize();
		StringBuffer bf = new StringBuffer();
		bf.append(getBlackPiecesResult() + returnLine);
		bf.append(getBlackPawnsResult() + returnLine);
		bf.append(line + returnLine);
		bf.append(line + returnLine);
		bf.append(line + returnLine);
		bf.append(line + returnLine);
		bf.append(getWhitePawnsResult() + returnLine);
		bf.append(getWhitePiecesResult() + returnLine);
		return bf.toString();
	}

	private String getWhitePiecesResult() {
		Piece piece;
		StringBuffer bf = new StringBuffer();
		for (int i = 0; i < 8; i++) {
			piece = whitePieces.get(i);
			bf.append(piece.getRepresentation());
		}
		return bf.toString();
	}

	private String getBlackPiecesResult() {
		Piece piece;
		StringBuffer bf = new StringBuffer();
		for (int i = 0; i < 8; i++) {
			piece = blackPieces.get(i);
			bf.append(piece.getRepresentation());
		}
		return bf.toString();
	}

	public String getWhitePawnsResult() {
		Piece pawn;
		StringBuffer bf = new StringBuffer();
		for (int i = 0; i < 8; i++) {
			pawn = whitePawns.get(i);
			bf.append(pawn.getRepresentation());
		}
		return bf.toString();
	}

	public String getBlackPawnsResult() {
		Piece pawn;
		StringBuffer bf = new StringBuffer();
		for (int i = 0; i < 8; i++) {
			pawn = blackPawns.get(i);
			bf.append(pawn.getRepresentation());
		}
		return bf.toString();
	}

	public Piece findBlackPawn(int index) {
		return blackPawns.get(index);
	}

	public Piece findWhitePawn(int index) {
		return whitePawns.get(index);
	}

	public int blackPawnSize() {
		return blackPawns.size();
	}

	public void addBlackPawn(Piece pawn) {
		blackPawns.add(pawn);
	}

	public void addWhitePawn(Piece pawn) {
		whitePawns.add(pawn);
	}

	public int whitePawnSize() {
		return whitePawns.size();
	}

	public int blackPieceSize() {
		return blackPieces.size();
	}

	public int whitePieceSize() {
		return whitePieces.size();
	}

	public int pieceCount() {
		return blackPieceSize() + blackPawnSize() + whitePawnSize() + whitePieceSize();
	}

	public String showBoard() {
		return print();
	}
}
