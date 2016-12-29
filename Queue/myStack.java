import java.io.*;
import java.util.*;
//Chris DeCarolis
public class myStack
{
	private Node head = new Node();
	public myStack()
	{
		head = null;
	}
	
	public myStack(int data)
	{
		Node N = new Node();
		N.setname(data);
		head = N;
	}
	
	public void push(int data)
	{
		//System.out.println("push");
		Node N = new Node();
		N.setname(data);
		N.setnext(head);
		head = N;
	}
	
	public boolean isEmpty()
	{
		return head == null;
	}
	
	public int pop()
	{
		if(isEmpty())
		{
			throw new EmptyStackException();
		}
			//System.out.println("pop");
			Node temp = head;
			head = head.getnext();
			return temp.getname();
	}
	
	public int peek()
	{
		return head.getname();
	}
		
}	