import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ViewMembers extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private DefaultTableModel tableModel;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ViewMembers frame = new ViewMembers();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public ViewMembers() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 950, 347);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Define the columns for the table
        String[] columnNames = {"ID", "Name", "Age", "Course", "Year"};

       
        tableModel = new DefaultTableModel(columnNames, 0);
        
       
        table = new JTable(new DefaultTableModel(
        	new Object[][] {
        	},
        	new String[] {
        		"ID", "Name", "Age", "Course", "Year"
        	}
        ));

        // Add the table to a scroll pane in case the data overflows the frame
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 0, 924, 273);
        contentPane.add(scrollPane);
        
        JButton DeleteButton = new JButton("Delete");
        DeleteButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
        DeleteButton.setBounds(20, 284, 89, 23);
        contentPane.add(DeleteButton);
        
        JButton btnBack = new JButton("Back");
        btnBack.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnBack.setBounds(835, 284, 89, 23);
        contentPane.add(btnBack);
        btnBack.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        LibraryGUI back = new LibraryGUI();
		        back.setVisible(true);
		    }
		});
    }

    private void addMemberToTable(int id, String name, int age, String course, int year) {
        Object[] rowData = {id, name, age, course, year};
        tableModel.addRow(rowData);
    }
}