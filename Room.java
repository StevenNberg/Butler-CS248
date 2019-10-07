import java.util.*;
// My exciting Hunt the Wumpus Class
/**
@author Steven Nirenberg
*/
public class Room {
	// Room information 
	int RoomNum;
	int Adj []=new int[3];; // adjacent rooms
	String Descr; // Description of room
	
	// constructor
	/**
	Standard constructor
	@param r the room number
	@param a the adjacent rooms 
	@param d the description of the room
	*/ 
	public Room(int r, int a, String d){
		RoomNum=r; Adj[a]=a; Descr=d;
	}
	/**
	@param cin Scanner connected to a text  file with the room information
	*/
	public Room(Scanner cin){
		RoomNum=cin.nextInt();
		Adj[0]=cin.nextInt();
		Adj[1]=cin.nextInt();
		Adj[2]=cin.nextInt();
		cin.nextLine();
		Descr=cin.nextLine();
		}
		/** observers
		@return a string description of how the room situation w/ player 
		*/
		public String toString() {
		return "You are currently in room "+RoomNum+"."+"There are tunnels that lead to rooms "+Adj[0]+" "+Adj[1]+" "+Adj[2]+". "+Descr;}
		
	/** return the room number player is currently in */
	public int getRoomNum() {return RoomNum;}
	/** return the three room numbers that player can move or shoot into */
	public int [] getAdj() {return Adj;}
	/** return the description of the room the player is currently in */
	public String getDescr() {return Descr;}
		
}