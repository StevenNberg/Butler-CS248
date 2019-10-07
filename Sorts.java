public class Sorts
{
	private static void swap(Object [] list, int x, int y)
	{
		Object tmp=list[x];
		list[x]=list[y];
		list[y]=tmp;
	}
	
	private static int findmax(Comparable [] list, int length)
	{
		int max=0; // location of the max, not the value
		for(int j=1; j<=length; j++)
			if(list[max].compareTo(list[j])<0)
				max=j;
		return max;
	}
	
	public static void selection(Comparable [] list)
	{
		for(int i=list.length-1; i>0; i--)
		{
			int maxpos=findmax(list,i);
			swap(list,maxpos,i);
		}
	}
	
	public static void bubble(Comparable [] list)
	{
		boolean done=false;
		while(!done)
		{
			done=true;
			for(int i=0; i+1<list.length; i++)
				if(list[i].compareTo(list[i+1])>0)
				{ swap(list,i,i+1); done=false; }
		}
	}
	
	public static void insertion(Comparable [] list)
	{
		for(int toinsert=1; toinsert<list.length; toinsert++)
		{
			Comparable tmp=list[toinsert];
			int i;
			for(i=toinsert-1; i>=0 && 
					// list[i] > tmp
					list[i].compareTo(tmp)>0; i--)
				{ list[i+1]=list[i]; }
			list[i+1]=tmp;
		}
	}
	
	public static void stripeinsertion(Comparable [] list,
	  int gap, int offset)
	// gap = number of stripes
	// offset = position of first item in the stripe
	{
		for(int toinsert=offset+gap; toinsert<list.length; 
		  toinsert=toinsert+gap)
		{
			Comparable tmp=list[toinsert];
			int i;
			for(i=toinsert-gap; i>=0 && 
					// list[i] > tmp
					list[i].compareTo(tmp)>0; i=i-gap)
				{ list[i+gap]=list[i]; }
			list[i+gap]=tmp;
		}
	}
	
	public static void shell(Comparable [] list)
	{
		int gap=list.length/3;
		while(gap>=3)
		{
			// sort all offset in current gapsize
			for(int offset=0; offset<gap; offset++)
			{
				stripeinsertion(list,gap,offset);
			}
			gap=(int)(gap/2.2);
		}
		insertion(list);
	}
	
	public static void quick(Comparable [] list)
	{
		quickhelp(list,0,list.length-1);
	}
	
	private static void quickhelp(Comparable [] list,
		int start, int stop)
	{
		// base cases
		if(stop<=start) return; // size 0 or 1
		if(start+1==stop) // size 2
		{
			if(list[start].compareTo(list[stop])>0)
				swap(list,start,stop);
			return;
		}
		
		// recursive case
		int pivotpos=partition(list,start,stop);
	//System.out.println(start+" "+pivotpos+" "+stop);
		quickhelp(list,start,pivotpos-1);
		quickhelp(list,pivotpos+1,stop);
	}
	
	private static int partition(Comparable [] list,
		int start, int stop)
	{
		Comparable pivot=list[stop];
		int fr=start;
		for(int i=start; i<stop; i++)
		{
			if(list[i].compareTo(pivot)<0)
				// if list[i]<pivot
			{
				swap(list,i,fr);
				fr++;
			}
		}
		swap(list,fr,stop);
		return fr;
	}
	
	public static void merge(Comparable [] list)
	{
		mergehelp(list,0,list.length-1);
	}
	
	private static void mergehelp(Comparable [] list,
		int start, int stop)
	{
		// base cases
		if(stop<=start) return; // size 0 or 1
		if(start+1==stop) // size 2
		{
			if(list[start].compareTo(list[stop])>0)
				swap(list,start,stop);
			return;
		}
		// recursive case
		int mid=(start+stop)/2;
		quickhelp(list,start,mid);
		quickhelp(list,mid+1,stop);
		merger(list,start,mid,stop);
	}
	private static void merger(Comparable [] list,
		int start, int mid, int stop)
	{
		Comparable [] HA=new Comparable[stop-start+1];
		// HA = helper array
		int left=start;
		int right=mid+1;
		for(int i=0; i<HA.length; i++)
		{
			if(right>stop || left<=mid &&
				list[left].compareTo(list[right])<0)
				HA[i]=list[left++];
			else
				HA[i]=list[right++];
		}
		for(int i=0; i<list.length; i++)
			list[start+i]=HA[i];
	}
	// binary search tree maybe?
	/*private static void BST(Comparable [] list)
{
	public class treenode
	{
		Comparable data;
		treenode left;
		treenode right;
	}
	treenode root;
	int count;
	
	public BST()
	{
		root=null; count=0;
	}
	public void makeEmpty()
	{
		root=null; count=0;
	}
	
	public int size() { return count; }
	public boolean isEmpty() { return count<=0; }
	public boolean isFull() { return false; }
	
	public void insert(Comparable x)
	{
		root=inserthelp(root,x);
	}
	private treenode inserthelp(treenode r, Comparable x)
	{
		if(r==null)
		{
			treenode newnode=new treenode();
			newnode.data=x;
			newnode.left=newnode.right=null;
			count++;
			return newnode;
		}
		if(x.compareTo(r.data)<0) // x<r.data
		{
			r.left=inserthelp(r.left,x);
			return r;
		}
		else
		{
			r.right=inserthelp(r.right,x);
			return r;
		}
	}
	
	/*public void print() { printhelp(root); }
	private void printhelp(treenode r)
	{
		if(r==null) return;
		printhelp(r.left);
		System.out.println(r.data);
		printhelp(r.right);
	} }*/

	
	
}