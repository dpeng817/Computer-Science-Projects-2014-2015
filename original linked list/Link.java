import java.util.Iterator;	
public class Link implements Iterable {
	private int counter;
	private LLNode head;
	private int listcount;
	private class myListIter implements Iterator {
		LLNode t;
		public myListIter() 
		{
			t = head;
		} // constructs iterator with node at head
		public boolean hasNext() {
			return t != null;
		}

		public Object next() {
			if (hasNext()) {
				Object ReturnVal = t.getData();
				t = t.getNext();
				return ReturnVal;
			} else {
				return null;
			}
		}		
	}

	public Iterator iterator() // iterator constructor
	{
		return new myListIter(); // returns new object with method myListIter
	}

	public Link() {
		head = null;
		listcount = 0;
	}

	public void addFront(String data) {
		if (head == null) {
			head = new LLNode(data);
		} else {
			LLNode temp = new LLNode(data);
			temp.setNext(head);
			head = temp;
		}
		listcount++;
	}
	public boolean remove(String data) {
		LLNode now = head;
		if (check(data) == false) {
			return false;
		} else {
			if ((head.getData()).equals(data)) {
				head = head.getNext();
				listcount--;
				return true;
			} else {
				while (!(now.getNext()).getData().equals(data)) {
					now = now.getNext();
				}
				now.setNext((now.getNext()).getNext());
				listcount--;
				return true;
			}
		}
	}
	public void print() {
		LLNode now = head;
		for (int i = 1; i <= listcount; i++) {
			if (now.getData() == null)
				break;
			else
				System.out.println(now.getData());
			now = now.getNext();
		}
	}
	public boolean check(String data) {
		LLNode now = head;
		boolean checker = false;
		int i = 1;
		while (i <= listcount) {
			if (data.compareTo(now.getData()) == 0) {
				checker = true;
			}
			now = now.getNext();
			i++;
		}
		return checker;
	}
	public int partition(int first, int last)
	{
		if(last > first)
		{
			LLNode pivot = head;
			for(int p = 1; p < first; p++)
			{
				pivot = pivot.getNext();
			}
			String pivotString = pivot.getData();
			
			int i = first; 
			LLNode divNode = pivot;
			LLNode countNode = pivot.getNext();
			for(int j = first + 1; j <= last; j++)
			{
				if((countNode.getData()).compareTo(pivotString) < 0 )
				{
					i++;
					divNode = divNode.getNext(); 
					String countString = countNode.getData(); 
					countNode.setData(divNode.getData());
					divNode.setData(countString);	
				}
				countNode = countNode.getNext();
			}
			pivot.setData(divNode.getData());
			divNode.setData(pivotString);
			return i;
		}
		return -1;
	}

	public void qsortAccess()
	{
		qsort(1, listcount);
	}	
	private void qsort(int first, int last)
	{
		if(first < last) 
		{
			int q = partition(first, last);
			qsort(first, q - 1); 
			qsort(q + 1, last); 
			}
	}					
}

