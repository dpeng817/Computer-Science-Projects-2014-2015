import java.io.*;
import java.util.*;

public class BreadthTraversal
{//Breadth traversal
	
	public static void main(String[] args)
	{
		try
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String[] matrix = new String[Integer.parseInt(br.readLine())];
			for(int i = 0; i<=matrix.length-1; i++)
			{
				matrix[i] = br.readLine();
			}
			System.out.println("-------------");
			bfs(interpret(br.readLine().charAt(0)), matrix);
			br.close();
		}
		catch (Exception e) {System.out.println(e);}
	}
	public static void bfs(int root, String[] graph)
	{
		myQueue Q = new myQueue();
		Q.enQueue(root);
		boolean[] b = new boolean[graph.length];
		b[root] = true;
		while(!Q.isEmpty())
		{
			int current = Q.deQueue();
			for(int i = 0; i<=graph.length-1; i++)
			{//Determines connections from current vertice, makes nodes for connected vertice and enQueues them
				//System.out.println("Entered loop");
				if(graph[current].charAt(i) == '1' && !b[i])
				{
					//System.out.println("if");
					b[i] = true;
					Q.enQueue(i);
				}
			}
			System.out.println(interpret(current));
		}
	}
			
		
	public static char interpret(int i)
	{//Interprets number from 1-26 and changes it to corresponding letter
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		return alphabet.charAt(i);
	}
	
	public static int interpret(char c) throws Exception
	{
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for(int i = 0; i<=alphabet.length()-1; i++)
		{
			if(alphabet.charAt(i) == c)
				return i;
		}
		throw new Exception ("invalid input: not a letter");
	}
}		
	