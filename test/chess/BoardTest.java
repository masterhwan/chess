package chess;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BoardTest {

	String returnLine = System.getProperty("line.separator");
	String line = "........";

	Board bard = new Board();

	@Test
	public void drawTest() {
		assertEquals(line + returnLine + line + returnLine + line + returnLine + line + returnLine + line + returnLine
				+ line + returnLine + line + returnLine + line + returnLine, bard.draw());
	}
}
