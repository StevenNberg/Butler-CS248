public class BST // binary search tree
{
	private class treenode
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
	
	public Comparable lookup(Comparable x)
	{
		return lookhelp(root,x);
	}
	private Comparable lookhelp(treenode r, Comparable x)
	{
		if(r==null) return null;
		if(x.compareTo(r.data)==0)
			return r.data;
		if(x.compareTo(r.data)<0)
			return lookhelp(r.left,x);
		else
			return lookhelp(r.right,x);
	}
	
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
	
	public Comparable delete(Comparable x)
	{
		root=deletehelp(root,x);
		return saveditemtodelete;
	}
	Comparable saveditemtodelete;
	private treenode deletehelp(treenode r, Comparable x)
	{
		if(r==null)
		{
			return null;
		}
		if(r.data.compareTo(x)==0) // x is in the root
		{
			// count children
			// 0 children
			if(r.left==null && r.right==null)
			{
				count--;
				saveditemtodelete=r.data;
				return null;
			}
			if(r.left==null) // 1 child, a right child
			{
				count--;
				saveditemtodelete=r.data;
				return r.right;
			}
			if(r.right==null) // 1 child, a left child
			{
				count--;
				saveditemtodelete=r.data;
				return r.left;
			}
			// 2 children
			Comparable is=min(r.right); // is=inorder successor
			// min(r) is the smallest data item in r's subtree
			r.right=deletehelp(r.right,is);
			saveditemtodelete=r.data;
			r.data=is;
			return r;
		}
		if(x.compareTo(r.data)<0)
		{
			r.left=deletehelp(r.left,x);
			return r;
		}
		else
		{
			r.right=deletehelp(r.right,x);
			return r;
		}
	}
	
	private Comparable min(treenode r)
	{
		if(r==null) return null;
		if(r.left==null) return r.data;
		return min(r.left);
	}
	
	public void print() { printhelp(root); }
	private void printhelp(treenode r)
	{
		if(r==null) return;
		printhelp(r.left);
		System.out.println(r.data);
		printhelp(r.right);
	}
	
	Queue fangorn;
	
	public static final int PREORDER=0;
	public static final int INORDER=1;
	public static final int POSTORDER=2;
	
	public void reset(int order)
	{
		if(fangorn==null)
			fangorn=new QueueLL();
		else
			fangorn.makeEmpty();
		traversal(root,order);
	}
	
	void traversal(treenode r, int order)
	{
		if(r==null) return;
		if(order==PREORDER) fangorn.enqueue(r.data);
		traversal(r.left,order);
		if(order==INORDER) fangorn.enqueue(r.data);
		traversal(r.right,order);
		if(order==POSTORDER) fangorn.enqueue(r.data);
	}
	
	public Comparable getNext()
	{
		return (Comparable) fangorn.dequeue();
	}
	public boolean hasNext()
	{
		return !fangorn.isEmpty();
	}
}