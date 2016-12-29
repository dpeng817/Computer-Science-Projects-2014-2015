import java.io.*;
import java.util.*;

public class doublestack
{
	private static Node top = new Node(null);
	
	
	public static void push(Double data)
	{
		SNode Temp = new Node(data);
		Temp.setnext(top);
		top = Temp;
	}
	
	public static String pop()
	{
		Double temp = top.getdata();
		if(top.getnext()!=null)
		{
		top = top.getnext();
		}
		return temp;
	}
	
	public doublestack()
	{
		top = null;
	}
	
	public boolean isempty()
	{
		return(top.getdata() == null);
	}
	
	public String peek()
	{
		return top.getdata();
		if(this.isempty()==true)
		{
			throws EmptyStackException;
		}
	}
}