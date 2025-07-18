package CoddyTech;

public class Item_list {

	public static void main(String[] args) {
		// creating an loop for the item list
		for(int i = 1; i<= 20; i++) { // will stop at 20
			if(i == 4 || i == 13 || i == 7) {
				System.out.println("Skipping item unlucky number: " + i);
				continue; // Skip the unlucky numbers
			}
			System.out.println("Item number: " + i);
		}
	}

}
