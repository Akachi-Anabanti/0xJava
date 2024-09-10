## Things I learned in DAY 4
1. Java Abstraction
2. Java Interface
3. Java Enums
4. User input
5. Java date
6. ArrayList
7. LinkedList

---
## Tasks

1. **Java Abstraction and Interfaces:**
   - **Task:** Create an abstract class `Shape` with an abstract method `draw()`. Then, implement two concrete subclasses: `Circle` and `Rectangle`. Each subclass should provide its own implementation of the `draw()` method. Additionally, define an interface `Colorable` with a method `applyColor()`, and have the `Circle` and `Rectangle` classes implement this interface. Test your implementation by creating instances of `Circle` and `Rectangle` and calling their methods.

2. **Java Enums and ArrayList:**
   - **Task:** Define an enum `Day` with constants for each day of the week. Create an `ArrayList` to store a list of `Day` enums representing the days a particular event occurs. Write a method that takes an `ArrayList` of `Day` enums and prints out the days in a formatted way. For example, "The event occurs on Monday, Wednesday, and Friday."

3. **User Input and Java Date:**
   - **Task:** Write a program that prompts the user to enter a date in the format "YYYY-MM-DD". Use `java.time.LocalDate` to parse the input and validate the date. If the date is valid, calculate and print the day of the week for that date. If the date is invalid, display an error message.

4. **LinkedList and ArrayList:**
   - **Task:** Create a program that demonstrates the difference between `ArrayList` and `LinkedList`. Initialize both with the same data (e.g., a list of 100 integers). Measure and compare the time it takes to add elements to the end of each list and to remove elements from the beginning of each list. Print the results to compare the performance of `ArrayList` and `LinkedList` in these operations.

5. **Java Enums and Business Case Task:**
   - **Task:** Imagine you are developing a task management system. Define an enum `TaskPriority` with values `LOW`, `MEDIUM`, and `HIGH`. Create a class `Task` that contains a `String` title, a `String` description, and a `TaskPriority` enum for the priority of the task. Write a method to print out all tasks sorted by their priority. Then, implement a small application to demonstrate adding tasks with various priorities and displaying them in order.

---
## Business Case Task

6. **Business Case - Task Scheduling System:**
   - **Task:** Develop a task scheduling system for a small company. The system should allow users to create tasks with the following attributes: title, description, due date, and priority. Use the following concepts:
     - **Java Abstraction:** Create an abstract class `Task` with methods for setting and getting task details.
     - **Java Interface:** Implement an interface `Schedulable` with methods `schedule()` and `reschedule()`.
     - **Java Enums:** Use an enum `PriorityLevel` for task priority (e.g., LOW, MEDIUM, HIGH).
     - **Java Date:** Use `java.time.LocalDate` to handle due dates.
     - **ArrayList and LinkedList:** Store tasks in both an `ArrayList` and a `LinkedList` to compare performance for adding and retrieving tasks.
   - **Requirements:** 
     - Allow users to add, edit, and delete tasks.
     - Display tasks sorted by priority and due date.
     - Provide functionality to filter tasks based on priority and due date range.
     - Implement a command-line interface for interaction.

