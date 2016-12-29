import java.io.*;
import java.util.*;

public class Stack
{
	private static SNode top = new SNode(null);
	
	
	public static void push(Integer[] data)
	{
		SNode Temp = new SNode(data);
		Temp.setnext(top);
		top = Temp;
	}
	
	public static Integer[] pop()
	{
		Integer[] temp = top.getdata();
		if(top.getnext()!=null)
		{
		top = top.getnext();
		}
		return temp;
	}
	
	public Stack()
	{
		top = null;
	}
	
	public boolean isempty()
	{
		return(top.getdata() == null);
	}
}
		
	
	
	
	
	
		