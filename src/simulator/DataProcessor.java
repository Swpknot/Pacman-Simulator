/**
 * This class process the input and generate output
 *
 * @author Swpknot
 *
 */

package simulator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataProcessor {
	
	public List<String> dataProcessing(List<String> input, Pacman pacman){
		
		List<String> output = new ArrayList<String>();
		
		for(int inputIndex = 0 ; inputIndex < input.size() ; inputIndex ++) {
			
			String line = input.get(inputIndex);
			System.out.println(line);
			// Get the input command
			String command = line.split(" ")[0];
			
			if(command.equals("PLACE")) {
				// Get the coordinates and direction from the PLACE command
				int coordX = coordCheck(line.split(" ")[1].split(",")[0]);
				int coordY = coordCheck(line.split(" ")[1].split(",")[1]);
				String direction = line.split(" ")[1].split(",")[2];
				
				if(pacman == null) {
					// If it is the first PLACE command, initialize the pacman
					if(coordX >= 0 && coordX <= Params.GRID_COL - 1 && 
					   coordY >= 0 && coordY <= Params.GRID_ROW  - 1 &&
					   (direction.equals("NORTH") || direction.equals("SOUTH") ||
					    direction.equals("EAST") || direction.equals("WEST"))) {
						
						pacman = new Pacman(coordX,coordY,direction);
						
					}else {
						System.out.println("Invalid coordinate or direction!");
					}
					
				}else {
					// If it is not the first PLACE command, update the pacman
					pacman.Place(coordX, coordY, direction);
				}
				
			}else if(command.equals("MOVE")) {
				// MOVE command
				if(pacman == null) {
					System.out.println("Cannot move the Pacman that has not been placed!");
				}else {
					pacman.Move();
				}
				
			}else if(command.equals("LEFT")) {
				// LEFT command
				if(pacman == null) {
					System.out.println("Cannot turn left the Pacman that has not been placed!");
				}else {
					pacman.TurnLeft();
				}
				
			}else if(command.equals("RIGHT")) {
				// RIGHT command
				if(pacman == null) {
					System.out.println("Cannot turn right the Pacman that has not been placed!");
				}else {
					pacman.TurnRight();
				}
				
			}else if(command.equals("REPORT")) {
				// REPORT command
				if(pacman == null) {
					System.out.println("No Pacman has not been placed!");
				}else {
					output.add(pacman.Report());
				}
				
			}else {
				// Invalid command
				System.out.println("Invalid command!");
			}
		}
		
		return output;
		
	}
	
	// Check if the input coordinate is valid
	@SuppressWarnings("finally")
	public int coordCheck(String coord) {

		int coordInt = -1;
		try{
			// Check if the coordinate is empty
			if(coord.isEmpty()){
				System.out.println("Coordinate cannnot be empty!");
			}
			// Check if the coordinate is a number
			Pattern pattern = Pattern.compile("[0-9]*");
			Matcher isNum = pattern.matcher(coord);
			if( !isNum.matches() ){
				System.out.println("Coordinate must be a number");
			}
			// Transfer the coordinate to integer
			coordInt = Integer.valueOf(coord);
		}catch(NumberFormatException e){
			System.out.println("The number exceed the limitation");
		}finally {
			return coordInt;
		}
	}

}
