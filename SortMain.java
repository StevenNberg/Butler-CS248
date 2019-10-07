import java.io.*;
import java.util.*;
// Steven Nirenberg

class SortMain
{
	public static int runningTime(int start, int stop)
	{
		int runtime=stop-start;
		return runtime;
	}
	public static void main(String [] args) 
	{
		int start=0;
		int stop=0;
	
		Scanner cin=new Scanner(System.in);

		int size;

		System.out.println("What size list would you like");
		size=cin.nextInt();
		System.out.println("\n");
		
		Integer [] bubbleArray;
		Integer [] insertionArray;
		Integer [] selectionArray;
		Integer [] quicksortArray;
		Integer [] shellArray;
		Integer [] mergeArray;
		
		Integer [] array=new Integer [size];
		bubbleArray=new Integer[size];
		insertionArray=new Integer[size];
		selectionArray=new Integer[size];
		quicksortArray=new Integer[size];
		shellArray=new Integer[size];
		mergeArray=new Integer[size];
		
		for(int i=0; i<array.length; i++){
			int number =(int) (Math.random()*size);
			array[i]=number;

			bubbleArray[i]=array[i];
			insertionArray[i]=array[i];
			selectionArray[i]=array[i];
			quicksortArray[i]=array[i];
			shellArray[i]=array[i];
			mergeArray[i]=array[i];
		}

		start = (int)System.currentTimeMillis();
		Sorts.bubble(bubbleArray);
		stop = (int)System.currentTimeMillis();

		// bubble sort
		int runtime=runningTime(start, stop);
		System.out.println("bubble sort time: "+ runtime+" ms");

		System.out.println("--");

		// insertion sort
		start = (int)System.currentTimeMillis();
		Sorts.insertion(insertionArray);
		stop = (int)System.currentTimeMillis(); 
		runtime=runningTime(start, stop);
		System.out.println("insertion sort time: "+ runtime+" ms");


		System.out.println("--");

		// selection sort
		start = (int)System.currentTimeMillis();
		Sorts.selection(selectionArray); 
		stop = (int)System.currentTimeMillis();
		runtime=runningTime(start, stop);
		System.out.println("selection sort time: "+runtime+" ms");

		System.out.println("--");
		
		// shell sort
		start = (int)System.currentTimeMillis();
		Sorts.shell(shellArray);
		stop = (int)System.currentTimeMillis();
		runtime=runningTime(start, stop);
		System.out.println("shell sort time: "+ runtime+" ms");

		System.out.println("--");

		// quick sort
		start = (int)System.currentTimeMillis();
		Sorts.quick(quicksortArray);
		stop = (int)System.currentTimeMillis();
		runtime=runningTime(start, stop);
		System.out.println("quick sort time: "+ runtime+" ms");


		System.out.println("--");

		// merge sort
		start = (int)System.currentTimeMillis();
		Sorts.merge(mergeArray);
		stop = (int)System.currentTimeMillis();
		runtime=runningTime(start, stop);
		System.out.println("merge sort time: "+ runtime+" ms");
		System.out.println("\n");
		
		if(size<=100)
		{
			System.out.println("The random array as follows");
			for(int i=0; i<array.length; i++)
			{
				System.out.println(array[i]);
			}
			System.out.println("\n The bubble array sorted looks like this");
			for(int i=0; i<array.length; i++)
			{
				System.out.println(bubbleArray[i]);
			}
			System.out.println("\n The insertion array sorted looks like this");
			for(int i=0; i<array.length; i++)
			{
				System.out.println(insertionArray[i]);
			}
			System.out.println("\n The selection array sorted looks like this");
			for(int i=0; i<array.length; i++)
			{
				System.out.println(selectionArray[i]);
			}
			System.out.println("\n The shell sort array sorted looks like this");
			for(int i=0; i<array.length; i++)
			{
				System.out.println(shellArray[i]);
			}
			System.out.println("\n The quick sorr array sorted looks like this");
			for(int i=0; i<array.length; i++)
			{
				System.out.println(quicksortArray[i]);
			}
			System.out.println("\n The merge sort array sorted looks like this");
			for(int i=0; i<array.length; i++)
			{
				System.out.println(mergeArray[i]);
			}
		}
	}
}
