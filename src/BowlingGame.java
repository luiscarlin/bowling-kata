public class BowlingGame {

	private final int NUMBER_OF_FRAMES = 10;

	private Frame[] myFrames;
	private int currentFrame;

	public BowlingGame() {
		myFrames = new Frame[NUMBER_OF_FRAMES];
		currentFrame = 0;
		configureFrames();
	}

	private void configureFrames() {
		for (int i = 0; i < NUMBER_OF_FRAMES; i++) {

			if (i == (NUMBER_OF_FRAMES - 1)) {
				myFrames[i] = new TenthFrame(i);
			} else {
				myFrames[i] = new Frame(i);
			}
		}
		
		for (int i = 0; i < NUMBER_OF_FRAMES; i++) {
			if (i == 0) {
				myFrames[i].setNextFrame(myFrames[i+1]);
			} else if (i == NUMBER_OF_FRAMES -1) {
				myFrames[i].setPreviousFrame(myFrames[i-1]);
			} else {
				myFrames[i].setPreviousFrame(myFrames[i-1]);
				myFrames[i].setNextFrame(myFrames[i+1]);
			}
		}
	}

	public Frame getCurrentFrame() {
		return myFrames[currentFrame];
	}

	public void setCurrentFrameNumber(int location) {
		currentFrame = location;
	}

	public void roll(int pinsDown) throws Exception {
		Frame frame = getCurrentFrame();
		int pinsRemaining = frame.addRoll(pinsDown);
		if (pinsRemaining == 0) {
			currentFrame++;
		}
	}

	public int getScore() {
		return getCurrentFrame().getScore();
	}
}
