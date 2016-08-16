package cluedo;

import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.ArrayList;
<<<<<<< HEAD
import java.util.Arrays;
=======
>>>>>>> 87c8cbd1ba02038ce420a2611b31047dc44a8212
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Player {

	private Character character;
	private boolean playing = true;
	private Room room = null;
	private int id;
	private int remainingSteps;
	private Position position;
	private Board board;
<<<<<<< HEAD
	//private Map<String, Position> placeMap;
	private Set<Card> hand = new HashSet<Card>();

	public Player(Character character, Board board, int id) {
		this.character = character;
		this.id = id;
		this.board = board;
		position = this.character.getStart();
	}

=======
	private CluedoGame game;
	//private Map<String, Position> placeMap;
	private Set<Card> hand = new HashSet<Card>();
	
	public Player(Character character, Board board, CluedoGame game, int id) {
		this.character = character;
		this.id = id;
		this.board = board;
		this.game = game;
		position = this.character.getStart();
	}
	
>>>>>>> 87c8cbd1ba02038ce420a2611b31047dc44a8212
	/**
	 * Returns the room that the player is in and null if they aren't in one
	 * @return
	 */
	public Room inRoom() {
		return room;
	}

	/**
	 * Gets the id of this player (their turn order)
	 * @return
	 */
	public int getID() {
		return id;
	}
	/**
	 * Returns the players position on the board
	 * @return
	 */
	public Position getPosition() {
		return position;
	}
<<<<<<< HEAD

=======
	
	
	/**
	 * Sets the position of the player
	 * @param newP
	 */
	public void setPosition(Position newP) {
		if(newP != null) {
			position = newP;			
		}
	}
	
>>>>>>> 87c8cbd1ba02038ce420a2611b31047dc44a8212
	/**
	 * Takes an input key from the user and attempts to move in that direction
	 * @return
	 */
	public void move(Scanner s) {
		remainingSteps = rollDice();
<<<<<<< HEAD

=======
		
>>>>>>> 87c8cbd1ba02038ce420a2611b31047dc44a8212
		while(remainingSteps > 0){
			System.out.println(String.format("Moves remaining: %d. Input a direction: 'W' 'A' 'S' 'D' or 'STOP'", remainingSteps));
			System.out.println(position.toString());
			String key = s.next().toUpperCase(); //Take the first string from the user
			s.nextLine();//End the line
			switch(key){
<<<<<<< HEAD
			case "W":
				if(goUp())
					remainingSteps--;
				break;
			case "A":
				if(goLeft())
					remainingSteps--;
				break;
			case "S":
				if(goDown())
					remainingSteps--;
				break;
			case "D":
				if(goRight())
					remainingSteps--;	
				break;
			case "STOP":
				remainingSteps = 0;
				break;
			default: {
				System.out.println("Invalid move input please try again");
			}
=======
				case "W":
					if(goUp())
						remainingSteps--;
					break;
				case "A":
					if(goLeft())
						remainingSteps--;
					break;
				case "S":
					if(goDown())
						remainingSteps--;
					break;
				case "D":
					if(goRight())
						remainingSteps--;	
					break;
				case "STOP":
					remainingSteps = 0;
					break;
				default: {
					System.out.println("Invalid move input please try again");
				}
>>>>>>> 87c8cbd1ba02038ce420a2611b31047dc44a8212
			}
		}
	}

	/**
	 * Returns a random(ish) number between 1 and 6 to represent the players dice roll
	 * @return
	 */
	private int rollDice() {
		Random rand = new Random();
		int roll = rand.nextInt(6) + 6; // _+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		System.out.println(String.format("DEBUG: dice rolled and was: %d", roll));
		return roll;
	}

	/**
	 * Moves the player by using the stairs, this should end the players turn
	 */
	public void useStairs() {
		Room oldRoom = room;
		room = room.getStairRoom();
<<<<<<< HEAD

=======
		//Visually move to the new room
>>>>>>> 87c8cbd1ba02038ce420a2611b31047dc44a8212
		System.out.println(String.format("DEBUG: player used stairs from %s and is now in %s", oldRoom, room));
		//Make suggestion
	}

	/**
	 * Moves the player into the room
	 * @param room
	 */
	public void enterRoom(Room entRoom) {
		if(entRoom == null) {
			System.out.println("DB: ERROR attempt to enter room failed");
		}
		System.out.println("DEBUG: entering room: " + entRoom.toString());
		this.room = entRoom;
		remainingSteps = 0;//Stop moving when we enter a room
	}

	/**
	 * Moves the player into the room
	 * @param room
	 */
	public void enterRoom(Room entRoom) {
		if(entRoom == null) {
			System.out.println("DB: ERROR attempt to enter room failed");
		}
		System.out.println("DEBUG: entering room: " + entRoom.toString());
		this.room = entRoom;
		remainingSteps = 0;//Stop moving when we enter a room
		//Make suggestion
	}

	/**
	 * Gets the door the player wishes to exit the room from and then calls move
	 */
	public void exitRoom(Scanner s) {
		Position exitMat = room.placemats[0]; //Initialise to make compiler happy 
		Map<String, Position> pM = room.placeMap;
<<<<<<< HEAD

=======
		
>>>>>>> 87c8cbd1ba02038ce420a2611b31047dc44a8212
		//Get all the possible doors from the room and map these to the letter shown on the map (determined from index)
		/*placeMap = new HashMap<String, Position>();
		for(int i = 0; i < room.placemats.length; i++) {
			placeMap.put(String.valueOf(('A'+i)), room.placemats[i]);
		}*/
<<<<<<< HEAD

=======
		
>>>>>>> 87c8cbd1ba02038ce420a2611b31047dc44a8212
		List<Position> blockMats = board.getBlockedMats(room);
		//Remove all the blocked placemats from the map of the available mats 
		for(Position p : blockMats) {
			if(pM.containsValue(p)) {
				pM.values().remove(p);
			}
		}
<<<<<<< HEAD


=======
		
>>>>>>> 87c8cbd1ba02038ce420a2611b31047dc44a8212
		//if there is no unblocked mats then END TURN
		if(pM.isEmpty()) {
			//END TURN
			System.out.println("Other players are blocking your exits, you will have to spend the turn here");
			return;
		} //else if there is more than one free mat then ASK WHERE TO LEAVE FROM
		else if (pM.size() > 1) {
			exitMat = whichExit(s);
		} //else there is only one free mat so poop the player onto that one
		else {
			//board move me to the placemat please
			exitMat = pM.get("A");
		}
		System.out.println(String.format("DB: Exitign from %s into pos %d, %d", room.toString(), exitMat.x, exitMat.y));
		room = null; //No longer in a room
<<<<<<< HEAD
		//use the exitmat probably like board.moveplayer or seomthign
	}

=======
		//Leave the room
		board.teleport(this, position, exitMat);
		position = exitMat;
		game.turnInput(s, this);
	}
	
