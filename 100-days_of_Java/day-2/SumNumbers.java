// a program that calculates the sum of
// all integers from 1 to a given number
import java.util.Scanner;

public class SumNumbers {
	public static void main(String[] args) {
		System.out.print("Enter the stop number > 0: ");
		Scanner scnr = new Scanner(System.in);

		int end = scnr.nextInt();

		if (end <= 0) {
			System.out.println("Provide postive integers only!");
			return;
		}
		int start = 1;
		long sum = 0;

		while (start <= end) {
			sum += start;
			start++;
		}

		System.out.printf("The sum of numbers from 1-%d is %d\n", end, sum);
	}
}
