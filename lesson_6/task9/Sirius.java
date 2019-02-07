package task9;

public class Sirius extends Star {

	String type;
	String constellation;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getConstellation() {
		return constellation;
	}

	public void setConstellation(String constellation) {
		this.constellation = constellation;
	}

	// Implement abstract methods in subclasses.
	@Override
	public void printStarSystemName() {
		System.out.println("Sirius is in the " + starSystemName);
	}

	@Override
	public void printDistance() {
		System.out.println(super.distance);
	}

}
