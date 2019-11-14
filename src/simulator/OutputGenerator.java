/**
 * This class generates output to a txt file
 *
 * @author Swpknot
 *
 */

package simulator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class OutputGenerator {
	
	// Path to the output file
	private String outputPath = "./Output.txt";
	
	// Write the output into the txt file
	public void outputWriter(List<String> output) throws IOException {
		
		File file = new File(outputPath);
		
		// Check if the file already exists
		if(!file.exists()){
			file.createNewFile();
		}
		
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        
        // Write the output into the file line by line
        for(int outputIndex = 0 ; outputIndex < output.size() ; outputIndex ++) {
        	fileOutputStream.write(("Output: " + output.get(outputIndex) + "\n").getBytes());
        	System.out.println("Output: " + output.get(outputIndex));
		}

        fileOutputStream.close();
	}

}
