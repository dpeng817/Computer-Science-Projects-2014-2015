import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class concordancechecker {
	public static void main(String[] args)
	{
		ArrayList<String> a = get_input(); 
		TreeMap<String, Integer> tree = new TreeMap<String, Integer>();
		for(int i = 0; i<=a.size()-1; i++)
		{
			if(tree.get(a.get(i))==null)
			{
				tree.put(a.get(i), 1);
			}
			else
			{
				int val = tree.get(a.get(i)).intValue()+1;
				tree.put(a.get(i), val);
			}
		}
		for(Map.Entry<String, Integer> entry:tree.entrySet())
		{System.out.println(entry.getKey() + " : " + entry.getValue());}
	}
	public static ArrayList<String> get_input()
	{
        // read line from standard input and store in array of strings
        // return array of inputted strings
        ArrayList<String> a = new ArrayList<String>();
            try
			{
                BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
                String[] s=br.readLine().split("[ \n\r\n\t\r\\s]");
                while (s!=null)
                {
                	for(int i = 0; i<s.length; i++)
                    {
                		if(s[i]!="");
                		{
                			s[i] = s[i].toLowerCase().replaceAll("[^a-zA-Z']", " ");
                			String[] words = s[i].split(" ");
                			for(int j = 0; j<words.length;j++)
                			{
                			if(words[j].compareTo(" ") != 0 && words[j].compareTo("")!=0)
                				a.add(words[j]);
                			}
                		}
                    }
                    s=br.readLine().split("[ \n\t\r,.;:!?]");
                }
				br.close();
            }
			catch (Exception e){}
			return a;
	}
}
