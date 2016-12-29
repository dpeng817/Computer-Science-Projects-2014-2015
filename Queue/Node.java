import java.io.*;

public class Node
{
	private int name;//Stores name of vertice(A, B, C, etc.) as numerical value
	private Node next = null;
	
	public Node()
	{
		name = 0;
	}
	
	public Node(int a)
	{
		name = a;
	}
	
	public int getname()
	{
		return name;
	}
	
	public void setname(int i)
	{
		name = i;
	}
	
	public void setnext(Node y)
	{
		next = y;
	}
	
	public Node getnext()
	{
		return next;
	}
}
		