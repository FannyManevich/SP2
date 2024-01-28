package XO;
/* Fany Manevich 206116725
 * Dmitri podoluk 317059244
 * https://github.com/FannyManevich/SP2.git
 */
public abstract class Player {

	private String name;
	public PlayerType playerSymbol;
	PlayerType thisTurn,nextTurn;
	public Player(String name, PlayerType playerSymbol) {
			
		this.name = name;
		this.playerSymbol = playerSymbol;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PlayerType getPlayerSymbol() {
		return playerSymbol;
	}


	public PlayerType getTurn() {
		return thisTurn;
	}
	public PlayerType setNextTurn() {
		if ( thisTurn == PlayerType.X )
			nextTurn = PlayerType.O;
		else nextTurn = PlayerType.X;
		
		return nextTurn;
	}
	
}
