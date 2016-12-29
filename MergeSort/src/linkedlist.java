public class linkedlist <T extends Comparable <T>> {
	private node<T> head;//Constructs head node
	private int listcount = 0;
	public void add(T data)
	{//Adds new data to the end of the list
		if(head == null)
		{
			head = new node<T>(data);
		}
		else
		{
			node<T> n = new node<T>(data);
			node<T> temp = head;
			n.setNext(temp);
			head = n;
		}	
		listcount++;
		}
	
	public void insert(node<T> n)
	{
		node<T> temp = head;
		head = n;
		head.setNext(temp);
	}
	
	public node<T> remove(int i)
	{//Removes specific string from array
		node<T> Remember = head;
		node<T> Current = head;
		for(int j = 0; j<=i; j++)
		{
			Remember = Current;
			Current = Current.getNext();
		}
		Remember.setNext(Current.getNext());
		return Current;
	}
	public node<T> look(int i)
	{
		node<T> tracker = head;
		for(int j = 0; j<=i; j++)
		{tracker = tracker.getNext();}
		return tracker;
			
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
	
	public void mergesort()
	{//recursively splits linked list, then merges it back together
		domergesort();
	}
	
	public void domergesort()
	{//Calls recursively split, sort, merge
		if(this.head!=null && this.head.getNext()!=null)
		{
			linkedlist<T> list1 = split();
			/*System.out.println("_____Iteration");
			list1.print();
			System.out.println("_____");
			this.print();*/
			this.domergesort();
			list1.domergesort();
			merge(list1);
		}
	}
	
	public void merge(linkedlist<T> l)
	{//Merges this and l into just this linked list
		/*print();
		System.out.println("-");
		l.print();*/
		node<T> prev = null;
		node<T> tracker = this.head;
		node<T> ltracker = l.head;
		while(tracker!=null && ltracker!=null)
		{
			//System.out.println("Entered");
			if(tracker.getData().compareTo(ltracker.getData())<=0)
			{//If tracker is less alphabetically, since tracker is the final list we don't need to change it, keep iterating
				prev = tracker;
				tracker = tracker.getNext();
			}
			else if(ltracker.getData().compareTo(tracker.getData())<0 && prev == null)
			{//Head case where ltracker needs to be inserted in the head position
				this.head = ltracker;
				ltracker = ltracker.getNext();
				this.head.setNext(tracker);
				prev = head;
				this.listcount++;
			}	
			else
			{//If ltracker is less than, we need to insert ltracker in between prev and tracker
				prev.setNext(ltracker);
				ltracker = ltracker.getNext();
				prev = prev.getNext();
				prev.setNext(tracker);
				this.listcount++;
			}	
		}
				if(ltracker!=null)
				{//Flush all of the elements of ltracker into the list
					prev.setNext(ltracker);
				}
				/*System.out.println("--");
				System.out.println("---");*/
			}
		
	
	public linkedlist<T> split()
	{
		linkedlist<T> l = new linkedlist<T>();
		node<T> tracker = this.head;
		node<T> prev = null;
		//System.out.println(this.listcount);
		for(int i = 0; i<=this.listcount/2; i++)
		{
			prev = tracker;
			if(tracker!=null)
				tracker = tracker.getNext();
		}
		if(prev!=null)
			prev.setNext(null);
		l.head = tracker;
		l.listcount = this.listcount - this.listcount/2;
		this.listcount = this.listcount/2;
		//l.print();
		return l;
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

