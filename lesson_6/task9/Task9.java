package task9;

public class Task9 {

	public static void main(String[] args) {

		Planet planet = new Planet(5000, 2566.015);
		planet.starSystemName = "Alpha Centauri";
		planet.setDistance(2000);
		planet.printStarSystemName(); // method from super class + override
		planet.printRadius();
		
		Earth earth = new Earth();
		earth.diametr = 6378.1; // method from parent class
		earth.weight = 5.9726; // method from parent class
		earth.setStarSystemName("Solar"); // method from super class
		earth.population = 760000000;
		earth.periodOfRotation = 0.99726968;
		earth.printStarSystemName(); // method from parent class + override
		System.out.println(earth.getStarSystemName()); // method from super class + override

		// Override the hashCode() and toString() methods for each of the classes.
		// Demonstrate the operation of these methods.
		System.out.println(planet.toString());
		System.out.println("Planet hash code = " + planet.hashCode());
		System.out.println(earth.toString());
		System.out.println("Earth hash code = " + earth.hashCode());
	}

}
