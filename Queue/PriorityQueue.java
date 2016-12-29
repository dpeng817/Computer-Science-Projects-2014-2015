import java.io.*;
import java.util.*;
public class myQueue
{//Linked list based queue
	private Node first;//Reference to first node in list
	private Node last;//Reference to last node in the list
	
	public myQueue()
	{//Default constructor for Queue
		first = null;
		last = null;
	}
	
	public boolean isEmpty()
	{
		return(first==null);
	}
	
	public int Peek()
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
	
	public void enQueue(int i)
	{//Adds data in a new node at end of queue
		Node temp = last;
		Node r = new Node();
		r.setname(i);
		last = r;
		if(isEmpty())
		{
			first = last;
		}
		else
		{
			temp.setnext(last);
		}
	}
	
	public int deQueue()
	{
		if(isEmpty()) throw new NoSuchElementException("Queue underflow");
		Node temp = first;
		first=first.getnext();
		return temp.getname();
	}
}