>>>>>>> 87c8cbd1ba02038ce420a2611b31047dc44a8212
	/**
	 * Asks the player which exit they would like to leave the room from, from the available options
	 * and returns the position of the placemat
	 * @param s
	 * @return
	 */
	public Position whichExit(Scanner s) {
		Map<String, Position> pM = room.placeMap;
		Position mat = pM.values().iterator().next(); //Initialise to a random valid option
		boolean valid = false;
		while(!valid) {
			System.out.println("Which door would you like to go out? ");
			for(String label : pM.keySet())
				System.out.print(label + " ");
			String input = s.next().toUpperCase(); //Get the input from the user
			s.nextLine(); //Consume the line
			if(pM.containsKey(input)) {
				mat = pM.get(input);
				valid = true;
			}
<<<<<<< HEAD

			System.out.println("Invalid exit input please try again");

		}
		return mat;

=======
			
			System.out.println("Invalid exit input please try again");
			
		}
		return mat;
		
>>>>>>> 87c8cbd1ba02038ce420a2611b31047dc44a8212
	}

	/**
	 * Make a game ending accusation
	 */
	public void accuse(Scanner s) {
		boolean isValid = false;

		System.out.println("DEBUG: accuse called");
<<<<<<< HEAD

		String input;
		Character c = null;
		Weapon w= null;
		Room r= null;

		while(!isValid){
			System.out.println("You are accusing. Please enter a room:");
			input = s.nextLine().toUpperCase();
			r = new Room(input);
			if(Arrays.asList(CluedoGame.roomsArray).contains(r)){
				isValid = true;
			} else{
				System.out.println("Invalid Room!");
			}

		}
		isValid = false;

		while(!isValid){
			System.out.println("Please enter a weapon:");
			input = s.nextLine().toUpperCase();
			w = new Weapon(input);
			if(Arrays.asList(CluedoGame.weaponsArray).contains(w)){
				isValid = true;
			} else{
				System.out.println("Invalid Weapon!");
			}
		}
		isValid = false;

		while(!isValid){
			System.out.println("Please enter a character:");
			input = s.nextLine().toUpperCase();
			c = new Character(input);
			if(Arrays.asList(CluedoGame.charactersArray).contains(c)){
				isValid = true;
			} else{
				System.out.println("Invalid Character!");
			}
		}
		isValid = false;

		Suggestion guess = new Suggestion(r.toString(),w.toString(), c.toString());

		System.out.println("DEBUG: "+ CluedoGame.solution.toString());
		if(CluedoGame.solution.equals(guess)){ //STOP GAME
			System.out.println("***YOU WIN***");
		} else{ //CONTINUE GAME A PLAYER DOWN
			System.out.println("***YOU LOSE***");
			playing = false;
		}
	}



