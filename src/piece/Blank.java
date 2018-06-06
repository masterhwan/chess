package piece;

import java.util.Arrays;
import java.util.List;

import Exception.InvalidMovePositionException;

public class Blank extends Piece {

	public Blank(Color color, Type type, Position position, List<Direction> directions) {
		super(color, type, position, directions);
	}

	public static Blank create(Position position) {
		return new Blank(Color.NOCOLOR, Type.NO_PIECE, position, Arrays.asList());
	}

	@Override
	public Direction verifyMovePosition(Piece piece) {
		throw new InvalidMovePositionException("블랭크는 이동할 수 없습니다.");
	}
}
