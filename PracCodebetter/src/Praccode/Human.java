package Praccode;

public class Human {
	int age;
	String name;
	double weight;
	
	
	Human(int age, String name, double weight){
		this.age = age;
		this.name = name;
		this.weight = weight;
		
	}
	void eat() {
		System.out.println(this.name+"is eating food");
	}
}
