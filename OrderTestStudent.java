import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderTestStudent {
	private Order o1, o2;
	
	@BeforeEach
	void setUp() throws Exception {
		o1 = new Order(8, Day.MONDAY, new Customer("MIKASA", 25));
		o2 = new Order(13, Day.SUNDAY, new Customer("EREN", 35));
	}

	@AfterEach
	void tearDown() throws Exception {
		o1 = o2= null;
	}

	@Test
	void testAddNewBeverage() throws NullPointerException {
		// Order A1
		assertTrue(o1.getTotalItems() == 0);
		o1.addNewBeverage("Coffee", Size.SMALL, false, false); 
		assertTrue(o1.getBeverage(0).getType().equals(Type.COFFEE));
		o1.addNewBeverage(" Coffee2", Size.SMALL);
		assertTrue(o1.getBeverage(1).getType().equals(Type.ALCOHOL));
		o1.addNewBeverage("Vodka", Size.MEDIUM, 1, false);
		assertTrue(o1.getBeverage(2).getType().equals(Type.SMOOTHIE));
		assertTrue(o1.getTotalItems() == 3);

		// Order A2
		assertTrue(o2.getTotalItems() == 0);
		o2.addNewBeverage("coffe1", Size.MEDIUM, 4, true); 
		assertTrue(o2.getBeverage(0).getType().equals(Type.SMOOTHIE));
		o2.addNewBeverage("Coffee2", Size.SMALL);
		assertTrue(o2.getBeverage(1).getType().equals(Type.ALCOHOL));
		o2.addNewBeverage(" Coffee3", Size.MEDIUM, true, false);
		assertTrue(o2.getBeverage(2).getType().equals(Type.COFFEE));
		assertTrue(o2.getTotalItems() == 3);
	}
		
	@Test
	 void testisWeekend() {

		assertFalse(o1.isWeekend()); 
		assertTrue(o2.isWeekend());
		

	}
	

	@Test
	 void testFindNumOfBeveType() {

		o1.addNewBeverage(" Coffee", Size.SMALL, false, false); 
		o1.addNewBeverage("Frappe", Size.SMALL);
		o1.addNewBeverage("smoothie", Size.MEDIUM, 1, false);
		o1.addNewBeverage("Caremel", Size.LARGE, true, true);
		assertEquals(2, o1.findNumOfBeveType(Type.COFFEE)); 
		assertEquals(1, o1.findNumOfBeveType(Type.SMOOTHIE));
		assertEquals(1, o1.findNumOfBeveType(Type.ALCOHOL));
	
	

	
	}
	
	@Test
	public void testGetBeverage() {
		Coffee Coffee = new Coffee(" Coffee", Size.SMALL, false, false);
		Alcohol alcohol = new Alcohol("Alcohol", Size.SMALL, false);
		Smoothie smoothie = new Smoothie("Smoothie", Size.LARGE, 1, false);

		o1.addNewBeverage(" Coffee", Size.SMALL, false, false); 
		o1.addNewBeverage("Alcohol", Size.SMALL);
		o1.addNewBeverage("smoothie", Size.MEDIUM, 1, false);
		assertTrue(o1.getBeverage(0).equals(Coffee)); 
		assertTrue(o1.getBeverage(1).equals(alcohol));
		assertFalse(o1.getBeverage(2).equals(smoothie));

	}
	
	@Test
		void testToString() {

		o1.addNewBeverage(" Coffee", Size.SMALL, false, false); 
		o1.addNewBeverage("Coffee", Size.LARGE);

		assertTrue(o1.toString().contains(String.valueOf(o1.getOrderNo()))); 
		assertTrue(o1.toString().contains(o1.getCustomer().getName()));
		assertTrue(o1.toString().contains(o1.getBeverage(0).getSize().toString()));
		assertTrue(o1.toString().contains(o1.getBeverage(0).getbevName()));

	
	
	
	
	
	
	
	
	
	
	
	}
	


	
}
