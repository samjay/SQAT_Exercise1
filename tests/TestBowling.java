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
	public void testFrame_10_0_IsStrike() throws BowlingException{
		Frame frame = new Frame(10, 0);
		
		assertEquals("Frame is not a strike", frame.isStrike(), true);
	}
	
	@Test
	public void testFrame_3_0_IsNotAStrike() throws BowlingException{
		Frame frame = new Frame(3, 0);
		
		assertEquals("Frame is a strike", frame.isStrike(), false);
	}
	
	@Test
	public void testFrame_3_7_IsSpare() throws BowlingException{
		Frame frame = new Frame(3, 7);
		
		assertEquals("Frame is not a spare", frame.isSpare(), true);
	}
	
	@Test
	public void testFrame_3_6_IsNotASpare() throws BowlingException{
		Frame frame = new Frame(3, 6);
		
		assertEquals("Frame is a spare", frame.isSpare(), false);
	}
	
	@Test
	public void testBowling_add3Frames() throws BowlingException{
		BowlingGame game = new BowlingGame();
		
		Frame frame1 = new Frame(1, 4);
		
		game.addFrame(frame1);
		
		Frame frame2 = new Frame(4, 5);
		
		game.addFrame(frame2);
		
		Frame frame3 = new Frame(6, 4);
		
		game.addFrame(frame3);
		
		assertEquals("Frames are not added in game", game.numberOfFrames(), 3);
		
		
	}
	
	@Test(expected= BowlingException.class)
	public void testBowling_add11Frames_should_fail() throws BowlingException{
		BowlingGame game = new BowlingGame();		
		Frame frame1 = new Frame(1, 4);		
		game.addFrame(frame1);		
		Frame frame2 = new Frame(4, 5);		
		game.addFrame(frame2);		
		Frame frame3 = new Frame(6, 4);		
		game.addFrame(frame3);	
		Frame frame4 = new Frame(1, 4);		
		game.addFrame(frame1);		
		Frame frame5 = new Frame(4, 5);		
		game.addFrame(frame2);		
		Frame frame6 = new Frame(6, 4);		
		game.addFrame(frame3);		
		Frame frame7 = new Frame(1, 4);		
		game.addFrame(frame1);		
		Frame frame8 = new Frame(4, 5);		
		game.addFrame(frame2);		
		Frame frame9 = new Frame(6, 4);		
		game.addFrame(frame3);	
		Frame frame10 = new Frame(1, 4);		
		game.addFrame(frame1);	
		Frame frame11 = new Frame(1, 4);		
		game.addFrame(frame11);	
		
	}
	
	@Test(expected= BowlingException.class)
	public void testBowling_setBonusFrameWithoutEndingSHouldFail() throws BowlingException{
		BowlingGame game = new BowlingGame();
		Frame frame = new Frame(6, 4);	
		game.addFrame(frame);
		frame= new Frame(4,  2);
		game.addFrame(frame);
		game.setBonus(2, 3);	
		
	}
	
	@Test
	public void testBowling_score_with_1_4_frame() throws BowlingException{
		BowlingGame game = new BowlingGame();
		Frame frame = new Frame(1, 4);	
		game.addFrame(frame);
		
		assertEquals("Score is not calculated for single frame", game.score(), 5);
	}
	
	@Test
	public void testBowling_score_with_1_4_frame_4_5_frame() throws BowlingException{
		BowlingGame game = new BowlingGame();
		Frame frame = new Frame(1, 4);	
		game.addFrame(frame);
		frame= new Frame(4, 5);
		game.addFrame(frame);
		
		assertEquals("Score is not calculated for single frame", game.score(), 14);
	}
	
	@Test
	public void testBowling_score_with_spare_frame() throws BowlingException{
		BowlingGame game = new BowlingGame();
		Frame frame = new Frame(1, 4);	
		game.addFrame(frame);
		frame= new Frame(4, 5);
		game.addFrame(frame);
		frame= new Frame(6, 4);
		game.addFrame(frame);
		frame= new Frame(5, 5);
		game.addFrame(frame);
		
		assertEquals("Spare is not calculated", game.score(), 39);
	}
	
	@Test
	public void testBowling_score_with_strike_frame() throws BowlingException{
		BowlingGame game = new BowlingGame();
		Frame frame = new Frame(1, 4);	//5
		game.addFrame(frame);
		frame= new Frame(4, 5);  //14
		game.addFrame(frame);
		frame= new Frame(10, 0); //24 + 5 +3 =32
		game.addFrame(frame);
		frame= new Frame(5, 3); //32 + 5 + 3 = 40
		game.addFrame(frame);
		
		assertEquals("Strike is not calculated", game.score(), 40);
	}
	
	@Test
	public void testBowling_score_with_last_round_spare_and_bonus_6() throws BowlingException{
		BowlingGame game = new BowlingGame();
		Frame frame = new Frame(1, 4);
		game.addFrame(frame);
		frame= new Frame(4, 5); 
		game.addFrame(frame);
		frame= new Frame(6, 4); 
		game.addFrame(frame);
		frame= new Frame(5, 5); 
		game.addFrame(frame);
		frame= new Frame(10, 0); 
		game.addFrame(frame);
		frame= new Frame(0, 1); 
		game.addFrame(frame);
		frame= new Frame(7, 3); 
		game.addFrame(frame);
		frame= new Frame(6, 4); 
		game.addFrame(frame);
		frame= new Frame(10, 0); 
		game.addFrame(frame);
		frame= new Frame(2, 8); 
		game.addFrame(frame);
		game.setBonus(6, 0);
		
		assertEquals("Strike is not calculated", game.score(), 133);
	}

}
