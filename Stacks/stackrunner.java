import java.io.*;
import java.util.*;
	
public class stackrunner
{	
	public static int Maxsize = 1000;
	
	public static void main(String[] args)
	{
		String[] input = get_input();
		Integer[] bounds = new Integer[2];
		bounds[0] = new Integer(0);
		bounds[1] = new Integer(input.length);
		qsort(input, bounds);
		print(input);
	}
		
		
	public static String[] get_input()
	{
        // read line from standard input and store in array of strings
        // return array of inputted strings
        String storage[]=new String[Maxsize];
        int numin=0;
            try
			{
                BufferedReader
                br=new BufferedReader(new InputStreamReader(System.in));
                String s;
                s=br.readLine();
                while (numin<Maxsize&&s!=null)
                {
                    storage[numin]=s;
                    numin++;
                    s=br.readLine();
                }
				br.close();
            }
			catch (Exception e){System.out.println("Ack!:" + e);}
			int oursize = numin;
			numin=0;
			String[]trimmed=new String[oursize];
			while (numin<oursize)
			{ 
				//Copy existing data into trimmed
				trimmed[numin]=storage[numin];
				numin++;
			}
			return trimmed;
	}
	
	public static void qsort(String[] arr, Integer[] bounds)
	{
		myStack s = new myStack();
		Integer[] right = new Integer[2];
		Integer [] left = new Integer[2];
		Integer check;
		s.push(bounds);
		while(s.isempty() == false)
		{
			bounds = s.pop();
			System.out.println("------------");
			if (bounds[1].intValue()>bounds[0].intValue()+1){
			check = partition(arr, bounds);
			left = new Integer[2];
			right = new Integer[2];
			left[0] = bounds[0];
			left[1] = check.intValue();
			right[0] = check.intValue()+1;
			right[1] = bounds[1];
			System.out.println(left[0].intValue() + " " + left[1].intValue() + " " + right[0].intValue() + " " + right[1].intValue());
			print(arr);
			s.push(left);
			s.push(right);
			}
		}
		s.print();
	}
	
	public static Integer partition(String[] arr, Integer[] bounds)
	{//Sorts an array of strings using the lomuto partition
		int l = bounds[0].intValue();
		int r = bounds[1].intValue();
		String piv = arr[l];//Comparison string
		int wall = l;//stores indiceof last sorted string
		int count = l+1;//iterates throughout unsorted array to compare values
		while(count<=(r-1))
		{//checks each indice of array to see if it is higher alphabetically than the pivot; if so, it swaps with the first element of the unsorted array until the whole array has been sorted relative to the pivot
			if(arr[count].compareTo(piv)<0)
			{
					wall++;
					swap(arr, wall, count);
			}
			count++;
		}
		swap(arr, l, wall);
		return new Integer(wall);
	}
	
	public static void swap(String[] arr, int l, int r)
	{//swaps element at one indice with element at another
		String temp = arr[l];
		arr[l] = arr[r];
		arr[r] = temp;
	}
	
	public static void print(String[] arr)
	{
		int i = 0;
		while(i<arr.length)
		{
			System.out.println(arr[i]);
			i++;
		}
	}
}