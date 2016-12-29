public class SNode
	{//Two parts: one stores data and the other contains a reference to the next node in the list
		private Integer[] data;//Stores information
		private SNode next;//Reference to next node in list
		
		public SNode()
		{//Default constructor
			data = null;
			next = null;
		}
		
		public SNode(Integer[] i, SNode n)
		{//Accepts user input, constructor
			data = i;
			next = n;
		}
		
		public SNode(Integer[] i)
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
		
		public void setdata(Integer[] i)
		{
			data = i;
		}
		
		public void setnext(SNode n)
		{
			next = n;
		}
	}