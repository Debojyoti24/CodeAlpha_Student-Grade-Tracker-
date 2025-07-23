# CodeAlpha_Student-Grade-Tracker-

Overview
The Student Grade Tracker GUI is a Java-based desktop application designed to manage student grades using a graphical user interface (GUI). Built with Java Swing, it allows users to add student names and grades, display them in a table, and view statistical summaries such as average, highest, and lowest grades. The application provides input validation and a user-friendly interface for educational purposes.
Features

Add Students: Enter a student's name and grade (0-100) to add them to the system.
Input Validation: Ensures names are not empty and grades are valid numbers between 0 and 100.
Grade Table: Displays all students and their grades in a tabular format.
Statistics Summary: Shows:
Total number of students
Average grade
Highest grade with the corresponding student name
Lowest grade with the corresponding student name


Exit Functionality: Closes the application gracefully.
User Feedback: Displays success or error messages for user actions.

Requirements

Java Development Kit (JDK): Version 8 or higher.
Operating System: Any OS that supports Java (Windows, macOS, Linux, etc.).
No additional libraries are required as the application uses standard Java libraries (javax.swing and java.awt).

Installation

Ensure JDK is installed on your system. Verify by running:java -version


Save the provided Java code in a file named StudentGradeTrackerGUI.java.
Compile the code:javac StudentGradeTrackerGUI.java


Run the application:java StudentGradeTrackerGUI



Usage

Launch the application using the steps above.
In the input panel:
Enter a student's name in the "Student Name" field.
Enter a grade (0-100) in the "Grade" field.


Click the Add Student button to add the student to the table.
View the updated table and statistics in the summary panel.
Click the Exit button to close the application.
Error messages will appear if:
The name field is empty.
The grade is not a valid number or is outside the 0-100 range.


A success message confirms when a student is added successfully.

Code Structure

Class: StudentGradeTrackerGUI
Inner Class: Student (stores name and grade).
Main Components:
JFrame: Main window.
JTextField: Input fields for name and grade.
JTable with DefaultTableModel: Displays student data.
JLabel: Displays statistics (average, highest, lowest, total).
JButton: Add Student and Exit buttons.


Key Methods:
createAndShowGUI(): Sets up the GUI components and layout.
addStudent(): Validates input and adds a student to the list and table.
updateSummary(): Calculates and updates the statistics display.





Limitations

Grades are stored in memory and are not persisted after the application closes.
No option to edit or delete student records.
Basic error handling for input validation; no advanced data validation (e.g., duplicate names).

Future Improvements

Add persistence (e.g., save grades to a file or database).
Include options to edit or delete student records.
Add sorting or filtering capabilities for the table.
Enhance the GUI with additional styling or themes.

License
This project is for educational purposes and is not licensed for commercial use. Feel free to modify and use it for learning or personal projects.
