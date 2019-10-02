import java.io.*;
import java.util.*;

class FoodMain
{
	
	public static void main(String [] args) throws IOException
	{
		Scanner dinnerfile;
		dinnerfile=new Scanner(new FileReader("list.txt"));
		
		/*int timecount=0;
		int time=dinnerfile.nextInt();
		int pplSeated=0;*/
		
		// We are Queueing the party
		Queue Q=new QueueLL();

		while(!Q.isFull())
		{
			char check=dinnerfile.next().charAt(0);
			// count=dinnerfile.nextInt();
			if(check=='A')
			{
				Party bar=new Party(dinnerfile);
				Q.enqueue(bar);
			System.out.println("Please wait at the bar, \n" +" "+ bar.toString()+".");
			//timecount+=time;
			}
			
			if(check=='T'){
			//	timecount+=time;
				//Party bar=new Party(dinnerfile);;
				//Q.getFront(); this looks at first object in queue
				Party seated= (Party) Q.dequeue();
			System.out.println("Table for "+ seated.name.toString()+ "!");
			
				}
			
			if(check=='Q'){
				System.out.println("Simulation has ended");
			break;}
		}
		
		
		/*System.out.println(timecount);
		System.out.println("\n"+pplSeated);*/
		
		
		/*while(!Q.isEmpty())
			System.out.println(Q.dequeue());*/

		
		//System.out.println("average wait time was " + time variable)
		System.out.println("The following parties were never seated: \n"+"  "+Q.getFront());
		System.out.println("\nHave a nice meal!");
	}
}



