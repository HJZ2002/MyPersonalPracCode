package Praccode;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.time.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;
public class MainProgram extends MyFrame implements ActionListener,MouseListener,KeyListener,WindowListener{
	// data fields for search method
	private JLabel lblSearch;
	private JTextField txtSearch;
	//database class
	private DataBase 
	db=new DataBase("Pet.txt");
	
	//data fields panelTable
	private JTable tbl_Pet;
	//table access and manipulation
	private DefaultTableModel model_pet;
	private Vector columns, rowData;
	private TableRowSorter tbl_sort;
	//data fields
	private JLabel lblID, lblName, lblType, lblGender, lblColor, lblBreed, lblPrice;
	private JTextField txtID, txtName, txtColor, txtPrice;
	private JComboBox cboGender, cboType , cboBreed;
	private Font f = new Font("Arial",Font.BOLD, 16);
	
		
	//Jpanel objexts
	private JPanel panelPetInfo, panelBirthDate , panelButtons, panelSearch , panelTable;
	//constructor
	public MainProgram() {
		initializedComponents();
		petInfo();
		loadtoComboBox();
		//settingbutton
		btnAdd = new JButton("Add New ",new ImageIcon("images/add_user.png"));
		btnClear= new JButton("Clear New ",new ImageIcon("images/clear.png"));
		
		//buttons without icons
		btnUpdate = new JButton("Update");
		btnDelete = new JButton("Delete");
		btnClose = new JButton("Close");
		add(panelPetInfo).setBounds(10,10,300,250);
		
		panelBirthdate();//calling the method
		add(panelBirthDate).setBounds(10,260,300,80);
		panelpetButtons();//method call
		//adding panel to frames
		add(panelButtons).setBounds(40,340,600,30);
		//calling the search method
		add(panelPetSearch()).setBounds(320,20,300,30);
		//calling the table method
		add(panelPetTable()).setBounds(320,50,550,250);
		//setting value of your txtID
		txtID.setText(getRowCount());
		add(setBackgroundImage("images/bg3.jpeg"));
		setMyFrame("Pet Registration Form " ,920, 612 , true,DISPOSE_ON_CLOSE,true);
		setLocationRelativeTo(null);
		
		//register the buttons to the actionlistener
		btnAdd.addActionListener(this);
		btnClear.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnDelete.addActionListener(this);
		btnClose.addActionListener(this);
		//mouse listener
		tbl_Pet.addMouseListener(this);
		txtSearch.addKeyListener(this);
		//adding keylistner
		txtName.addKeyListener(this);
		txtPrice.addKeyListener(this);
		txtColor.addKeyListener(this);
		txtColor.addMouseListener(this);
		//reseting
		resetComponents();
		//pack();
	}
	public void initializedComponents() {
		lblID = new JLabel("ID:");
		lblName = new JLabel("Name:");
		lblType = new JLabel("Type:");
		lblGender = new JLabel("Gender:");
		lblColor = new JLabel("Color:");
		lblBreed = new JLabel("Breed:");
		lblPrice = new JLabel("Price:");
		
		//setting and editing the text
		txtID = new JTextField(20);
		txtID.setEditable(false);
		
		txtName = new JTextField(20);
		txtColor = new JTextField(20);
		txtPrice = new JTextField(20);
		//combo box
		cboGender = new JComboBox();
		cboType = new JComboBox();
		cboBreed = new JComboBox();
	}//end of method
	public void petInfo() {
		panelPetInfo = new JPanel();
		panelPetInfo.setBorder(BorderFactory.createTitledBorder("Pet Registration Form"));
		panelPetInfo.setLayout(new GridLayout(7, 2));//rows and columns
		panelPetInfo.setFont(f);
		panelPetInfo.setOpaque(false);
		
		//adding components
		panelPetInfo.add(lblID); panelPetInfo.add(txtID);
		panelPetInfo.add(lblName); panelPetInfo.add(txtName);
		panelPetInfo.add(lblGender); panelPetInfo.add(cboGender);
		panelPetInfo.add(lblType); panelPetInfo.add(cboType);
		panelPetInfo.add(lblBreed); panelPetInfo.add(cboBreed);
		panelPetInfo.add(lblColor); panelPetInfo.add(txtColor);
		panelPetInfo.add(lblPrice); panelPetInfo.add(txtPrice);
		
	}
	public void panelpetButtons() {
		panelButtons = new JPanel();
		panelButtons.setLayout(new GridLayout(1,5,4,2));
		panelButtons.add(btnAdd);
		panelButtons.add(btnClear);
		
		//create an empty label as a seperator
		
		panelButtons.add(new JLabel(""));
		
		panelButtons.add(btnUpdate);
		panelButtons.add(btnDelete);
		panelButtons.add(btnClose);
	}//end of methods
	//adding the information
	public void loadtoComboBox() {
		//list of the gender for animals
		cboGender.addItem("Male");
		cboGender.addItem("Female");
		
		//text for animals
		db = new DataBase("Type.Txt");
		db.filltocomboBox(cboType);
		//breedtext
		db = new DataBase("BreedTxt");		
		db.filltocomboBox(cboBreed);
		
		//animal type
		cboType.addItem("Dog");
		cboType.addItem("Cat");
		cboType.addItem("Bird");
		cboType.addItem("Fish");

		// what type of breed
		cboBreed.addItem("Persian");
		cboBreed.addItem("Siamese");
		cboBreed.addItem("Askal");
		cboBreed.addItem("Siberian");
		cboBreed.addItem("Bulldog");
		
	}
	public void getData() {
		rowData=new Vector<String>();
		rowData.add(txtID.getText());
		rowData.add(txtName.getText());
		rowData.add(cboGender.getSelectedItem());
		rowData.add(cboType.getSelectedItem());
		rowData.add(cboBreed.getSelectedItem());
		rowData.add(txtColor.getText());
		rowData.add(txtPrice.getText());
		rowData.add(cboMonth.getSelectedItem());
		rowData.add(cboDay.getSelectedItem());
		rowData.add(cboYear.getSelectedItem());
		rowData.add(txtAge.getText());
	}//end of method for data
	//petTable
	public JPanel panelPetTable() {
		//setting the table
		panelTable = new JPanel();
		tbl_Pet = new JTable();
		model_pet = new DefaultTableModel();
		
		panelTable.setLayout(new BorderLayout());
		panelTable.add(new JScrollPane(tbl_Pet), BorderLayout.CENTER);
		
		//arrays
		String cols[]= {"ID","Name","Gender","Tybe","Breed","Color",
				"Price","Month","Day","Year","Age"};
		columns = new Vector<>();
		//looping for the array
		for (String val:cols) {
			columns.add(val);
		}
		//setcolumn to a table via model
		model_pet.setColumnIdentifiers(columns);
		// bind jtable for the defaultmodel
		tbl_Pet.setModel(model_pet);
		
		//set all the columns width the same
		tbl_Pet.setAutoResizeMode(tbl_Pet.AUTO_RESIZE_OFF);
		return panelTable;
		
	}
	//returning panel
	public JPanel panelPetSearch() {
		panelSearch= new JPanel();
		lblSearch = new JLabel("Search");
		txtSearch = new JTextField(10);
		panelSearch.setLayout(new FlowLayout(FlowLayout.LEFT,2,1));
		panelSearch.add(lblSearch);
		panelSearch.add(txtSearch);
		panelSearch.setOpaque(false);
		return panelSearch;
	}//end
	//date fields
	private JLabel lblAge;
	private JTextField txtAge;
	private JComboBox cboMonth, cboDay , cboYear;
	private int age;
	//current year
	private int currentYear = Year.now().getValue();
	//setting the buttons
	private JButton btnAdd,btnClear,btnUpdate,btnDelete,btnClose;
	
	
	public void panelBirthdate() {
		panelBirthDate = new JPanel();
		lblAge = new JLabel("Age");
		txtAge = new JTextField("0", 5);//initial value
		txtAge.setEditable(false);
		txtAge.setToolTipText("Age");
		
		//filling the months for each 
		cboMonth = new JComboBox(Month.values());
		cboDay = new JComboBox();
		cboYear = new JComboBox();
		
		// getting the birthmonth
		panelBirthDate.setLayout(new FlowLayout(FlowLayout.LEFT,1,1));
		panelBirthDate.setBorder(BorderFactory.createTitledBorder("Birthdate"));
		panelBirthDate.add(cboMonth);
		panelBirthDate.add(cboDay);
		panelBirthDate.add(cboYear);
		panelBirthDate.add(lblAge);
		panelBirthDate.add(txtAge);
		
		//for loops
		for (int i =1; i<=31; i++) {
			cboDay.addItem(i);
			cboYear.addItem(i+1970);
		}
		//let the user choose what year is the birthmonth of that animal
		cboYear.setEditable(true);
		cboYear.addActionListener(this);
		
	}
	//method that returns to the current number
	public String getRowCount() {
		return "10"+model_pet.getRowCount();
	}//end of method
	public static void main(String[]args) {
		
		new MainProgram();
	}// end of main
	@Override
	//knowing the currentYear
	public void actionPerformed(ActionEvent e) {
		//if else statment
		if(e.getSource().equals(cboYear)) {
			age = currentYear-Integer.parseInt(cboYear.getSelectedItem().toString());
			txtAge.setText(age+"");
			//else if
		} else if(e.getSource().equals(btnAdd)) {
			getData();
			//geting the row data
			model_pet.addRow(rowData);
			resetComponents();
			//esle if statment
		} else if (e.getSource().equals(btnClear)) {
			resetComponents();
		} else if (e.getSource().equals(btnUpdate)) {
			int i =tbl_Pet.getSelectedRow();
			//tbl_Pet.setValueAt(txtName.getText(),i,1);
			//tbl_Pet.setValueAt(cboGender.getSelectedItem(),i,2);
			//tbl_Pet.setValueAt(cboType.getSelectedItem(),i,3);
			//tbl_Pet.setValueAt(cboBreed.getSelectedItem(),i,4);
			//tbl_Pet.setValueAt(txtColor.getText(),i,5);
			//tbl_Pet.setValueAt(txtPrice.getText(),i,6);
			//tbl_Pet.setValueAt(cboMonth.getSelectedItem(),i,7);
			//tbl_Pet.setValueAt(cboDay.getSelectedItem(),i,8);
			//tbl_Pet.setValueAt(cboYear.getSelectedItem(),i,9);
			//tbl_Pet.setValueAt(txtAge.getText(),i,10);
			getData();
			//starts with 1
			for(int col = 1; col<tbl_Pet.getColumnCount();col++){
				tbl_Pet.setValueAt(rowData.get(col), i, col);
			}
			resetComponents();
		} else if (e.getSource().equals(btnDelete)) {
			int i=tbl_Pet.getSelectedRow();
			model_pet.removeRow(i);
			resetComponents();
		} else if (e.getSource().equals(btnClose)) {
			process();
			System.exit(0);
		}
		
	}
	public void process() {
		String records = "";
		//0 to number of rows
		for(int r = 0; r<model_pet.getRowCount();r++) {
			//number of columns
			for(int c = 0; c<model_pet.getColumnCount();c++) {
				records+=model_pet.getValueAt(r, c)+"#";
			}
			records+="\n";
		}
		db.storeToFile(records);
		//end of loop 
	}// end if statment
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource().equals(tbl_Pet)) {
			int i=tbl_Pet.getSelectedRow();
			//JOptionPane.showMessageDialog(null, "Row "+i+" is selected");
			
			txtID.setText(tbl_Pet.getValueAt(i, 0)+"");
			txtName.setText(tbl_Pet.getValueAt(i,  1)+"");
			cboGender.setSelectedItem(tbl_Pet.getValueAt(i,  2)+"");
			cboType.setSelectedItem(tbl_Pet.getValueAt(i, 3)+"");
			cboBreed.setSelectedItem(tbl_Pet.getValueAt(i, 4)+"");
			txtColor.setText(tbl_Pet.getValueAt(i, 5)+"");
			txtPrice.setText(tbl_Pet.getValueAt(i, 6)+"");
			cboMonth.setSelectedItem(tbl_Pet.getValueAt(i, 7)+"");
			cboDay.setSelectedItem(tbl_Pet.getValueAt(i, 8)+"");
			cboYear.setSelectedItem(tbl_Pet.getValueAt(i, 9)+"");
			txtAge.setText(tbl_Pet.getValueAt(i, 10)+"");
			
			tableClick();
			}else if(e.getSource().equals(txtColor)) {
				Color color = JColorChooser.showDialog(null, "Choose", Color.black);
				txtColor.setBackground(color);
				txtColor.setText("");
			}
		}// end if statment
