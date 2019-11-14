/**
 * This class reads the content of input file
 *
 * @author Swpknot
 *
 */

package simulator;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class InputReader {
	
	// Path to the input file
	private String inputPath = this.getClass().getResource("/").getPath() + "Files/Input.txt";
	
	// Read the input file and return the array list
	public List<String> inputReader() throws IOException {
		
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(inputPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));

        String line = null;
        List<String> input = new ArrayList<String>();

        while ((line = bufferedReader.readLine()) != null) {
        	input.add(line);
        	//System.out.println(line);
        }

        fileInputStream.close();
		
        return input;
	}

}
