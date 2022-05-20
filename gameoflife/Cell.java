package gameoflife;

/**
 * @author Sakshi S
 * Class to represent individual cells in the grid
 * This class holds the logic for deciding whether a cell would stay alive or would die
 *
 */
public class Cell {
    private int state;
    private int livingNeighborsCount;
    
    public Cell(int state, int livingNeighborsCount){
        this.state = state;
        this.livingNeighborsCount = livingNeighborsCount;
    }

    /*
     * Any live cell with fewer than two live neighbors dies, as if caused by under-population.
     * Any live cell with two or three live neighbors lives on to the next generation.
     * Any live cell with more than three live neighbors dies, as if by overcrowding.
     * Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction. 
     */
    public int getNextCellState(){
        if(state == CellState.ALIVE.getCellState() && (livingNeighborsCount == 2 || livingNeighborsCount == 3)) {
            return CellState.ALIVE.getCellState();
        }

        if(state == CellState.DEAD.getCellState() && livingNeighborsCount == 3) {
            return CellState.ALIVE.getCellState();
        }

        return CellState.DEAD.getCellState();
    }
}
