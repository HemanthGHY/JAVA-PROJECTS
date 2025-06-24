import java.util.ArrayList;
import java.util.Scanner;

class Task {
    String description;
    boolean isCompleted;

    public Task(String description) {
        this.description = description;
        this.isCompleted = false;
    }

    public void markAsCompleted() {
        this.isCompleted = true;
    }

    @Override
    public String toString() {
        return description + " - " + (isCompleted ? "Completed" : "Pending");
    }
}

public class ToDoListAppCMD {
    private ArrayList<Task> tasks;
    private Scanner scanner;

    public ToDoListAppCMD() {
        tasks = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addTask() {
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();
        tasks.add(new Task(description));
        System.out.println("Task added successfully!");
    }

    public void deleteTask() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available to delete.");
            return;
        }
        System.out.println("Select task to delete:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i).description);
        }
        int choice = scanner.nextInt();
        scanner.nextLine(); 
        if (choice > 0 && choice <= tasks.size()) {
            tasks.remove(choice - 1);
            System.out.println("Task deleted successfully!");
        } else {
            System.out.println("Invalid choice.");
        }
    }

    public void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }
        System.out.println("Tasks:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    public void markTaskAsCompleted() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available to mark as completed.");
            return;
        }
        System.out.println("Select task to mark as completed:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i).description);
        }
        int choice = scanner.nextInt();
        scanner.nextLine();
        if (choice > 0 && choice <= tasks.size()) {
            tasks.get(choice - 1).markAsCompleted();
            System.out.println("Task marked as completed!");
        } else {
            System.out.println("Invalid choice.");
        }
    }

    public void run() {
        while (true) {
            System.out.println("\nTo-Do List Menu:");
            System.out.println("1. Add Task");
            System.out.println("2. Delete Task");
            System.out.println("3. Display Tasks");
            System.out.println("4. Mark Task as Completed");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number between 1 and 5.");
                scanner.nextLine(); 
                continue;
            }
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch(choice) {
                case 1 -> addTask();
                case 2 -> deleteTask();
                case 3 -> displayTasks();
                case 4 -> markTaskAsCompleted();
                case 5 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        ToDoListAppCMD app = new ToDoListAppCMD();
        app.run();
    }
}