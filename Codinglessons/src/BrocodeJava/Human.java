package BrocodeJava;

public class Human {
	String name;
	int age;
	double weight;
	String color;
	String description;
	
	
	Human(String name, int age, double weight,String color,String description){
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.color = color;
		this.description = description;
		
	}
	void eat() {
		System.out.println(this.name+" is eating ");
	}
	void age() {
		System.out.println(this.age+ " is 18 years old");
	}
	void describe() {
		System.out.println(this.description+" looks gay");
	}
}
