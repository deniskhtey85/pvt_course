package task9;

public class Star extends StarSystem {

	String color;
	double tepmerature;

	// The other is a system of setters and getters and initialized through them.

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getTepmerature() {
		return tepmerature;
	}

	public void setTepmerature(double tepmerature) {
		this.tepmerature = tepmerature;
	}

	// Implement abstract methods in subclasses.
	@Override
	public void printStarSystemName() {
		System.out.println(super.starSystemName);
	}

	@Override
	public void printDistance() {
		System.out.println(super.distance);
	}

}
