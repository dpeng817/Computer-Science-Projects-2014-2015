import java.io.*;
import java.util.*;

public class BreadthTraversal
{//Breadth traversal
	public void bfs(int[][] graph, Node root)
	{//Traverses array breadth first
		myQueue Q = new myQueue();//declares new queue
		root.setstate(true);//We are now visiting this node
		Q.enQueue(root);//Adds node to queue
		while(!Q.isEmpty())
		{
			Node r = Q.deQueue();
			System.out.println(r.getdata());
			int i = 0;//Horizontal
			int x = 0;//Vertical
			while(x<graph.length-1)
			{
				if(graph[i][x]==1)
				{
					int [] I = new int[2];
					I[0] = i; I[1] = x;
					Node n = new Node(I);
					n.setstate(true);
					Q.enQueue(n);
				}
				if(i==arr.length-1)
				{
					i = -1;
					x++;
				}
				i++;
			}
		}
	}
}		
	