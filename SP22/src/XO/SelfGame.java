package XO;

/* Fany Manevich 206116725
 * Dmitri podoluk 317059244
 * https://github.com/FannyManevich/SP2.git
 */

public class SelfGame extends Game{

	PlayerType[][] gameBoard;
	PlayerType thisTurn,nextTurn;
	private SelfPlayer player1, player2;

	public SelfGame(SelfPlayer player1, SelfPlayer player2) {
		this.player1 = player1;
		this.player2 = player2;
		thisTurn = player1.playerSymbol;
	}

	public PlayerType getTurn() {
		return thisTurn;
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
			if ( gameBoard[i][i] == getTurn() || gameBoard[i][i] == player2.getPlayerSymbol()) {
				count ++;
			}
		}
		if( count == 5) {
			return true;
		}
		else return false;
	}
	public PlayerType CheckRightDiagonal() {
		int count = 0;
		for (int i = 0; i < 5; i ++) {
			for (int j = 4; j >= 0; j --) {
				if ( gameBoard[i][i] == player1.getPlayerSymbol() ) {
					count ++;
				}
		}
		}
		if( count == 5) {
			return player1.getPlayerSymbol() ;
		}
		else return player1.getPlayerSymbol() ;
	}

	public PlayerType CheckRow() {
		int count = 0;
		
		for (int i = 0; i < 5; i ++) {
			if ( gameBoard[i][i] == player1.getPlayerSymbol()  ) {
				count ++;
			}
		}
		if( count == 5) {
			return player1.getPlayerSymbol() ;
		}
		else return  PlayerType.FREE;
	}
	
	
}
