import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BevShopTest {
	private BevShop bevShop;

	@BeforeEach
	public void setUp() {
		bevShop = new BevShop();
	}

	
	@Test
	public void testValidTime() {
		assertTrue(bevShop.isValidTime(9));
		assertTrue(bevShop.isValidTime(20));
		assertFalse(bevShop.isValidTime(2));
		
	}

	@Test
	public void testValidAge() {
		assertFalse(bevShop.isValidAge(19));
		assertTrue(bevShop.isValidAge(27));
	}

	
	@Test
	public void testStartNewOrder() {
		bevShop.startNewOrder(17, Day.MONDAY, "megan", 30); 
		assertEquals(17, bevShop.getCurrentOrder().getOrderTime());
		assertEquals(Day.MONDAY, bevShop.getCurrentOrder().getOrderDay());
		assertEquals(17, bevShop.getCurrentOrder().getOrderTime());
		assertEquals("megan", bevShop.getCurrentOrder().getCustomer().getName());
		assertEquals(30, bevShop.getCurrentOrder().getCustomer().getAge());
		assertEquals(0, bevShop.getNumOfAlcoholDrink());
		assertTrue(bevShop.getCurrentOrder().getTotalItems() == 0);

	}

	
	@Test
	public void testFindOrder() {

		
		bevShop.startNewOrder(15, Day.MONDAY, "megan", 15); 
		bevShop.processCoffeeOrder("Cappuccino", Size.SMALL, true, false); // process each
		bevShop.processCoffeeOrder("Latte", Size.LARGE, false, false);
		bevShop.processSmoothieOrder("Strawberry Banana", Size.LARGE, 4, true);

		int orderNumber = bevShop.getCurrentOrder().getOrderNo(); // set
	}


	

	
	@Test
	public void testProcessCoffeeOrder() {
		Coffee Coffee;
		bevShop.startNewOrder(11, Day.MONDAY, "megan", 35); // start new order
		bevShop.processCoffeeOrder("Latte", Size.SMALL, true, false);
		assertTrue(bevShop.getCurrentOrder().getTotalItems() == 1);

		Coffee = (Coffee) bevShop.getCurrentOrder().getBeverage(0);
		assertTrue(bevShop.getCurrentOrder().getBeverage(0).getbevName().equals("Latte")); // check each one
		assertTrue(bevShop.getCurrentOrder().getBeverage(0).getSize().equals(Size.SMALL));
		assertTrue(bevShop.getCurrentOrder().getBeverage(0).getType().equals(Type.COFFEE));
	}

	
	@Test
	public void testProcessAlcoholOrder() {
		bevShop.startNewOrder(9, Day.WEDNESDAY, "John", 25); // start new order

		bevShop.processAlcoholOrder("Beer", Size.LARGE);
		assertTrue(bevShop.getCurrentOrder().getTotalItems() == 1);
		assertTrue(bevShop.getCurrentOrder().getBeverage(0).getbevName().equals("Beer")); // check if each asserts true
		assertTrue(bevShop.getCurrentOrder().getBeverage(0).getSize().equals(Size.LARGE));
		assertTrue(bevShop.getCurrentOrder().getBeverage(0).getType().equals(Type.ALCOHOL));
		assertTrue(bevShop.isEligibleForMore());
		bevShop.processAlcoholOrder("Wine", Size.MEDIUM); // create medium drink
		assertTrue(bevShop.getCurrentOrder().getTotalItems() == 2);
		assertTrue(bevShop.getCurrentOrder().getBeverage(1).getbevName().equals("Wine"));
		assertTrue(bevShop.getCurrentOrder().getBeverage(1).getSize().equals(Size.MEDIUM));
		assertTrue(bevShop.getCurrentOrder().getBeverage(1).getType().equals(Type.ALCOHOL));
		assertTrue(bevShop.isEligibleForMore());
	}

	

}
