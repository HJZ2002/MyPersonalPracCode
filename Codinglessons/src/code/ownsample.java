package code;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;
import java.text.DateFormat;
public class ownsample {

	public static void main(String[] args) {
		//int price = 200;
		
		// default format from the system locale
		
		//NumberFormat defaultFormat = NumberFormat.getCurrencyInstance();
		//System.out.println("Default Locale:"+ defaultFormat.format(price));
		
		
		// US local format
		//NumberFormat usFormat = NumberFormat.getCurrencyInstance (new Locale("en","US")); // if u wanna change the convertion of the format
		//System.out.println("US Locale:"+ usFormat.format(price));
		
		// France local format
		//NumberFormat frFormat = NumberFormat.getCurrencyInstance(Locale.FRANCE);
		//System.out.println("France Locale:"+ frFormat.format(price));
		
		// Japan local Format
		//NumberFormat jpFormat = NumberFormat.getCurrencyInstance(Locale.JAPAN);
		//System.out.println("Japan Locale:"+ jpFormat.format(price));
		
		
		//Date today = new Date();
		
		// default system format in the country
		//DateFormat df = DateFormat.getDateInstance(DateFormat.FULL);
		//System.out.println("Date today : " + df.format(today));
		
		//DateFormat dfUS = DateFormat.getDateInstance(DateFormat.FULL);
		//System.out.println("Date today US : " + dfUS.format(today));
		
	    double productPrice = 98765.43;
        Date currentDate = new Date();

        // custom locale for Filipino (Philippines)
        Locale filipinoPhilippines = new Locale("fil", "PH");

        // Format currency in Filipino (Philippines)
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(filipinoPhilippines);
        System.out.println("Filipino Philippines Currency: " + currencyFormat.format(productPrice));

        // Format date in Filipino (Philippines)
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL, filipinoPhilippines);
        System.out.println("Filipino Philippines Date: " + dateFormat.format(currentDate));
    }

}

