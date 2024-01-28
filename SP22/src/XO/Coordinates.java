package XO;

/* Fany Manevich 206116725
 * Dmitri podoluk 317059244
 * https://github.com/FannyManevich/SP2.git
 */

public class Coordinates{

	final private int row;
	final private int column;
	public Coordinates(int row, int col) {

		this.row = row;
		this.column = col;
	}
	public int getRow(){
		return row;
	}

	public int getColumn() {
		return column;
	}
	 public String toString() {
	        return "(" + row + ", " + column + ")";
	    }


}
