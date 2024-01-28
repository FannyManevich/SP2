package XO;

/* Fany Manevich 206116725
 * Dmitri podoluk 317059244
 * https://github.com/FannyManevich/SP2.git
 */

public class SelfGame extends Game{

	private PlayerType thisTurn,nextTurn;
	private SelfPlayer player1, player2;

	public SelfGame(SelfPlayer player1, SelfPlayer player2,PlayerType[][] gameBoard1) {
		this.player1 = player1;
		this.player2 = player2;
		
		thisTurn = player1.getPlayerSymbol();
		nextTurn = player2.getPlayerSymbol();
		
		resetBoard();
	}

	public PlayerType getTurn() {
		return thisTurn;
	}
	
	public PlayerType setNextTurn() {
		if ( thisTurn == PlayerType.X )
			thisTurn = PlayerType.O;
		else thisTurn = PlayerType.X;
		
		return thisTurn;
	}
	

	
}
