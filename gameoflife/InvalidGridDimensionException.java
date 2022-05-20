package gameoflife;

/**
 * @author Sakshi S
 * Custom Exception class to handle exception for Invalid Grid Dimension
 *
 */
public class InvalidGridDimensionException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public InvalidGridDimensionException(String errorMessage) {
		super(errorMessage);
	}

}
