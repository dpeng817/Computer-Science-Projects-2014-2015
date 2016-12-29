import java.io.*;

public class ArrayNode
{
	private int[] name;//Stores name of vertice(A, B, C, etc.) as numerical value and path length, and vertex we are coming from
	private ArrayNode next = null;
	
	public ArrayNode()
	{
		name = null;
	}
	
	public ArrayNode(int[] a)
	{
		name = a;
	}
	
	public int[] getname()
	{
		return name;
	}
	
	public void setname(int[] i)
	{
		name = i;
	}
	
	public void setnext(ArrayNode y)
	{
		next = y;
	}
	
	public ArrayNode getnext()
	{
		return next;
	}
}
