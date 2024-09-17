package BrocodeJava;
import java.util.Random;
public class DiceRoller {
	//local variables
	Random rand;
	int number =0;
	
	DiceRoller(){
		//global variables
		Random rand = new Random();
		int number = 0;
		roll();
	}
	//global variables
	void roll(){
		number = rand.nextInt(6) +1;
		System.out.println(number);
	}
}
