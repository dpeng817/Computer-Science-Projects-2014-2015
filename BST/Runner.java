import java.io.*;
import java.util.*;

public class Runner
{
	public static void main(String[] args)
	{
		BST B = new BST();
		Scanner sc = new Scanner(System.in);
		String s = new String();
		do
		{
			s = sc.nextLine();
			CommandCenter(s, B);
		}
		while(s.compareTo("exit") != 0);
	}
			
	public static void CommandCenter(String input, BST B)
	{
		if(input.charAt(0) == 'i')
		{
			input = input.substring(2, input.length());
			B.Insert(input);
			System.out.println("Inserted " + input);
		}
		else if(input.charAt(0) == 'c')
		{
			input = input.substring(2, input.length());
			boolean b = B.Check(input);
			if(b == true)
			{
				System.out.println(input + " is in the tree.");
			}
			else
			{
				System.out.println(input + " is not in the tree.");
			}
		}
		else if(input.charAt(0) == 'p')
		{
			B.PrintHandler();
		}
		else if(input.charAt(0) == 'd')
		{
			input = input.substring(2, input.length());
			B.Delete(input);
		}
	}
	

}