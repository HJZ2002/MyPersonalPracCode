import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;


public class AddBooks extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddBooks frame = new AddBooks();
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
	public AddBooks() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 499, 357);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(195, 193, 141, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(195, 245, 141, 25);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(195, 132, 141, 25);
		contentPane.add(textField_2);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(161, 287, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBack.setBounds(0, 0, 89, 23);
		btnBack.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        LibraryGUI addBooks = new LibraryGUI();
		        addBooks.setVisible(true);
		    }
		});
		contentPane.add(btnBack);
		
		JLabel lblNewLabel = new JLabel("New Book");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(216, 59, 120, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblName.setBounds(58, 128, 83, 25);
		contentPane.add(lblName);
		
		JLabel lblBookId = new JLabel("Book ID");
		lblBookId.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblBookId.setBounds(58, 178, 95, 25);
		contentPane.add(lblBookId);
		
		JLabel lblPublisher = new JLabel("Publisher");
		lblPublisher.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPublisher.setBounds(58, 241, 108, 25);
		contentPane.add(lblPublisher);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnClear.setBounds(271, 287, 89, 23);
		contentPane.add(btnClear);
		
	}

}
