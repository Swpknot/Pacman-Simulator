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
	 * @throws IOException 1   
	 */

	public static void main(String[] args) throws IOException {
		
		InputReader inputReader = new InputReader();
		DataProcessor dataProcessor = new DataProcessor();
		Pacman pacman = null;
		
		List<String> input = inputReader.inputReader();
		List<String> output = dataProcessor.dataProcessing(input, pacman);
		
		for(int outputIndex = 0 ; outputIndex < output.size() ; outputIndex ++) {
			System.out.println(output.get(outputIndex));
		}

	}

}
