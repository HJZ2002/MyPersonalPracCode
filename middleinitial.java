package Courseratest;
import java.util.Scanner;
public class middleinitial {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		char firstname,secondname,thirdname,firstinitial,secondinitial,thirdinitial;
		
		System.out.println("Enter your first name");
		firstname = Character.toUpperCase(scan.next().charAt(0));
		scan.nextLine();
		
		System.out.println("Enter your second name");
		secondname = Character.toUpperCase(scan.next().charAt(0));
		scan.nextLine();
		
		System.out.println("Enter your third name");
		thirdname = Character.toUpperCase(scan.next().charAt(0));
		scan.nextLine();
		
		System.out.println("Enter your friend name");
		firstinitial = Character.toUpperCase(scan.next().charAt(0));
		scan.nextLine();
		
		System.out.println("Enter your friend second name");
		secondinitial = Character.toUpperCase(scan.next().charAt(0));
		scan.nextLine();
		
		System.out.println("Enter your friend last name");
		thirdinitial = Character.toUpperCase(scan.next().charAt(0));
		scan.nextLine();
		
		System.out.println("Your initial");
		System.out.println(display(firstname,secondname,thirdname));
		System.out.println("Your friend initial");
		System.out.println(display(firstinitial,secondinitial,thirdinitial));
		scan.close();
	}
	public static String display(char firstname, char secondname, char thirdname) {
		String show = "" + firstname + "." + secondname + "." + thirdname + ".";
		return show;
	}

}
