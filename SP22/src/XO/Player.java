package XO;
/* Fany Manevich 206116725
 * Dmitri podoluk 317059244
 * https://github.com/FannyManevich/SP2.git
 */
public abstract class Player {

	private String name;
	public PlayerType turn;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PlayerType getTurn() {
		return turn;
	}

	public void setTurn(PlayerType turn) {
		this.turn = turn;
	}
	
	public Player(String name, PlayerType turn) {
		
		this.name = name;
		this.turn = turn;
	}
}
