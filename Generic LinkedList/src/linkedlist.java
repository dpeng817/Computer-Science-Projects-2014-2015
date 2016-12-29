
public class linkedlist <T extends Comparable <T>> {
	private node<T> head;//Constructs head node
	
	public void add(T data)
	{//Adds new data to the end of the list
		if(head == null)
		{
			head = new node<T>(data);
		}
		else{
		node<T> current = head;
		node<T> prev = null;
		while(current!=null)
		{
			if(data.compareTo(current.getData())<0)
			{
				break;
			}
			else
			{
				prev = current;
				current = current.getNext();
			}
		}
		if(current==head)
		{
			node<T> temp = new node<T>(data);
			node<T> temp2 = head;
			temp.setNext(temp2);
			head = temp;
		}
		else if(current!=null)
		{
			node<T> n = new node<T>(data);
			prev.setNext(n);
			n.setNext(current);
		}
		else
		{
			node<T> n = new node<T>(data);
			prev.setNext(n);
			n.setNext(current);
		}
		}
	}
		
	public boolean remove(T input)
	{//Removes specific string from array
		node<T> Remember = head;
		node<T> Current = head;
		if(head == null)
		{
			return false;
		}
		if(head.getData().compareTo(input) == 0)
		{
			head = head.getNext();
			return true;
		}
		
		while(Current.getNext() != null)
		{
			Current = Current.getNext();
			if(Current.getData().compareTo(input) == 0)//if the desired element is found at element current
			{
				Remember.setNext(Current.getNext());
				return true;
			}
			Remember = Current;
		}
		return false;
	}
		
	public boolean check(T input)
	{//Checks to see if a specific piece of data is in the list
	 //If return is true, input is in the list, if false, input is not in list
		node<T> checker = head;//Starts at beginning of list
		boolean c = false;
		while(checker != null)
		{//Searches throughout list for input, if found, return true, else return false
			if(checker.getData().compareTo(input) == 0)
			{
				c = true;
			}
			checker = checker.getNext();
		}
		return c;
		
	}
	
	public void print()
	{//prints list
		node<T> Current = head;//Starts at beginning of list
		while(Current != null)
		{
			System.out.println(Current.getData());
			Current = Current.getNext();
		}
	}
}
