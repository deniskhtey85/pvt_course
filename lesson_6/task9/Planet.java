package task9;

import java.util.Objects;

public class Planet extends StarSystem {

	double diametr;
	double weight;

	// One of the classes to should contain overloaded related constructors and be
	// created with their help (use "this").

	public Planet() {
	}

	public Planet(double diametr) {
		this.diametr = diametr;
	}

	public Planet(double diametr, double weight) {
		this(diametr);
		this.weight = weight;
	}

	public void printRadius() {
		double radius;
		radius = diametr / 2;
		System.out.printf("Planet radius = %s", radius);
		System.out.println();
	}

	public void printWeight() {
		System.out.println("Planet weight = " + weight);
	}

	public void printDiametr() {
		System.out.println("Planet diametr = " + diametr);
	}

	// Implement abstract methods in subclasses.
	@Override
	public void printStarSystemName() {
		System.out.println("Planet from " + super.starSystemName);
	}

	@Override
	public void printDistance() {
		System.out.println(super.distance);
	}

	// Override the hashCode() and toString() methods for each of the classes.
	// Demonstrate the operation of these methods.

	@Override
	public int hashCode() {
		return Objects.hash(diametr, weight);
	}

	@Override
	public String toString() {
		return "Planet diametr = " + diametr + ", weight = " + weight;
	}

}
