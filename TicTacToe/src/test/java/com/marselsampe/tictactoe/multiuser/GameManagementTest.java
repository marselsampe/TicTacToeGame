package com.marselsampe.tictactoe.multiuser;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GameManagementTest {
	@Test
	public void testAddGame() {
		IGameManagement gameManagement = new GameManagement();
		gameManagement.addGame("game 1", 3, "Player 1", "Player 2");
		
		int[][] expectedGameContents = new int[][] {
			{0,0,0},
			{0,0,0},
			{0,0,0}
		};
		assertArrayEquals(expectedGameContents, gameManagement.getGameContents("game 1"));
	}
	
	@Test
	public void testUpdateGame() {
		IGameManagement gameManagement = new GameManagement();
		gameManagement.addGame("game 1", 3, "Player 1", "Player 2");
		gameManagement.updateGame("game 1", 1, 1);
		int[][] game1Contents = gameManagement.getGameContents("game 1");
		
		assertEquals(1, game1Contents[0][0]);
	}
	
	@Test
	public void testRestartGame() {
		IGameManagement gameManagement = new GameManagement();
		gameManagement.addGame("game 1", 3, "Player 1", "Player 2");
		gameManagement.updateGame("game 1", 1, 1);
		gameManagement.restartGame("game 1");
		int[][] game1Contents = gameManagement.getGameContents("game 1");

		// check cell
		assertEquals(0, game1Contents[0][0]);
		
		// check board
		int[][] expectedGameContents = new int[][] {
			{0,0,0},
			{0,0,0},
			{0,0,0}
		};
		assertArrayEquals(expectedGameContents, game1Contents);
	}
}
