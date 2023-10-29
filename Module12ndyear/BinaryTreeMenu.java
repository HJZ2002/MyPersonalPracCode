package TestClassPackage;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
public class BinaryTreeMenu extends JFrame implements ActionListener,ItemListener,KeyListener{
	private JLabel lblChoose,lblValue;
	private JTextField txtValue;
	private JComboBox cboChoose;
	private JTextArea txtAreaUp,txtAreaDown;
	private JButton btnProccess,btnClose;
	private BinaryTree tree;//tree declaration
	private int value;
	
	String hold = "",traversal = "";
	BinaryTreeMenu(){
		tree = new BinaryTree();//Tree installation
		lblChoose = new JLabel("Choose");
		String menu[]= {"Add Node","Remove Node,","Search","Cut The Tree","End"};
		cboChoose = new JComboBox(menu);
		txtAreaUp = new JTextArea();
		txtAreaDown = new JTextArea();
		btnProccess = new JButton("Process");
		btnClose = new JButton("Close");
		lblValue = new JLabel("Value");
		txtValue = new JTextField();
		setTitle("Binary Tree ADT Application by Hosea James Zacarias ");
		setSize(400,300);
		getContentPane().setBackground(new Color (100,50,90,80));
		setLayout(null);
		txtAreaUp.setEditable(false);
		txtAreaDown.setEditable(false);
		display();
		add(txtAreaUp).setBounds(20,20,330,60);
		add(new JScrollPane(txtAreaDown)).setBounds(20,80,330,100);
		add(lblChoose).setBounds(20,200,60,20);
		add(cboChoose).setBounds(80,200,150,20);
		add(btnProccess).setBounds(240,200,110,60);
		add(lblValue).setBounds(20,230,100,20);
		add(txtValue).setBounds(80,230,150,20);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		btnProccess.addActionListener(this);
		cboChoose.addItemListener(this);
		txtValue.addKeyListener(this);
		btnProccess.setEnabled(false);
	}
	
	public static void main(String[] args) {
		new BinaryTreeMenu();
	}
	public void actionPerformed(ActionEvent e) {
		int i = cboChoose.getSelectedIndex();
		value = Integer.parseInt(txtValue.getText());
		 if (i == 0) {
		        if (tree.search(value)) {
		            JOptionPane.showMessageDialog(null, "Value is already added to the tree", "Created by Hosea James Zacarias", JOptionPane.INFORMATION_MESSAGE);
		        } else {
		            tree.addNode(value);
		        }
		    } else if (i == 1) {
		        if (!tree.search(value)) {
		            JOptionPane.showMessageDialog(null, "Value is not found", "Created by Hosea James Zacarias", JOptionPane.INFORMATION_MESSAGE);
		        } else {
		            tree.remove(value);
		        }
		    } else if (i == 2) {
		        if (tree.search(value)) {
		            JOptionPane.showMessageDialog(null, "Value is Found", "Created by Hosea James Zacarias", JOptionPane.INFORMATION_MESSAGE);
		        } else {
		            JOptionPane.showMessageDialog(null, "Value is not found", "Created by Hosea James", JOptionPane.INFORMATION_MESSAGE);
		        }
		    } else if (i == 3) {
		        tree.cutTheTree();
		    } else if (i == 4) {
		        System.exit(0);
		    }
		
		display();
		btnProccess.setEnabled(false);
	}
	public void itemStateChanged(ItemEvent e) {
		int i = cboChoose.getSelectedIndex();
		if (i == 0) {
			disable();
		} else if (i == 1) {
			enable();
		} else if (i == 2) {
			disable();
		} else if (i == 3) {
			disableAll();
			btnProccess.setEnabled(true);
		} else if(i == 4) {
			//disableall
			txtValue.setText("0");
			txtValue.setEditable(false);
			btnProccess.setEnabled(true);
		}
	}
	public void enable() {
		txtValue.setEditable(true);
	}
	public void disable() {
		txtValue.setEditable(true);
	}
	public void disableAll() {
		txtValue.setEditable(false);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if(e.getSource().equals(txtValue)) {
			if(e.getSource().equals(txtValue)) {
				if(!(Character.isDigit(e.getKeyChar()))) {
					e.consume();
				}
			}
		}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getSource().equals(txtValue)) {
			if(txtValue.getText().isEmpty()) {
				btnProccess.setEnabled(false);
			} else {
				btnProccess.setEnabled(true);
			}
		}
		
	}

	void display() {
		traversal = "Level Order\t: " + tree.printLevelOrder()
		+"\nInOrder\t:"+tree.printInOrder()
		+"\nPreorder\t:"+tree.printPreOrder()
		+"\nPostOrder\t:"+tree.printPostOrder()
		+"\nInternal Nodes\t:"+tree.printParents()
		+"\nLeaves\t:"+tree.printLeaves();
		txtAreaDown.setText(traversal);
		hold = "Empty\t:"+tree.isEmpty()+"\tCurrent Nodes\t:"+tree.count()
		+"\nDepth\t:"+tree.depth()+"\tHeight\t:"+tree.height()
		+"\nLevel\t:"+tree.level()+"\tType\t:"+tree.treeType();
		txtAreaUp.setText(hold);
	}
}
