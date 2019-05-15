package tictactoe.lib;

class Board {
	private int BOARD_SIZE;
	private Cell cells[][];

	public Board( int boardSize ){
		this.BOARD_SIZE = boardSize;
		initializeEmptyBoard();
	}
	
	void initializeEmptyBoard(){
		cells = new Cell[ this.BOARD_SIZE ][ this.BOARD_SIZE ];
		for( int row=0; row<this.BOARD_SIZE; row++ ){
			for( int col=0; col<this.BOARD_SIZE; col++ ){
				cells[ row ][ col ] = new Cell();
			}
		}
	}
	
	public int getSize(){
		return this.BOARD_SIZE;
	}

	public void updateCell( int row, int column, SeedTypeEnum type ){
		cells[ row ][ column ].setContent( type );
	}

	public SeedTypeEnum[][] getBoardContents(){
		SeedTypeEnum[][] boardContents = new SeedTypeEnum[ this.BOARD_SIZE ][ this.BOARD_SIZE ];
		for( int row=0; row<this.BOARD_SIZE; row++){
			for( int col=0; col<this.BOARD_SIZE; col++){
				boardContents[row][col] = cells[row][col].getContent();
			}
		}
		return boardContents;
	}
}