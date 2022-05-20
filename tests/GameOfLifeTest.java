package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import gameoflife.Coord;
import gameoflife.GameOfLife;
import gameoflife.InvalidGridDimensionException;

/**
 * @author Sakshi S
 * Class containing test cases for testing major modules for Game of Life 
 *
 */
public class GameOfLifeTest {
    GameOfLife gameOfLife;
    int testRowCount = 4;
    int testColumCount = 5;
    Coord[] testCoords = { };
    int result;

    @Before
    public void setUp() throws InvalidGridDimensionException{
        gameOfLife = new GameOfLife(testRowCount,testColumCount, testCoords);
    }

    @Test (expected = InvalidGridDimensionException.class)
    public void initializeGrid_shouldThrowInvalidGridDimensionException() throws InvalidGridDimensionException{
        gameOfLife = new GameOfLife(1,1, testCoords);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void initGridValue_shouldThrowOutOfBoundException(){
        gameOfLife.prefillGridWithDeadCells();
        result = gameOfLife.getGrid()[5][7];
        
    }

    @Test
    public void initAllCellsZeroAfterinitializeGrid_shouldReturnZero(){
       for(int i = 0; i<testRowCount; i++){
           for (int j = 0; j<testColumCount; j++){
               assertEquals(0, gameOfLife.getGrid()[i][j]);
           }
       }
    }

    @Test
    public void setLivingCells_shouldSetMultipleCells() throws InvalidGridDimensionException{
        testCoords = new Coord[] {
                new Coord(2,0),
                new Coord(3,3),
                new Coord(3,4),
        };

        gameOfLife = new GameOfLife(testRowCount,testColumCount, testCoords);

        assertEquals(1, gameOfLife.getGrid()[2][0]);
        assertEquals(1, gameOfLife.getGrid()[3][3]);
        assertEquals(1, gameOfLife.getGrid()[3][4]);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void setLivingCells_setMultipleCells_shouldThrowOutOfBoundException() throws InvalidGridDimensionException{
        testCoords = new Coord[] {
                new Coord(4,5),
                new Coord(3,6),
                new Coord(4,6),
        };

        gameOfLife = new GameOfLife(testRowCount,testColumCount, testCoords);
    }

    @Test
    public void setLivingCells_setSingleCell_shouldReturnOne(){
        assertEquals(0, gameOfLife.getGrid()[2][4]);
        gameOfLife.populateLivingCell(2,4);
        assertEquals(1, gameOfLife.getGrid()[2][4]);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void setLivingCells_setSingle_shouldThrowCellOutOfBoundException(){
        gameOfLife.populateLivingCell(testRowCount + 1, testColumCount+1);
    }

    @Test
    public void countLivingNeighbours_VerticeCell(){
        for(int i = 0; i<testRowCount; i++){
            for (int j = 0; j<testColumCount; j++){
                gameOfLife.populateLivingCell(i,j);
            }
        }

        int result = gameOfLife.getLivingNeighboursCount(0,0);

        assertEquals(3,result);
    }

    @Test
    public void countLivingNeighbours_countNeighboursOfEdgeCell(){
        for(int i = 0; i<testRowCount; i++){
            for (int j = 0; j<testColumCount; j++){
                gameOfLife.populateLivingCell(i,j);
            }
        }

        int result = gameOfLife.getLivingNeighboursCount(0,1);

        assertEquals(5,result);
    }

    @Test
    public void countLivingNeighbours_countNeighboursOfInsideCell(){
        for(int i = 0; i<testRowCount; i++){
            for (int j = 0; j<testColumCount; j++){
                gameOfLife.populateLivingCell(i,j);
            }
        }

        int result = gameOfLife.getLivingNeighboursCount(1,2);

        assertEquals(8,result);
    }

    @Test
    public void countLivingNeighbours_allNeighboursDead(){
        int verticeCell = gameOfLife.getLivingNeighboursCount(0,0);
        assertEquals(0,verticeCell);
        int edgeCell = gameOfLife.getLivingNeighboursCount(0,2);
        assertEquals(0,edgeCell);
        int insideCell = gameOfLife.getLivingNeighboursCount(1,2);
        assertEquals(0,insideCell);
    }

}