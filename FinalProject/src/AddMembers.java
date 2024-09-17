import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class AddMembers extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnNewButton;
	private JButton btnClear;
	private JButton btnBack;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddMembers frame = new AddMembers();
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
	public AddMembers() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 415);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(163, 104, 161, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("User Info");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(181, 58, 115, 35);
		contentPane.add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(163, 166, 161, 20);
		contentPane.add(textField_1);
		
		btnNewButton = new JButton("Register");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(116, 330, 121, 35);
		contentPane.add(btnNewButton);
		
		btnClear = new JButton("Clear");
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnClear.setBounds(274, 330, 91, 35);
		contentPane.add(btnClear);
		
		btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBack.setBounds(0, 0, 91, 35);
		btnBack.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        LibraryGUI back = new LibraryGUI();
		        back.setVisible(true);
		    }
		});
		contentPane.add(btnBack);
		
		JLabel lbID = new JLabel("ID");
		lbID.setFont(new Font("Tahoma", Font.BOLD, 19));
		lbID.setBounds(57, 96, 48, 28);
		contentPane.add(lbID);
		
		JLabel Name = new JLabel("Name");
		Name.setFont(new Font("Tahoma", Font.BOLD, 19));
		Name.setBounds(57, 158, 78, 28);
		contentPane.add(Name);
		
		JLabel Age = new JLabel("Age");
		Age.setFont(new Font("Tahoma", Font.BOLD, 19));
		Age.setBounds(57, 206, 64, 28);
		contentPane.add(Age);
		
		JLabel lblCourse_1 = new JLabel("Course");
		lblCourse_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblCourse_1.setBounds(57, 245, 78, 28);
		contentPane.add(lblCourse_1);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblYear.setBounds(57, 284, 64, 28);
		contentPane.add(lblYear);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(163, 210, 161, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(163, 253, 161, 20);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(163, 292, 161, 20);
		contentPane.add(textField_4);
	}
}
