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
		OutputGenerator outputGenerator = new OutputGenerator();
		DataProcessor dataProcessor = new DataProcessor();
		Pacman pacman = null;
		
		// Read the input
		List<String> input = inputReader.inputReader();
		// Pass input and pacman to data processor to get the output
		List<String> output = dataProcessor.dataProcessing(input, pacman);
		// Write the output into file
		outputGenerator.outputWriter(output);
	}

}
