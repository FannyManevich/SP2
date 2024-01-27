package XO;

import java.util.Random;

/* Fany Manevich 206116725
 * Dmitri podoluk 317059244
 * https://github.com/FannyManevich/SP2.git
 */

public class SelfPlayer extends Player implements Runnable  {
	
	public SelfGame selfGame;
	PlayerType nextTurn;
	Coordinates[] empty;
	
	public SelfPlayer(String name, PlayerType playerSymbol) {
		super(name, playerSymbol);	
		selfGame = new SelfGame();
		empty = new Coordinates[25];
		empty = selfGame.getFreeCells();
	}
	
	public void run(){
		
		int randomRow, randomCol;
		Random random = new Random();
		
		while( !selfGame.isBoardFull() ){
			
			try {
				Thread.sleep(500);
				
				if(this.getPlayerSymbol() == selfGame.getTurn()) {
					randomRow = random.nextInt(5);
					randomCol = random.nextInt(5);
					selfGame.setCell(randomRow,randomCol,this.playerSymbol, empty);
					
					if ( selfGame.getTurn() == PlayerType.X )
						nextTurn = PlayerType.O;
					else nextTurn = PlayerType.X;
				
				}
				
				selfGame.printBoard();
				
				} catch (InterruptedException e) {
					System.out.println("Board is full");
					e.printStackTrace();
				}
		}
		
	}

}
