package Module12ndyear;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Algorithm {

	public static void main(String[] args) {
		//getting the algo
		Integer num []= {23,56,-10,100,45,-78,90,45,69,-7};
		List data = new ArrayList(Arrays.asList(num));
		System.out.println(Algorithm.delete_algo1(num));
		System.out.println(Algorithm.delete_algo2(data));
		System.out.println(" Made by Hosea James Zacarias ");
		
	} // end of algo1
	//Algo 1
	public static String delete_algo1(Integer num[]) {
		String hold=("");
		for (int i = 0; i<num.length; i++) {
			if(num[i] > 0) {
				hold = hold + num[i] +  " ";
			}// end of algo1
		}// end of for
		return hold;	
	}
	// algo 2
	public static String delete_algo2(List data) {
		String hold = "";
		for(int j = 0 ; j<data.size();j++) {
			Integer num = (Integer)data.get(j);
			if(num>=0) {
				hold += num + " ";
			}
		}
		return hold;
	}
}
