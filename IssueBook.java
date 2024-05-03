import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class IssueBook extends JFrame {

	private JPanel contentPane;
	private JTextField textField_2;
	private JTextField textField_1;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IssueBook frame = new IssueBook();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public IssueBook() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 415, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Issue Info");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(208, 121, 108, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblStudentId = new JLabel("Student ID");
		lblStudentId.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblStudentId.setBounds(51, 156, 124, 33);
		contentPane.add(lblStudentId);
		
		JLabel lblBookId = new JLabel("Book ID");
		lblBookId.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblBookId.setBounds(51, 200, 124, 33);
		contentPane.add(lblBookId);
		
		JLabel lblReturnDate = new JLabel("Return Date");
		lblReturnDate.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblReturnDate.setBounds(51, 265, 124, 33);
		contentPane.add(lblReturnDate);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(185, 275, 163, 20);
		contentPane.add(textField_2);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSubmit.setBounds(134, 322, 108, 33);
		contentPane.add(btnSubmit);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnClear.setBounds(274, 322, 92, 33);
		contentPane.add(btnClear);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBack.setBounds(0, 0, 84, 33);
		btnBack.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        LibraryGUI Library = new LibraryGUI();
		        Library.setVisible(true);
		    }
		});
		contentPane.add(btnBack);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(185, 210, 163, 20);
		contentPane.add(textField_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(185, 165, 163, 20);
		contentPane.add(textField);
	}
}
