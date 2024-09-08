// A class that formats text

import java.util.Scanner;

public class Formatter {

	public static String format(String sentence) {
		return sentence.toUpperCase();
	}

	public static String format(String sentence1,
			String sentence2) {
		String combined = sentence1 + " " + sentence2;
		return combined;
	}

	public static String format(String sentence, int n) {
		StringBuilder sb = new StringBuilder();
		while (n > 0) {
			sb.append(sentence);
			n--;
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(format("Hello world!"));
		System.out.println(format("Hello", "world!"));
		System.out.println(format("Hello world!", 4));
	}
}
