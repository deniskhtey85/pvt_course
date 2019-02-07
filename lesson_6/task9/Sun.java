package task9;

public class Sun extends Star {

	double radius;
	double square;

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public double getSquare() {
		return square;
	}

	public void setSquare(double square) {
		this.square = square;
	}

	// Implement abstract methods in subclasses.
	@Override
	public void printStarSystemName() {
		System.out.println("Sun is in the " + starSystemName);
	}

	@Override
	public void printDistance() {
		System.out.println(super.distance);
	}

}
