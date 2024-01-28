package XO;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

/* Fany Manevich 206116725
 * Dmitri podoluk 317059244
 * https://github.com/FannyManevich/SP2.git
 */

public class SelfPlayer extends Player implements Runnable  {
	
	Object o = new Object();
	char sign;
	String name;
	Random random = new Random();
	Game board;
	public ArrayList<Coordinates> result = new ArrayList<Coordinates>();

	boolean turn = true;
	Scanner sc = new Scanner(System.in);
	PlayerType turn_;

	public SelfPlayer(PlayerType turn_, String name, Game board) {
		super(turn_, name, board);
		this.board = board;
		this.name = name;
		this.turn_ = turn_;
	}


	public void run() {
		int x;
		int y;
		int rand;

		while (!(this.board.getFreeCells().isEmpty()) && !(this.board.HaveWinner())) {

			if (this.board.getTurn().equals(this.turn_)) {
				synchronized (o) {
					System.out.println(this.name+" play ");
					ArrayList<Coordinates> free = this.board.getFreeCells();

					rand = random.nextInt(free.size());
					x = free.get(rand).getRow();
					y = free.get(rand).getColumn();

					try {
						this.board.fillBoard(x, y, this.turn_);

					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					if (this.turn_.equals(PlayerType.O)) {
						this.board.turn_ = PlayerType.X;
					} else {
						this.board.turn_ = PlayerType.O;
					}
				}

			} else {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}

		if (this.board.getFreeCells().isEmpty()) {
			System.out.println("board full");
		}
	}

}