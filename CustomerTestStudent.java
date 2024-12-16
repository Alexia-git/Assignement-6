import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomerTestStudent {
	Customer two;

	@BeforeEach
	void setUp() throws Exception {
		two = new Customer("lily", 15);
	}

	@AfterEach
	void tearDown() throws Exception {
		two=null;
	}

	@Test
	void testGetName() {
		Customer customer = new Customer("John ", 23);
		assertEquals("John ", customer.getName());
		assertTrue(two.getName().equals("lily"));
		
	}
	@Test
	void testSetName() {
		Customer customer = new Customer("John ", 23);
		customer.setName("megan");
		assertEquals("megan", customer.getName());
	}
	@Test
	void testGetAge() {
		Customer customer = new Customer("John ", 23);
		assertEquals(23, customer.getAge());
		assertEquals(15,two.getAge());
	}
	@Test
	void testSetAge() {
		Customer customer = new Customer("John ", 23);
		customer.setAge(25);
		assertEquals(25, customer.getAge());
	}
	
	@Test
	void testToString() {
		Customer Customer = new Customer("John ", 23);
		assertEquals("John  23", Customer.toString());
	}
	
	
	

}
