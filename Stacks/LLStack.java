import java.io.*;
import java.util.*;
//Chris DeCarolis
//Linked List Class
public class LLStack
	{
	
		private Node head;//Constructs head node
		public void removefront()
		{
			head = head.getnode();
		}
		
		public String gethead()
		{
			if(head!=null){
			return head.getdata();
			}
			return null;
		}
		public void add(String data)
		{//Adds new data to the end of the list
			Node Temp = new Node(data);
			Temp.setnext(head);
			head = Temp;
		}
			
		public boolean remove(String input)
		{//Removes specific string from array
			Node Remember = head;
			Node Current = head;
			if(head == null)
			{
				return false;
			}
			if(head.getdata().compareTo(input) == 0)
			{
				head = head.getnode();
				return true;
			}
			while(Current!=null)
			{
				Current = Current.getnode();
				if(Current.getdata().compareTo(input) == 0)//if the desired string is found at element current
				{
					Remember.setnext(Current.getnode());
					return true;
				}
				Remember = Current;
			}
			return false;
		}
			
		public boolean check(String input)
		{//Checks to see if a specific piece of data is in the list
		 //If return is true, input is in the list, if false, input is not in list
			Node checker = head;//Starts at beginning of list
			boolean c = false;
			while(checker != null)
			{//Searches throughout list for input, if found, return true, else return false
				if(checker.getdata().compareTo(input) == 0)
				{
					c = true;
				}
				checker = checker.getnode();
			}
			return c;
			
		}
		
		public Iter iterator()
		{//Constructor
			return new Iter();
		}
		
		private class Iter implements Iterator
		{//Iterator class
			Node Current;
			public boolean hasNext()
			{//Checks to see if there is another node after this node in the list, true if there is, false if not
				if (Current.getnode() != null)
				{
					return true;
				}
				else
				{
					return false;
				}
			}
			
			public Object next()
			{
				Current = Current.getnode();
				return Current.getdata();
			}
			
			Iter()
			{//Constructor
				Current = head;
			}
}
	}	