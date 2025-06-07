package lessons;
import java.util.Calendar;
public class CalendarV2 {
	public static void main (String[]args) {
		Calendar calendar = Calendar.getInstance();
		long timeInMillis = calendar.getTimeInMillis();
		
		Object obj = Calendar.getInstance();
		long time = calendar.getTimeInMillis();
		
		if (obj instanceof Calendar) {
			Calendar cal = (Calendar) obj;
			System.out.println("Current time in milliseconds: " + cal.getTimeInMillis());
		} else {
			System.out.println("Object is not an instance of Calendar");
		}
		System.out.println("Current time in milliseconds: " + timeInMillis);
		System.out.println("Current time in milliseconds: " + time);
	}
}
