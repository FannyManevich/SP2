package XO;

import java.util.ArrayList;
import java.util.Random;

/* Fany Manevich 206116725
 * Dmitri podoluk 317059244
 * https://github.com/FannyManevich/SP2.git
 */

public class SelfPlayer extends Player implements Runnable  {
	
	private SelfGame selfGame;
    private PlayerType[][] gameBoard;
	
	public SelfPlayer(String name, PlayerType playerSymbol) {
		super(name, playerSymbol);

	}
	
	public void run(){
		
		int x, y ,randomCell;
		Random random = new Random();
		
		while( !selfGame.isBoardFull() ){
			
			try {
                Thread.sleep(500);

                if (this.getPlayerSymbol() == selfGame.getTurn()) {
                    ArrayList<Coordinates> empty = selfGame.getFreeCells();

                    if (!empty.isEmpty()) {
                        randomCell = random.nextInt(empty.size());
                        x = empty.get(randomCell).getRow();
                        y = empty.get(randomCell).getColumn();

                        gameBoard[x][y] = this.getPlayerSymbol();
                        selfGame.setNextTurn();
                    }
                }

                selfGame.printBoard();

            } catch (InterruptedException e) {
            	System.out.println("Board is full");
                e.printStackTrace();
            }
        }
    }
}