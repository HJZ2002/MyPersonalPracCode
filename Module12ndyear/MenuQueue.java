package Module12ndyear;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class MenuQueue {

	public static void main(String[] args) {
		Queue q = new Queue();
		
		String mainmenu[]= {"Enqueue", "Dequeue", "Exit"};
		String choice = "",hold;
		int data;
		JOptionPane Jop = new JOptionPane();
		
		do {
			hold = "Made by Hosea James Zacarias"
					 +"\nEmpty\t: "+q.isEmpty()+"\tFull\t: "+q.isFull()
					 +"\nCapacity\t: "+q.getCapacity()+"\nSize\t: "+q.getCurrentSize()
					 +"\nPeek\t: "+q.peek()+"\tLast\t: "+q.last()
					 +"\nElements\t: "+q.display()
					 +"\nSelect";
			choice = Jop.showInputDialog(null, new JTextArea(hold),
						"MainMenu",1,null,mainmenu,mainmenu[0]).toString();
			switch(choice) {
			case"Enqueue":
				data = Integer.parseInt(Jop.showInputDialog("Enter the data"));
				q.enque(data);
				Jop.showMessageDialog(null,data + " Has been inserted:");
				break;
			case"Dequeue":
				q.dequeue();
				break;
			}
		}while(!choice.equals("End"));
	}
}