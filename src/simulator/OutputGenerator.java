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
	
	// Path to the input file
	private String outputPath = "./Output.txt";
	
	public void outputWriter(List<String> output) throws IOException {
		
		File file = new File(outputPath);
		
		if(!file.exists()){
			file.createNewFile();
		}
		
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        
        for(int outputIndex = 0 ; outputIndex < output.size() ; outputIndex ++) {
        	fileOutputStream.write((output.get(outputIndex) + "\n").getBytes());
		}

        fileOutputStream.close();
	}

}
