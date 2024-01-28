package XO;

/* Fany Manevich 206116725
 * Dmitri podoluk 317059244
 * https://github.com/FannyManevich/SP2.git
 */

public class UserGame extends Game {

	    private SelfPlayer selfPlayer;
	    private UserPlayer userPlayer;
	    PlayerType thisTurn,nextTurn;

	    public UserGame(SelfPlayer selfPlayer, UserPlayer userPlayer, PlayerType[][] gameBoard) {
	        super();
	        this.selfPlayer = selfPlayer;
	        this.userPlayer = userPlayer;
	        resetTurns();
	        resetBoard();
	    }

	    private void resetTurns() {
	         thisTurn = selfPlayer.getPlayerSymbol();
	         nextTurn = userPlayer.getPlayerSymbol();
	    }

	    public PlayerType getTurn() {
	        return thisTurn;
	    }
	
}
