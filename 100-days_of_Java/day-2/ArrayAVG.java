// A program that calculates the average of all numbers in an array

/**
 * Calculates average of an array
 *
 */
public class ArrayAVG {

	public static void main(String[] args) {

		int[] list = {1, 5, 29, 4, 59, 43, 7, 89, 54, 12, 5, 8};

		String listString = "[";

		int sum = 0;
		double AVG;

		for (int num: list) {
			sum += num;
			listString += num;

			if (num != list[list.length - 1])
				listString += ", ";
		}

		listString += "]";

		AVG = (double) sum / (double)list.length;
		System.out.printf("Average of %s is %.3f\n", listString, AVG);
	}
}
