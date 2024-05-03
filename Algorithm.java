package Prac;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Algorithm {

	public static void main(String[] args) {
		//getting the algo
				Integer num []= {23,56,-18,100,45,-78,98,45,69,-7};
				List data = new ArrayList(Arrays.asList(num));
				System.out.println(Algorithm.delete_algo1(num,-78));
				System.out.println(Algorithm.delete_algo2(data,-78));
			} // end of algo1
			//Algo 1
			public static String delete_algo1(Integer num[],int del) {
				String hold = del+(" IS NOT FOUND ");
				for (int i = 0;i<num.length;i++) {
					if(num[i]==del) {
						hold = del+(" is deleted successfully");
						for(int j = 0; j<num.length;j++) {
							num[j]=num[j+1];
						}
						break;
					}// end of algo1
				}// end of for
				return hold;	
			}
			// algo 2
			public static String delete_algo2(List data, int del) {
				if(data.contains(del)) return del+(" is deleted sucessfully");
				else return del + (" is not found ");
			}
		}