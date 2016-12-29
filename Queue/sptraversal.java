//To identify the shortest path between two nodes in a graph
//Djiskra's algorithm 

import java.io.*;
public class sptraversal
{
	public static void main(String[] args)
	{
		
			try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int i=0;
			String stor = br.readLine();
			String[][] adjmat = new String[Integer.parseInt(stor)][Integer.parseInt(stor)]; //identifies dimensions of the matrix 
			while (stor != null && i<adjmat.length)
			{
				adjmat[i]=br.readLine().split("\\s"); //Eliminates white space
				i++;
			}
			String store[] = br.readLine().split("\\s"); //isolates nodes between which to travel 
			path (store[0], store[1], adjmat);
			br.close();
		}
		catch(Exception e){System.out.println(e);}
	}

	public static int find(String tofind, char[] findin)
	//utilized to convert between numeric and alphabetical 
		{
			int i = 0;
			while (i < findin.length)
			{
				if (tofind.charAt(0)==findin[i]) {
				return i;
				}
				i++;
			}
			return i;
		}
	
	public static void path(String start, String end, String[][] adjmat) throws Exception
	//Finds the shortest path between two nodes, given start and end
	{
		char[] alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();//Used to convert from integers to letters and vice versa
		pqueue paths = new pqueue();
		int [][] flag = new int[adjmat[0].length][2]; 
		int i = 0;
		while (i<flag.length)//Fills the array with 0's
		{
			flag[i][0]=0;
			i++;
		}
		i=0;
		while (i<flag.length)//Fills the array with -1's
		{
			flag[i][1]=-1;
			i++;
		}
		int[] current = {-1, -1, -1};//0 is identity; 1 is shortest path; 2 is prev
		paths.enqueue(new int[]{find(start,alpha), 0, 0});//First path should be starting node
		while (!paths.isEmpty())
		{
			current = paths.dequeue();
			if (flag[current[0]][0]>0)//checks the length
			{
				if (current[1] < flag[current[0]][0])
				{
					flag[current[0]][0]=current[1];
					flag[current[0]][1]=current[2];
				}
			}
			else
			{
				flag[current[0]][1]=current[2];//If not visited, flag the lengths and previous node
				flag[current[0]][0]=current[1];
				if (current[0]!=find(end, alpha))//Once you hit your end node, don't continue
				{
					i=0;
					while(i<adjmat[current[0]].length) //Checks for nonvisited, adjacent nodes
					{
						if (flag[i][0]==0&&Integer.parseInt(adjmat[current[0]][i])>0&&i!=find(start, alpha))//last condition is to avoid weirdness with starting node
						{ 
							paths.enqueue(new int[]{i,Integer.parseInt(adjmat[current[0]][i])+current[1], current[0]});//Add identity, agg path length, and prev node
						}
						i++;
					}
				}
			}
		
		}
		if (flag[find(end, alpha)][1]==-1) {
			throw new Exception("Cannot traverse from " + alpha[find(start, alpha)] + " to " + alpha[find(end, alpha)]);
		}
		i = find(end, alpha);//Start at end node and work backwards with prevs until reaching first node
		System.out.println(alpha[find(start,alpha)]);
		travStack output = new travStack();
		 while (i!= find(start, alpha))
		{
			char cur = alpha[i];
			output.push(cur);
			i = flag[i][1];
		} 
		while (!output.isEmpty()){
		System.out.println(output.pop());
		}
		System.out.println("The shortest path from " + alpha[i] + " to " + alpha[find(end,alpha)] + " is " + flag[find(end, alpha)][0]);//Print path length
	}
}
					
		
	