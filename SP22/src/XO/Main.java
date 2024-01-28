package XO;

import java.util.Scanner;

/* Fany Manevich 206116725
 * Dmitri podoluk 317059244
 * https://github.com/FannyManevich/SP2.git
 */

public class Main {

	public static void main(String[] args) {
		
		int choose;
		UserPlayer p3;
		Thread t1, t2;
		SelfPlayer p1, p2;
		SelfGame selfGame;
		UserGame userGame;
		PlayerType[][] gameBoard  = new PlayerType[5][5];

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please choose a game option:");
		System.out.println("1)Computer VS computer.");
		System.out.println("2)User VS computer.");
		choose = sc.nextInt();
		
		switch (choose) {
		case 1:
			System.out.println("You chose comuter VS computer.");
			p1 = new SelfPlayer("Fany", PlayerType.X);
			p2 = new SelfPlayer("Dima",PlayerType.O);
			
			selfGame = new SelfGame(p1,p2, gameBoard);
			
			t1 = new Thread(p1);
			t2 = new Thread(p2);
			
			selfGame.printBoard();
			
			t1.start();
			t2.start();
			
			break;
		case 2:
			System.out.println("You chose user VS comuter.");
			p1 = new SelfPlayer("Fany", PlayerType.X);
			p3 = new UserPlayer("Dima", PlayerType.O);
			
			userGame =new UserGame(p1,p3, gameBoard);
			
			t1 = new Thread(p1);
			t2 = new Thread(p3);
			
			userGame.printBoard();
			
			t1.start();
			t2.start();
			
			break;
		}
		
		sc.close();
	}

}
