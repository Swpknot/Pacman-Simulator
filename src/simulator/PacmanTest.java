package simulator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PacmanTest {
	private static Pacman pacman = null;

	@Before
	public void setUp() throws Exception {
		pacman = new Pacman(0,0,"NORTH");
	}

	@Test
	public void testPlace() {
		pacman.Place(1, 1, "SOUTH");
		assertEquals(1, pacman.getCoordX());
		assertEquals(1, pacman.getCoordY());
		assertEquals("SOUTH", pacman.getDirection().toString());
	}

	@Test
	public void testMove() {
		pacman.Move();
		assertEquals(0, pacman.getCoordX());
		assertEquals(1, pacman.getCoordY());
		assertEquals("NORTH", pacman.getDirection().toString());
	}

	@Test
	public void testTurnLeft() {
		pacman.TurnLeft();
		assertEquals(0, pacman.getCoordX());
		assertEquals(0, pacman.getCoordY());
		assertEquals("WEST", pacman.getDirection().toString());
	}

	@Test
	public void testTurnRight() {
		pacman.TurnRight();
		assertEquals(0, pacman.getCoordX());
		assertEquals(0, pacman.getCoordY());
		assertEquals("EAST", pacman.getDirection().toString());
	}

	@Test
	public void testReport() {
		String output = pacman.Report();
		assertEquals("0,0,NORTH", output);
	}

}
