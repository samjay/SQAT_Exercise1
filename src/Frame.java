public class Frame {
	private int firstThrow;
	private int secondThrow;
	
	public Frame(int firstThrow, int secondThrow){
		this.firstThrow = firstThrow;
		this.secondThrow = secondThrow;
	}
	
	public int getFirstThrow() {
		return firstThrow;
	}

	public int getSecondThrow() {
		return secondThrow;
	}

	//returns the score of a single frame
	public int score() throws BowlingException{
		int score = firstThrow + secondThrow;
		if(score>10 || score < 0){
			throw new BowlingException();
		}
		return firstThrow + secondThrow;
	}
	
	//returns whether the frame is a strike or not
	public boolean isStrike() throws BowlingException{
		if(firstThrow==10){
			return true;
		}
		return false;
	}
	
	//return whether a frame is a spare or not
	public boolean isSpare() throws BowlingException{
		if(score()==10){
			return true;
		}
		return false;
	}	

}
