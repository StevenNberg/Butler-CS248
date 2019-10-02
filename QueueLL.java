public class QueueLL implements Queue
{
	public class node
	{
		private Object data;
		private node next;
	}
	node front, back;
	int count;
	
	public QueueLL()
	{
		count=0;
		front=back=null;
	}

	public void enqueue(Object x)
	{
		node newnode=new node();
		newnode.data=x;
		newnode.next=null;
		if(isEmpty())
			front=newnode;
		else
			back.next=newnode;
		back=newnode;
		count++;
	}
	public Object dequeue()
	{
		if(isEmpty()) return null;
		Object saveditem=front.data;
		front=front.next;
		count--;
		return saveditem;
	}
	public Object getFront()
	{
		if(isEmpty()) return null;
		return front.data;
	}
	public boolean isEmpty() { return count<=0; }
	public boolean isFull() { return false; }
	public void makeEmpty()
	{
		count=0;
		front=back=null;
	}
	public int size() { return count; }	
}