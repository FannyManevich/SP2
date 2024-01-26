package XO;

import java.util.Scanner;

/* Fany Manevich 206116725
 * Dmitri podoluk 317059244
 * https://github.com/FannyManevich/SP2.git
 */
public class UserPlayer extends Player implements Runnable  {

	UserGame userGame;
	PlayerType nextTurn;
	Coordinates[] empty;
	
	public UserPlayer(String name, PlayerType playerSymbol) {
		super(name, playerSymbol);
		empty = userGame.getFreeCells();
	}

	public void run() {
		
		Scanner sc = new Scanner(System.in);
		
		while( !userGame.isBoardFull()) {
			
			if(this.getPlayerSymbol() == userGame.getTurn()) {
				System.out.println("Please enter coordinates cell.");
				System.out.println("x:");
				int x = sc.nextInt();
				System.out.println("y:");
				int y = sc.nextInt();
				
				userGame.setCell(x, y, playerSymbol, empty);
				
				if ( userGame.getTurn() == PlayerType.X )
					nextTurn = PlayerType.O;
				else nextTurn = PlayerType.X;
			}
				
				
			
			sc.close();
		}
	}
	
	public PlayerType CheckLeftDiagonal() {
		int count = 0;
		for (int i = 0; i < 5; i ++) {
			if ( userGame.getGameBoard()[i][i] == this.getPlayerSymbol() ) {
				count ++;
			}
		}
		if( count == 5) {
			return this.getPlayerSymbol();
		}
		else return PlayerType.FREE;
	}
	public PlayerType CheckRightDiagonal() {
		int count = 0;
		for (int i = 0; i < 5; i ++) {
			for (int j = 4; j >= 0; j --) {
				if ( userGame.getGameBoard()[i][i] == this.getPlayerSymbol() ) {
					count ++;
				}
			}
		}
		if( count == 5) {
			return this.getPlayerSymbol();
		}
		else return PlayerType.FREE;
	}

	public PlayerType CheckRow() {
		int count = 0;
		
		for (int i = 0; i < 5; i ++) {
			if ( userGame.getGameBoard()[i][i] == this.getPlayerSymbol() ) {
				count ++;
			}
		}
		if( count == 5) {
			return this.getPlayerSymbol();
		}
		else return PlayerType.FREE;
	}
	
	//public PlayerType

}
