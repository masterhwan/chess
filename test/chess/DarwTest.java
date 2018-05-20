package chess;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DarwTest {

	String returnLine = System.getProperty("line.separator");
	String line = "........";

	Draw draw = new Draw();

	@Test
	public void drawTest() {
		assertEquals(line + returnLine + line + returnLine + line + returnLine + line + returnLine + line + returnLine
				+ line + returnLine + line + returnLine + line + returnLine, draw.draw());
	}
}
