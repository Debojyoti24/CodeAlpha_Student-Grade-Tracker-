# Student Grade Tracker

A simple Swing-based GUI application for tracking student grades.

## Installation

To run the Student Grade Tracker, you will need to have Java installed on your system. You can download the latest version of Java from the [Oracle Java website](https://www.java.com/en/download/).

Once you have Java installed, you can run the application by executing the `StudentGradeTrackerGUI.java` file.

## Usage

The Student Grade Tracker application allows you to:

1. Add a student's name and grade (between 0 and 100).
2. View the list of students and their grades in a table.
3. See the overall statistics, including the average grade, highest grade, lowest grade, and total number of students.

To use the application, follow these steps:

1. Enter a student's name in the "Student Name" field.
2. Enter the student's grade (between 0 and 100) in the "Grade (0-100)" field.
3. Click the "Add Student" button to add the student to the list.
4. The student's name and grade will be displayed in the table.
5. The summary statistics will be updated to reflect the new student's information.
6. To exit the application, click the "Exit" button.

## API

The `StudentGradeTrackerGUI` class is the main entry point for the application. It contains the following methods:

- `main(String[] args)`: The main method that creates and shows the GUI.
- `createAndShowGUI()`: Initializes and sets up the GUI components.
- `addStudent()`: Handles the addition of a new student to the list.
- `updateSummary()`: Updates the summary statistics displayed in the GUI.


## License

This project is licensed under the [MIT License](LICENSE).

## Testing

To run the tests for the Student Grade Tracker application, you can use a testing framework like JUnit. The tests should cover the following scenarios:

- Verify that a student can be added successfully.
- Verify that the summary statistics are updated correctly when a student is added.
- Verify that an error message is displayed when an invalid name or grade is entered.
- Verify that the application can handle a large number of students.
