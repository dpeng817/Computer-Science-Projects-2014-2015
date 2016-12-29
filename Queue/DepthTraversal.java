import java.io.*;
import java.util.*;

public class DepthTraversal
{
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
			dfs(interpret_char(br.readLine().charAt(0)), matrix);
			br.close();
		}
		catch (Exception e) {System.out.println(e);}
	}
	public static void dfs(int root, String[] graph)
	{//Traversal of a graph through depth first traversal
		//System.out.println("dfs");
		myStack S = new myStack();//Creates a new stack to store connected vertices
		boolean [] Stacked = new boolean[graph.length];//Array of flags to determine if an
		//Vertex has been stacked previously; true means stacked, otherwise unstacked.
		Stacked[root] = true;//Sets the starting vertice as visited
		S.push(root);//Pushes root vertex onto stack
		System.out.println(interpret_int(root));
		while(!S.isEmpty())
		{
			//System.out.println("While");
			int temp = S.peek();//Pops node off stack
			for(int i = 0; i<graph.length ; i++)
			{//Creates loop to interpret connections to a particular vertex
				if(graph[temp].charAt(i) == '1' && !Stacked[i])
				{
					//System.out.println("if");//If the current vertex has not previously been added to the stack
						S.push(i);
						//System.out.println(i);
						//System.out.println("if");
						System.out.println(interpret_int(i));
						Stacked[i] = true;
						break;
				}
				if(i == graph.length-1 && !S.isEmpty())
				{
				temp = S.pop();
				i = 0;
				}
			}
		}
	}
	
	public static char interpret_int(int i)
	{//Interprets number from 1-26 and changes it to corresponding letter
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		//System.out.println("interpret int");
		return alphabet.charAt(i);
	}
	
	public static int interpret_char(char c) throws Exception
	{
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		//System.out.println("interpret char");
		for(int i = 0; i<=alphabet.length()-1; i++)
		{
			if(alphabet.charAt(i) == c)
				return i;
		}
		throw new Exception ("invalid input: not a letter");
	}
}

