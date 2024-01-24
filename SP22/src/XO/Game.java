package XO;
/* Fany Manevich 206116725
 * Dmitri podoluk 317059244
 * https://github.com/FannyManevich/SP2.git
 */
public abstract class Game {
	
	char gameBoard[][] = new char[5][5];
	PlayerType turn;
	
	public abstract void printBoard();
	public abstract PlayerType getTurn();
	
	abstract int getFreeCells();
	
	public abstract boolean  getWinner();
	
}
