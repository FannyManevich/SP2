package XO;

/* Fany Manevich 206116725
 * Dmitri podoluk 317059244
 * https://github.com/FannyManevich/SP2.git
 */

public class SelfGame extends Game{

	//Game gameBoard;
	PlayerType thisTurn,nextTurn;
	private SelfPlayer player1, player2;

	public SelfGame(SelfPlayer player1, SelfPlayer player2) {
		this.player1 = player1;
		this.player2 = player2;
		thisTurn = player1.playerSymbol;
		nextTurn = player2.playerSymbol;
	}
	public SelfGame() {
		//gameBoard = ;
	}

	public PlayerType getTurn() {
		return thisTurn;
	}
	

	
}
