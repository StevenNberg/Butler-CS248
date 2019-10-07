import java.io.*;
import java.util.*;
import java.math.*;

class CampMain
{
	public static void main(String [] args) throws IOException
	{
		System.out.println("Enter in file name: ");
		Scanner campfile=new Scanner(System.in);
		String filename=campfile.nextLine();
		
		Scanner fileRead=new Scanner(new FileReader(filename));
		Scanner cin=new Scanner(System.in);
		BST treebeard=new BST();

		boolean startLoop=false;

		int countBoys=0;
		int countGirls=0;
		double sumAge=0.0;
		double count=0.0;

		while(!startLoop)
		{
			char check=fileRead.next().charAt(0);
			
			if(check=='A')
			{
				System.out.println("Command A");
				if(sumAge==0)
					System.out.println("There are no campers");
					else{
						double averageAge=sumAge / count;
				System.out.println("Average age = "+averageAge+"\n"); }
			}
			if(check=='E')
			{
				System.out.println("\n Command E");
				Campers enroll=new Campers(fileRead);
				treebeard.insert (enroll);
				System.out.println("New camper added \n");
				count++;
				if(enroll.gender.equals("M"))
					countBoys++;
				else
					countGirls++;
				sumAge=sumAge+enroll.age;
			}
			if(check=='L')
			{
				System.out.println("\n Command L");
				System.out.println("Alphabetical list of Campers:");
				treebeard.reset(BST.INORDER);
				while(treebeard.hasNext()){
					System.out.println(((Campers) treebeard.getNext()).getName());}
			}
			if(check=='D')
			{
				System.out.println("\n Command D");
				Campers look=new Campers(fileRead.next(),0," ");
				System.out.println(treebeard.lookup(look));
			}
			if(check=='S')
			{
				System.out.println("\n Command S");
				System.out.println("Campers count by gender");
				System.out.print("boys = "+countBoys+"\n"+
				"girls = "+countGirls+"\n");
			}
			if(check=='W')
			{
				System.out.println("\n Command W");
				Campers withdraw = new Campers (fileRead.next(),0,"");
				treebeard.delete (withdraw);
				System.out.println("Camper withdrawn\n");
				sumAge=sumAge-withdraw.age;
				count--; 
				if(withdraw.gender.equals("M"))
					countBoys--;
				else
					countGirls--;
			}
			if(check=='P')
			{
				System.out.println("\n Command P");
				System.out.println("Preorder Traversal");
				treebeard.reset(BST.PREORDER);
				while(treebeard.hasNext()){
					System.out.println(((Campers) treebeard.getNext()).getName());}
			}
			if(check=='H'){
				System.out.print("H - Help: print a list of commands \n" +
				"E - Enroll a new camper \n" +
				"W - Withdraw a camper \n" +
				"D - Display the age and gender of a camper \n" +
				"A - Print the average age of the campers \n" +
				"L - List all camper names in alphabetical order \n" +
				"S - Print the number of boy and girl gender \n" +
				"P - List all camper names in preorder \n" +
				"Q - Quit \n");
			}
			if(check=='Q')
			{
				System.out.print("\n Command: Q \n End of program. \n Bring plenty of calomine! \n");
				startLoop=true;
			}
		}
	}
}