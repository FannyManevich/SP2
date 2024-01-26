package XO;

/* Fany Manevich 206116725
 * Dmitri podoluk 317059244
 * https://github.com/FannyManevich/SP2.git
 */

public class Coordinates{

	private int row;
	private int column;

	public int getRow(){
		return row;
	}

	public void setRow(int row){
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column){
		this.column = column;
	}

	public Coordinates(int column, int row){
		this.row = row;
		this.column = column;
	}
}
