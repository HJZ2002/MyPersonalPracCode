package lessons;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.awt.*;
import javax.swing.*;
import javax.swing.Timer;

public class Calendar_Class_GUI extends JFrame {
	private JLabel timeLabel;
	private JLabel dayLabel;
	private JLabel monthLabel;
	private JLabel yearLabel;
	private JLabel daynumberLabel;
	private SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
	private SimpleDateFormat fulldayFormat = new SimpleDateFormat("EEE");
	private SimpleDateFormat monthFormat = new SimpleDateFormat("MMMM");
	private SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
	private SimpleDateFormat daynumberFormat = new SimpleDateFormat("dd");
	
	//call upon the class constructor to set up the GUI
	public Calendar_Class_GUI() {
        setTitle("Calendar GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 1));
        setResizable(false);

        timeLabel = new JLabel();
        dayLabel = new JLabel();
        monthLabel = new JLabel();
        yearLabel = new JLabel();
        daynumberLabel = new JLabel();
       
        add(timeLabel);
        add(dayLabel);
        add(monthLabel);
        add(yearLabel);
        add(daynumberLabel);

        // Set the date to 1st June 2025 and get the day of the week
        Calendar calendar = Calendar.getInstance();
        calendar.set(2025, Calendar.JUNE, 1);
        SimpleDateFormat dayFormat = new SimpleDateFormat("E");
        String dayOfWeek = dayFormat.format(calendar.getTime());
       
		// Add a label to display the day of the week
        updateDateTime();
        setSize(300, 230);
        setLocationRelativeTo(null);
        setVisible(true);
        

        // Timer to update current time and date
        Timer timer = new Timer(1000, e -> updateDateTime());
        timer.start();
    }

    public void updateDateTime() {
        Calendar now = Calendar.getInstance();
        timeLabel.setText("Current Time: " + timeFormat.format(now.getTime()));
        dayLabel.setText("Day: " + fulldayFormat.format(now.getTime()));
        monthLabel.setText("Month: " + monthFormat.format(now.getTime()));
        yearLabel.setText("Year: " + yearFormat.format(now.getTime()));
        daynumberLabel.setText("Day Number: " + daynumberFormat.format(now.getTime()));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Calendar_Class_GUI::new);
    }
}
