package dkeep.test;

import static org.junit.Assert.*;
import org.junit.Test;

import dkeep.logic.*;
public class TestDungeonGameLogic {
	
	@Test
	public void testMoveHeroToFreeCell() {
		GameMap Game = new GameMap();
		Game.changeState(0);
		assertEquals(1, Game.getHeroX()); assertEquals(1, Game.getHeroY()); 
		Game.moveHero('s');
		assertEquals(1, Game.getHeroX()); assertEquals(2, Game.getHeroY()); 		
	}
	
	@Test
	public void testHeroBlockedByWall(){
		GameMap Game = new GameMap();
		Game.changeState(0);
		assertEquals(1, Game.getHeroX()); assertEquals(1, Game.getHeroY()); 
		Game.moveHero('w');
		assertEquals(1, Game.getHeroX()); assertEquals(1, Game.getHeroY()); 
	}
	
	@Test
	public void testHeroLosesByGuard(){
		GameMap Game = new GameMap();
		Game.changeState(0);
		assertEquals(1, Game.getHeroX()); assertEquals(1, Game.getHeroY()); 
		Game.moveHero('d');
		assertTrue(Game.isEndOfGame()); 
	}
	
	@Test
	public void testHeroTriesToExit() {
		
		GameMap Game = new GameMap();
		Game.changeState(0);
		assertEquals(1, Game.getHeroX()); assertEquals(1, Game.getHeroY()); 
		Game.moveHero('s');
		Game.moveHero('a');
		assertEquals(1, Game.getHeroX()); assertEquals(2, Game.getHeroY());
		assertFalse(Game.isEndOfGame());
	}
	
	@Test
	public void testHeroTriesToExitAndPasses() {
		
		GameMap Game = new GameMap();
		Game.changeState(0);
		assertEquals(1, Game.getHeroX()); assertEquals(1, Game.getHeroY()); 
		Game.moveHero('s');
		Game.moveHero('s');
		Game.moveHero('a');
		assertTrue(Game.isEndOfGame());	
	}
	
	@Test
	public void testDoorsOpen() {
		
		GameMap Game = new GameMap();
		Game.changeState(0);
		assertEquals(1, Game.getHeroX()); assertEquals(1, Game.getHeroY()); 
		Game.moveHero('s');
		Game.moveHero('s');
		assertEquals('S',Game.getMapPos(2,0));	
		assertEquals('S',Game.getMapPos(3,0));	
	}
}