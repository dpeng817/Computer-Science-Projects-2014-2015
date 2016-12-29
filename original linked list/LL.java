import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class LL {
	static Link alist = new Link();

	public static void main(String[] args) {
		String[] cmds = getCmd();
		for (int i = 0; i < cmds.length; i++) {
			if (cmdCenter(cmds[i]) == false) {
				System.out.println("Invalid Command");
				System.exit(1);
			}
		}
	}
	public static boolean cmdCenter(String data) {
		if (data.charAt(0) == 'i') {
			data = whiteCheck(data.substring(1));
			alist.addFront(data);
			System.out.println(data + " has been added");
			return true;
		} else if (data.charAt(0) == 'c') {
			data = whiteCheck(data.substring(1));
			if (alist.check(data) == true) {
				System.out.println(data + " is  there");
			} else {
				System.out.println(data + " is not there");
			}
			return true;
		} else if (data.charAt(0) == 'd') {
			data = whiteCheck(data.substring(1));
			if (alist.check(data) == false) {
				System.out.println(data + " cannot be deleted");
				return true;
			} else if (alist.remove(data) == true) {
				System.out.println(data + " has been deleted");
				return true;
			} else
				return true;
		} else if (data.charAt(0) == 'p') {
			Iterator firstIter = alist.iterator(); // create iterator object
			while (firstIter.hasNext()) // prints out list elements
			{
				String s = (String) firstIter.next();
				System.out.println(s);
			}
			return true;
		} else if (data.charAt(0) == 'q') {
			System.exit(0);
			return true;
		}
			else if(data.charAt(0) == 's')
			{
				alist.qsortAccess();
				System.out.println("The list has been sorted");
				System.out.println();
				return true;
			}
				
		 else {
			return false;
		}
	}
	public static String whiteCheck(String data) {
		char space = ' ';
		char tab = '	';
		int i = 0;
		while (i < data.length()
				&& (data.charAt(i) == space || data.charAt(i) == tab)) {
			i++;
		}
		return data.substring(i);
	}

	public static String[] getCmd() {
		List<String> stringinps = new ArrayList<>(); // string inps is a new
														// list
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));
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
