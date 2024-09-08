// A java program that takes a string and returns the
// number of vowels
import java.util.Scanner;

public class VowelCounter {

	public static void main(String[] args) {
		System.out.print("Enter the sentence: ");
		Scanner scnr = new Scanner(System.in);

		String sentence = scnr.nextLine();

		if (sentence.isEmpty()) {
			System.out.println("You didn't enter a sentence");
			return;
		}

		String cleanedSentence = sentence.trim()
			.toLowerCase().replaceAll("[,;:]","")
			.replaceAll("\\s+", "");

		int nVowels = countVowels(cleanedSentence);
		
		System.out.printf("Vowels = %d\n", nVowels);
	}

	static int countVowels(String sentence) {
		char[] vowels = {'a','e','i','o','u'};
		int nVowels = 0; // number of vowels
		for (char vowel: vowels) {
			for (int i = 0; i < sentence.length(); i++) {
				if (vowel == sentence.charAt(i))
					nVowels += 1;
			}
		}
		return nVowels;
	}
}
