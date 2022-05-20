package gameoflife;
import java.util.Arrays;

/**
 * @author Sakshi S
 * GameOfLife driver class
 *
 */
public class GameOfLife {

    private int rowCount;
    private int columnCount;

    private int[][] grid;
    
    

    public int[][] getGrid() {
		return grid;
	}

	public void setGrid(int[][] grid) {
		this.grid = grid;
	}

	/**
	 * Sets the grid and the seed state of grid
	 * @param rowCount
	 * @param columnCount
	 * @param coords
	 * @throws InvalidGridDimensionException
	 */
	public GameOfLife(int rowCount, int columnCount, Coord[] coords) throws InvalidGridDimensionException {
        if(rowCount<=1 || columnCount<=1){
        	throw new InvalidGridDimensionException("The row count and column count of the grid mist be greater than 1");
        }
        this.rowCount = rowCount;
        this.columnCount = columnCount;
        prefillGridWithDeadCells();
        populateLivingCells(coords);
        printGrid();
    }
	
	/**
     * Populate the grid with dead cells
     */
    public void prefillGridWithDeadCells(){
        grid = new int [rowCount][columnCount];
        for (int y = 0; y < this.rowCount; y++) {
            Arrays.fill(grid[y], CellState.DEAD.getCellState());
        }
    }

    /**
     * Given a list of coordinates, sets the initial living cells
     * @param coords : List of coordinates indicating the position of the initial living cells
     */
    public void populateLivingCells(Coord[] coords){
    	System.out.println("Initialized grid with living cells");
        for(Coord coord : coords) {
            populateLivingCell(coord.getX(), coord.getY());
        }
    }
    
    /**
     *  Given a row and a column number, sets the corresponding cell to a living state
     * @param row
     * @param column
     */
    public void populateLivingCell(int row, int column) {
        grid[row][column] = CellState.ALIVE.getCellState();
    }
    
	/**
	 * print method for the grid
	 */
    public void printGrid(){
        for(int i = 0; i < rowCount; i++){
            for(int j = 0; j < columnCount; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }

    /**
     * This method is responsible generating nth next generation 
     * and updating the cell states after that generation.
     * @param n Generation Number that needs to be generated
     */
    public void createNthGeneration(int n){
        for(int i = 0; i < n; i++) {
            System.out.println("**** Creating generation: " + i+1);
            generateNextGeneration();
            printGrid();
        }
    }
    
    /**
     * Generates the next generation for the grid
     */
    public void generateNextGeneration() {
        int[][] nextGenerationGrid = new int[rowCount][columnCount];
        for (int row = 0; row < rowCount; row++) {
            for (int col = 0; col < columnCount; col++) {
                int livingNeighboursCount = getLivingNeighboursCount(row, col);
                int cellCurrentState = grid[row][col];
                // to generate cell's next generation
                Cell cell = new Cell(cellCurrentState, livingNeighboursCount);
                nextGenerationGrid[row][col] = cell.getNextCellState();
            }
        }
        // cloning to avoid expensive operations of creating new grid
        grid = nextGenerationGrid.clone();
    }

    /**
     * For a given cell, returns the number or adjacent living neighbors
     * @param row
     * @param column
     * @return livingNeighboursCount
     */
    public int getLivingNeighboursCount(int row, int column) {
        int[][] neighbourCells = {
                {row - 1, column - 1},
                {row - 1, column},
                {row - 1, column + 1},
                {row, column + 1},
                {row + 1, column + 1},
                {row + 1, column},
                {row + 1, column - 1},
                {row, column - 1},
        };
        int livingNeighboursCount = 0;
        for (int i = 0; i < neighbourCells.length; i++) {
            int neighbourRow = neighbourCells[i][0];
            int neighbourCol = neighbourCells[i][1];
            if (isValidGridCell(neighbourRow, neighbourCol)) {
                livingNeighboursCount+= grid[neighbourRow][neighbourCol];
            }
        }
        return livingNeighboursCount;
    }

    /**
     * Indicates weather given row and column coordinates lie in the grid boundaries
     * @param row
     * @param col
     * @return
     */
    private boolean isValidGridCell(int row, int col) {
        return row >= 0 && col >= 0 && row < rowCount && col < columnCount;
    }
}
