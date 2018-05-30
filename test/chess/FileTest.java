package chess;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FileTest {
	File file;
	private String whitePawnLine = "pppppppp";
	private String whiteSpectialLine = "rnbqkbnr";
	private String emptyLine = "........";
	private String returnLine = System.getProperty("line.separator");

	@Before
	public void setUp() {
		file = new File();
	}

	@Test
	public void countFile() throws Exception {
		file = new File(8);
		assertEquals((int) 8, file.size());
	}

	@Test
	public void showFile() throws Exception {
		file = new File(3);
		assertEquals(emptyLine + returnLine + whitePawnLine +
				returnLine + whiteSpectialLine + returnLine, file.show());
	}
}
