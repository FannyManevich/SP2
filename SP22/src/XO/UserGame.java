package XO;

/* Fany Manevich 206116725
 * Dmitri podoluk 317059244
 * https://github.com/FannyManevich/SP2.git
 */

public class UserGame extends Game {
	
	PlayerType thisTurn,nextTurn;
	SelfPlayer selfPlayer;
	UserPlayer userPlayer;
	//PlayerType[][] gameBoard;
	
	public UserGame(SelfPlayer selfPlayer, UserPlayer userPlayer) {
		super();
		this.selfPlayer = selfPlayer;
		this.userPlayer = userPlayer;
		thisTurn = selfPlayer.playerSymbol;
	}

	public PlayerType getTurn() {
		return thisTurn;
	}
}
