package Courseratest;
import javax.swing.*;
public class SortAlgoSelection {

	public static void main(String[] args) {
		SortAlgoSelectionV2 selec = new SortAlgoSelectionV2();
		int max = 0;
		String menu[] = { "Add Elements", "Choose", "End" };
		String sortAlgo[] = { "Bubble", "Selection", "Exchange", "Insertion", "Merge", "Quick", "Radix", "Back" };
		String choice = "", option = "", all = "", hold = "";
		JOptionPane jop = new JOptionPane();
		do {
			hold = "Tester\t\t: Hosea James Zacarias \nOriginal Elements\t: " + selec.getElements();
			choice = jop.showInputDialog(null, new JTextArea(hold + "\nChoose"), "Menu", 1, null, menu, menu[0]).toString();
			switch (choice) {
			case "Add Elements":
				max = Integer.parseInt(jop.showInputDialog("Enter max capacity: "));
				selec.setElements(max);
				break;
			case "Choose":
				do {
					option = jop.showInputDialog(null, "Choose", "Option", 1, null, sortAlgo, sortAlgo[0]).toString();
					switch (option) {
					case "Bubble":
						all += selec.bubbleSort_2();
						break;
					case "Exchange":
						all += selec.exchangeSort();
						break;
					case "Selection":
						all += selec.selectionSort();
						break;
					case "Insertion":
						all += selec.insertionSort();
						break;
					case "Merge":
						all += selec.mergeSort();
						break;
					case "Quick":
						all += selec.quickSort();
						break;
					case "Radix":
						all += selec.RadixSort();
						break;
					}// end of switch - sortAlgo
					jop.showMessageDialog(null, new JTextArea(hold + "\n" + all));
					all = "\nSorted Elements\t:" + selec.getSortedElements() + "\n";
				} while (!option.equals("Back")); 
				break;
			}// end of switch - Menu
		} while (!choice.equals("End")); 
	} 
} 