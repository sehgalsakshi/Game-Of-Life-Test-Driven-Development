package gameoflife;


/**
 * @author Sakshi S
 * Class to hold the x and y coordinates of a particular cell
 *
 */
public class Coord {
    private int x;
    private int y;

    public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Coord(int x, int y){
        this.x = x;
        this.y = y;
    }
}
