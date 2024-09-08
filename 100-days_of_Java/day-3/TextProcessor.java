// Textprocessor class
//

public class TextProcessor {
	public String reverseTextUsingBuilder(String text) {
		StringBuilder sb = new StringBuilder(text);
		return sb.reverse().toString();
	}

	public String reverseTextUsingBuffer(String text) {
		StringBuffer sb = new StringBuffer(text);
		return sb.reverse().toString();
	}

	public void comparePerformance(String text) {
		long startTime, endTime;

		// measure performance using StringBuilder
		startTime = System.currentTimeMillis();
		reverseTextUsingBuilder(text);
		endTime = System.currentTimeMillis();
		System.out.println("StringBuilder time: " + (endTime - startTime));

		// measure performance using StringBuffer
		startTime = System.currentTimeMillis();
		reverseTextUsingBuffer(text);
		endTime = System.currentTimeMillis();
		System.out.println("StringBuffer time: " + (endTime - startTime));
	}

	public static void main(String[] args) {
		TextProcessor processor = new TextProcessor();
		// test reversing a small string
		System.out.println(processor.reverseTextUsingBuilder("Hello"));
		System.out.println(processor.reverseTextUsingBuffer("World!"));

		String largeText = "This is test text to determine which of the string types performs better. Let us Find out which is faster between StringBuilder and String Buffer".repeat(1000);
		processor.comparePerformance(largeText);
	}
}
