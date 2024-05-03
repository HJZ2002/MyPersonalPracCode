package Courseratest;

public class circle {
	double radius;
	public circle(double radius) {
		this.radius = radius;
	}
	public double CalculateArea() {
		return Math.PI *radius * radius;
	}
	public double CalculateParameter() {
		return 2*Math.PI * radius;
	}
}
