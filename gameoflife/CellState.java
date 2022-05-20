package gameoflife;

/**
 * @author Sakshi S
 * This class serves as an enum for holding the Cell State
 * DEAD : 0, or ALIVE : 1
 * 
 */
public enum CellState {
    DEAD(0), ALIVE(1);
	private int cellState;
	CellState(int cellState) {
		this.cellState = cellState;
	}
	public int getCellState() {
		return this.cellState;
	}
}
