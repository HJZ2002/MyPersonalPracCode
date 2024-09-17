package MyPracCodeProcess;
import java.util.ArrayList;
public class ArrayStuff {

	public static void main(String[] args) {
		//Arraylist a resizable array 
				//          Elements can be added and remove compilation 
		ArrayList<String> food = new ArrayList<String>();
		food.add("pizza");
		food.add("bread");
		food.add("spag");
		
		food.set(0, "burger");
		food.remove(2);
		food.clear();
		for(int i =0; i<food.size();i++) {
			System.out.println(food.get(i));
		}
		
		ArrayList<ArrayList<String>> grocerrylist = new ArrayList();
		
	}

}
