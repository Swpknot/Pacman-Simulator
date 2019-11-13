/**
 * Pacman
 * This class describes a pacman which includes
 * its x-coordinate, y-coordinate and direction
 *
 * @author Swpknot
 *
 */

package simulator;

public class Pacman {
	
	// x-coordinate of the pacman
    private int coordX;

    // y-coordinate of the pacman
    private int coordY;
    
	// Direction of the pacman
	private Params.Direction direction;

	// Constructor of the daisy
    public Pacman(int coordX, int coordY, String direction) {
    	
    	if(coordX >= 0 && coordX <= Params.GRID_COL - 1 && 
    	   coordY >= 0 && coordY <= Params.GRID_ROW  - 1 &&
    	   (direction.equals("NORTH") || direction.equals("SOUTH") ||
    	    direction.equals("EAST") || direction.equals("WEST"))) {
    		
    		Params.Direction directionEnum = Params.Direction.valueOf(direction);
    	    this.coordX = coordX;
    	    this.coordY = coordY;
    	    this.direction = directionEnum;
    	}
    	else {
    		System.out.println("Invalid Place!");
    	}
    }
    
    // Place the pacman if is not the first time
    public void Place(int coordX, int coordY, String direction) {
    	
    	if(coordX >= 0 && coordX <= Params.GRID_COL - 1 && 
    	   coordY >= 0 && coordY <= Params.GRID_ROW  - 1 &&
    	   (direction.equals("NORTH") || direction.equals("SOUTH") ||
    	    direction.equals("EAST") || direction.equals("WEST"))) {
    		
    		Params.Direction directionEnum = Params.Direction.valueOf(direction);
            this.coordX = coordX;
            this.coordY = coordY;
            this.direction = directionEnum;
    		
    	}
    	else {
    		System.out.println("Invalid Place!");
    	}
    }
    
    // Pacman moves towards the direction
    public void Move() {
    	
    	if(this.direction == Params.Direction.NORTH && this.coordY < Params.GRID_ROW  - 1) {
    		this.coordY += 1;
    	}
    	else if(this.direction == Params.Direction.SOUTH && this.coordY > 0) {
    		this.coordY -= 1;
    	}
    	else if(this.direction == Params.Direction.EAST && this.coordX < Params.GRID_COL  - 1) {
    		this.coordX += 1;
    	}
    	else if(this.direction == Params.Direction.WEST && this.coordX > 0) {
    		this.coordX -= 1;
    	}
    	else {
    		System.out.println("Invalid Movement!");
    	}
    	
    }
    
    // Pacman turns to left
    public void TurnLeft() {
    	
    	if(this.direction == Params.Direction.NORTH) {
    		this.direction = Params.Direction.WEST;
    	}
    	else if(this.direction == Params.Direction.SOUTH) {
    		this.direction = Params.Direction.EAST;
    	}
    	else if(this.direction == Params.Direction.EAST) {
    		this.direction = Params.Direction.NORTH;
    	}
    	else if(this.direction == Params.Direction.WEST) {
    		this.direction = Params.Direction.SOUTH;
    	}
    	else {
    		System.out.println("Invalid Direction and Cannot Turn Left!");
    	}
    	
    }
    
    // Pacman turns to right
    public void TurnRight() {
    	
    	if(this.direction == Params.Direction.NORTH) {
    		this.direction = Params.Direction.EAST;
    	}
    	else if(this.direction == Params.Direction.SOUTH) {
    		this.direction = Params.Direction.WEST;
    	}
    	else if(this.direction == Params.Direction.EAST) {
    		this.direction = Params.Direction.SOUTH;
    	}
    	else if(this.direction == Params.Direction.WEST) {
    		this.direction = Params.Direction.NORTH;
    	}
    	else {
    		System.out.println("Invalid Direction and Cannot Turn Right!");
    	}
    	
    }
    
    // Report command and return the output
    public String Report() {
    	
    	String output = String.valueOf(this.coordX) + "," + 
    					String.valueOf(this.coordX) + "," + 
    					this.direction.toString();
    	return output;
    	
    }

}
