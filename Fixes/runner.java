import java.io.*;
import java.util.*;

public class runner
{
	public static void main(String[] args)
	{
		try{
		posteval p = new posteval();
		double d = p.evaluate(args[0]);
		System.out.println(d);
		}
		catch (Exception e){System.out.println(e);}
	}
}