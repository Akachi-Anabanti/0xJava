// A Program that prints the multiplication table
// from 1 to 10 for a given number
//
import java.util.Scanner;

public class MultiplicationTable {

	public static void main(String[] args) {
		System.out.print("Enter the number: ");
		Scanner scnr = new Scanner(System.in);

		int number = scnr.nextInt();

		for(int i = 1; i <= 10; i++) {

			System.out.printf("%d x %d = %d \n", number, i, number * i);
		}

	}
}
