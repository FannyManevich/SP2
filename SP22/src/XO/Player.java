package XO;
/* Fany Manevich 206116725
 * Dmitri podoluk 317059244
 * https://github.com/FannyManevich/SP2.git
 */
public abstract class Player {


	PlayerType turn_;
	String name;
	Game board;

	public Player(PlayerType turn_, String name, Game board) {
		this.turn_ = turn_;
		this.name = name;
		this.board = board;
	}

}