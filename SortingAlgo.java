package Courseratest;
import java.util.Random;
public class SortingAlgo {
	private int num[];
	private int hold;
	private String all;
	
	private long startTime,stopTime,elapsedTime;
	
	SortingAlgo(){num = new int[0];}
	
	SortingAlgo(int num[]) {this.num = num;};
	
	public boolean isEmpty(){return (num.length<0);}
	
	public void setElements(String elements) {
		String data[] = elements.split(",\\s*");

		if (data.length < 2 || data[data.length - 1].isEmpty()) {
			System.out.println("Format invalid! Elements must be at least 2.");
		} else {
			for (String val : data) {
				if (!val.matches("-?\\d+")) {
					System.out.println("Format invalid! Only numbers are allowed.");
				}
			}

			num = new int[data.length];
			for (int i = 0; i < num.length; i++) {
				num[i] = Integer.parseInt(data[i]);
			}
		}
	}

	public String getElements() {
		all = "";
		if(!isEmpty()) {
			for(int val:num){
				all += val + " ";
			}
		}else {
			all = "Array is Empty";
		}
		return all;
	}
	public int size(){return num.length;}
	
	
		public static void main(String[] args) {
		
		System.out.println("Tester\t: Hosea James Zacarias.");
		SortingAlgo sortingAlgo = new SortingAlgo();
		
		String elements = "12,4,-10,7@,5";
		sortingAlgo.setElements(elements);
		
		
		System.out.println("Elements\t:" +sortingAlgo.getElements());
		System.out.println("Size\t\t:" +sortingAlgo.size());
	}
}
