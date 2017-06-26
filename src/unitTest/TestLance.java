package unitTest;

import static org.junit.Assert.*;

import org.junit.*;

import business.Lance;

public class TestLance {
	private Lance lance;
	

	@Before
	public void setUp() {
		lance = new Lance("999.999.999-99", "12/12/2222", "23:59", 999999999.999f);
	}

	@Test
	public void testHashCodeTrue() {
		assertEquals(1191176192, lance.hashCode());
	}
	
	@Test 
	public void testHashCodeFalse() {
		lance.setHora("23:58");
		assertFalse(1002552778 == lance.hashCode());
	}

	
	@Test
	public void testEqualsObjectTrue() {
		Lance lance2 = new Lance("999.999.999-99","12/12/2222", "23:59", 999999999.999f);		
		assertTrue(lance.equals(lance2));
	}
	
	@Test
		public void testEqualsObjectFalse() {
			Lance lance2 = new Lance("999.999.999-99", "12/12/2222", "23:58", 999999999.999f);		
			assertFalse(lance.equals(lance2));
		}

}
