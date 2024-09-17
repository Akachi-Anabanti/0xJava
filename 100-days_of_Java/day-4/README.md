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

---

## Business Case Task

2. **Business Case - Task Scheduling System:**
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
