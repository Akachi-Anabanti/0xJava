// a program that checks is an input age can vote
import java.util.Scanner;

public class CanVote {
	private static final int benchmark = 18;

	public static void main(String[] args) {
		System.out.println("Provide the user age:");
		Scanner scnr = new Scanner(System.in);

		int age = scnr.nextInt();
		
		String result = age < benchmark? "can't vote" : "Can vote";

		System.out.printf("%d %s\n", age, result);
	}
}
