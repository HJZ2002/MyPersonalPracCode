package Prac;

public class gugma {

	public static void main(String[] args) {
		String str = "amgug", hold ="";
		
		for(int i = str.length() - 1; i >=0; i--) {
			hold+= str.charAt(i);
		}
		System.out.println(hold);
	}

}
