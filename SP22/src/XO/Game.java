package XO;
/* Fany Manevich 206116725
 * Dmitri podoluk 317059244
 * https://github.com/FannyManevich/SP2.git
 */
public abstract class Game {
	
	PlayerType[][] gameBoard;
	
	public PlayerType[][] getGameBoard() {
		return gameBoard;
	}
	
	public void setGameBoard(PlayerType[][] gameBoard) {
		this.gameBoard = gameBoard;
	}
	
	public Game(){
		gameBoard = new PlayerType[5][5];
		resetBoard();
		
	}

	public abstract void printBoard();

	public abstract PlayerType getTurn();

	public abstract Coordinates[] getFreeCells();
	
	public  abstract boolean  getWinner();
	
	public boolean isBoardFull() {
		
		for (int i = 0; i < 5; i ++) {
			
			for (int j = 0; j < 5; j ++) {
				if (gameBoard[i][j] == PlayerType.FREE)
					return false;
			}
		}
		
		return true;
	}
	
	public void resetBoard() {
		for (int i = 0; i < 5; i ++) {
			for (int j = 0; j < 5; j ++) {
				gameBoard[i][j] = PlayerType.FREE;
			}
		}
	}
	


}
