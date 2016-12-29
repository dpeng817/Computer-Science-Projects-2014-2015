import java.util.*;
public class runner {
	public static void main(String[] args)
	{
		tree t = new tree();
		Scanner sc = new Scanner(System.in);
		String s = new String();
		do
		{
			s = sc.nextLine();
			CommandCenter(s, t);
		}
		while(s.compareTo("q") != 0);
	}
			
	public static void CommandCenter(String input, tree B)
	{
		if(input.charAt(0) == 'i')
		{
			input = input.substring(2, input.length());
			B.insert(input);
			System.out.println("Inserted " + input);
		}
		else if(input.charAt(0) == 'c')
		{
			input = input.substring(2, input.length());
			boolean b = B.check(input);
			if(b == true)
			{
				System.out.println(input + " is in the tree.");
			}
			else
			{
				System.out.println(input + " is not in the tree.");
			}
		}
		else if(input.charAt(0)== 'p')
		{
			B.print();
		}
		else if(input.charAt(0) == 'd')
		{
			input = input.substring(2, input.length());
			boolean b = B.remove(input);
			if(b == true)
			{
				System.out.println(input + " has been removed.");
			}
			else
			{
				System.out.println(input + " is not in the tree.");
			}
		}
	}
}
