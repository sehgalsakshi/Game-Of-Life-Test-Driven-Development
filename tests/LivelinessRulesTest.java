package tests;

import org.junit.Test;

import gameoflife.Cell;
import gameoflife.CellState;

import static org.junit.Assert.*;


/**
 * @author Sakshi S
 * Class containing test cases for Cells of Grid to test individual rules
 *
 */
public class LivelinessRulesTest {
    @Test
    public void IsAliveWithNoLivingNeighbours_shouldReturnDead(){
        Cell cell = new Cell(1,0);
        assertEquals(CellState.DEAD, cell.getNextCellState());
    }

    @Test
    public void IsAliveWithOneLivingNeighbours_shouldReturnDead(){
        Cell cell = new Cell(1,1);
        assertEquals(CellState.DEAD, cell.getNextCellState());
    }

    @Test
    public void IsAliveWithTwoLivingNeighbours_shouldReturnAlive(){
        Cell cell = new Cell(1,2);
        assertEquals(CellState.ALIVE, cell.getNextCellState());
    }

    @Test
    public void IsAliveWithThreeLivingNeighbours_shouldReturnAlive(){
        Cell cell = new Cell(1,3);
        assertEquals(CellState.ALIVE, cell.getNextCellState());
    }

    @Test
    public void IsAliveWithFourLivingNeighbours_shouldReturnDead(){
        Cell cell = new Cell(1,4);
        assertEquals(CellState.DEAD, cell.getNextCellState());
    }

    @Test
    public void IsDeadCellAliveWithThreeLivingNeighbours_shouldReturnAlive(){
        Cell cell = new Cell(0,3);
        assertEquals(CellState.ALIVE, cell.getNextCellState());
    }

    @Test
    public void DeadCellDeadWithTwoLivingNeighbours_shouldReturnDead(){
        Cell cell = new Cell(0,2);
        assertEquals(CellState.DEAD, cell.getNextCellState());
    }

    @Test
    public void DeadCellDeadWithFourLivingNeighbours_shouldReturnDead(){
        Cell cell = new Cell(0,4);
        assertEquals(CellState.DEAD, cell.getNextCellState());
    }
}