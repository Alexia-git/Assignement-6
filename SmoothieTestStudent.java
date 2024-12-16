import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SmoothieTestStudent {

Smoothie Smoothie1, Smoothie2, Smoothie3;
	
	@BeforeEach
	void setUp() throws Exception {
		Smoothie1 = new Smoothie("Strawberry", Size.SMALL, 1, false);
		Smoothie2 = new Smoothie("Berry ", Size.MEDIUM, 2, false);
		Smoothie3 = new Smoothie("mango ", Size.LARGE, 3, true);
	}

	@AfterEach
	void tearDown() throws Exception {
		Smoothie1 = Smoothie2 = Smoothie3 = null;
	}

	@Test
	void testCalPrice() {
		assertEquals(2.5, Smoothie1.calcPrice(), .01); 
		assertEquals(3.5, Smoothie2.calcPrice(), .01);
		assertEquals(6.0, Smoothie3.calcPrice(), .01);
		
		
		
	}
	
	@Test
	void testGetBasePrice() {
		assertEquals(2.0, Smoothie1.getBasePrice(), .01); 
		assertEquals(2.0, Smoothie2.getBasePrice(), .01);
		assertEquals(2, Smoothie3.getBasePrice(), .01);
		
		
	}
	
	@Test
	public void testEquals() {
		Smoothie Smoothie1 = new Smoothie(" Banana ", Size.MEDIUM, 2, false);
		Smoothie Smoothie2 = new Smoothie("Peach ", Size.MEDIUM, 2, false);
		Smoothie Smoothie3 = new Smoothie("Blueberry ", Size.SMALL, 3, true);

		assertFalse(Smoothie1.equals(Smoothie2));
		
	}
	@Test
	public void testToString() {

		assertTrue(Smoothie1.toString().contains(Smoothie1.getbevName()));
		assertTrue(Smoothie1.toString().contains(String.valueOf(Smoothie1.calcPrice())));
		assertTrue(Smoothie1.toString().contains(Smoothie1.getSize().toString()));
		assertTrue(Smoothie1.toString().contains(String.valueOf(Smoothie1.getNumOfFruits())));

	}
	
	

}
