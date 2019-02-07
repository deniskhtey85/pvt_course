package task9;

public abstract class StarSystem { // Make the Star System class to the abstract

	String starSystemName;
	double distance;

	public String getStarSystemName() {
		return starSystemName;
	}

	public void setStarSystemName(String starSystemName) {
		this.starSystemName = starSystemName;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	// Add abstract methods

	public abstract void printStarSystemName();

	public abstract void printDistance();

}
