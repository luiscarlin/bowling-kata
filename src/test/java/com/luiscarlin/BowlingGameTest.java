package com.luiscarlin;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class BowlingGameTest {
	
	private BowlingGame game;
	
	@Before
	public void setUp() { 
		game = new BowlingGame(); 	
	}
	
	@Test
	public void whenICreateANewGameIGetAnObject() {
		assertNotNull(game);
	}
	
	@Test
	public void whenIStartANewGameIStartWithFrameOne() { 
		Frame frame = game.getCurrentFrame();
		
		assertNotNull(frame); 
		assertEquals(0, frame.getFrameNumber()); 
	}
	
	@Test 
	public void whenPlayerRollsTwoAndSevenThenScoreIsNine() throws Exception { 
		game.roll(2); 
		game.roll(7); 
		
		assertEquals(9, game.getScore());
	}
	
	@Test (expected=Exception.class)
	public void whenPlayerRollsMoreThanTenPinsThenErrorIsReturned() throws Exception { 
		game.roll(2); 
		game.roll(10); 
	}
	
	@Test
	public void whenPlayerRollsStrikeThenFrameNumberShouldAdvance() throws Exception { 
		game.roll(10); 
		
		assertEquals(1, game.getCurrentFrame().getFrameNumber());
	}
	
	@Test
	public void playerRollsThreeStrikes() throws Exception { 
		game.roll(10);
		game.roll(10);
		game.roll(10);
		
		assertEquals(3, game.getCurrentFrame().getFrameNumber());
	}
	@Test
	public void whenThePlayerRollsAStrikeAndTwoGuttersThenScoreShouldBeTen() throws Exception { 
		game.roll(10);
		assertEquals(1, game.getCurrentFrame().getFrameNumber());
		
		game.roll(0);
		game.roll(0);
		
		assertEquals(2, game.getCurrentFrame().getFrameNumber());
		assertEquals(10, game.getScore()); 
	}
}