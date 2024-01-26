package XO;

/* Fany Manevich 206116725
 * Dmitri podoluk 317059244
 * https://github.com/FannyManevich/SP2.git
 */

public class SelfGame extends Game{

	private SelfPlayer player1, player2;
	PlayerType[][] gameBoard;
	PlayerType nextTurn;
	
	public SelfPlayer getPlayer() {
		return player1;
	}

	public void setPlayer(SelfPlayer player) {
		this.player1 = player;
	}

	public PlayerType[][] getGameBoard() {
		return gameBoard;
	}

	public SelfGame(SelfPlayer player1, SelfPlayer player2) {
		this.player1 = player1;
		this.player2 = player2;
		gameBoard = new PlayerType[5][5];
		resetBoard();
		
	}

	public PlayerType getTurn() {
		if ( player1.getTurn() == PlayerType.X )
			nextTurn = PlayerType.O;
		else nextTurn = PlayerType.X;
		
		return nextTurn;
	}
	
	public void printBoard() {
		
		System.out.println("Self Game");
		System.out.println("~~~~~~~~~~~~~~~~");
		for (int i = 0; i < 5; i ++) {
			
			System.out.print("| ");
			for (int j = 0; j < 5; j ++) {
				System.out.print(gameBoard[i][j]);
			}			
		}
		
		System.out.println();
		System.out.println("~~~~~~~~~~~~~~~~");
		
	}
	
	public Coordinates[] getFreeCells() {
		
		Coordinates[] empty = new Coordinates[25];
		
		for (int i = 0; i < 5; i ++) {
			for (int j = 0; j < 5; j ++) {
				if ( gameBoard[i][j] == PlayerType.FREE ) {
					empty[j].setRow(i);
					empty[j].setColumn(j);
				}
			}
		}
		
		return empty;
	}
	
	public boolean getWinner() {
		
		return false;
	}
	
	public boolean CheckLeftDiagonal() {
		int count = 0;
		for (int i = 0; i < 5; i ++) {
			if ( gameBoard[i][i] == player1.getTurn() || gameBoard[i][i] == player2.getTurn()) {
				count ++;
			}
		}
		if( count == 5) {
			return true;
		}
		else return false;
	}
	public PlayerType CheckRightDiagonal() {
		int count1, count2 = 0;
		for (int i = 0; i < 5; i ++) {
			for (int j = 4; j >= 0; j --) {
				if ( gameBoard[i][i] == player1.getTurn() ) {
					count1 ++;
				}
				if ( gameBoard[i][i] == player2.getTurn() ) {
					count2 ++;
				}
		}
		}
		if( count1 == 5) {
			return player1.getTurn();
		}
		else return false;
	}

	public boolean CheckRow() {
		int count = 0;
		
		for (int i = 0; i < 5; i ++) {
			if ( gameBoard[i][i] == player1.getTurn() ) {
				count ++;
			}
		}
	}
}
