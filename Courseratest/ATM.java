package Courseratest;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class ATM {
    private double balance = 0;
    private int storedPin = 1234; // Default pin

    private JFrame loginFrame;
    private JPasswordField pinField;

    private JFrame frame;
    private JTextField textField;
    private JButton btnCheckBalance, btnDeposit, btnWithdraw;
    private JTextArea textArea;

    public ATM() {
        initialize();
    }

    private void initialize() {
        // Login Frame
        loginFrame = new JFrame();
        loginFrame.setBounds(100, 100, 300, 200);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.getContentPane().setLayout(null);

        JLabel pinLabel = new JLabel("Enter Pin:");
        pinLabel.setBounds(20, 20, 80, 25);
        loginFrame.getContentPane().add(pinLabel);

        pinField = new JPasswordField();
        pinField.setBounds(100, 20, 160, 25);
        loginFrame.getContentPane().add(pinField);

        JButton btnLogin = new JButton("Login");
        btnLogin.setBounds(100, 60, 160, 25);
        loginFrame.getContentPane().add(btnLogin);

        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String enteredPin = new String(pinField.getPassword());
                if (Integer.parseInt(enteredPin) == storedPin) {
                    loginFrame.setVisible(false);
                    frame.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(loginFrame, "Invalid Pin");
                }
            }
        });

        readPinFromFile();

        // ATM Frame
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        textField = new JTextField();
        textField.setBounds(20, 20, 200, 25);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        btnCheckBalance = new JButton("Check Balance");
        btnCheckBalance.setBounds(20, 60, 200, 25);
        frame.getContentPane().add(btnCheckBalance);

        btnDeposit = new JButton("Deposit");
        btnDeposit.setBounds(20, 100, 200, 25);
        frame.getContentPane().add(btnDeposit);

        btnWithdraw = new JButton("Withdraw");
        btnWithdraw.setBounds(20, 140, 200, 25);
        frame.getContentPane().add(btnWithdraw);

        textArea = new JTextArea();
        textArea.setBounds(20, 180, 400, 60);
        frame.getContentPane().add(textArea);

        btnCheckBalance.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.setText("Balance: " + balance);
            }
        });

        btnDeposit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double amount = Double.parseDouble(textField.getText());
                balance += amount;
                writeBalanceToFile();
                textField.setText("");
                textArea.setText("Deposited: " + amount);
            }
        });

        btnWithdraw.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double amount = Double.parseDouble(textField.getText());
                if (balance >= amount) {
                    balance -= amount;
                    writeBalanceToFile();
                    textField.setText("");
                    textArea.setText("Withdrew: " + amount);
                } else {
                    textArea.setText("Insufficient balance!");
                }
            }
        });

        readBalanceFromFile();
    }

    private void readPinFromFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("pin.txt"));
            String line = reader.readLine();
            if (line != null) {
                storedPin = Integer.parseInt(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readBalanceFromFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("balance.txt"));
            String line = reader.readLine();
            if (line != null) {
                balance = Double.parseDouble(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeBalanceToFile() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("balance.txt"));
            writer.write(Double.toString(balance));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ATM window = new ATM();
                    window.loginFrame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    }