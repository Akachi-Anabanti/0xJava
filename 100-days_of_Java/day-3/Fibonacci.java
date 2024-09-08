// A scripts that recursively finds the nth fibonacci number

import java.util.Scanner;


public class Fibonacci {

	public static void main(String[] args) {
		System.out.print("Enter n: ");
		Scanner scnr = new Scanner(System.in);
		int n = scnr.nextInt();

		System.out.println(fib(n));
	}

	static int fib(int n) {
		if (n <= 1) {
			return n;
		}
		return fib(n - 1) + fib(n - 2);
	}
}
