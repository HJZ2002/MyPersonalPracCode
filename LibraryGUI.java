import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;


public class LibraryGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtLibraryManagment;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LibraryGUI frame = new LibraryGUI();
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
	public LibraryGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 970, 572);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton Exit = new JButton("Exit");
		Exit.setBounds(374, 455, 262, 29);
		Exit.setFont(new Font("Tahoma", Font.PLAIN, 22));
		Exit.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		       System.exit(0);
		    }
		});
		contentPane.add(Exit);
		
		txtLibraryManagment = new JTextField();
		txtLibraryManagment.setText("Library Management System");
		txtLibraryManagment.setFont(new Font("Tahoma", Font.PLAIN, 33));
		txtLibraryManagment.setBounds(289, 0, 436, 54);
		contentPane.add(txtLibraryManagment);
		txtLibraryManagment.setColumns(10);
		
		JButton btnIssueBook = new JButton("Issue Book");
		btnIssueBook.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnIssueBook.setBounds(374, 350, 262, 29);
		btnIssueBook.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        IssueBook Issue = new IssueBook();
		        Issue.setVisible(true);
		    }
		});
		contentPane.add(btnIssueBook);
		
		JButton btnReturnBook = new JButton("Return Book");
		btnReturnBook.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnReturnBook.setBounds(374, 404, 262, 29);
		btnReturnBook.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        ReturnBook Return = new ReturnBook();
		        Return.setVisible(true);
		    }
		});
		contentPane.add(btnReturnBook);
		
		
		JButton btnAddBooks = new JButton("Add books");
		btnAddBooks.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnAddBooks.setBounds(374, 65, 262, 29);
		btnAddBooks.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        AddBooks addBooks = new AddBooks();
		        addBooks.setVisible(true);
		    }
		});
		contentPane.add(btnAddBooks);
		
		JButton btnViewbooks = new JButton("ViewBooks");
		btnViewbooks.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnViewbooks.setBounds(374, 130, 262, 29);
		btnViewbooks.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        ViewBooks viewBooks = new ViewBooks();
		        viewBooks.setVisible(true);
		    }
		});
		contentPane.add(btnViewbooks);
		
		JButton btnViewissuebooks = new JButton("View Issue Books");
		btnViewissuebooks.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnViewissuebooks.setBounds(374, 292, 262, 29);
		btnViewissuebooks.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        ViewIssueBook ViewIssue = new ViewIssueBook();
		        ViewIssue.setVisible(true);
		    }
		});
		contentPane.add(btnViewissuebooks);
		
		JButton btnAddmembers = new JButton("Add members");
		btnAddmembers.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnAddmembers.setBounds(374, 180, 262, 29);
		btnAddmembers.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        AddMembers addmember = new AddMembers();
		        addmember.setVisible(true);
		    }
		});
		contentPane.add(btnAddmembers);
		
		JButton btnViewMembers = new JButton("View Members");
		btnViewMembers.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnViewMembers.setBounds(374, 234, 262, 29);
		contentPane.add(btnViewMembers);
		btnViewMembers.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        ViewMembers View = new ViewMembers();
		        View.setVisible(true);
		    }
		});
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\zacca\\Downloads\\large-collection-old-books-wooden-shelves-generated-by-ai_188544-29739 (1).jpg"));
		lblNewLabel.setBounds(0, 0, 960, 537);
		contentPane.add(lblNewLabel);
	}
}
