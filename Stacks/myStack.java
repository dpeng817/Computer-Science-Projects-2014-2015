import java.io.*;
import java.util.*;

public class myStack
{
	private SNode top = new SNode(null);
	
	
	public void push(Integer[] data)
	{
		SNode Temp = new SNode(data);
		Temp.setnext(top);
		top = Temp;
	}
	
	public Integer[] pop()
	{
		Integer[] temp = top.getdata();
		top = top.getnext();
		return temp;
	}
	
	public myStack()
	{
		top = null;
	}
	
	public boolean isempty()
	{
		return(top == null);
	}
	public void print ()
	{
	System.out.print("{");
	SNode n = top;
	while (n != null)
	{
		System.out.print("(" + n.getdata()[0].intValue() + "," + n.getdata()[1].intValue() + ")");
		n = n.getnext();
	}
	System.out.println("}");
	}
}
		
	
	
	
	
	
		