// a script that calculates grade

import java.util.Scanner;

public class Grade {
	public static void main(String[] args) {
		System.out.println("Enter your Grade");
		Scanner scnr = new Scanner(System.in);

		double score = Math.round(scnr.nextDouble());
		char grade;

		if (score >= 90 && score <= 100) {
			grade = 'A';
		} else if (score >= 80 && score <= 89) {
			grade = 'B';
		} else if (score >= 70 && score <= 79) {
			grade = 'C';
		} else if (score >= 60 && score <= 69) {
			grade = 'D';
		} else if (score >= 0 && score <= 59) {
			grade = 'F';
		} else {
			System.out.println("Grade is not valid");
			return;
		}

		System.out.printf("Your grade is %c\n", grade);
	}
}
