import javax.sound.sampled.LineUnavailableException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MorseCode extends JFrame implements KeyListener {
	private MorseCodeFuntion morsecodefunction;
	//private text area
	private JTextArea textInputArea, morseCodeArea;
	
	public MorseCode() {
		//text of the tittel bar
		
		super("Morse Code Program Translator");
		
		//setting the size for the frame
		setSize(new Dimension(540, 760));
		setResizable(false);
		
		setLayout(null);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		getContentPane().setBackground(Color.decode("#264653"));
		setLocationRelativeTo(null);
		
		morsecodefunction = new MorseCodeFuntion();
		addGuiComponents();
		
		
	}

	private void addGuiComponents() {
		JLabel titleLable = new JLabel("Morse code Translator :)");
		
		titleLable.setFont(new Font("Dialog", Font.BOLD, 32));
		//changes the font size for the lable and font weight
		
		titleLable.setForeground(Color.WHITE);
		
		titleLable.setHorizontalAlignment(SwingConstants.CENTER);
		
		titleLable.setBounds(0, 0,540,100);
		
		//setting up the text label 
		JLabel textInputLabel = new JLabel("Text:");
		textInputLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		textInputLabel.setForeground(Color.WHITE);
		textInputLabel.setBounds(20,100,200, 30);
		// text input area
		textInputArea = new JTextArea();
		textInputArea.setFont(new Font("Dialog", Font.PLAIN,18));
		textInputArea.addKeyListener(this);
		textInputArea.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		
		// makes the words wrap to the next line
		textInputArea.setLineWrap(true);
		
		//makes it so that when the words do get wrap it does not split off
		textInputArea.setWrapStyleWord(true);
		
		JScrollPane textinputScroll = new JScrollPane(textInputArea);
		textinputScroll.setBounds(20,132,484,236);
		
		//input for the morse code
		JLabel morseCodeInputLabel = new JLabel("Morse Code");
		morseCodeInputLabel.setFont(new Font("Dialog", Font.PLAIN,  16));
		morseCodeInputLabel.setForeground(Color.WHITE);
		morseCodeInputLabel.setBounds(20,390,200,30);
		
		morseCodeArea = new JTextArea();
		morseCodeArea.setFont(new Font("Dialog", Font.PLAIN, 18));
		morseCodeArea.setEditable(false);
		morseCodeArea.setLineWrap(true);
		morseCodeArea.setWrapStyleWord(true);
		morseCodeArea.setBorder(BorderFactory.createEmptyBorder(10,10,10,10)); // Adding empty border

		JScrollPane morseCodeScroll = new JScrollPane(morseCodeArea);
		morseCodeScroll.setBounds(20,432,484,236); // setting up the size
		
		 JButton playSoundButton = new JButton("Play Sound");
	        playSoundButton.setBounds(210, 680, 100, 30);
	        playSoundButton.addActionListener(new ActionListener(){
	            @Override
	            public void actionPerformed(ActionEvent e){
	                // disable the play button (prevents the sound from getting interrupted)
	                playSoundButton.setEnabled(false);

	                Thread playMorseCodeThread = new Thread(new Runnable() {
	                    @Override
	                    public void run() {
	                        // attempt to play the morse code sound
	                        try{
	                            String[] morseCodeMessage = morseCodeArea.getText().split(" ");
	                            morsecodefunction.playSound(morseCodeMessage);
	                        }catch(LineUnavailableException lineUnavailableException){
	                            lineUnavailableException.printStackTrace();
	                        }catch(InterruptedException interruptedException){
	                            interruptedException.printStackTrace();
	                        }finally{
	                            // enable play sound button
	                            playSoundButton.setEnabled(true);
	                        }
	                    }
	                });
	                playMorseCodeThread.start();
	            }
	        });

		add(titleLable);
		add(textInputLabel);
		add(textinputScroll);
		add(morseCodeInputLabel);
		add(morseCodeScroll);
	 add(playSoundButton);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		//ignores the shift key press
		if(e.getKeyCode() == KeyEvent.VK_SHIFT) {
			String inputText = textInputArea.getText();
			
			morseCodeArea.setText(morsecodefunction.translatetoMorseCode(inputText));
		}
	}
}
