import java.io.*;

public class tree
{
	private node root = new node();
	
	public boolean check(String s)
	{//Checks for the existence of a particular string in the tree: if true, string is in the tree, if false, string is not in the tree
		if(root == null)
		{//If root is null, we can assume tree is empty
			return false;//Since tree is empty, string is not in the tree
		}
		else
		{//Assumes that tree is not empty
			node tracker = root;
			while(tracker!=null)
			{
				boolean b = false;
				int i = analyze(tracker, s, b);//Analyze method that returns -1 if we have found the string
				if(b == true)
				{//Indicator that we have reached the string
					return true;
				}
				else
				{
					tracker = tracker.getchild(i);//Otherwise goes to subtree where string would lie
				}
			}
			return false;//If we have gone through the whole tree and still haven't found the string, it isn't there
		}
	}
	
	public int analyze(node n, String s, boolean b)
	{//analyzes where a string belongs in reference to a node: -1 means that string is within the node
		if(s.compareTo(n.getdata(0))<0)
		{//If we are at the leftmost indice and s belongs to the leftmost
			return 0;
		}
		for(int i = 0; i<=n.getcount(); i++)
		{
			if(s.compareTo(n.getdata(i)) > 0 && n.getdata(i+1) == null)
			{//If we have reached the rightmost end of the node and s belongs further to the right
				return i+1;
			}
			else if(s.compareTo(n.getdata(i)) > 0 && s.compareTo(n.getdata(i+1))<0)
			{//If s is in between the data in indices i and i+1
				return i+1;
			}
			else if(s.compareTo(n.getdata(i)) == 0)
			{//If the string at indice i is equal to still
				b = true;
				return i;
			}
		}
		return -1;
	}
	
	public void insert(String s)
	{
		System.out.println(s);
		if(root == null)
		{
			root.insertdata(s);
		}
		else{
		node current = root;
		while(current!=null)
		{
			if(current.isfull())
			{//If we have reached a 3 node
				split(current);
				current = current.getparent();
				boolean b = false;//Decoy boolean
				int i = analyze(current, s, b);
				current = current.getchild(i);
			}
			else if(current.isleaf())
			{
				break;
			}
			else
			{
				boolean b = false;//Decoy boolean
				int i = analyze(current, s, b);
				current = current.getchild(i);
			}
		}
		current.insertdata(s);
		}
	}
	
	public void split(node n)
	{//Splits 3 node into 3 separate nodes
		node n2 = new node();//Takes leftmost reference
		node n3 = new node();//Takes rightmost reference
		n.getparent().insertdata(n.getdata(1));//Places data from n into n's parent node data
		n2.insertdata(n.getdata(0));
		n3.insertdata(n.getdata(2));
		n2.setchild(0, n.getchild(0));
		n2.setchild(1, n.getchild(1));
		n3.setchild(0, n.getchild(2));
		n3.setchild(1, n.getchild(3));
		n.getparent().setchild(n.getparent().getcount(), n3);//sets rightmost reference
		n.getparent().setchild(n.getparent().getcount()-1, n2);//sets rightmost-1 reference
	}
}
		