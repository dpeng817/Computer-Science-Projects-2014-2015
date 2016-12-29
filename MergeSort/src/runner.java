import java.io.BufferedReader;
import java.io.*;
public class runner {
	public static void main(String[] args)
	{
		linkedlist<String> l = get_input();
		l.print();
		l.mergesort();
		System.out.println("----");
		l.print();
	}
	public static linkedlist<String> get_input()
	{
        // read line from standard input and store in array of strings
        // return array of inputted strings
        linkedlist<String> ll = new linkedlist<String>();
            try
			{
                BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
                String s=br.readLine();
                while (s!=null)
                {
                    ll.add(s);
                    s=br.readLine();
                }
				br.close();
            }
			catch (Exception e){System.out.println("Ack!:" + e);}
			return ll;
	}
}
