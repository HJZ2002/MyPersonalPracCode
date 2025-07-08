package CoddyTech;

public class role_Playing {

	public static void main(String[] args) {
		
		int classNumber = 3;
		int health = 0;
		int power = 0;
		
		String ability = "";
		
		switch (classNumber) {
		case 1: // warrior
			ability = "Sword Mastery";
			health = 100;
			power =8;
			break;
			
		case 2: // mage
			ability = "spell caster";
			health = 70;
			power = 10;
			break;
		case 3: // sharp shooter
			ability = "Sharp Shooter";
			health = 80;
			power = 9;
			break;
			
		case 4: //healer
				ability = "Life Giver";
				health = 40;
				power = 7;
				break;
		case 5: //Knight class
				ability = "Shield Bearer";
				health = 90;
				power = 8;
				break;
				default:
					ability = "Unknown Class";
					health = 0;
					power = 0;
		}
		 	System.out.println("Character Creation:");
	        System.out.println("-----------------");
	        System.out.println("Class Number: " + classNumber);
	        System.out.println("Special Ability: " + ability);
	        System.out.println("Health: " + health);
	        System.out.println("Power: " + power);
	}

}
