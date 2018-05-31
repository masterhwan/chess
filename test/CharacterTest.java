import static org.junit.Assert.*;

import org.junit.Test;

public class CharacterTest {
	@Test
	public void whitespace() throws Exception {
		assertTrue(Character.isWhitespace('\t'));
		assertTrue(Character.isWhitespace('\t'));
		assertTrue(Character.isWhitespace(' '));
	}

}
