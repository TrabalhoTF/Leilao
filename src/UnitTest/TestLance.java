package UnitTest;

import static org.junit.Assert.*;

import org.junit.*;

import Business.Lance;

public class TestLance {
	private Lance lance;
	

	@Before
	public void setUp() {
		lance = new Lance(12345, 54321, "12/12/2222", "23:59", 999999999.999f);
	}

	//@Test
	public void testHashCodeTrue() {
		assertEquals(1002552778, lance.hashCode());
	}
	
	@Test
	public void testHashCodeFalse() {
		lance.setData("23:58");
		//System.out.println(lance.getHora());
		System.out.println(lance.getData());
		assertEquals(1002552778, lance.hashCode());
	}

	
	//@Test
	public void testEqualsObject() {
		fail("Not yet implemented");
	}

}
