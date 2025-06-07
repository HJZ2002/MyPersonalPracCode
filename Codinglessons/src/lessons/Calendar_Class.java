package lessons;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
import java.text.SimpleDateFormat;

public class Calendar_Class {
	public static void main(String[] args) {
		// Create a Calendar instance
		Calendar calendar = Calendar.getInstance();
		
		// Set the date to 1st Week of June 2025
		calendar.set(2025, Calendar.JUNE, 1);
		SimpleDateFormat dayformat = new SimpleDateFormat("E");
		// Get the day of the week
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		
		// Print the day of the week
		System.out.println("Day of the week for 1st JUNE 2025: " + dayOfWeek);
		
		// Create a Timer to print the current time every second
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss"); //setting up Hours minutes and seconds
			SimpleDateFormat fulldayformat = new SimpleDateFormat("EEEE");
			public void run() {
				Calendar now = Calendar.getInstance();
				String currentTime = sdf.format(now.getTime());
				String currentDay = fulldayformat.format(now.getTime());
				System.out.println("Current time: " + currentTime + " on " + currentDay);
			}
		}, 0, 1000);
		
		try {
			Thread.sleep(5000); // Let it run for 5 seconds
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}