// A Shift Scheduler
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Scheduler {

    private enum PriorityLevel {
        LOW,
        MEDIUM,
        HIGH
    }
    private interface Schedulable {
        void schedule();
        void reschedule(LocalDate newDate);
    }

    ArrayList<Task> tasks = new ArrayList<Task>();
    
    private void addTask(Scanner scanner) {
        System.out.print("Enter task name: ");
        String name = scanner.nextLine();

        System.out.print("Enter task date (YYYY-MM-DD): ");
        LocalDate date = LocalDate.parse(scanner.nextLine());

        System.out.print("Enter task priority (LOW, MEDIUM, HIGH): ");
        PriorityLevel priority = PriorityLevel.valueOf(scanner.nextLine().toUpperCase());

        Task task = new Task(name, date, priority);
        tasks.add(task);
        System.out.println("Task added successfully.");
    }

    private void removeTask(Scanner scanner) {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to remove. The task list is empty.");
            return;
        }
        displayTask();
        System.out.print("Enter the number of the task to remove: ");
        int taskIndex = scanner.nextInt() - 1;
        scanner.nextLine();

        if (taskIndex < 0 || taskIndex >= tasks.size()) {
            System.out.println("Invalid task number.");
            return;
        } 

    }

    private void displayTask() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks scheduled.");
            return;
        }
        for (int i = 0; i < tasks.size(); i++) {
            System.out.printf("%d.%s\n", i + 1, tasks.get(i));
        }
    }

    private void rescheduleTask(Scanner scanner) {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to reschedule. The task list is empty.");
            return;
        }
        displayTask();
        System.out.print("Enter the number of the task to reschedule: ");
        int taskIndex = scanner.nextInt() - 1;
        scanner.nextInt();

        if (taskIndex < 0 || taskIndex >= tasks.size()) {
            System.out.println("Invalid task number.");
            return;
        }

        System.out.print("Enter new date (YYYY-MM-DD): ");
        LocalDate newDate = LocalDate.parse(scanner.nextLine());

        tasks.get(taskIndex).reschedule(newDate);
        System.out.println("Task rescheduled successfully.");
    }

    private class Task implements Schedulable {
        private String taskName;
        private LocalDate taskDate;
        private PriorityLevel taskPriority;

        public Task(String taskName, LocalDate taskDate, PriorityLevel taskPriority) {
            this.taskName = taskName;
            this.taskDate = taskDate;
            this.taskPriority = taskPriority;
        }

        public void schedule() {
            System.out.println("Task scheduled: " + this);
        }

        public void reschedule(LocalDate newDate) {
            this.taskDate = newDate;
            System.out.println("Task rescheduled: " + this);
        }

        public String toString() {
            return String.format("%s (Date: %s, Priority: %s)", taskName, taskDate, taskPriority);
        }
    }

    public void run(){
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Add Task");
            System.out.println("2. Display tasks");
            System.out.println("3. Reschedule Task");
            System.out.println("4. Remove Task");
            System.out.println("5. Exit");
            System.out.println("Choose an option: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        addTask(scanner);
                        break;
                    case 2:
                        displayTask();
                        break;
                    case 3:
                        rescheduleTask(scanner);
                        break;
                    case 4:
                        removeTask(scanner);
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid option. Please try again.");

                }
            } catch(InputMismatchException e) {
                System.out.println("Incorrect option type. Please again!");
                scanner.nextLine();
            }
        }
    }

    public static void main(String[] args) {
        Scheduler scheduler = new Scheduler();
        scheduler.run();
    }
}