=======
		System.out.println("Something about asking for a room/weapon/character");
	}
	
	
	
>>>>>>> 87c8cbd1ba02038ce420a2611b31047dc44a8212
	/**
	 * Sets the players hand
	 * @param hand
	 */
	public void addCard(Card card) {
		hand.add(card);
	}
<<<<<<< HEAD

=======
	
>>>>>>> 87c8cbd1ba02038ce420a2611b31047dc44a8212
	/**
	 * Returns the players hand as a string
	 * @return
	 */
	public String handToString() {
		String s = "";
		for(Card c : hand) {
			s += c.toString() + ", ";
		}
		return s;
	}

	/**
	 * Returns true if the player is still in the game
	 */
	public boolean isPlaying() {
		return playing;
	}

	/**
	 * Attempts to move the player up 1 space
	 * Returns true if was successful
	 * @return
	 */
<<<<<<< HEAD
	private boolean goUp() {
		Position newP;
		if((newP = board.movePlayer(position, new Position(position.x,position.y-1), this)) != null) {
			position = newP;
=======
	private boolean goUp(){
		Position newP;
		if((newP = board.movePlayer(position, new Position(position.x,position.y-1), this)) != null) {
			//position = newP;
>>>>>>> 87c8cbd1ba02038ce420a2611b31047dc44a8212
			return true;
		}
		return false;
	}
	/**
	 * Attempts to move the player left 1 space
	 * Returns true if was successful
	 * @return
	 */
<<<<<<< HEAD
	private boolean goLeft() {
		//Note - Move validity is determined from the board class
		Position newP;
		if((newP = board.movePlayer(position, new Position(position.x-1, position.y), this)) != null) {
			position = newP;
=======
	private boolean goLeft(){
		//Note - Move validity is determined from the board class
		Position newP;
		if((newP = board.movePlayer(position, new Position(position.x-1, position.y), this)) != null) {
			//position = newP;
>>>>>>> 87c8cbd1ba02038ce420a2611b31047dc44a8212
			return true;
		}
		return false;
	}
	/**
	 * Attempts to move the player right 1 space
	 * Returns true if was successful
	 * @return
	 */
<<<<<<< HEAD
	private boolean goRight() {
		Position newP;
		if((newP = board.movePlayer(position, new Position(position.x+1, position.y), this)) != null) {
			position = newP;
=======
	private boolean goRight(){
		Position newP;
		if((newP = board.movePlayer(position, new Position(position.x+1, position.y), this)) != null) {
			//position = newP;
>>>>>>> 87c8cbd1ba02038ce420a2611b31047dc44a8212
			return true;
		}
		return false;
	}
	/**
	 * Attempts to move the player down 1 space
	 * Returns true if was successful
	 * @return
	 */
<<<<<<< HEAD
	private boolean goDown() {
		Position newP;
		if((newP = board.movePlayer(position, new Position(position.x, position.y+1), this)) != null) {
			position = newP;
			return true;
		}
		return false;
=======
	private boolean goDown(){
		Position newP;
		if((newP = board.movePlayer(position, new Position(position.x, position.y+1), this)) != null) {
			//position = newP;
			return true;
		}
		return false;
	}
	
	public char toChar() {
		return Integer.toString(id).charAt(0);
>>>>>>> 87c8cbd1ba02038ce420a2611b31047dc44a8212
	}

	public char toChar() {
		return Integer.toString(id).charAt(0);
	}


	public String toString() {
		return character.toString();
	}

	//Some sort of move 
}