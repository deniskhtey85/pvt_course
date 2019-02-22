package core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(value = Parameterized.class)
public class ParametrizedTestMassive {

	private ArrayList<Integer> values;

	@Parameterized.Parameters
	public static Collection<Object[]> set_of_parameters() {
		return Arrays.asList(new Object[][] { { new ArrayList<Integer>(Arrays.asList(1, 2, 3, 6)) },
				{ new ArrayList<Integer>(Arrays.asList(1, 0, 0, 1)) },
				{ new ArrayList<Integer>(Arrays.asList(5, 5, 5, 15)) },
				{ new ArrayList<Integer>(Arrays.asList(1, 2, -2, -1, 0)) }, });
	}

	public ParametrizedTestMassive(ArrayList<Integer> values) {
		this.values = values;
	}
	
	@BeforeClass
	public static void beforeClass() {
		System.out.println("Test execution 2 for Massive.");
	}
	
	@AfterClass
	public static void afterClass() {
		System.out.println("Complete");
	}
	

	@Test
	public void sumOfElementsParametrizedTest() {
		Massive mass = new Massive();
		int[] array = new int[values.size() - 1];
		for (int i = 0; i < values.size() - 1; i++) {
			array[i] = values.get(i);
		}
		int expResult = values.get(values.size() - 1);
		int actResult = mass.getSumOfElements(array);
		assertEquals("Sum isn't correct. ", expResult, actResult, 0.0);
	}

}
