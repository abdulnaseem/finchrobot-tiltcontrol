import java.awt.FlowLayout;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.logging.Logger;

import javax.swing.*;

public class Tasks extends JFrame {
	/*
	 * This is the sub-class of JFrame; all components of JFrame can be accessed
	*/

	String [] tasks = {"Select the Task","Search for Light","Draw Shape","Navigate",
			"ZigZag","Detect Objects","Dance","Tilt Control"};//ComboBox will take these values
	
	JComboBox<String>list = new JComboBox<String>(tasks);
	/*
	 * The ComboBox takes in 'tasks' as parameter, 
	 * to show these values within the ComboBox. 
	 */
	
	JButton open = new JButton("Accept");//The button will navigate to another JFrame
	private JLabel text;//Consists on the JFrame
	
	UserInput tiltC = new UserInput();//Option 'Tilt Control' will navigate to this JFrame
	GUI formApplication = new GUI();
	FinchDanceGUI finchdanceGUI = new FinchDanceGUI();	
	Finchnavigation nav = new Finchnavigation();
	Finchassignment search = new Finchassignment();
	ConstructorCode shape = new ConstructorCode();

	 
	public Tasks() {
	
		setLayout(new FlowLayout());//Provides a simple layout on the JFrame
		
		text = new JLabel("Select the task you wish to execute:  ");//Text that instructs the user 
		
		setSize(400,150);//Sets the JFrame size
		setTitle("Assignment 2");//Sets the JFrame title
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/*
		 * Option to close the frame, without this it will not officially close however, 
		 * it will set the frame visible to false.
		 */
		
		add(text);
		add(list);
		add(open);
		/*
		 * 'add' simply adds the ComboBox, JButton and JLabel on the JFrame
		 */
		
		open.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent openE) {
				/*
				 * The following event is the action when choosing the task from the JComboBox
				 * and clicking onto the JButton, it will lead to the next JFrame
				 */
				String task = list.getSelectedItem().toString();//obtains the list; gets the string array 'tasks'...
				switch(task) {//Tests the variable
				
				case "Tilt Control": tiltC.setVisible(true);
				/*
				 * ...then compares to the selected list
				 * Once the button is pressed, it sets the 'UserInput' class as visible;
				 * the JFrame will show up.
				 */
					break;//termination
					
				case "ZigZag" : formApplication.setVisible(true);
				try {
					for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
						if ("".equals(info.getName())) {
							javax.swing.UIManager.setLookAndFeel(info.getClassName());
							break;
						}
					}
				} catch (ClassNotFoundException ex) {
					Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
				} catch (InstantiationException ex) {
					Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
				} catch (IllegalAccessException ex) {
					Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
				} catch (javax.swing.UnsupportedLookAndFeelException ex) {
					Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
				}
					break;
					
				case "Dance" : finchdanceGUI.setVisible(true);
					break;
					
				case "Navigate" : nav.runProgram();
					break;
				
				case "Search for Light" : search.turnFinchOn();
					break;
					
				case "Detect Objects" : WelcomePage.main(null);
					break;
					
				case "Draw Shape" : try {
						shape.main();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
					
					
				default:text.setText("Error, restart the program!");
				}
			}
		});		
	}	
}