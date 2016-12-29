import java.io.*;
public class travStack { 
	private qNode head=null;
	class qNode{
		public qNode next; 
		public char data;
		public qNode(qNode n, char c) {
			next = n;
			data = c;
		}
		public char getdata() 
		{
			return data;
		}
		public qNode getnext()
		{
			return next;
		}
		public void setnext(qNode q)
		{
			next = q;
		}
	}
	public void push(char data)
	{
		head = new qNode (head, data);
	}
	public char pop() 
	{
		qNode current = head; 
		head = current.getnext();
		return current.getdata();
		      
         }
 	public boolean isEmpty()
	{
		return head == null; 
	}
	public int peek()
	{
		return head.getdata();
	}
 }