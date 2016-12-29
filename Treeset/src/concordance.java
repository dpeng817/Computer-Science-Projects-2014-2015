import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class concordance {
	public static void main(String[] args)
	{
		TreeMap<String, Set<Integer>> tree = get_input();
		
		for(Map.Entry<String, Set<Integer>> entry:tree.entrySet())
		{
			System.out.print(entry.getKey() + " : ");
			for(Integer i : entry.getValue())
			{System.out.print(i.intValue() + " ");
		}
			System.out.println();
		}
	}
	public static TreeMap<String, Set<Integer>> get_input()
	{
        // read line from standard input and store in array of strings
        // return array of inputted strings
		TreeMap<String, Set<Integer>> tree = new TreeMap<String, Set<Integer>>();
            try
			{
            	int line = 1;
                BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
                String[] s=br.readLine().split("[\n]");
                while (s!=null)
                {
                	for(int i = 0; i<s.length; i++)
                    {//traverses input
                		String[] current = s[i].split("[ \r\t\r\\s]");
                		for(int j = 0; j<current.length; j++)
                		{
                		if(current[j]!="");
                		{
                			s[i] = s[i].toLowerCase().replaceAll("[^a-zA-Z']", " ");
                			String[] words = s[i].split(" ");
                			for(int z = 0; z<words.length;z++)
                			{
                			if(words[z].compareTo(" ") != 0 && words[z].compareTo("")!=0)
                			{
                				if(tree.get(words[z])==null)
                				{
                					Set<Integer> set = new TreeSet<Integer>();
                					//System.out.println(i+1);
                					Integer temp = new Integer(line);
                					set.add(temp);
                					tree.put(words[z], set);
                				}
                				else
                				{
                					Set<Integer> temp = tree.remove(words[z]);
                					temp.add(new Integer(line));
                					tree.put(words[z], temp);
                				}
                			}
                			}
                		}
                    }
                }
                	s = br.readLine().split("[\n]");
                	line++;
                }
				br.close();
            }
			catch (Exception e){}
			return tree;
	}
}

