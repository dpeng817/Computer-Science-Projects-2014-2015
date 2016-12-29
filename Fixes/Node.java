public class Node
	{//Two parts: one stores data and the other contains a reference to the next node in the list
		private Integer[] data;//Stores information
		private SNode next;//Reference to next node in list
		
		public Node()
		{//Default constructor
			data = null;
			next = null;
		}
		
		public Node(String i, SNode n)
		{//Accepts user input, constructor
			data = i;
			next = n;
		}
		
		public Node(String i)
		{//Accepts string
			data = i;
			next = null;
		}
		
		public Integer[] getdata()
		{//Accessor
			return data;
		}
		
		public SNode getnext()
		{//Accessor
			return next;
		}
		
		public void setdata(String i)
		{
			data = i;
		}
		
		public void setnext(SNode n)
		{
			next = n;
		}
	}