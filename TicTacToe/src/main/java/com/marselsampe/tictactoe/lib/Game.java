package com.marselsampe.tictactoe.lib;

public class Game implements IGame {
	private Board board;
	private Player player1;
	private Player player2;
	private Player currentPlayer;
	private GameStateEnum state;
	
	public Game(){
		
	}

	public Game( int boardSize, String player1Name, String player2Name ){
		initializeNewGame(boardSize, player1Name, player2Name);
	}

	@Override
	public GameStateEnum getGameState(){
		return this.state;
	}

	@Override
	public boolean updateGame( int currentRow, int currentColumn ){
		currentRow--;
		currentColumn--;
		
		if( this.state != GameStateEnum.PLAYING )
			return true;
		
		if( isRowOrColumnNotValid( currentRow, currentColumn ) )
			return false;
		
		SeedTypeEnum currentPlayerType = currentPlayer.getType();
		this.board.updateCell( currentRow, currentColumn, currentPlayerType );
			
		updateGameState( currentRow, currentColumn );
		if( this.state == GameStateEnum.PLAYING )
			switchPlayer();

		return true;
	}

	@Override
	public SeedTypeEnum[][] getBoardContents(){
		return this.board.getBoardContents();
	}

	@Override
	public void restartGame(){
		this.board = new Board( board.getSize() );
		this.state = GameStateEnum.PLAYING;
		this.currentPlayer = player1;
	}
	
	@Override
	public Player getCurrentPlayer() {
		return this.currentPlayer;
	}
	
	void initializeNewGame( int boardSize, String player1Name, String player2Name ){
		this.board = new Board( boardSize );
		this.state = GameStateEnum.PLAYING;
		
		this.player1 = new Player( player1Name, SeedTypeEnum.CROSS );
		this.player2 = new Player( player1Name, SeedTypeEnum.NOUGHT );
		this.currentPlayer = player1;
	}

	void switchPlayer(){
		this.currentPlayer = currentPlayer.getType() == SeedTypeEnum.CROSS ? this.player2 : this.player1;
	}
	
	void updateGameState( int currentRow, int currentColumn ){
		SeedTypeEnum playerType = this.currentPlayer.getType();
		if( hasWon( playerType, currentRow, currentColumn ) )
			this.state = playerType == SeedTypeEnum.CROSS ? GameStateEnum.CROSS_WON : GameStateEnum.NOUGHT_WON;
		else if( isDraw() )
			this.state = GameStateEnum.DRAW;
		else
			this.state = GameStateEnum.PLAYING;
	}
	
	boolean isRowOrColumnNotValid( int currentRow, int currentColumn ){
		int boardSize = this.board.getSize();
		if( currentRow >= boardSize || currentColumn >= boardSize )
			return true;
		return false;
	}

	boolean hasWon(SeedTypeEnum playerType, int currentRow, int currentColumn ){
		int boardSize = this.board.getSize();
		SeedTypeEnum[][] boardContents = this.board.getBoardContents();
		
		boolean isMatch = true;
		
		// check in-the-row
		for( int col=0; col<boardSize; col++ ){
			if( boardContents[ currentRow ][ col ] != playerType ){
				isMatch = false;
				break;
			}
		}
		if( isMatch )
			return true;

		// check in-the-column
		for( int row=0; row<boardSize; row++ ){
			if( boardContents[ row ][ currentColumn ] != playerType ){
				isMatch = false;
				break;
			}
		}
		if( isMatch )
			return true;

		// check in-the-diagonal
		for( int row=0; row<boardSize; row++ ){
			if( boardContents[ row ][ row ] != playerType ){
				isMatch = false;
				break;
			}
		}
		if( isMatch )
			return true;

		// check in-the-opposite-diagonal
		for( int row=0; row<boardSize; row++ ){
			if( boardContents[ row ][ boardSize - ( row + 1 ) ] != playerType ){
				return false;
			}
		}
		
		return true;
	}
	
	public boolean isDraw() {
		int boardSize = this.board.getSize();
		SeedTypeEnum[][] boardContents = this.board.getBoardContents();
		for (int row = 0; row < boardSize; ++row) {
			for (int col = 0; col < boardSize; ++col) {
	            if (boardContents[row][col] == SeedTypeEnum.EMPTY) {
	               return false; // an empty cell found, not draw, exit
	            }
			}
		}
		return true; // no empty cell, it's a draw
	}
}