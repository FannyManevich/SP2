package XO;

/* Fany Manevich 206116725
 * Dmitri podoluk 317059244
 * https://github.com/FannyManevich/SP2.git
 */

public class UserGame extends Game {
	
	PlayerType thisTurn,nextTurn;
	SelfPlayer selfPlayer;
	UserPlayer userPlayer;
	PlayerType[][] gameBoard;
	
	public UserGame(SelfPlayer selfPlayer, UserPlayer userPlayer) {
		super();
		this.selfPlayer = selfPlayer;
		this.userPlayer = userPlayer;
		thisTurn = selfPlayer.playerSymbol;
	}

	public PlayerType getTurn() {
		return thisTurn;
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

}
