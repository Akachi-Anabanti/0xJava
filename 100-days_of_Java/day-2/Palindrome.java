// a program that checks if a string is a palindrome
import java.util.Scanner;

public class Palindrome {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		System.out.println("Enter the string:");
		String word = scnr.nextLine();
		String cleaned = word.trim().toLowerCase()
			.replaceAll("\\s+", "")
			.replaceAll("[,;:]", ""); // remove delimiters and spaces

		if (cleaned.isEmpty()) {
			System.out.println("Please provide a valid String!");
			return;
		}

		boolean isPalindrome = isPalindrome(cleaned);

		String stmt = isPalindrome ? "is palindrome": "is not palindrome";
		System.out.println(word + " " + stmt); // output
	}

	private static boolean isPalindrome(String str) {
		int left = 0;
		int right = str.length() - 1;

		while (left < right) {
			if (str.charAt(left) != str.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
}
