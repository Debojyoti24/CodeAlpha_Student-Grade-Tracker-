import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {
    static class Student {
        String name;
        double grade;

        Student(String name, double grade) {
            this.name = name;
            this.grade = grade;
        }
    }

    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            displayMenu();
            int choice = getUserChoice();
            
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displaySummary();
                    break;
                case 3:
                    System.out.println("Exiting program...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\n=== Student Grade Tracker ===");
        System.out.println("1. Add Student");
        System.out.println("2. Display Summary Report");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
    }

    private static int getUserChoice() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine().trim();
        
        if (name.isEmpty()) {
            System.out.println("Error: Name cannot be empty!");
            return;
        }

        System.out.print("Enter student grade (0-100): ");
        try {
            double grade = Double.parseDouble(scanner.nextLine());
            if (grade < 0 || grade > 100) {
                System.out.println("Error: Grade must be between 0 and 100!");
                return;
            }
            students.add(new Student(name, grade));
            System.out.println("Student added successfully!");
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid grade format!");
        }
    }

    private static void displaySummary() {
        if (students.isEmpty()) {
            System.out.println("No students recorded yet!");
            return;
        }

        double total = 0;
        double highest = students.get(0).grade;
        double lowest = students.get(0).grade;
        String highestStudent = students.get(0).name;
        String lowestStudent = students.get(0).name;

        System.out.println("\n=== Grade Summary Report ===");
        System.out.printf("%-20s %s%n", "Student Name", "Grade");
        System.out.println("--------------------------------");

        for (Student student : students) {
            System.out.printf("%-20s %.2f%n", student.name, student.grade);
            total += student.grade;
            
            if (student.grade > highest) {
                highest = student.grade;
                highestStudent = student.name;
            }
            if (student.grade < lowest) {
                lowest = student.grade;
                lowestStudent = student.name;
            }
        }

        double average = total / students.size();
        System.out.println("\nStatistics:");
        System.out.printf("Average Grade: %.2f%n", average);
        System.out.printf("Highest Grade: %.2f (%s)%n", highest, highestStudent);
        System.out.printf("Lowest Grade: %.2f (%s)%n", lowest, lowestStudent);
        System.out.printf("Total Students: %d%n", students.size());
    }
}