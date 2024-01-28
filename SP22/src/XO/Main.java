package XO;

import java.util.Scanner;

/* Fany Manevich 206116725
 * Dmitri podoluk 317059244
 * https://github.com/FannyManevich/SP2.git
 */

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Thread t1, t2;
		System.out.println("choose game option ");
		System.out.println("1)user against computer ");
		System.out.println("2)computer against computer ");

		int choose = sc.nextInt();
		switch (choose) {
		case 1:
			UserGame UserGame = new UserGame();
			UserGame.init();

			UserGame.turn_ = PlayerType.O;
			UserPlayer p1 = new UserPlayer(PlayerType.O, "yosi", UserGame);
			SelfPlayer p2 = new SelfPlayer(PlayerType.X, "dima", UserGame);
			t1 = new Thread(p1);
			t2 = new Thread(p2);

			t1.start();
			t2.start();

			try {

				t1.join();
				t2.join();

				if (UserGame.getWinner() == ' ') {
					System.out.println("nobody " + " win");
				}

				if (UserGame.getWinner() == 'O') {
					System.out.println(p1.name + " win");
				}
				if (UserGame.getWinner() == 'x') {
					System.out.println(p2.name + " win");
				}

			} catch (InterruptedException e) {
				e.printStackTrace();

				break;
			}
			break;

		case 2:
			SelfGame selfGame = new SelfGame();
			selfGame.init();
			selfGame.turn_ = PlayerType.O;
			SelfPlayer p3 = new SelfPlayer(PlayerType.O, "Fany", selfGame);
			SelfPlayer p4 = new SelfPlayer(PlayerType.X, "dima", selfGame);
			t1 = new Thread(p3);
			t2 = new Thread(p4);

			t1.start();
			t2.start();
			try {
				t1.join();
				t2.join();

				if (selfGame.getWinner() == ' ') {
					System.out.println("nobody " + " win");
				}
				if (selfGame.getWinner() == 'O') {
					System.out.println(p3.name + " win");
				}
				if (selfGame.getWinner() == 'x') {
					System.out.println(p4.name + " win");
				}

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			break;
		}
		sc.close();
	}

}
		
		