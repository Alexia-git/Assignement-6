import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TypeTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testType() 
	{
		assertEquals("SMOOTHIE", Type.SMOOTHIE.name());
		assertEquals("COFFEE", Type.COFFEE.name());
		assertEquals("ALCOHOL", Type.ALCOHOL.name());
	}

}
