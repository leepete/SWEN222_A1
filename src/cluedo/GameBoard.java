package cluedo;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * The GameBoard is responsible for managing the GUI 
 * @author Peter
 *
 */

@SuppressWarnings("serial") 
public class GameBoard extends JFrame{
	
	//JFrame - organisation tool
	//JPanel - can draw on it easier/content
	/**Draws shapes for us, we need 2 copies is for the save changes*/
	private GamePanel myGamePanel;
		
	public GameBoard(){
		super("Cluedo GameBoard");
		myGamePanel = new GamePanel();
		start();
	}
	
	public void start(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true); //to see the window
		buildGUI();
	}
	
	private void buildGUI(){		
//		JPanel masterPanel = new JPanel();
//		masterPanel.add(myGamePanel);
//		add(masterPanel);
		
		
		add(myGamePanel);
		
		pack(); //resizes panel so things fit, no extra whitespace
		
	}
}
