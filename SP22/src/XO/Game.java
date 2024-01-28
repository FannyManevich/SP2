package XO;
/* Fany Manevich 206116725
 * Dmitri podoluk 317059244
 * https://github.com/FannyManevich/SP2.git
 */

import java.util.ArrayList;



public abstract class Game {
	char gameBoard[][] = new char[5][5];
	PlayerType turn_;
	ArrayList<Coordinates> result = new ArrayList<Coordinates>();

	public ArrayList<Coordinates> getFreeCells() {
		
		return result;
	}
	
	public  void fillBoard(int x, int y, PlayerType turn_) throws InterruptedException{
	}

	public abstract void printBoard();

	public abstract PlayerType getTurn();
		

	public abstract  int checkDiagonalBack(int x, int y, char sign) ;
		

	public abstract int checkDiagonal(int x, int y, char sign) ;
		

	public abstract int checkDiagonalFront(int x, int y, char sign) ;
		

	public abstract int checkRow(int x, int y, char sign) ;
	


	public abstract boolean HaveWinner() ;
	
	
	public abstract char getWinner() ;
		
	

	abstract void init();

	public abstract int checkColomn(int x, int y, char sign) ;
	}


