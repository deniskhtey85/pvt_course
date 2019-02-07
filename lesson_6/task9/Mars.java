package task9;

public class Mars extends Planet {

	boolean aliens;
	int numberOfSatellites;

	// The third class should contain the constructors overloaded but not related to
	// each other, and can be been
	// created through one of them (for choose).

	public Mars() {
	}

	public Mars(boolean aliens) {
		this.aliens = aliens;
	}

	public Mars(boolean aliens, int numberOfSatellites) {
		this.aliens = aliens;
		this.numberOfSatellites = numberOfSatellites;
	}

	// Implement abstract methods in subclasses.
	@Override
	public void printStarSystemName() {
		System.out.println("Mars is in the " + super.starSystemName + " Star System");
	}

	@Override
	public void printDistance() {
		System.out.println(super.distance);
	}

}
