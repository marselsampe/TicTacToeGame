package com.marselsampe.tictactoe.multiuser;

import java.util.HashMap;

import com.marselsampe.tictactoe.lib.*;

public class GameManagement implements IGameManagement {
	private HashMap<String,IGame> gameMap;
	
	public GameManagement(){
		this.gameMap = new HashMap<String,IGame>();
	}

	@Override
	public void addGame( String key, int boardSize, String player1Name, String player2Name ){
		this.gameMap.put(key, new Game( boardSize, player1Name, player2Name ) );
	}

	@Override
	public int updateGame( String key, int currentRow, int currentColumn ){
		// -1=NOT VALID, 0=PLAYING, 1=DRAW, 2=CROSS_WON, 3=NOUGHT_WON
		
		IGame game = this.gameMap.get( key );
		boolean isSuccess = game.updateGame(currentRow, currentColumn);
		if( !isSuccess )
			return -1;
		
		return convertGameStateToNumber( game.getGameState() );
	}
	
	@Override
	public void restartGame( String key ){
		IGame game = this.gameMap.get( key );
		game.restartGame();
	}

	@Override
	public void removeGame( String key ){
		this.gameMap.remove( key );
	}

	@Override
	public int[][] getGameContents( String key ){
		// 0=EMPTY, 1=CROSS, 2=NOUGHT
		IGame game = this.gameMap.get( key ); 
		return convertBoardContentsToClientFormat( game.getBoardContents() );
	}
	
	int[][] convertBoardContentsToClientFormat( SeedTypeEnum[][] boardContents ){
		int boardSize = boardContents.length;
		int[][] convertedContents = new int[boardContents.length][boardContents.length];
		for( int i=0; i<boardSize; i++ ){
			for( int j=0; j<boardSize; j++ ){
				convertedContents[i][j] = convertSeedTypeToNumber( boardContents[i][j]  );
			}
		}
		return convertedContents;		
	}
	
	int convertGameStateToNumber( GameStateEnum gameState ){
		switch (gameState) {
	   		case DRAW: return 1;
	   		case CROSS_WON: return 2;
	   		case NOUGHT_WON: return 3;
	   		default : return 0;
	    }
	}
	
	int convertSeedTypeToNumber( SeedTypeEnum seedType ){
		switch (seedType) {
	   		case CROSS: return 1;
	   		case NOUGHT: return 2;
	   		default : return 0;
	    }
	}
}
