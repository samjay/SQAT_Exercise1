import static org.junit.Assert.*;

import org.junit.Test;

public class TestBowling {

	@Test
	public void testFrameScore_afterBothThrows_2_4() throws BowlingException {
		
		Frame frame = new Frame(2, 4);
		
		int score = frame.score();		
		
		assertEquals("Scores are not added for the frame", score, 6);

	}
	
	@Test(expected= BowlingException.class)
	public void testFrameScore_score_more_than_10_with_8_5() throws BowlingException {
		
		Frame frame = new Frame(8, 5);		
		frame.score();
	
	}
	
	@Test(expected= BowlingException.class)
	public void testFrameScore_score_less_than_0_with_4_neg5() throws BowlingException {
		
		Frame frame = new Frame(4, -5);		
		frame.score();
	
	}
	
	@Test
	public void testFrameIsSpare() throws BowlingException{
		Frame frame = new Frame(10, 0);
		
		assertEquals("Frame is not a spare", frame.isSpare(), true);
	}

}
