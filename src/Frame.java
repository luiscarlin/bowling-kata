import java.util.ArrayList;
import java.util.List;


public class Frame {
	
	private int frameNumber;
	private List<Roll> rolls; 
	private int score;
	private int pinsRemaining;
	private Frame next, previous;
	
	public Frame(int frameNumber) {
		this.setFrameNumber(frameNumber);
		rolls = new ArrayList<Roll>();
		this.setPinsRemaining(10);
		score = 0;
		this.next = null;
		this.previous = null;
	}
	
	public void setNextFrame(Frame nextFrame) {
		this.next = nextFrame;
	}
	
	public void setPreviousFrame(Frame previousFrame) {
		this.previous = previousFrame;
	}
	

	public int getFrameNumber() {
		return frameNumber;
	}

	public void setFrameNumber(int frameNumber) {
		this.frameNumber = frameNumber;
	}
	
	public int addRoll(int pinsDown) throws Exception { 
	
		if (pinsDown > this.getPinsRemaining()) {
			throw new Exception("Roll exceeds number of pins remaining");
		}
		
		Roll roll = new Roll(); 
		roll.setNumberPinsDown(pinsDown);
		rolls.add(roll); 
		
		if (rolls.size() < 2) {
			setPinsRemaining(getPinsRemaining() - pinsDown);
		} else {
			setPinsRemaining(0);
		}
		
		return getPinsRemaining();
	}
	
	public int getScore() { 
		int total = 0;
		int frameScore = calculateFrameScore(); 
		return frameScore;
		
	}
	
	public int calculateFrameScore() { 
		int frameScore = 0; 
		
		for (Roll roll : rolls) { 
			frameScore += roll.getNumberPinsDown();
		}
		return frameScore;
	}

	public int getPinsRemaining() {
		return pinsRemaining;
	}

	public void setPinsRemaining(int pinsRemaining) {
		this.pinsRemaining = pinsRemaining;
	}
}