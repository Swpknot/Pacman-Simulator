package simulator;

import java.util.ArrayList;
import java.util.List;

public class DataProcessor {
	
	public List<String> dataProcessing(List<String> input, Pacman pacman){
		
		List<String> output = new ArrayList<String>();
		
		for(int inputIndex = 0 ; inputIndex < input.size() ; inputIndex ++) {
			//System.out.println(input.get(index));
			String line = input.get(inputIndex);
			String command = line.split(" ")[0];
			
			if(command.equals("PLACE")) {
				
				int coordX = Integer.parseInt(line.split(" ")[1].split(",")[0]);
				int coordY = Integer.parseInt(line.split(" ")[1].split(",")[1]);
				String direction = line.split(" ")[1].split(",")[2];
				
				if(pacman == null) {
					
					if(coordX >= 0 && coordX <= Params.GRID_COL - 1 && 
					   coordY >= 0 && coordY <= Params.GRID_ROW  - 1 &&
					   (direction.equals("NORTH") || direction.equals("SOUTH") ||
					    direction.equals("EAST") || direction.equals("WEST"))) {
						
						pacman = new Pacman(coordX,coordY,direction);
						
					}else {
						System.out.println("Invalid place coordinate or direction!");
					}
					
				}else {
					pacman.Place(coordX, coordY, direction);
				}
				
			}else if(command.equals("MOVE")) {
				
				if(pacman == null) {
					System.out.println("Cannot move the Pacman that has not been placed!");
				}else {
					pacman.Move();
				}
				
			}else if(command.equals("LEFT")) {
				
				if(pacman == null) {
					System.out.println("Cannot turn left the Pacman that has not been placed!");
				}else {
					pacman.TurnLeft();
				}
				
			}else if(command.equals("RIGHT")) {
				
				if(pacman == null) {
					System.out.println("Cannot turn right the Pacman that has not been placed!");
				}else {
					pacman.TurnRight();
				}
				
			}else if(command.equals("REPORT")) {
				
				if(pacman == null) {
					System.out.println("No Pacman has not been placed!");
				}else {
					output.add(pacman.Report());
				}
				
			}else {
				System.out.println("invalid command");
			}
		}
		
		return output;
		
	}

}
