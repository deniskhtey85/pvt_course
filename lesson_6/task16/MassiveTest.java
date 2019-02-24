package core;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class MassiveTest {

	Massive massive;

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Befor Method");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("Befor Class");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("After Class");
	}

	@BeforeTest
	public void beforeTest() {
		massive = new Massive();
	}

	@AfterTest
	public void afterTest() {
		massive = null;
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before Suite");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("After Suite");
	}

	@Test(enabled = false)
	public void checklistP15Test() {
		System.out.println("Not yet implemented");
	}

	@Test(timeOut = 10)
	public void createRandomMassiveTest() {
		int size = 10;
		Assert.assertNotNull(massive.createRandomMassive(size), "Massive isn't created");
	}

	@Test(expectedExceptions = NegativeArraySizeException.class)
	public void createRandomMassiveNegativeSizeTest() {
		int size = -1;
		massive.createRandomMassive(size);
	}

	@Test
	public void checkAscSortTrueTest() {
		int[] array = { 1, 2, 3, 4, 5 };
		Assert.assertTrue(massive.checkAscSort(array), "The Massive isn't sorted by ascending");
	}

	@Test
	public void checkAscSortFalseTest() {
		int[] array = { 2, 1, 3, 5, 4 };
		Assert.assertFalse(massive.checkAscSort(array), "The Massive isn't sorted");
	}

	@Test
	public void checkDescSortTrueTest() {
		int[] array = { 5, 4, 3, 2, 1 };
		Assert.assertTrue(massive.checkDescSort(array), "The Massive isn't sorted by descending");
	}

	@Test
	public void checkDescSortFalseTest() {
		int[] array = { 5, 4, 2, 1, 3 };
		Assert.assertFalse(massive.checkDescSort(array), "The Massive isn't sorted");
	}

	@Test
	public void checkOnlyEvenContainsTest() {
		int[] array = { 2, 4, 6, 8, 10 };
		Assert.assertTrue(massive.checkOnlyEvenContains(array), "Massive doesn't contain only even numbers");
	}

	@Test
	public void checkNotOnlyEvenContainsTest() {
		int[] array = { 2, 4, 6, 8, 9 };
		Assert.assertFalse(massive.checkOnlyEvenContains(array), "Massive contains only even numbers");
	}

	@Test
	public void checkOnlyOddContainsTest() {
		int[] array = { 1, 3, 5, 7, 9 };
		Assert.assertTrue(massive.checkOnlyOddContains(array), "Massive doesn't contain only odd numbers");
	}

	@Test
	public void checkNotOnlyOddContainsTest() {
		int[] array = { 1, 3, 5, 7, 10 };
		Assert.assertFalse(massive.checkOnlyOddContains(array), "Massive contains only odd numbers");
	}

	@Test
	public void allElementsPowBy2Test() {
		int powIndex = 2;
		int[] array = { 0, 1, 2, 3, 4 };
		int[] expResult = { 0, 1, 4, 9, 16 };
		int[] actResult = massive.allElementsPowN(array, powIndex);
		Assert.assertEquals(actResult, expResult, "Elements aren't powered by " + powIndex);
	}

	@Test
	public void allElementsPowBy1Test() {
		int powIndex = 1;
		int[] array = { 0, 1, 2, 3, 4 };
		int[] expResult = { 0, 1, 2, 3, 4 };
		int[] actResult = massive.allElementsPowN(array, powIndex);
		Assert.assertEquals(actResult, expResult, "Elements aren't powered by " + powIndex);
	}

	@Test
	public void allElementsPowBy0Test() {
		int powIndex = 0;
		int[] array = { 0, 1, 2, 3, 4 };
		int[] expResult = { 1, 1, 1, 1, 1 };
		int[] actResult = massive.allElementsPowN(array, powIndex);
		Assert.assertEquals(actResult, expResult, "Elements aren't powered by " + powIndex);
	}

	@Test
	public void moveMassiveElementsRightTest() {
		int index = 3;
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int[] expResult = { 8, 9, 10, 1, 2, 3, 4, 5, 6, 7 };
		int[] actResult = massive.moveMassiveElementsRight(array, index);
		Assert.assertEquals(actResult, expResult, "Resulted massive is equaled to the initial massive");
	}

	@Test(expectedExceptions = ArrayIndexOutOfBoundsException.class)
	public void moveMassiveElementsRightOutOfBoundsTest() {
		int index = -2;
		int[] array = { 1, 2, 3, 4, 5 };
		massive.moveMassiveElementsRight(array, index);
	}

	@Test
	public void moveMassiveElementsRightNullTest() {
		int index = 0;
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int[] expResult = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int[] actResult = massive.moveMassiveElementsRight(array, index);
		Assert.assertEquals(actResult, expResult, "Resulted massive is equaled to the initial massive");
	}

	@Test
	public void getReverseMassiveTest() {
		int[] array = { 1, 2, 3, 4, 5 };
		int[] revertArray = massive.getReverseMassive(array);
		Assert.assertNotEquals(revertArray, array, "Resulted massive is equaled to the initial massive");
		Assert.assertEquals(massive.getReverseMassive(revertArray), array,
				"Resulted massive is equaled to the initial massive");
	}

	@Test
	public void getSumOfPositiveElementsTest() {
		int[] array = { 0, 1, 2, 3, 4 };
		int expResult = 10;
		int actResult = massive.getSumOfElements(array);
		Assert.assertTrue(actResult == expResult, "The sum isn't correct");
	}

	@Test
	public void getSumOfNegativeElementsTest() {
		int[] array = { 0, -1, -2, -3, -4 };
		int expResult = -10;
		int actResult = massive.getSumOfElements(array);
		Assert.assertTrue(actResult == expResult, "The sum isn't correct");
	}

	@Test
	public void getSumOfElementsFalseExTest() {
		int[] array = { 0, 1, 2, 3, 4 };
		int expResult = 11;
		int actResult = massive.getSumOfElements(array);
		Assert.assertFalse(actResult == expResult, "The sum isn't correct");
	}

	@Test
	public void getMultOfPositiveElementsTest() {
		int[] array = { 1, 2, 3, 4, 5 };
		int expResult = 120;
		int actResult = massive.getMultOfElements(array);
		Assert.assertEquals(actResult, expResult, "The product isn't correct");
	}

	@Test
	public void getMultOfNegativeElementsTest() {
		int[] array = { -1, -2, -3, 4, 5 };
		int expResult = -120;
		int actResult = massive.getMultOfElements(array);
		Assert.assertEquals(actResult, expResult, "The product isn't correct");
	}

	@Test
	public void getMultOfElementsNullTest() {
		int[] array = { 0, -2, -3, 4, 5 };
		int expResult = 0;
		int actResult = massive.getMultOfElements(array);
		Assert.assertEquals(actResult, expResult, "The product isn't correct");
	}

	@Test
	public void getMultOfElementsFalseExTest() {
		int[] array = { 1, 2, 3 };
		int expResult = 10;
		int actResult = massive.getMultOfElements(array);
		Assert.assertNotEquals(actResult, expResult, "The product isn't correct");
	}

	@Test
	public void multiplyByNTest() {
		int nValue = 2;
		int[] array = { 0, 5, 4, 2, 3 };
		int[] expResult = { 0, 10, 8, 4, 6 };
		int[] actResult = massive.multiplyByN(array, nValue);
		Assert.assertEquals(actResult, expResult, "Elements aren't powered by " + nValue);

	}

	@Test
	public void bubbleSortTest() {
		int[] array = { 1, 5, 4, 2, 3 };
		int[] expResult = { 1, 2, 3, 4, 5 };
		int[] actResult = massive.bubbleSort(array);
		Assert.assertEquals(actResult, expResult, "The massive isn't sorted");
	}

}
