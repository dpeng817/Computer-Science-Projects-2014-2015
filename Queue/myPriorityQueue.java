import java.io.*;
import java.util.*;
public class myPriorityQueue
{//Linked list based queue
	private ArrayNode first;//Reference to first node in list
	private ArrayNode last;//Reference to last node in the list
	
	public myPriorityQueue()
	{//Default constructor for Queue
		first = null;
		last = null;
	}
	
	public boolean isEmpty()
	{
		return(first==null);
	}
	
	public int[] Peek()
	{
		try{
		if(isEmpty())
		{
			throw new Exception("Empty queue");
		}
		}
		catch(Exception e){System.out.println(e);}
		return first.getname();
	}
	
	public void enQueue(int[] i)
	{//Adds data in a new node at end of queue

		System.out.println("We out here");
		ArrayNode r = new ArrayNode();
		r.setname(i);
		if(isEmpty())
		{
			last = r;
			first = last;
		}
		else
		{
			ArrayNode temp = first;
			ArrayNode N = first.getnext();
			while(N.getname()[1] < N.getname()[1])
			{
				temp = temp.getnext();
				N = N.getnext();
			}
			temp.setnext(r);
			r.setnext(N);
		}
}
	public int[] deQueue()
	{
		if(isEmpty()) throw new NoSuchElementException("Queue underflow");
		ArrayNode temp = first;
		first=first.getnext();
		return temp.getname();
	}
}
