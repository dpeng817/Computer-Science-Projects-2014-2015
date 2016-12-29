
public class node
{//Node class for 234 tree
	private node[] children = new node[4];
	private String[] data = new String[3];
	private int datacount = 0;
	private boolean[] flags = new boolean[3];
	
	public node()
	{
		datacount = 0;
	}
	
	public node(String s, node n1, node n2, node n3, node n4)
	{
		insertchild(0, n1);
		insertchild(1, n2);
		insertchild(2, n3);
		insertchild(3, n4);
		for(int i = 0; i<=2; i++)
		{
			flags[i] = false;
		}
		insertdata(s);
	}
	public boolean isfull()
	{return datacount==data.length;}
	
	public boolean isleaf()
	{
		int i = 0;
		for(int j = 0; j < children.length; j++)
		{
			if(children[i]!=null)
			{
				i++;
			}
		}
		return i == 0;
	}
	
	public String getdata(int i)
	{return data[i];}
	
	public node getchild(int i)
	{return children[i];}
	
	
	public int insertdata(String s)
	{
		//System.out.println("Currently inserting " + s);
		for(int i = 1; i >= 0; i--)
		{
			if(flags[i] == false)
			{
				continue;
			}
			else
			{
				if(s.compareTo(data[i]) < 0)
				{//If the data in s is alphabetically less than the data at index i--
					data[i+1] = data[i];//Shift data over by one index
					children[i+2] = children[i+1];
					flags[i+1] = true;
				}
				else
				{//We must have found the place where we wish to insert data
					data[i+1] = s;
					flags[i+1] = true;
					datacount++;
					return i+1;
				}
			}
		}
		data[0] = s;
		flags[0] = true;
		datacount++;
		return 0;//If we have reached this point, then insert at beginning of node
	}
	
	public String removedata(int i)
	{
		String temp = data[i];
		flags[i] = false;
		datacount--;
		return temp;
	}
	
	public boolean isthere(int i)
	{
		return flags[i];
	}
	
	public void setflags(int i, boolean b)
	{
		flags[i] = b;
	}
	
	public void insertchild(int i, node n)
	{children[i] = n;}
	
	public int count()
	{return datacount;}
	
	public void printnode()
	{
		System.out.println(getdata(0)+getdata(1)+getdata(2));
	}
	}


	



