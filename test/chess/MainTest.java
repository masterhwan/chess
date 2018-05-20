package chess;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MainTest {

	Main main = new Main();

	@Test
	public void mainTest() {
		assertEquals("Hello", main.hello());
	}
}
