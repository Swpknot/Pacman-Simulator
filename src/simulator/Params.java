/**
 * Parameters of the system
 *
 * @author swpknot
 *
 */
package simulator;

public class Params {

	// The number of rows
    static final int GRID_ROW = 5;

    // The number of columns
    static final int GRID_COL = 5;
    
    // The direction of the pacman
	enum Direction {
	    NORTH,
	    SOUTH,
	    EAST,
	    WEST
	}
	
	// The legal commands
	enum Command {
		PLACE,
	    LEFT,
	    RIGHT,
	    MOVE,
	    REPORT
	}
}
