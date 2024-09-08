## THINGS I LEARNED IN DAY 3
1. Java Methods
2. Java Method overloading
3. Java Recursion
4. Java Class/Objects
5. Class Methods
6. Constructors
7. Modifiers
8. Encapsulation
9. Packages /API
10. Inheritance
11. StringBuilder and StringBuffer types

## CHALLENGES
1. **Java Methods**

    **Challenge:** Write a Java method that takes a string and returns the number of vowels in the string.
	[Vowel Counter](VowelCounter.java)


2. **Java Method Overloading**

    **Challenge:** Create a class named `Formatter` with overloaded methods to format text. Provide methods that:
    
    - Take a single string and return it in uppercase.
    - Take two strings and return them concatenated with a space in between.
    - Take a string and an integer, and return the string repeated `n` times, where `n` is the integer.
	[Text Formatter](Formatter.java)

3. **Java Recursion**

    **Challenge:** Write a recursive method to compute the nth Fibonacci number.

4. **Java Class/Objects**

    **Challenge:** Create a class named `Book` with attributes `title`, `author`, and `year`. Include methods to display the book details and to update the year of publication.

5. **Class Methods**

    **Challenge:** In the `Book` class, add a static method that returns the total number of books created.

6. **Constructors**

    **Challenge:** Modify the `Book` class to include a constructor that initializes `title`, `author`, and `year` when a new book is created.

7. **Modifiers**

    **Challenge:** In the `Book` class, use access modifiers to ensure that `title` and `author` cannot be accessed directly outside the class, but `year` can be accessed and modified.

8. **Encapsulation**

    **Challenge:** Refactor the `Book` class to use getter and setter methods for all attributes to ensure proper encapsulation.

9. **Packages/API**

    **Challenge:** Create a package `com.example.geometry` with a class `Rectangle` that has a method `public double area()` to return the area of the rectangle. Import and use this class in a separate `Main` class.

10. **Inheritance**

    **Challenge:** Create a base class `Vehicle` with a method `start()`. Then create a subclass `Car` that overrides `start()` to return `"Car started"` and a subclass `Bike` that returns `"Bike started"`. Demonstrate polymorphism by calling `start()` on a `Vehicle` reference that points to a `Car` and a `Bike`.

11. **StringBuilder vs. StringBuffer**

    **Challenge:** Create a class named `TextProcessor` with methods to demonstrate the use of `StringBuilder` and `StringBuffer`. Implement the following methods:

    - **Method 1:** `public String reverseTextUsingBuilder(String text)` - Use `StringBuilder` to reverse the given string and return the result.
    - **Method 2:** `public String reverseTextUsingBuffer(String text)` - Use `StringBuffer` to reverse the given string and return the result.
    - **Method 3:** `public void comparePerformance(String text)` - Compare the performance of `StringBuilder` and `StringBuffer` by measuring the time taken to reverse a large string using both classes.

    Test these methods in the `main` function with sample strings and a large string to observe their behavior and performance differences.
	
