import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class QuickSortList {
	static Link alist = new Link();
	public static void main(String[] args)
	{
		String [] Storage = getInp();
	for(int i = 0; i < Storage.length; i++)//adds each entered element to the linked list using the insert command
		{		
			alist.addFront(Storage[i]);
		}
	System.out.println("Unsorted List: ");
	System.out.print("\n");
	Iterator firstIter = alist.iterator(); // create iterator object
	while (firstIter.hasNext()) // prints out unsorted list
	{
		String s = (String) firstIter.next();
		System.out.println(s);
	}
	System.out.print("\n");
	alist.qsortAccess();
	firstIter = alist.iterator();//restarts iteration at the beginning of the list
	System.out.println("Sorted List: ");
	System.out.print("\n");
	while (firstIter.hasNext())//prints sorted elements
	{
		String s = (String) firstIter.next();
		System.out.println(s);
	}
	System.out.print("\n");
}
	public static String[] getInp()
	{
		List<String> stringinps = new ArrayList<>(); // string inps is a new
		// list
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String s = new String();
			s = br.readLine(); // s is the next input string
			while ((s != null) && (s.length() > 0)) // loops through all input
			{
				stringinps.add(s); // s is added as next element of stringinps
				s = br.readLine(); // s is redefined as the next string
			}
			br.close(); // close buffered reader
			String[] array = new String[stringinps.size()]; // array will be the
			// array of inputs
			// size of stringinps is the size of the returned input array
			return stringinps.toArray(array); // values of list stringinps are
			// sent to array of same size
		} catch (Exception e) {
			System.out.println("Ack!:" + e); // Ack
		}

		return null;
		}
	}
