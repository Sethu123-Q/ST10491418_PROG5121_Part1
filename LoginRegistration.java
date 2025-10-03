package com.mycompany.loginregistrationapp;

import javax.swing.*;
import java.awt.*;

public class LoginRegistration extends JFrame {
    JTextField txtUsername, txtCell;
    JPasswordField txtPassword;

    public LoginRegistration() {
        setTitle("📝 Login & Registration");
        setSize(420, 320);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(173, 216, 230));
        setLayout(new GridLayout(5, 2, 10, 10));

        txtUsername = new JTextField();
        txtPassword = new JPasswordField();
        txtCell = new JTextField();
        JButton btnRegister = new JButton("Register");

        btnRegister.setBackground(new Color(0, 102, 204));
        btnRegister.setForeground(Color.WHITE);
        btnRegister.setFont(new Font("Segoe UI", Font.BOLD, 14));

        add(new JLabel("Username:"));
        add(txtUsername);
        add(new JLabel("Password:"));
        add(txtPassword);
        add(new JLabel("SA Cell Number:"));
        add(txtCell);
        add(new JLabel(""));
        add(btnRegister);

        btnRegister.addActionListener(e -> validateInputs());

        setVisible(true);
    }

    private void validateInputs() {
        String username = txtUsername.getText();
        String password = new String(txtPassword.getPassword());
        String cell = txtCell.getText();

        if (password.length() < 8 ||
            !password.matches(".*[A-Z].*") ||
            !password.matches(".*[a-z].*") ||
            !password.matches(".*\\d.*") ||
            !password.matches(".*[!@#$%^&*].*")) {
            JOptionPane.showMessageDialog(this,
                "Password must be at least 8 characters and include a capital letter, number, and special character.");
            return;
        }

        if (cell.contains("_") || cell.replaceAll("\\D", "").length() > 10) {
            JOptionPane.showMessageDialog(this, "Phone number is incorrectly captured");
            return;
        }

        JOptionPane.showMessageDialog(this,
            "✅ Registration successful!\nWelcome, " + username + "!");
    }

    public static void main(String[] args) {
    }
}

