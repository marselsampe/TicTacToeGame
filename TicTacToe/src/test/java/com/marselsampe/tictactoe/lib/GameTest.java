package com.marselsampe.tictactoe.lib;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GameTest {
	@Test
	public void testInitializeGame() {
		IGame game = new Game(3, "Player 1", "Player 2");
		
		assertEquals(GameStateEnum.PLAYING, game.getGameState());
		
		SeedTypeEnum[][] expectedBoardContents = new SeedTypeEnum[][] {
			{SeedTypeEnum.EMPTY, SeedTypeEnum.EMPTY, SeedTypeEnum.EMPTY},
			{SeedTypeEnum.EMPTY, SeedTypeEnum.EMPTY, SeedTypeEnum.EMPTY},
			{SeedTypeEnum.EMPTY, SeedTypeEnum.EMPTY, SeedTypeEnum.EMPTY}
		};
		assertArrayEquals(expectedBoardContents, game.getBoardContents());
	}
	
	@Test
	public void testUpdateGame() {
		IGame game = new Game(3, "Player 1", "Player 2");
		game.updateGame(1, 1);
		SeedTypeEnum[][] boardContents = game.getBoardContents();
		assertEquals(SeedTypeEnum.CROSS, boardContents[0][0]);
	}
	
	@Test
	public void testRestartGame() {
		IGame game = new Game(3, "Player 1", "Player 2");
		game.updateGame(1, 1);
		game.restartGame();
		
		// check game state
		assertEquals(GameStateEnum.PLAYING, game.getGameState());
		
		// check current player
		Player currentPlayer = game.getCurrentPlayer();
		assertEquals("Player 1", currentPlayer.getName());
		
		// check board
		SeedTypeEnum[][] expectedBoardContents = new SeedTypeEnum[][] {
			{SeedTypeEnum.EMPTY, SeedTypeEnum.EMPTY, SeedTypeEnum.EMPTY},
			{SeedTypeEnum.EMPTY, SeedTypeEnum.EMPTY, SeedTypeEnum.EMPTY},
			{SeedTypeEnum.EMPTY, SeedTypeEnum.EMPTY, SeedTypeEnum.EMPTY}
		};
		assertArrayEquals(expectedBoardContents, game.getBoardContents());
	}
}