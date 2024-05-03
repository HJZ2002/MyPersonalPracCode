import java.awt.EventQueue;
import javax.swing.JScrollPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewBooks extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private DefaultTableModel tableModel;

    public ViewBooks() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1048, 409);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

       // table model with columns.
        String[] columnNames = {"Book ID", "Name", "Publisher"};
        tableModel = new DefaultTableModel(columnNames, 0);

        // with the table model.
        table = new JTable(new DefaultTableModel(
        	new Object[][] {
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        	},
        	new String[] {
        		"Book ID", "Name", "Publisher"
        	}
        ));
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 10, 1010, 300);
        contentPane.add(scrollPane);

        // Button for deleting selected rows.
        JButton btnDelete = new JButton("Delete");
        btnDelete.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnDelete.setBounds(10, 336, 100, 23);
        contentPane.add(btnDelete);
        
        JButton btnBackbutton = new JButton("Back");
        btnBackbutton.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnBackbutton.setBounds(903, 336, 89, 23);
        contentPane.add(btnBackbutton);
        btnBackbutton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        LibraryGUI back = new LibraryGUI();
		        back.setVisible(true);
		    }
		});
        btnDelete.addActionListener(e -> deleteSelectedRows());

    }

    
    private void deleteSelectedRows() {
        int[] selectedRows = table.getSelectedRows();

        for (int i = selectedRows.length - 1; i >= 0; i--) {
            tableModel.removeRow(selectedRows[i]);
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                ViewBooks frame = new ViewBooks();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}