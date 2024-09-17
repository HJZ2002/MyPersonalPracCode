package Prac;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
public class Customer {

	public static void main(String[] args) {
		String menu[]={"[A]dd Customer","[V]iew Customers","[S]earch Customers", "[E]dit Customer", "[D]elete Customer", "[E]xit"};
		//Created By Hosea James Zacarias.
		
		int MAX=10, index=1;
		
		int customer_id[]=new int[MAX];
		String customer_name[]=new String[MAX];
		String customer_gender[]=new String[MAX];
		int customer_age[]=new int[MAX];
		String choice="", all = "", hold = "";
		
		
		do{
		choice=JOptionPane.showInputDialog(null, "Please Select\nChoose the choices above", "Menu", 1, null,menu,menu[0]).toString();
		
		
		switch(choice){
		case "[A]dd Customer": //Case 1
			customer_id[index]= index;
			customer_name[index]=JOptionPane.showInputDialog("Customer Name: ");
			customer_age[index]=Integer.parseInt(JOptionPane.showInputDialog("Customer Age: "));
			customer_gender[index]=JOptionPane.showInputDialog("Customer Gender: ");
			JOptionPane.showMessageDialog(null, "Added new customer successfully");
			index++;
			break;
//finish of case 1
		case "[V]iew Customers": //Case 2
			all="Customer's Info\nID\tName\tAge\tGender\n";
			for(int x=1;x<index;x++){
				all=all+customer_id[x]+"\t"+customer_name[x]+"\t"+customer_age[x]+"\t"+customer_gender[x]+"\n";
				}
			JOptionPane.showMessageDialog(null, new JTextArea(all));
			break;
//finish of case 2
		case "[S]earch Customers": //Case 3
			//name
			String search = JOptionPane.showInputDialog("Enter Name: ");
			int x=1;
			while (x<index) {
				if (search.equals(customer_name[x])) {
						hold="Customer's Info\nID\tName\tAge\tGender\n";
						hold=hold+customer_id[x]+"\t"+customer_name[x]+"\t"+customer_age[x]+"\t"+customer_gender[x]+"\n";
						break;
					}else {
						hold = "Sorry " + search + " No found.";
				}
				x++;
			}
			JOptionPane.showMessageDialog(null, new JTextArea(hold));
			break;
//finish of case 3
		case "[E]dit Customer": //Case 4
			//Edit
			String EditcustomerName = JOptionPane.showInputDialog("Enter Name to edit: ");
			int v=1;
			while (v<index) {
				if(EditcustomerName.equals(customer_name[v])) {
					hold = "Change successful\nID\tName\tAge\tGender\n";
					customer_name[v]=JOptionPane.showInputDialog("Customer Name: ");
					customer_age[v]=Integer.parseInt(JOptionPane.showInputDialog("Customer Age: "));
					customer_gender[v]=JOptionPane.showInputDialog("Customer Gender: ");
					
					hold += customer_id[v]+"\t"+customer_name[v]+"\t"+customer_age[v]+"\t"+customer_gender[v]+"\n";
					break;
				}else {
					hold = "Sorry, " + EditcustomerName + " cannot be found.";
				}
				v++;
			}
			JOptionPane.showMessageDialog(null, new JTextArea(hold));
			break;
			
//finish of case 4
		case"[D]elete Customer"://case5
			//Delete name 
			String DeleteName= JOptionPane.showInputDialog("Enter Name to delete:");
			int a = 1;
			while(a<index) {
				if(DeleteName.equals(customer_name[a])) {
					//delete the name
					hold= customer_name[a]+" has been remove from your list:";
					for(int i = a; i<index; i++) {
						customer_id[i]=customer_id[i];
						customer_name[i]=customer_name[i+1];
						customer_age[i]=customer_age[i+1];
						customer_gender[i]=customer_gender[i+1];
						
					}
					index--;
					break;
					
				} else {
					hold = " Sorry "  + DeleteName + " No found try again";
				}
				a++;
			}
			JOptionPane.showMessageDialog(null, new JTextArea(hold));
			break;
//finish of case 5
		case "[E]xit": //Case 6
			System.exit(0);
//finish of case 6
		}
	//finish
	}while(!choice.equals("[E]xit"));
}
}
