import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CoffeeTestStudent {
	Coffee coffee1;
	@BeforeEach
	void setUp() throws Exception {
		coffee1 = new Coffee("Expresso", Size.SMALL, true, true);

	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	public void testCoffee() {
		Coffee three = new Coffee("Espresso", Size.SMALL, false, false);
		
	}
	@Test
	public void testCalcPrice() {
		assertFalse(2 == coffee1.calcPrice());
		
	}

	@Test
	public void testEquals() {
		Coffee four = new Coffee("Starbuck Coffee", Size.LARGE, true, true);
		assertFalse(coffee1.equals(four));
	}

	@Test
	public void testGetExtraShot() {
		assertTrue(true == coffee1.getExtraShot());
		
	}

	@Test
	public void testGetExtraSyrup() {
		assertTrue(true == coffee1.getExtraSyrup());
		
	}
	@Test
	void testGetBasePrice() {
		assertEquals(2.0, coffee1.getBasePrice(), .01);
	
	
		
	}


}
