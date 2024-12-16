import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AlcoholTestStudent {
	Alcohol one; Alcohol two;
	@Before
	public void setUp() throws Exception {
		one = new Alcohol("Vodka", Size.SMALL, true);
		
	}

	@After
	public void tearDown() throws Exception {
		
	}

	
	@Test
	public void testCalcPrice() {
		assertTrue(2 == one.calcPrice());
		
	}
	
	@Test
	public void testEquals() {
		
	}
	
	@Test
	public void testIsWeekend() {
		
		assertTrue(true == two.isWeekend());
	}
	
	
	
	
	

}
