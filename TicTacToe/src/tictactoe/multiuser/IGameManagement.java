package tictactoe.multiuser;

public interface IGameManagement {
	public void addGame( String key, int boardSize, String player1Name, String player2Name );
	public int updateGame( String key, int currentRow, int currentColumn );
	public void restartGame( String key );
	public void removeGame( String key );
	public int[][] getGameContents( String key );
}
