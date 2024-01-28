package XO;

import java.util.ArrayList;
import java.util.Scanner;

/* Fany Manevich 206116725
 * Dmitri podoluk 317059244
 * https://github.com/FannyManevich/SP2.git
 */
public class UserPlayer extends Player implements Runnable  {

	private UserGame userGame;
	PlayerType nextTurn;
	ArrayList<Coordinates> empty;
	PlayerType[][] gameBoard;
	
	
	public UserPlayer(String name, PlayerType playerSymbol) {
		super(name, playerSymbol);
		empty = new ArrayList<Coordinates>();
	}

	public void run() {
		
		Scanner sc = new Scanner(System.in);
		Coordinates temp = new Coordinates();
		
		while( !userGame.isBoardFull()) {
			
			if(this.getPlayerSymbol() == this.getTurn()) {
				empty = userGame.getFreeCells();
				
				System.out.println("Please enter coordinates cell.");
				System.out.println("x:");
				int x = sc.nextInt();
				System.out.println("y:");
				int y = sc.nextInt();
				
				temp.setRow(x);
				temp.setColumn(y);
				
				if(empty.contains(temp)) {
					gameBoard[x][y] = this.getPlayerSymbol();
					this.setNextTurn();
					empty = userGame.getFreeCells();
				} else {
                    System.out.println("Cell is not empty.");
				}			
			}
		}
		System.out.println("Board is full");
		sc.close();
	}

}
