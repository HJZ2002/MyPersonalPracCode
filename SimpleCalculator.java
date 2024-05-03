package Praccode;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalculator {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Simple Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new BorderLayout());

        // Text field to display the result
        JTextField resultField = new JTextField();
        resultField.setEditable(false);
        frame.add(resultField, BorderLayout.NORTH);

        // Panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4));
        frame.add(buttonPanel, BorderLayout.CENTER);

        // Buttons and their actions
        JButton addButton = new JButton("+");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double num1 = Double.parseDouble(resultField.getText());
                double num2 = Double.parseDouble(JOptionPane.showInputDialog("Enter second number: "));
                resultField.setText(String.valueOf(num1 + num2));
            }
        });

        JButton subtractButton = new JButton("-");
        subtractButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double num1 = Double.parseDouble(resultField.getText());
                double num2 = Double.parseDouble(JOptionPane.showInputDialog("Enter second number: "));
                resultField.setText(String.valueOf(num1 - num2));
            }
        });

        JButton multiplyButton = new JButton("*");
        multiplyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double num1 = Double.parseDouble(resultField.getText());
                double num2 = Double.parseDouble(JOptionPane.showInputDialog("Enter second number: "));
                resultField.setText(String.valueOf(num1 * num2));
            }
        });

        JButton divideButton = new JButton("/");
        divideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double num1 = Double.parseDouble(resultField.getText());
                double num2 = Double.parseDouble(JOptionPane.showInputDialog("Enter second number: "));
                resultField.setText(String.valueOf(num1 / num2));
            }
        });

        // Add buttons to panel
        buttonPanel.add(addButton);
        buttonPanel.add(subtractButton);
        buttonPanel.add(multiplyButton);
        buttonPanel.add(divideButton);

        frame.setVisible(true);
    }
}
