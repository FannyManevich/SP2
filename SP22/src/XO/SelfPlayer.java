package XO;

import java.util.Random;

/* Fany Manevich 206116725
 * Dmitri podoluk 317059244
 * https://github.com/FannyManevich/SP2.git
 */

public class SelfPlayer extends Player implements Runnable  {

	PlayerType nextTurn, selfTurn;
	public SelfGame selfGame;
	PlayerType[][] gameBoard;
	
	public SelfPlayer(String name, PlayerType selfTurn) {
		super(name, selfTurn);
		gameBoard = selfGame.getGameBoard();
		
		
	}
	
	public void setCell(int randomRow, int randomCol, PlayerType turn) {
	
		if ( gameBoard[randomRow][randomCol] == PlayerType.FREE) {
				this.gameBoard[randomRow][randomCol] = turn;
			if ( selfGame.getTurn() == selfTurn) {
				
			}
				
		}
	}
	
	public void run(){
		
		int randomRow, randomCol;
		Random random = new Random();
		
		while( !selfGame.isBoardFull() ){
			
			try {
				Thread.sleep(500);
				
				randomRow = random.nextInt(5);
				randomCol = random.nextInt(5);
				setCell(randomRow,randomCol,this.turn);
				
				selfGame.printBoard();
				
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		}
		
	}

}
