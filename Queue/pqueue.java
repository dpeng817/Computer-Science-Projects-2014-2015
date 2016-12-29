class pqueue{
//add at tail, remove at head	
	private ArrayNode head, tail; 
	class ArrayNode{
	private int[] data;
	private ArrayNode next;
	public ArrayNode(int[] i, ArrayNode n)
	{
		data = i;
		next = n;
	}
	public ArrayNode getnext()
	{
		return next;
	}
	public int[] getdata()
	{
		return data;
	}
	public void setnext(ArrayNode i)
	{
		next = i;
	}
       }	
	public boolean isEmpty() {
		return head == null; 
	}
	public void enqueue(int[] i)
	//method to prioritize 'weight' additions 
	{
		ArrayNode current = head;
		ArrayNode prev = null;
		while (current!=null && i[1]>current.getdata()[1])
		{
			prev = current;
			current = current.getnext();
		}
		if (prev == null)//If first node
		{
			head = new ArrayNode(i, head);
			if (isEmpty())//If first and last node
			{
				tail = head;
			}
		}
		else 
		{
			prev.setnext(new ArrayNode (i, prev.getnext()));
			if (current==null)//if last node
			{
				tail = prev.getnext();
			}
		}
		
				
	}
	public int[] dequeue()
	{
		int[] store = head.getdata();
		head = head.getnext();
		return store;
	}
	public int[] peek() throws Exception
	{
		return head.getdata();
	}
}