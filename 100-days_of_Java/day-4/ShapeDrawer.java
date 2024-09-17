// a program that implements abastract shape interface

abstract class Shape {
	public abstract void draw();
}

interface Colorable {
	public void applyColor();
}

class Square extends Shape implements Colorable {
	static int length;
	static int breadth;

	public Square(int x) {
		length = x;
		breadth = x;
	}

	public void draw() {
		// draw a square
		for (int i = 0;  i < breadth; i++) {
			String marker = "-";
			String repeatedMarker = marker.repeat(length);
			System.out.println(repeatedMarker);
		}	
	}

	public void applyColor() {
		System.out.println("Color applied");
	}
}

class Rectangle extends Shape implements Colorable {
	static int length;
	static int breadth;
	public Rectangle(int x, int y) {
		length = x;
		breadth = y;
	}

	public void draw() {
		for (int i = 0; i < breadth; i++) {
			String marker = "*";
			String repeatedMarker = marker.repeat(length);
			System.out.println(repeatedMarker);
		}
	}
	public void applyColor() {
		System.out.println("Color applied");
	}
}


public class ShapeDrawer {
	public static void main(String[] args) {

		Shape square1 = new Square(4);
		square1.draw();

		System.out.print("\n");
		Shape rect1 = new Rectangle(4, 8);
		rect1.draw();

		System.out.print("\n");

		Shape square2 = new Square(7);
		square2.draw();

		System.out.print("\n");

		Shape rect2  = new Rectangle(7, 12);
		rect2.draw();
	}
}
