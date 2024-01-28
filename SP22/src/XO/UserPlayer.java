package XO;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

/* Fany Manevich 206116725
 * Dmitri podoluk 317059244
 * https://github.com/FannyManevich/SP2.git
 */
public class UserPlayer extends Player implements Runnable  {

	char sign;
	String name;
	Random random = new Random();
	Game board;
	Scanner sc = new Scanner(System.in);
	boolean turn = true;
	PlayerType turn_;

	public UserPlayer(PlayerType turn_, String name, Game board) {
		super(turn_, name, board);
		this.board = board;
		this.name = name;
		this.turn_ = turn_;
	}

	@Override
	public void run() {

		while (!(this.board.getFreeCells().isEmpty()) && !(this.board.HaveWinner())) {
			ArrayList<Coordinates> free = new ArrayList<>(this.board.getFreeCells());

			if (this.board.getTurn().equals(this.turn_)) {
				System.out.println(this.name+" play ");

				System.out.println("free cells (x,y)");
				System.out.println(free);
				System.out.println("x:");
				int x = sc.nextInt();
				System.out.println("y:");
				int y = sc.nextInt();
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
			
		}


		if (this.board.getFreeCells().isEmpty()) {
			System.out.println("board full");
		}
	}
}