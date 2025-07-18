import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class StudentGradeTrackerGUI {
    static class Student {
        String name;
        double grade;

        Student(String name, double grade) {
            this.name = name;
            this.grade = grade;
        }
    }

    private static ArrayList<Student> students = new ArrayList<>();
    private static JFrame frame;
    private static JTextField nameField;
    private static JTextField gradeField;
    private static DefaultTableModel tableModel;
    private static JLabel averageLabel;
    private static JLabel highestLabel;
    private static JLabel lowestLabel;
    private static JLabel totalLabel;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {
        frame = new JFrame("Student Grade Tracker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);
        frame.setLayout(new BorderLayout(10, 10));

        // Input Panel
        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        inputPanel.add(new JLabel("Student Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Grade (0-100):"));
        gradeField = new JTextField();
        inputPanel.add(gradeField);

        JButton addButton = new JButton("Add Student");
        inputPanel.add(addButton);

        JButton exitButton = new JButton("Exit");
        inputPanel.add(exitButton);

        // Table Panel
        String[] columns = {"Student Name", "Grade"};
        tableModel = new DefaultTableModel(columns, 0);
        JTable table = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(table);

        // Summary Panel
        JPanel summaryPanel = new JPanel(new GridLayout(4, 1));
        summaryPanel.setBorder(BorderFactory.createTitledBorder("Statistics"));
        
        averageLabel = new JLabel("Average Grade: N/A");
        highestLabel = new JLabel("Highest Grade: N/A");
        lowestLabel = new JLabel("Lowest Grade: N/A");
        totalLabel = new JLabel("Total Students: 0");
        
        summaryPanel.add(averageLabel);
        summaryPanel.add(highestLabel);
        summaryPanel.add(lowestLabel);
        summaryPanel.add(totalLabel);

        // Add components to frame
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(tableScrollPane, BorderLayout.CENTER);
        frame.add(summaryPanel, BorderLayout.SOUTH);

        // Button Listeners
        addButton.addActionListener(e -> addStudent());
        exitButton.addActionListener(e -> System.exit(0));

        // Center the frame and make it visible
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void addStudent() {
        String name = nameField.getText().trim();
        
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Error: Name cannot be empty!", 
                "Invalid Input", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            double grade = Double.parseDouble(gradeField.getText().trim());
            if (grade < 0 || grade > 100) {
                JOptionPane.showMessageDialog(frame, "Error: Grade must be between 0 and 100!", 
                    "Invalid Input", JOptionPane.ERROR_MESSAGE);
                return;
            }

            students.add(new Student(name, grade));
            tableModel.addRow(new Object[]{name, String.format("%.2f", grade)});
            updateSummary();
            
            // Clear input fields
            nameField.setText("");
            gradeField.setText("");
            
            JOptionPane.showMessageDialog(frame, "Student added successfully!", 
                "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Error: Invalid grade format!", 
                "Invalid Input", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void updateSummary() {
        if (students.isEmpty()) {
            averageLabel.setText("Average Grade: N/A");
            highestLabel.setText("Highest Grade: N/A");
            lowestLabel.setText("Lowest Grade: N/A");
            totalLabel.setText("Total Students: 0");
            return;
        }

        double total = 0;
        double highest = students.get(0).grade;
        double lowest = students.get(0).grade;
        String highestStudent = students.get(0).name;
        String lowestStudent = students.get(0).name;

        for (Student student : students) {
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
        averageLabel.setText(String.format("Average Grade: %.2f", average));
        highestLabel.setText(String.format("Highest Grade: %.2f (%s)", highest, highestStudent));
        lowestLabel.setText(String.format("Lowest Grade: %.2f (%s)", lowest, lowestStudent));
        totalLabel.setText("Total Students: " + students.size());
    }
}