//set the components
	public void resetComponents() {
		txtID.setText(getRowCount());
		
		btnAdd.setEnabled(true);
		btnClear.setEnabled(true);
		btnClose.setEnabled(true);
		
		btnUpdate.setEnabled(false);
		btnDelete.setEnabled(false);
		
		//clear the swing components
		txtName.setText("");
		txtPrice.setText("");
		txtColor.setText("");
		txtAge.setText("0");
		
		//setting the values by default to first index
		cboGender.setSelectedIndex(0);
		cboType.setSelectedIndex(0);
		cboBreed.setSelectedIndex(0);
		cboMonth.setSelectedIndex(0);
		cboDay.setSelectedIndex(0);
		cboYear.setSelectedIndex(0);
	}
	public void tableClick() {
		txtID.setText(getRowCount());
		btnAdd.setEnabled(false);
		btnUpdate.setEnabled(true);
		btnDelete.setEnabled(true);
	}//end method
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		if(e.getSource().equals(txtPrice)) {
			if(e.getKeyChar()>='a'&& e.getKeyChar()<='z'){
				e.consume();
			}
		}else if(e.getSource().equals(txtName) || e.getSource().equals(txtColor)) {
			char ch = e.getKeyChar();
			if(!((Character.isWhitespace(ch) || e.getKeyChar()>='a' || e.getKeyChar()>='A')
					&& (e.getKeyChar()<='z'|| e.getKeyChar()<='Z'))) {
				e.consume();
			}
		}//end of if
		
	}//end of method
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getSource().equals(txtSearch)) {
			String search=txtSearch.getText();
			tbl_sort=new TableRowSorter(model_pet);
			
			tbl_Pet.setRowSorter(tbl_sort);
			
			tbl_sort.setRowFilter(RowFilter.regexFilter(search, 0,1));

		}
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosing(WindowEvent e) {
		process();
		System.exit(0);
	}
	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}//end