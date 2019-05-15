package tictactoe.console;

import tictactoe.multiuser.*;

public class ConsoleApp {
	public static void main(String[] args){
		IGameManagement gameManagement = new GameManagement();

		// tes update game
		int gameState;
		gameManagement.addGame("game1", 3, "marsel", "sampe");
		gameState = gameManagement.updateGame("game1", 4, 4); // not valid
		printState( gameState );
		gameState = gameManagement.updateGame("game1", 1, 1);
		printState( gameState );
		gameState = gameManagement.updateGame("game1", 2, 1);
		printState( gameState );
		gameState = gameManagement.updateGame("game1", 1, 2);
		printState( gameState );
		gameState = gameManagement.updateGame("game1", 2, 2);
		printState( gameState );		
		gameState = gameManagement.updateGame("game1", 1, 3);
		printState( gameState );
		gameState = gameManagement.updateGame("game1", 2, 3);
		printState( gameState );

		int[][] game1Contents = gameManagement.getGameContents("game1");
		printBoard( game1Contents );
		
		// tes restart game
		gameManagement.restartGame("game1");
		game1Contents = gameManagement.getGameContents("game1");
		printBoard( game1Contents );

		// tes remove game
		gameManagement.removeGame("game1");
		
	}
	
	public static void printState( int state ){
		String convertedState="";
		switch (state) {
   			case 0: convertedState = "Playing"; break;
	   		case 1: convertedState = "Draw"; break;
	   		case 2: convertedState = "Cross Won"; break;
	   		case 3: convertedState = "Nought Won"; break;
	   		default : convertedState = "Not Valid...";
	    }
		System.out.println( "Game state : " + convertedState );
	}
	
	   public static void printBoard( int[][] contents ) {
		   int boardSize = contents.length;
		   for (int row = 0; row < boardSize; row++) {
			   for (int col = 0; col < boardSize; col++) {
				   printCell(contents[row][col]); // print each of the cells
				   if (col != boardSize) {
		               System.out.print("|");   // print vertical partition
				   }
			   }
			   System.out.println();
			   for (int col = 0; col < boardSize; col++) {
				   System.out.print("----"); // print horizontal partition
			   }
			   System.out.println();
		   }
		   System.out.println();
	   }
	   
	   public static void printCell(int content) {
		   switch (content) {
		   		case 0: System.out.print("   "); break;
		   		case 1: System.out.print(" X "); break;
		   		case 2: System.out.print(" O "); break;
		   }
	   }
}
