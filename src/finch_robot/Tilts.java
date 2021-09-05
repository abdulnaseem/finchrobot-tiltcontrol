import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import edu.cmu.ri.createlab.terk.robot.finch.Finch;

public class Tilts extends JFrame {
	/*
	 * By extending JFrame, we can use all properties within that class
	 */
	
	private Finch myfinch = new Finch();//Finch object is global; can be accessed in any methods
	Random ran = new Random();//Random generator used to set wheel velocities randomly; speed is random 
	ArrayList<Integer> record = new ArrayList<Integer>();//Stores the integers of the tilt sequence
	JFrame frame = new JFrame();//Creates an object frame, calls class JFrame
	
	public ArrayList<Integer> recordFinch(int input)  { 
		//Method records the action of the Finch, takes in users input as parameter

		input = input*1000;//To measure time in seconds, we multiply milliseconds by a thousand		
	
		int []rec = new int[input];//Takes in an array of users input
		JOptionPane.showMessageDialog(frame, "Please start tilting your Finch.");//Small dialog box that instructs user

		for(int i=1;i<rec.length;i++) {
		/*
		 * It records the sequence, based on the users input
		 */
			red(input);//Method red is called out to suggest recording is in process			
			if(myfinch.isBeakUp() == true) {//if Finch beak is up; move forward,
				record.add(new Integer(1));//add integer 1 to 'record'
				return record;
			}
			if(myfinch.isBeakDown() == true) {//if Finch beak is down; move backward,
				record.add(new Integer(2));//add integer 2 to 'record'
				return record;
			}
			if(myfinch.isLeftWingDown() == true) {//if Finch left wing is down; move left,
				record.add(new Integer(3));//add integer 3 to 'record'
				return record;
			}	
			if(myfinch.isRightWingDown() == true) {//if Finch right wing is up; move right,
				record.add(new Integer(4));//add integer 4 to 'record'
				return record;
			}
			if(myfinch.isFinchLevel()==true) {//if Finch is level; stop,
				record.add(new Integer(5));//add integer 5 to 'record'
				return record;
			}
		}
		return record;
	}
	public void tiltControl(int input) {//input is determined by 'UserInput' class of 'actionPerformed' method
		
		recordFinch(input);//calls the method and takes in the users input as parameter
		myfinch.buzz(1000, 400);//Finch buzzes to suggest the end of recording

		JOptionPane.showMessageDialog(frame, "You have 2 seconds to place Finch down, the Finch will begin playing.");
		//The GUI simply instructs user, frame object is called

		myfinch.sleep(2000);//Finch sleeps for 2 seconds
			green(input);//LED will turn green to suggest Finch is playing
			
			/*
			 * The integers that have been returned to 'record'
			 * will be called out using the 'size' method of ArrayList
			 * For e.g. if record size is 1 then move forward etc.
			 */
				if(record.contains(1)) {
					beakUp();//move forward
					myfinch.sleep(500);
				}
				if(record.contains(2)) {
					beakDown();//move backward
					myfinch.sleep(500);
				}
				if(record.contains(3)) {
					leftWingDown();//move left
					myfinch.sleep(500);
				}
				if(record.contains(4)) {
					rightWingDown();//move right
					myfinch.sleep(500);
				}
				if(record.contains(5)) {
					level();//stop
					myfinch.sleep(500);
				}
		
			myfinch.buzz(1000, 400);
			myfinch.buzz(1000, 400);
			System.exit(0);		
		//After Finch finishes playing, Finch will buzz twice and quit 			
	}
	public int beakUp() {//this method makes the Finch move forward
		int forward = ran.nextInt((255-1)+1)+1;//create variable to store random value
		myfinch.setWheelVelocities(forward, forward, 500);//moving forward speed is randomly generated for 500 milliseconds
		return forward;//random value gets returned to variable
	}
	public int beakDown() {//this method makes the Finch move backwards
		int backward = ran.nextInt((1-255)+1)+1;//create variable to store random value
		myfinch.setWheelVelocities(backward, backward, 500);//moving backwards speed is randomly generated for 500 milliseconds
		return backward;//random value gets returned to variable
	}
	public int leftWingDown() {//this method turns the Finch left
		int left = ran.nextInt((255-1)+1)+1;//create variable to store random value
		myfinch.setWheelVelocities(left, 0, 500);//moving left speed is randomly generated for 500 milliseconds and right is set to 0
		return left;//random value gets returned to variable
	}
	public int rightWingDown() {//this method turns the Finch right
		int right = ran.nextInt((255-1)+1)+1;//create variable to store random value
		myfinch.setWheelVelocities(0, right, 500);//moving right speed is randomly generated for 500 milliseconds and left is set to 0
		return right;//random value gets returned to variable
	}
	public void level() {//this method stops the Finch from moving
		myfinch.stopWheels();//stops Finch 
	}
	public void red(int input) { //takes users input as parameter
		myfinch.setLED(255,0,0,input);//Finch LED is set to red, how long it stays on is based on users input
	}
	public void green(int input) { //takes users input as parameter
		myfinch.setLED(0,255,0,input);//Finch LED set to green, used for execution of the program
	}
}