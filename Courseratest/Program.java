package Courseratest;
import java.util.Scanner;
public class Program {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Please choose from the following list ");
		
		
		System.out.println("1.Circle");
		
		
		System.out.println("2.Rectangle");
		
		
		System.out.println("3.Cylinder");
		
		
		int choice = Integer.parseInt(scan.nextLine());
		
		switch(choice) {
		  case 1:
              System.out.print("Enter radius: ");
              double circleRadius = Double.parseDouble(scan.nextLine());
              circle circle = new circle(circleRadius);
              System.out.println("A circle has:\n0 edges \n0 vertices");
              System.out.println("Area: " + circle.CalculateArea());
              System.out.println("Perimeter: " + circle.CalculateParameter());
              break;
          case 2:
              System.out.print("Enter length: ");
              double recLength = Double.parseDouble(scan.nextLine());
              System.out.print("Enter width: ");
              double recWidth = Double.parseDouble(scan.nextLine());
              rectangle rectangle = new rectangle(recLength, recWidth);
              System.out.println("A rectangle has:\n4 edges\n4 vertices");
              // Perform rectangle-related calculations
              break;
          case 3:
              System.out.print("Enter radius: ");
              double radius = Double.parseDouble(scan.nextLine());
              System.out.print("Enter height: ");
              double cylinderHeight = Double.parseDouble(scan.nextLine());
              cylinder cylinder = new cylinder(radius, cylinderHeight);
              System.out.println("A cylinder has:\n2 edges\n0 vertices");
              System.out.println("Area: " + cylinder.SurfaceArea());
              System.out.println("Perimeter: " + cylinder.perimeter());
              break;
          default:
              System.out.println("Invalid choice");
              break;
      }
      scan.close();
  }
}
