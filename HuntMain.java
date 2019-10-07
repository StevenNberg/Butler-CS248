import java.io.*;
import java.util.*;

class HuntMain
{
	static void checkIfNear(int curAdj[], int badGuy, int spider1, int spider2, int pit1, int pit2) // checks to see if hear hazards
	{

		for(int i=0; i<curAdj.length; i++){
			if(curAdj[i]==badGuy)
				System.out.println("You feel an increase in humidity!");
			else if(curAdj[i]==spider1|| curAdj[i]==spider2)
				System.out.println("You hear some faint clicking noises.");
			else if(curAdj[i]==pit1|| curAdj[i]==pit2)
				System.out.println("You faintly hear some extreme wind."); 
		}			
	}
	
	static boolean checkAdj(int adj[], int Room) // checks to see if room selection was possible
	{
		boolean temp = false;
		
		for(int i=0; i<adj.length; i++)
		{
			if(adj[i]==Room)
			{
				temp = true;
				break;
			}
		}
		return temp;
	}
	
	static boolean NoMatch(int[]r)
	{
		for(int i = 0; i<r.length ; i++)
			for(int j=0; j<i ; j++)
				if(r[i]==r[j])
					return false;
		return true;
	}
		
	
	public static void main(String [] args) throws IOException
	{
		Scanner gamefile;
		gamefile=new Scanner(new FileReader("WumpusFile.txt"));
		
		
		int NumRoom = gamefile.nextInt();
		
		int [] r=new int[6]; // randomNumber
		

		
		
		while(!NoMatch(r)) // produces random numbers to be designated as rooms for the hazards but with no matches
		{
			for(int i=0; i<r.length; i++)
			{
			r[i]=(int)(2+8*Math.random());
			}
		}
		
		int Wumpus=r[0];
		int SpidersOne=r[1];
		int SpidersTwo=r[2];
		int BottomlessPitOnes=r[3];
		int BottomlessPitTwos=r[4];
		int replenished=r[5];
		
		
		
		Room [] info=new Room[NumRoom];
		for(int i=0; i<info.length; i++){ 
		info[i]=new Room(gamefile); }
		
		Scanner cin=new Scanner(System.in);
		char userInput = 'M'; //cin.next().charAt(0);
		int RoomChoice=0;
		int ArrowCount=3;
		int CurRm=1; // current room player is in
		int curAdj[]=info[CurRm-1].getAdj();
		boolean GameOver = false;
		
		while(!GameOver)
		{
			
			System.out.println(info[CurRm-1].toString());
			System.out.println("You have "+ArrowCount+" arrow(s) left.");
			checkIfNear(curAdj, Wumpus, SpidersOne, SpidersTwo, BottomlessPitOnes, BottomlessPitTwos);
			System.out.println("Would you like to move or shoot?");

			System.out.println("Do you want to (M)ove or (S)hoot?");
			userInput = cin.next().charAt(0);
			if(userInput =='M') 
			{
				System.out.println("What room do you want to move in");
				RoomChoice=cin.nextInt();
						
				while(checkAdj(curAdj, RoomChoice)==false)
				{
					System.out.println("you cannot go there");
					System.out.println("Try again!");
					RoomChoice=cin.nextInt();
				}
				
				CurRm=RoomChoice;
				curAdj=info[CurRm-1].getAdj();

				
				if(RoomChoice==replenished) // extra credit, found room w/ arrows
				{
					System.out.println("You have found a room full of arrows!");
					if(ArrowCount==3)
						System.out.println("You are full of arrows. Remember this room!");
					else
						System.out.println("You have replenished "+(3-ArrowCount)+" arrows.");
					ArrowCount=3; 
				}
				if (RoomChoice==Wumpus)
				{
				System.out.println("You have found the Wumpus!");
				System.out.println("He laughs at your foolish mistake of not killing him");
				System.out.println("He then kills you...");
				GameOver=true; // game over
				}
				if(RoomChoice==SpidersOne || RoomChoice==SpidersTwo)
				{
				System.out.println("You have moved into a room full of spiders!");
				System.out.println("The spiders rip you apart limb from limb!");
				System.out.println("However, they are a sadistic species.");
				System.out.println("So they make your death both painful and slow!");
				System.out.println("How cool!");
				GameOver=true;  // game over
				}
				if(RoomChoice==BottomlessPitOnes || RoomChoice==BottomlessPitTwos)
				{
				System.out.println("You have walked right into a bottomless pit!");
				System.out.println("You will die in ten minutes due to the air pressure crushing your body");
				System.out.println("Neato!");
				GameOver=true; // game over
				}
				

			}
					
			if(userInput == 'S')
			{
				System.out.println("What room would you like to shoot in?");
				RoomChoice = cin.nextInt();
						
				if(checkAdj(curAdj, RoomChoice)==false)
				{
					System.out.println("you have shot an arrow into a wall!"); // you can't fix your arrows
					System.out.println("You have lost an arrow");
				}
				
	
				if(RoomChoice==Wumpus)
				{
				System.out.println("You have killed the Wumpus!");
				GameOver=true; // VICTORY IS MINE 
				}
				if(RoomChoice==SpidersOne || RoomChoice==SpidersTwo) // think of giant spiders from Harry Potter 
				{
				System.out.println("You shot at spiders, maiming only one of them");
				}
				if(RoomChoice==BottomlessPitOnes || RoomChoice==BottomlessPitTwos) 
				{
				System.out.println("You have shot into a bottomless pit!");
				System.out.println("You have lost an arrow");
				}
				--ArrowCount;
				if(ArrowCount==0)
				{
				System.out.println("You are out of arrows. You cannot shoot.");
				System.out.println("Game over");
				GameOver=true; // can't kill a wumpus with own fists
				}
			}
		}
	} 
} 