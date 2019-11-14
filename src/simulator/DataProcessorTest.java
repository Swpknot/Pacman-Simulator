package simulator;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class DataProcessorTest {
	private static Pacman pacman = null;
	private static List<String> input = new ArrayList<String>();
	private static DataProcessor dataProcessor = new DataProcessor();

	@Before
	public void setUp() throws Exception {
		pacman = new Pacman(0,0,"NORTH");
		input.add("PLACE 1,1,EAST");
		input.add("REPORT");
		input.add("MOVE");
		input.add("REPORT");
		input.add("LEFT");
		input.add("REPORT");
		input.add("MOVE");
		input.add("RIGHT");
		input.add("REPORT");
		input.add("MOVE");
		input.add("REPORT");
	}

	@Test
	public void testDataProcessing() {
		List<String> output = dataProcessor.dataProcessing(input, pacman);
		assertEquals("1,1,EAST", output.get(0));
		assertEquals("2,1,EAST", output.get(1));
		assertEquals("2,1,NORTH", output.get(2));
		assertEquals("2,2,EAST", output.get(3));
		assertEquals("3,2,EAST", output.get(4));
	}

	@Test
	public void testCoordCheck() {
		int coord1 = dataProcessor.coordCheck("0");
		int coord2 = dataProcessor.coordCheck(" ");
		int coord3 = dataProcessor.coordCheck("abc");
		int coord4 = dataProcessor.coordCheck("2147483648");
		assertEquals(0, coord1);
		assertEquals(-1, coord2);
		assertEquals(-1, coord3);
		assertEquals(-1, coord4);
	}

}
