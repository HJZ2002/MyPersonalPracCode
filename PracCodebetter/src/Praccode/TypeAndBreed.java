package Praccode;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
public class TypeAndBreed {
	
	public static void typeCRUD() throws FileNotFoundException{
		//setting the types of animals
		String all = "";
		String menu[]={"[A]dd Type","[V]iew Types", "[E]dit Type", "[D]elete Type", "[E]xit"};
		String choice="";
		ArrayList<String> AnimalTypes = new ArrayList<>();
		//file reader
		File file = new File("Type.txt");
		//scanning
		Scanner scanning = new Scanner(file);
		
		while (scanning.hasNextLine()) {
			String type = scanning.nextLine();
			AnimalTypes.add(type);
		}
		//exits the program
		while (!choice.equals("[E]xit")) {
			//letting the user choose
			choice=JOptionPane.showInputDialog(null, "Please Select", "Animal Types",
					1,null,menu,menu[0]).toString();
			
			switch(choice){
			case "[A]dd Type"://case ADD Type
				AnimalTypes.add(JOptionPane.showInputDialog("Animal Type: "));
				break;
			
			case "[V]iew Types"://case View Type
				//viewing types
				 all="Animal Types\n";
				for(int x=0;x<AnimalTypes.size();x++){
					all+=AnimalTypes.get(x)+"\n";
				}
				JOptionPane.showMessageDialog(null, new JTextArea(all));
				break;
				
			case "[E]dit Type"://Case EditType
				//editing the user
				String EditType = JOptionPane.showInputDialog("Input animal type: ");
				boolean containA = AnimalTypes.contains(EditType);
				if(containA == false) {
					JOptionPane.showMessageDialog(null, "Animal type NOT found.", null, JOptionPane.WARNING_MESSAGE);
				}else {
					int x = AnimalTypes.indexOf(EditType);
					AnimalTypes.set(x, JOptionPane.showInputDialog("Replace the animal with: "));
				}
				break;
				
			case "[D]elete Type"://case Delete Type
				//user has been decided of which animal wants to remove
				String nameB = JOptionPane.showInputDialog("Input animal type: ");
				boolean containB = AnimalTypes.contains(nameB);
				if(containB == false) {
					JOptionPane.showMessageDialog(null, "Animal type NOT found.", null, JOptionPane.WARNING_MESSAGE);
				}else {
					AnimalTypes.remove(nameB);
					JOptionPane.showMessageDialog(null, "Animal type has been removed.",null,JOptionPane.INFORMATION_MESSAGE);
				}
				break;
			}
		}
		try {
		    FileWriter writer = new FileWriter(file);
		    for (String line : AnimalTypes) {
		        writer.write(line + System.lineSeparator());
		    }
		    writer.close();
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}
	
	public static void breedCRUD() throws FileNotFoundException {
		//setting the menu
		String main[]={"[A]dd Breed","[V]iew Breeds", "[E]dit Breed", "[D]elete Breed", "[E]xit"};
		String choice="";
		ArrayList<String> breedTypes = new ArrayList<>();
		
		File breedFile = new File("Breed.txt");
		Scanner sc = new Scanner(breedFile);
		
		while (sc.hasNextLine()) {
			String type = sc.nextLine();
			breedTypes.add(type);
		}
		//exit
		while (!choice.equals("[E]xit")) {
			choice=JOptionPane.showInputDialog(null, "Please Select", "Animal Breeds",
					1,null,main,main[0]).toString();
			switch(choice){
			case "[A]dd Breed":
				breedTypes.add(JOptionPane.showInputDialog("Breed Type: "));
				break;
			
			case "[V]iew Breeds":
				String all="Breed Types\n";
				for(int x=0;x<breedTypes.size();x++){
					all+=breedTypes.get(x)+"\n";
				}
				JOptionPane.showMessageDialog(null, new JTextArea(all));
				break;
				
			case "[E]dit Breed":
				String nameA = JOptionPane.showInputDialog("Input breed: ");
				boolean containA = breedTypes.contains(nameA);
				if(containA == false) {
					JOptionPane.showMessageDialog(null, "Breed NOT found.", null, JOptionPane.WARNING_MESSAGE);
				}else {
					int idx1 = breedTypes.indexOf(nameA);
					breedTypes.set(idx1, JOptionPane.showInputDialog("Replace the breed with: "));
				}
				break;
				
			case "[D]elete Breed":
				String nameB = JOptionPane.showInputDialog("Input the breed: ");
				boolean containB = breedTypes.contains(nameB);
				if(containB == false) {
					JOptionPane.showMessageDialog(null, "Breed NOT found.", null, JOptionPane.ERROR_MESSAGE);
				}else {
					breedTypes.remove(nameB);
					JOptionPane.showMessageDialog(null, "Breed has been removed.",null,JOptionPane.INFORMATION_MESSAGE);
				}
				break;
			}
		}
		try {
		    FileWriter writer = new FileWriter(breedFile);
		    for (String line : breedTypes) {
		        writer.write(line + System.lineSeparator());
		    }
		    writer.close();
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		String menu[] = {"Animal Type", "Animal Breed"};
		String choice = JOptionPane.showInputDialog(null, "Please Select what CRUD you want to pick", "Menu",
				1,null,menu,menu[0]).toString();
		
		switch (choice) {
		case "Animal Type":
			typeCRUD();
			break;
			
		case "Animal Breed":
			breedCRUD();
			break;
		}

	}

}