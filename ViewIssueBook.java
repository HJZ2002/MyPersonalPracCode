import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewIssueBook extends JFrame {
    private JPanel contentPane;
    private JTable table;

  
    private Object[][] tableData = {
        
    };

    private String[] columnNames = {
        "Issue ID", "Member ID", "Member Name", "Book Name", "Issue Date", "Return Date"
    };
    private JButton btnBack;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ViewIssueBook frame = new ViewIssueBook();
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
    public ViewIssueBook() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 951, 485);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 10, 900, 400);
        contentPane.add(scrollPane);

       
        table = new JTable(new DefaultTableModel(tableData, columnNames));

        
        scrollPane.setViewportView(table);
        
        btnBack = new JButton("Back");
        btnBack.setFont(new Font("Tahoma", Font.BOLD, 19));
        btnBack.setBounds(20, 412, 89, 23);
        btnBack.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        LibraryGUI Back = new LibraryGUI();
		        Back.setVisible(true);
		    }
		});
        contentPane.add(btnBack);
    }
}