package chess;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RankTest {
	Rank rank;

	@Before
	public void setUp() {
		rank = new Rank();
	}

	@Test
	public void add_piece() throws Exception {
		rank.createBlackPiecesRank();
		rank.createBlackPawnRank();
		rank.createBlankRank();
		rank.createBlankRank();
		rank.createBlankRank();
		rank.createBlankRank();
		rank.createWhitePawnRank();
		rank.createWhitePiecesRank();
		assertEquals(64, rank.size());
	}

	@Test
	public void get_blackPawn() throws Exception {
		rank.createBlackPawnRank();
		assertEquals("PPPPPPPP", rank.getRankRepresentation());
	}

	@Test
	public void sort() throws Exception {
		rank.createBlackPiecesRank();
		rank.sortLowToHigh();
		System.out.println(rank.getRankRepresentation());
		rank.sortHighToLow();
		System.out.println(rank.getRankRepresentation());
	}
}
