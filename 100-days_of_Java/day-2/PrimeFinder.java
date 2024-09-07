import java.util.Scanner;

/** 
 * A program that finds prime numbers between 1 and a user input end value.
 */
public class PrimeFinder {

	public static void main(String[] args) {
		System.out.print("Enter the stop number: ");
		Scanner scnr = new Scanner(System.in);

		int stopNumber = scnr.nextInt();
		
		if (stopNumber < 2) {
			System.out.printf("There are no prime numbers less than 2");
			return;
		}

		for (int n = 2; n <= stopNumber; n++) {
			boolean isPrime = true;

			if (n == 2) {
				System.out.printf("%d is prime\n", n);
				continue;
			}

			if (n % 2 == 0)
				continue;
			
			// Check for divisiblity for odd numbers only
			for (int i = 3; i <= Math.sqrt(n); i += 2) {
				if (n % i == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				System.out.printf("%d is prime\n", n);
			}
		}
	}
}
