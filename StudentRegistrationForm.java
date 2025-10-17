import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class StudentRegistrationForm extends JFrame {
    // GUI Components
    JTextField nameField, rollField, ageField, emailField;
    JButton submitButton;

    public StudentRegistrationForm() {
        setTitle("Student Registration Form");
        setSize(400, 300);
        setLayout(new GridLayout(5, 2, 10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Labels and TextFields
        add(new JLabel("Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Roll Number:"));
        rollField = new JTextField();
        add(rollField);

        add(new JLabel("Age:"));
        ageField = new JTextField();
        add(ageField);

        add(new JLabel("Email:"));
        emailField = new JTextField();
        add(emailField);

        // Submit Button
        submitButton = new JButton("Submit");
        add(submitButton);

        // Action Listener for Submit
        submitButton.addActionListener(e -> saveStudent());

        setVisible(true);
    }

    // Method to save student to DB
    private void saveStudent() {
        String name = nameField.getText();
        String roll = rollField.getText();
        String ageText = ageField.getText();
        String email = emailField.getText();

        // Input Validation
        if(name.isEmpty() || roll.isEmpty() || ageText.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields");
            return;
        }

        int age;
        try {
            age = Integer.parseInt(ageText);
            if(age <= 0) throw new NumberFormatException();
        } catch(NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Enter a valid age");
            return;
        }

        if(!email.contains("@")) {
            JOptionPane.showMessageDialog(this, "Enter a valid email");
            return;
        }

        // Database Connection
        try {
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/studentDB", "root", "password");

            String query = "INSERT INTO students (name, roll_no, age, email) VALUES (?, ?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, name);
            pst.setString(2, roll);
            pst.setInt(3, age);
            pst.setString(4, email);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Student registered successfully!");

            // Clear fields
            nameField.setText("");
            rollField.setText("");
            ageField.setText("");
            emailField.setText("");

            conn.close();
        } catch(SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new StudentRegistrationForm();
    }
}
