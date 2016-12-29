public class SNode
	{//Two parts: one stores data and the other contains a reference to the next node in the list
		private String data;//Stores information
		private SNode next;//Reference to next node in list
		
		public SNode()
		{//Default constructor
			data = null;
			next = null;
		}
		
		public SNode(String i, SNode n)
		{//Accepts user input, constructor
			data = i;
			next = n;
		}
		
		public SNode(String i)
		{//Accepts string
			data = i;
			next = null;
		}
		
		public String getdata()
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