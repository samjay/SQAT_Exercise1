import static org.junit.Assert.*;

import org.junit.Test;

public class TestBowling {

	@Test
	public void testFrameScore_afterBothThrows_2_4() {
		
		Frame frame = new Frame(2, 4);
		
		assertEquals("Scores are not added for the frame", frame.score(), 6);
	}

}
