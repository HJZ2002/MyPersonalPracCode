package Praccode;
import java.io.*;
import java.util.*;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
public class DataBase {
	private File file =null;
	private FileWriter fWirte = null;
	private FileReader fread = null;
	private Scanner scan =null;
	private Vector<String> row, column;
	
	public DataBase(String fileName) {
		file = new File(fileName);
	}
	public void setFileName(String fileName) {
		new DataBase(fileName);
		
	}
	public void filltocomboBox(JComboBox<String> combo) {
		try {
			fread= new FileReader(file);
			scan = new Scanner(fread);
			while(scan.hasNext()) {
				combo.addItem(scan.nextLine());
			}// end
		} catch (Exception e) {
			errorMessage("Error 103: fillToComboBox\n"+e.getMessage());
		}//end of try
	}
	public String getFileName() { return file.getName();}
	//setting the error message
	
	public void errorMessage(String msg) {
		JOptionPane.showMessageDialog(null, msg,"Error",JOptionPane.ERROR_MESSAGE);
	}
	
	//Store Information to  a file
	public void storeToFile(String records) {
		try {
				fWirte = new FileWriter(file);
				fWirte.write(records);
				fWirte .flush();
		} catch(Exception e) {
			errorMessage("Error 101: storeToFile\n"+e.getMessage());
			
		}
	}//end of store to file
}
