package com.projectstarter;
import gameoflife.Coord;
import gameoflife.GameOfLife;

/**
 * @author Sakshi S
 *
 */
public class Main {

	/**
	 * Method to provide initial seed
	 *
	 */
    public static Coord[] initializeAliveCellCoords(){
        Coord[] coords = new Coord[] {
                new Coord(3,2),
                new Coord(3,3),
                new Coord(3,4),
        };

        return coords;
    }

    public static void main(String[] args) {
        try{
            Coord[] initialCells = initializeAliveCellCoords();
            GameOfLife gol = new GameOfLife(5, 5, initialCells);
            gol.createNthGeneration(10);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
