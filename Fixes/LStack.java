import java.io.*;
import java.util.*;

public class LStack
{
	private static SNode top;
	
	
	public static void push(String data)
	{//String stack
		SNode Temp = new SNode(data);
		Temp.setnext(top);
		top = Temp;
	}
	
	public static String pop()
	{
		if(top.getdata()!=null)
		{
		String temp = top.getdata();
		top = top.getnext();
		return temp;
		}
		return null;
	}
	
	public boolean isempty()
	{
		return(top == null);
	}
	
	public String peek()
	{
		if(this.isempty())
		{
			return "&";
		}
		return top.getdata();
	}
}
		
	
	
	
	
	
		