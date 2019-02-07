package task9;

import java.util.Objects;

public class Earth extends Planet {

	double population;
	double periodOfRotation;

	public double getPopulation() {
		return population;
	}

	public void setPopulation(double population) {
		this.population = population;
	}

	public double getPeriodOfRotation() {
		return periodOfRotation;
	}

	public void setPeriodOfRotation(double periodOfRotation) {
		this.periodOfRotation = periodOfRotation;
	}

	// Implement abstract methods in subclasses.
	@Override
	public void printStarSystemName() {
		System.out.println("Earth is in the " + super.starSystemName + " Star System");
	}

	@Override
	public void printDistance() {
		System.out.println(super.distance);
	}

	// Override the hashCode() and toString() methods for each of the classes.
	// Demonstrate the operation of these methods.

	@Override
	public int hashCode() {
		return Objects.hash(population, periodOfRotation);
	}

	@Override
	public String toString() {
		return "Earth population = " + population + ", period of rotation = " + periodOfRotation
				+ ", diametr = " + diametr + ", weight = " + weight;
	}

}
