package XO;
/* Fany Manevich 206116725
 * Dmitri podoluk 317059244
 * https://github.com/FannyManevich/SP2.git
 */
public abstract class Player {

	private String name;
	public PlayerType playerSymbol;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PlayerType getPlayerSymbol() {
		return playerSymbol;
	}

	public void setPlayerSymbol(PlayerType playerSymbol) {
		this.playerSymbol = playerSymbol;
	}
	
	public Player(String name, PlayerType playerSymbol) {
		
		this.name = name;
		this.playerSymbol = playerSymbol;
	}
}
