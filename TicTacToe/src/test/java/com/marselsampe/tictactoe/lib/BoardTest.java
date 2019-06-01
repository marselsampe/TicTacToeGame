package com.marselsampe.tictactoe.lib;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BoardTest {
	@Test
	public void testInitializeBoard() {
		Board board=new Board(3);
		assertEquals(3, board.getSize());
	}
	
	@Test
	public void testUpdateCell() {
		Board board=new Board(3);
		board.updateCell(0, 0, SeedTypeEnum.CROSS);
		SeedTypeEnum[][] boardContents = board.getBoardContents();
		assertEquals(SeedTypeEnum.CROSS, boardContents[0][0]);
	}
}
