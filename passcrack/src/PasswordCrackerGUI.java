/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author JohnSandra
 */
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;

public class PasswordCrackerGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Password Cracker");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel usernameLabel = new JLabel("Enter Username:");
        usernameLabel.setBounds(50, 50, 120, 25);
        frame.add(usernameLabel);

        JTextField usernameField = new JTextField();
        usernameField.setBounds(180, 50, 150, 25);
        frame.add(usernameField);

        JButton crackButton = new JButton("Crack Password");
        crackButton.setBounds(100, 100, 200, 30);
        frame.add(crackButton);

        JTextArea outputArea = new JTextArea();
        outputArea.setBounds(50, 150, 300, 100);
        outputArea.setEditable(false);
        frame.add(outputArea);

        crackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                try {
                    if (PasswordCracker.dictionaryAttack(username)) {
                        outputArea.setText("Password found using Dictionary Attack!");
                    } else if (PasswordCracker.bruteForceAttack()) {
                        outputArea.setText("Password found using Brute Force Attack!");
                    } else {
                        outputArea.setText("Password not found.");
                    }
                } catch (IOException ex) {
                    outputArea.setText("Error: " + ex.getMessage());
                }
            }
        });

        frame.setVisible(true);
    }
}
