package CoddyTech;

public class Continue_Sample {

	public static void main(String[] args) {
		for(int i = 1; i <= 20; i++) {
			if(i % 2 != 0) {
				continue; // Skip even numbers
			}
			System.out.println("" + i);
		}
	}

}
