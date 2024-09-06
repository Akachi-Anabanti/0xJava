// a program that computes the area and circumference
// of a circle given its radius
import java.util.Scanner;

public class Circle {
	private static double area(double radius) {
		// calculates the area of a circle
		// pi.r^2
		double result = Math.PI * Math.pow(radius, 2);
		return result;
	}

	private static double circumference(double radius) {
		// calculate the circumference
		// 2.pi.r
		double result = 2 * Math.PI * radius;
		return result;
	}

	public static void main(String[] args) {
		System.out.println("Enter the radius:");
		Scanner scnr = new Scanner(System.in);
		double radius = scnr.nextDouble();

		double area = area(radius);
		double circumference = circumference(radius);

		System.out.printf("Area of circle with radius %.2f is %.2f\n", radius, area);
		System.out.printf("Circumference of circle with radius %.2f is %.2f\n", radius, circumference);
	}
}
