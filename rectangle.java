package Courseratest;

public class rectangle {
	double length;
	double width;
	
	public rectangle(double length,double width) {
		this.length=length;
		this.width = width;
	}
	public double CalculateArea(double length,double width) {
		return length * width;
	}
	public double perimeter() {
		return 2* (length*width);
	}
}
