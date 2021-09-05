import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UserInput extends JFrame implements ActionListener{
	/*
	 * This is the sub-class of JFrame; all components of JFrame can be accessed
	 * 'ActionListener' is an interface
	 * A class that implements 'ActionListener' must use 'actionPerformed' method
	 */

	String [] userInput = {"Select a value",
			"1","2","3","4","5","6",
			"7","8","9","10","11","12","13",
			"14","15","16","17","18","19","20"};//ComboBox will consist of these values
		
	JComboBox<String> list = new JComboBox<String>(userInput);
	/*
	 * The ComboBox takes in 'userInput' as parameter, 
	 * to show these values within the ComboBox. 
	 */
		
	JLabel text = new JLabel();
	JLabel text2 = new JLabel();
	JLabel text3 = new JLabel();
	JLabel text4 = new JLabel();
	JLabel text5 = new JLabel();
	JLabel text6 = new JLabel();
	/*
	 * These JLabel text objects will consist of the text that instructs the user
	 * what to do, they will be included within the JFrame
	 */
	
	Tilts tControl = new Tilts();//Call the class 'Tilts' that initiates all the sequence of the program
	
	public UserInput() {
		setLayout(new FlowLayout());//Provides a simple layout on the JFrame
		
		text = new JLabel("Tilt the Finch in the following five directions.");
		text2 = new JLabel("BeakUp = forward, BeakDown = backward, LeftWingDown = left,");
		text3 = new JLabel(" RighWingDown = right and Level = stop.");
		text4 = new JLabel("Choose the values provided below.");
		text5 = new JLabel("The values determine how long you would like for");
		text6 = new JLabel(" the Finch to record the sequence of the movements.");
		
		/*
		 * The above object texts will show up on the frame or UI
		 * Created each text object to suggest new line
		 */
			text.setFont(new Font("calibri", Font.PLAIN, 16));//sets the font size, and style
			text2.setFont(new Font("calibri", Font.PLAIN, 16));//sets the font size, and style
			text3.setFont(new Font("calibri", Font.PLAIN, 16));//sets the font size, and style
			text4.setFont(new Font("calibri", Font.BOLD, 16));//sets the font size, and style
			text5.setFont(new Font("calibri", Font.PLAIN, 16));//sets the font size, and style
			text6.setFont(new Font("calibri", Font.PLAIN, 16));//sets the font size, and style

		setLocation(690, 300);//Determines the location of the frame
		setSize(520,235);//This determines the size of the frame, width & height
		setTitle("Tilt Control");//This is the frames title
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Option to close frame
		
		list.setSelectedIndex(0);//Index suggests which value should show up on the drop-down list first
		list.addActionListener(this);//'this' is referred to the current object
		
		add(text);
		add(text2);
		add(text3);
		add(text4);
		add(text5);
		add(text6);
		
		/*
		 * adds the texts onto the frame 
		 */
		add(list);//adds the drop-down list of values onto frame	
	}
	public void actionPerformed(ActionEvent e) {//This method links the 'list' object to the 'Tilts' class
		
		if(e.getSource()==list) {
		/*
		 * getSource returns the event initially occurred, if the event equals the list value
		 * then do the following....
		 */		
			JComboBox values = (JComboBox)e.getSource();
			String recAttempt = (String)values.getSelectedItem();
			/* The 'values' records the event, or event of the user
			 * where the event is stored in the String variable 'recAttempt'
			 */
			switch(recAttempt) {//Tests the variable
			
				case "1":tControl.tiltControl(1);
					break;//Termination
			/* This is linked with the 'userInput,' if you choose '1' then the object 'tControl'
			 * calls out the method 'tiltControl' and takes 1 as parameter; 
			 * 1 represents 1 seconds, this is repeated for all cases
			 */
				case "2":tControl.tiltControl(2);
					break;
				case "3":tControl.tiltControl(3);
					break;
				case "4":tControl.tiltControl(4);
					break;
				case "5":tControl.tiltControl(5);
					break;
				case "6":tControl.tiltControl(6);
					break;
				case "7":tControl.tiltControl(7);
					break;
				case "8":tControl.tiltControl(8);
					break;
				case "9":tControl.tiltControl(9);
					break;
				case "10":tControl.tiltControl(10);
					break;
				case "11":tControl.tiltControl(11);
					break;
				case "12":tControl.tiltControl(12);
					break;
				case "13":tControl.tiltControl(13);
					break;
				case "14":tControl.tiltControl(14);
					break;
				case "15":tControl.tiltControl(15);
					break;
				case "16":tControl.tiltControl(16);
					break;
				case "17":tControl.tiltControl(17);
					break;
				case "18":tControl.tiltControl(18);
					break;
				case "19":tControl.tiltControl(19);
					break;
				case "20":tControl.tiltControl(20);
					break;
				default: text.setText("Error, restart the program!");
				// Error message will pop up if something goes wrong		
			}	
		}
	}
}