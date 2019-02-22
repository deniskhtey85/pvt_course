package core;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class MassiveTest {

	Massive mass;

	@BeforeClass
	public static void beforeClass() {
		System.out.println("Test execution 1 for Massive.");
	}

	@Before
	public void before() {
		mass = new Massive();
	}

	@After
	public void after() {
		mass = null;
	}

	@AfterClass
	public static void afterClass() {
		System.out.println("Complete");
	}

	@Test(expected = ArithmeticException.class)
	public void exceptionDevideBy0Test() {
		int[] array = { 1, 2, 3 };
		mass.devideByN(array, 0);
	}

	@Test
	public void devideByNTest() {
		int[] initialArray = { 2, 4, 22, 0, 7 };
		int[] expResult = { 1, 2, 11, 0, 3 };
		assertArrayEquals(expResult, mass.devideByN(initialArray, 2));
	}

	@Test
	public void getMultiplyOfElementsTest() {
		int[] initialArray = { 1, 2, 3, 4, 5 };
		int expResult = 120;
		assertEquals(expResult, mass.getMultiplyOfElements(initialArray));
	}

	@Test(timeout = 100)
	public void reverseMassiveTest() {
		int[] initialArray = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int[] expResult = { 8, 7, 6, 5, 4, 3, 2, 1 };
		int[] actResult = mass.getReverseMassive(initialArray);
		assertArrayEquals("Array isn't reversed successfuly", expResult, actResult);
	}

	@Test
	public void checkListP14Test() {
		fail("Not yet implemented");
	}

	@Test
	public void sumOfElementsTest() {
		int[] initialArray = { 1, 2, 3, 4, 5 };
		int expResult = 15;
		assertTrue(expResult == mass.getSumOfElements(initialArray));
	}

	@Ignore("Not ready yet")
	@Test
	public void checkListP15Test() {
		fail("Not yet implemented");
	}

	@Test
	public void notNullTest() {
		int[] array = new int[] { 1, 2, 3, 4, 5 };
		assertNotNull(array);
	}

	@Test
	public void nullTest() {
		int[] array = null;
		assertNull(array);
	}

}
