import java.io.*;

public class node
{//Node class for 234 tree
	private int entrycount;//Number of entries in node
	private int maxsize;//Max number of children in node
	private node parent = new node();
	private String[] data = new String[3];//Stores entries
	private node[] children = new node[maxsize];//Stores references
	
	public node()
	{
		parent = null;
		entrycount = 0;
		maxsize = 4;
	}
		
	public boolean isleaf()
	{return children[0] == null;}
	
	public boolean isfull()
	{return entrycount == 3;}
	
	public int insertdata(String s)
	{
		for(int i = 2; i >= 0; i--)
		{
			if(data[i] != null)
			{
				if(s.compareTo(data[i]) < 0)
				{//If the data in s is alphabetically less than the data at index i--
					data[i] = data[i+1];//Shift data over by one index
				}
				else
				{//We must have found the place where we wish to insert data
					data[i+1] = s;
					entrycount++;
					return i+1;
				}
			}
		}
		return -1;
	}
	
	public String removedata(int i)
	{
		String temp = data[i];
		data[i] = null;
		entrycount--;
		return temp;
	}
	
	public String getdata(int i)
	{
		return data[i];
	}
	
	public node getchild(int i)
	{
		return children[i];
	}
	
	public void setchild(int i, node n)
	{
		children[i] = n;
	}
	
	public int getcount()
	{
		return entrycount;
	}
	
	public node getparent()
	{
		return parent;
	}
	
	public void setparent(node n)
	{
		parent = n;
	}
}
