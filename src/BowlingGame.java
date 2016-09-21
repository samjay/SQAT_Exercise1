import java.util.ArrayList;
import java.util.List;

//Finish time:
//ID:

public class BowlingGame {
	// a bowling game is made of (at least) 10 frames
	private List<Frame> frames = new ArrayList<Frame>();
	private Frame bonus;

	public BowlingGame() {
	}

	// adds a frame to the game
	public void addFrame(Frame frame) throws BowlingException {
		frames.add(frame);
		if (frames.size() > 10) {
			throw new BowlingException();
		}
	}

	// Sets the bonus throws at the end of the game
	public void setBonus(int firstThrow, int secondThrow) throws BowlingException {
		if (frames.size() == 10) {
			bonus = new Frame(firstThrow, secondThrow);
		}else{
			throw new BowlingException();
		}
	}

	// Returns the game score
	public int score() throws BowlingException {
		int totalScore = 0;
		for (Frame frame : frames) {
//			if(frame.isSpare()){
//				totalScore
//			}
			totalScore = totalScore + frame.score();
		}
		return totalScore;
	}

	public int numberOfFrames() {
		return frames.size();
	}
}
