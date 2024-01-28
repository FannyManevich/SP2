package XO;
import java.util.ArrayList;
import java.util.Scanner;
/* Fany Manevich 206116725
 * Dmitri podoluk 317059244
 * https://github.com/FannyManevich/SP2.git
 */

public class UserGame extends Game {
	char Signwinner = ' ';
	Scanner sc = new Scanner(System.in);
	char sign;
	boolean winner = false;

	void init() {
		for (int i = 0; i < gameBoard.length; i++) {
			for (int j = 0; j < gameBoard.length; j++) {
				gameBoard[i][j] = '0';
			}
		}
	}

	public ArrayList<Coordinates> getFreeCells() {
		ArrayList<Coordinates> result = new ArrayList<Coordinates>();
		for (int i = 0; i < gameBoard.length; i++) {
			for (int j = 0; j < gameBoard.length; j++) {
				if (gameBoard[i][j] == '0')
					result.add(new Coordinates(i, j));
			}
		}
		return result;
	}

	public void printBoard() {

		for (int i = 0; i < this.gameBoard.length; i++) {
			for (int j = 0; j < this.gameBoard.length; j++) {
				System.out.print(this.gameBoard[i][j]);
			}
			System.out.println();
		}
		System.out.println("-----------");

	}

	public void fillBoard(int x, int y, PlayerType turn_) throws InterruptedException {

		boolean flag1 = true;

		if (turn_ == PlayerType.X) {
			sign = 'x';
		}
		if (turn_ == PlayerType.O) {
			sign = 'O';
		}

		this.gameBoard[x][y] = sign;
		printBoard();

		if (flag1) {
			int diagonalBack = this.checkDiagonalBack(x, y, sign);
			if (diagonalBack == 4) {
				flag1 = false;
				winner = true;
				Signwinner = sign;
			}
		}
		if (flag1) {
			int diagonalFront = this.checkDiagonalFront(x, y, sign);
			if (diagonalFront == 4) {
				flag1 = false;
				winner = true;
				Signwinner = sign;

			}
		}
		if (flag1) {
			int row = this.checkRow(x, y, sign);
			if (row == 4) {
				flag1 = false;
				winner = true;
				Signwinner = sign;
			}
		}
		if (flag1) {
			int column = this.checkColomn(x, y, sign);
			if (column == 4) {
				winner = true;
				flag1 = false;
				Signwinner = sign;
			}
		}

		if (flag1) {
			int column = this.checkDiagonal(x, y, sign);
			if (column == 4) {
				flag1 = false;
				winner = true;
				Signwinner = sign;

			}
		}

	}

	public boolean HaveWinner() {
		return winner;
	}

	public char getWinner() {
		return Signwinner;
	}

	public PlayerType getTurn() {
		return this.turn_;
	}

	public int checkDiagonal(int x, int y, char sign) {
		int counter = 0;
		int sum = x + y;
		for (int i = 0; i < gameBoard.length; i++) {
			for (int j = 0; j < gameBoard.length; j++) {

				if (counter == 4) {
					return counter;
				}

				if (sum == i + j) {
					if (gameBoard[i][j] == sign) {
						counter++;

					} else {

						counter = 0;
					}
				}
			}
		}
		return counter;

	}

	public int checkDiagonalBack(int x, int y, char sign) {
		int counter = 0;
	
		while ((x < gameBoard.length && y < gameBoard.length)) {
			if (counter == 4) {
				return counter;

			}
			if (gameBoard[x][y] == sign) {
				counter++;
				x += 1;
				y += 1;
			} else {
				x += 1;
				y += 1;
				counter = 0;
			}
		}
		return counter;

	}

	public int checkDiagonalFront(int x, int y, char sign) {
		int counter = 0;
		while (x >= 0 && y >= 0) {
			if (counter == 4) {
				return counter;

			}
			if (gameBoard[x][y] == sign) {
				counter++;
				x -= 1;
				y -= 1;
			} else {
				x -= 1;
				y -= 1;
				counter = 0;
			}
		}

		return counter;
	}

	public int checkRow(int x, int y, char sign) {
		int counter = 0;

		for (int i = x; i < x + 1; i++) {
			for (int j = 0; j < gameBoard.length; j++) {
				if (counter == 4) {
					return counter;

				}
				if (gameBoard[i][j] == sign) {
					counter++;
				} else {
					counter = 0;
				}

			}
		}
		return counter;
	}

	public int checkColomn(int x, int y, char sign) {
		int counter = 0;
		for (int i = y; i < y + 1; i++) {
			for (int j = 0; j < gameBoard.length; j++) {

				if (counter == 4) {
					return counter;

				}

				if (gameBoard[j][i] == sign) {
					counter++;

				} else {
					counter = 0;
				}
			}
		}
		return counter;
	}

}