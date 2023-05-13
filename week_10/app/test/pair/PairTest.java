package pair;

import static org.junit.Assert.*;

import org.junit.Test;

public class PairTest {

	@Test
	public void firstInOut() {
		Pair <String, Boolean> p = new Pair<>("foo", true);
		assertEquals("foo", (String) p.getFirst());
		assertEquals(true, (Boolean) p.getSecond());
	}

	@Test
	public void fails()
	{
		Pair <String, Boolean> p = new Pair<>("foo", true);
		// This should be a compile error, not a run time error classCastExeption
		assertEquals(true, (Boolean) p.getFirst());
		assertEquals("foo", (String) p.getSecond());
	}
}
