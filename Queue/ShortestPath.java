import java.io.*;
import java.util.*;

public class ShortestPath
{//Shortest Path Breadth Traversal
	
	public static void main(String[] args)
	{
		try
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String dimension = br.readLine();
			String[][] matrix = new String[Integer.parseInt(dimension)][Integer.parseInt(dimension)];
			for(int i = 0; i<=matrix.length-1; i++)
			{
				matrix[i] = br.readLine().split("\\s");
			}
			System.out.println("-------------");
			String s = br.readLine();
			System.out.println("Hasn't crashed yet!");
			//System.out.println(s);
			int[] i = {interpret(s.charAt(0)), 0, s.charAt(0)};
			//System.out.println(s);
			spt(i, matrix, interpret(s.charAt(2)));
			//System.out.println(s);			
			br.close();
		}
		catch (Exception e) {System.out.println(e);}
	}
	public static void spt(int[] root, String[][] graph, int f)
	{
		myPriorityQueue Q = new myPriorityQueue();
		//System.out.println("Still going1");
		Q.enQueue(root);
		//System.out.println("Still going2");
		String path = "";
		//System.out.println("Still going3");
		int[][] flags = new int[graph.length][2];//0 is previous, 1 is shortest path
		//System.out.println("Still going4");
		flags[root[0]][0] = root[1];//Starting point is visited
		//System.out.println("Still going5");
		while(!Q.isEmpty())
		{
			int[] current = Q.deQueue();
			if(flags[current[0]][1]>0)//if we have already visited this vertex
			{
				System.out.println("Entered if");
				if (flags[current[0]][1]>current[1])//If this is a shorter path to this vertex
				{//Change path to new path
					flags[current[0]][1] = current[1];
					System.out.println("Entered if");
					flags[current[0]][0] = current[2];
				}
				continue;
			}
			for(int i = 0; i<=graph.length-1; i++)
			{//Determines connections from current vertice, makes nodes for connected vertice and enQueues them
				System.out.println("Entered loop");
				if(Integer.parseInt(graph[current[0]][i]) != 0 && flags[i][1] > 0)
				{//If the current index has not been visited and is visitable
					System.out.println("if");
					Q.enQueue(new int[]{i,Integer.parseInt(graph[current[0]][i]), current[0]});
					flags[i][0] = current[0];
					flags[i][1] = Integer.parseInt(graph[current[0]][i]) + current[1];
				}
			}
		}
		for(int i = f; i != root[0];)
		{
			path = path + interpret(i);
			i = Integer.parseInt(graph[i][0]);
		}
		reader(path);
		System.out.println("Shortest path length:" + flags[f][1]);
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
	
	public static void reader(String s)
	{
		for(int i = s.length(); i>=0; i--)
		{
			System.out.println(s.charAt(i));
		}
	}
	
	public static int[][] numberify(String[][] arr)
	{
		int[][] array = new int[arr[0].length][arr.length];
		int i = 0;
		int x = 0;
		while(i<arr.length)
		{
			System.out.println("Entered Loop");
			while(x<=arr[0].length-1)
			{
				array[i][x] = Integer.parseInt(arr[i][x]);
				System.out.println(array[i][x]);
				//System.out.println(x);
				x++;
			}
			System.out.println(i);
			i++;
		}
		return array;
	}
}		