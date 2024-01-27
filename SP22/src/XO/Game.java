package XO;
/* Fany Manevich 206116725
 * Dmitri podoluk 317059244
 * https://github.com/FannyManevich/SP2.git
 */
public abstract class Game {
	
	PlayerType[][] gameBoard = new PlayerType[5][5];;
	
	public PlayerType[][] getGameBoard() {
		return gameBoard;
	}
	
	public void setGameBoard(PlayerType[][] gameBoard) {
		resetBoard();
		this.gameBoard = gameBoard;
	}
	public abstract PlayerType getTurn();
	
	public void printBoard() {
		
		System.out.println("~~~~~~~~~~~~~~~~");
		for (int i = 0; i < 5; i ++) {
			
			System.out.print("|  ");
			for (int j = 0; j < 5; j ++) {
				System.out.print(gameBoard[i][j]);
				System.out.print("   | ");
			}	
			System.out.println();
		}
		
		System.out.println();
		System.out.println("~~~~~~~~~~~~~~~~");
		
	}

	public Coordinates[] getFreeCells() {
		
		Coordinates temp;
		Coordinates[] empty = new Coordinates[25];
		
		for (int i = 0; i < 5; i ++) {
			for (int j = 0; j < 5; j ++) {
				if ( gameBoard[i][j] == PlayerType.FREE ) {
					temp = new Coordinates(i, j);
					empty[i] =  temp;
				}
			}
		}
		
		return empty;
	}
	
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
	
	public void setCell(int randomRow, int randomCol, PlayerType turn, Coordinates[] empty) {
		
		for (int i = 0; i < 5; i ++) {
				if ( empty[i].getRow() ==  randomRow && empty[i].getColumn() == randomCol) {
					gameBoard[randomRow][randomCol] = turn;
				}
		}
	}
	
	public synchronized boolean checkWinner(Player player) {
		
		PlayerType symbol = player.getPlayerSymbol();
		
		if( CheckLeftDiagonal(symbol) || CheckRightDiagonal(symbol) || CheckRow(symbol) || CheckCol(symbol)) {
			return true;
		}
		
		return false;
	}
	
	
	public boolean CheckLeftDiagonal(PlayerType symbol) {
		int count = 0;
		for (int i = 0; i < 5; i ++) {
			if ( gameBoard[i][i] == getTurn() || gameBoard[i][i] == symbol) {
				count ++;
			}
		}
		if( count == 5) {
			return true;
		}
		else return false;
	}
	
	public boolean CheckRightDiagonal(PlayerType symbol) {
		int count = 0;
		for (int i = 0; i < 5; i ++) {
			for (int j = 4; j >= 0; j --) {
				if ( gameBoard[i][i] == symbol ) {
					count ++;
				}
		}
		}
		if( count == 5) {
			return true;
		}
		else return false;
	}

	public boolean CheckRow(PlayerType symbol) {
		int count = 0;
		
		for (int i = 0; i < 5; i ++) {
			for (int j = 0; j < 5; j ++) {
				if ( gameBoard[i][j] == symbol  ) {
					count ++;
				}
			}
			if( count == 5) {
				return true;
			}else count = 0;
		}
		return false;
		
	}
	
	public boolean CheckCol(PlayerType symbol) {
		
		int count = 0;
		
		for (int i = 0; i < 5; i ++) {
			for (int j = 0; j < 5; j ++) {
				if ( gameBoard[j][i] == symbol  ) {
					count ++;
				}
			}
			if( count == 5) {
				return true;
			}else count = 0;
		
		}
		return false;
	}

	
}
