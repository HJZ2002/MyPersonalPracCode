package CoddyTech;

public class SimpleWeather {
	 public static void main(String[] args) {
	        // Initialize variables
	        boolean isSunny = true;
	        double windSpeed = 5.4;
	        int solarPanelOutput = 9;
	        int temperature = 23;
	        boolean isCloudy = false;
	        
	        // The complete logical expression
	        boolean result = true;
	        
	        // Don't delete the lines below
	        System.out.println("Checking conditions for solar energy production...");
	        System.out.println("1. Is it sunny? " + isSunny);
	        System.out.println("2. Is wind speed safe? " + (windSpeed < 10));
	        System.out.println("3. Can panels produce more? " + (solarPanelOutput < 15));
	        System.out.println("4. Is temperature good OR no clouds? " + (temperature > 20 || !isCloudy));
	        System.out.println("\nFinal result - Good day for solar energy production: " + result);
	    }
	}
