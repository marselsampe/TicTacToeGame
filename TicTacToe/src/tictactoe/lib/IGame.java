package tictactoe.lib;

public interface IGame {
	public GameStateEnum getGameState();
	public boolean updateGame( int currentRow, int currentColumn );
	public SeedTypeEnum[][] getBoardContents();
	public void restartGame();
}
