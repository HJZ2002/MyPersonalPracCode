import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class FrameClock extends JFrame {
	Calendar calendar;
	SimpleDateFormat timeformat;
	SimpleDateFormat dayformat;
	SimpleDateFormat dateformat;
	JLabel timelabel;
	JLabel daylabel;
	JLabel datelabel;
	String time;
	String day;
	String date;
	// setting up the methods
	FrameClock(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Time clock made by me :)");
		this.setLayout(new FlowLayout());
		this.setSize(350,200);
		this.setResizable(true);
		this.setVisible(true);
		
		// setting up the 
		timeformat = new SimpleDateFormat("hh:mm:ss a");
		dayformat = new SimpleDateFormat("E");
		dateformat = new SimpleDateFormat(" MM  dd ,yyyy");
		timelabel = new JLabel();
		
		//font for better readable
		timelabel.setFont(new Font("Verdana",Font.PLAIN ,50));
		//color
		timelabel.setForeground(new Color(0x00FFFF));
		timelabel.setBackground(Color.black);
		timelabel.setOpaque(true);
		
		// for the daylabel
		daylabel = new JLabel();
		daylabel.setFont(new Font("Ink Free",Font.PLAIN ,32));
		
		datelabel = new JLabel();
		datelabel.setFont(new Font("Ink Free",Font.PLAIN ,25));
		this.add(timelabel);
		this.add(daylabel);
		this.add(datelabel);
		this.setVisible(true);
		 
	
		setTime();
	}
	public void setTime() {
		while(true) {
			time = timeformat.format(Calendar.getInstance().getTime());
			timelabel.setText(time);
			
			day = dayformat.format(Calendar.getInstance().getTime());
			daylabel.setText(day);
			
			date = dateformat.format(Calendar.getInstance().getTime());
			datelabel.setText(date);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		}
		
	}
}
