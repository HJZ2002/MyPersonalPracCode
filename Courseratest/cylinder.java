package Courseratest;

public class cylinder {
	double radius;
	double height;
	
	public cylinder(double radius, double height) {
		this.radius = radius;
		this.height = height;
	}
	 public double SurfaceArea() {
		 return 2 * Math.PI * radius*(radius + height);
	 }
	 public double perimeter() {
		 return Math.PI * radius * radius * height;
	 }
}
