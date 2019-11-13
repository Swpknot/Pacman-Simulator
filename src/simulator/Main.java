/**
 * Pacman Simulator
 *
 * @author Swpknot
 *
 */
package simulator;

import java.io.IOException;
import java.util.List;

public class Main {
	
	/**
	 * The Main procedure of the model
	 * @throws IOException 
	 */

	public static void main(String[] args) throws IOException {
		
		InputReader inputReader = new InputReader();
		List<String> input = inputReader.inputReader();
		
		for(int i = 0; i < input.size() ; i ++) {
			System.out.println(input.get(i));
		}

	}

}
