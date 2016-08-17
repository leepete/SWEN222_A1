package test;

import cluedo.Board;
import cluedo.GameBoard;

public class CluedoTest {

	/**Testing purposes*/
	private static Board myBoard;
	/** Create this*/
	private static GameBoard myGameBoard;
	
	public static void main(String[] args) {
		//Represents Logic
		myBoard = new Board();
		System.out.println("DEBUG: this is the board");
		
		System.out.println("*************************");
		
		//Represents GUI
		myGameBoard = new GameBoard();
		myGameBoard.start();
		System.out.println("DEBUG: this is the  GUI");
	

	}

}
