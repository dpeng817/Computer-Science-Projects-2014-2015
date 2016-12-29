import java.util.*;
public class arraylisttool {

	public static void main(String[] args)
	{
		ArrayList<String> list = new ArrayList<String>();
		Scanner sc = new Scanner(System.in);
		String s = new String();
		do
		{
			s = sc.nextLine();
			commandcenter(s, list);
		}
		while(s.compareTo("q") != 0);
		
	}
	
	public static void commandcenter(String input, ArrayList<String> a)
	{
		if(input.charAt(0) == 'i')
		{
			input = input.substring(2, input.length());
			a.add(input);
		}
		if(input.charAt(0) == 'p')
		{
			for(String s : a)
			{
				System.out.println(s);
			}
		}
	}
	
}
