package Praccode;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyFrame extends JFrame {

private int W,H;
	
	//constructor
	public MyFrame() {
		super();//calls JFame
		H=800; W = 500;
		setWindowSize(W,H);
	}
	
	
	//user may set based on preference
	
	public MyFrame(int width,int height) {
		super();
		setWindowSize(width,height);
		
	}
	
	public MyFrame(String title,int width, int height ) {
		super(title);
		setWindowSize(width,height);	
	}
	//visible of frame
	public MyFrame(String title,int width, int height, boolean visible ) {
		super(title);
		setWindowSize(width,height);	
		setVisible(visible);
	}
	//seting windowsize
	public void setWindowSize(int width,int height) {
		H= height; W= width;
		setSize(width,height);
		
	}
	//setting frames
	public void setMyFrame(String title,int width,int height) {
		setTitle(title);
		setWindowSize(width,height);
		
	}
	public void setMyFrame(String title,int width,int height,boolean visible) {
		setMyFrame(title,width,height);
		setVisible(visible);
	}
	public void setMyFrame(String title,int width,int height,boolean visible,int close_operation) {
		setMyFrame(title,width,height,visible);
		setDefaultCloseOperation(close_operation);
	}
	
	public void setMyFrame(String title,int width,int height,boolean visible,int close_operation,boolean resize) {
		setMyFrame(title,width,height,visible,close_operation);
		setResizable(resize);
	}
	// setting background color
	public void setBackgroundColor(int red,int green,int blue,int opacity) {
		getContentPane().setBackground(new Color(red,green,blue,opacity));
	}
	
	public JPanel setBackgroundImage(String file) {
		JPanel panelBG = new JPanel();
		JLabel img = new JLabel(new ImageIcon(file));
		panelBG.add(img);//adding image
		return panelBG;
	}
}//end of class
