import java.util.*;
// the party class
/**
@author Steven Nirenberg
*/
public class Party
{
	// Data members
    // String arrival;
	int time;
	int partyMembers;
	String name;
	//String openTable;
	
	public static int count=0;
	
	// constructor
	/**
	Standard constructor
	@param a what lets the simulation know if a party has arrived
	@param t the time in minutes past opening time 
	@param p who many people are in the party
	@param n the name to call when table is available
	@param o lets the simulation that a table is available
	*/
	public Party(int t, int p, String n)
	{
		time=t; partyMembers=p; name=n;
		count++;
	}
	/**
	@param cin Scanner connected to a text file with Party info
	*/
	
	public Party(Scanner cin)
	{
		//arrival=cin.nextInt();
		time=cin.nextInt();
		partyMembers=cin.nextInt();
		name=cin.next();
		name=name+cin.nextLine();
		count++;
		
	}
	
	// observers
	/**
	@return a string of who has a arrived
	*/
	public int Count()
	{ return count; }
	
	
	public String toString()
	{
	return "party "+name+" of "+partyMembers+" people";
	}
	
}