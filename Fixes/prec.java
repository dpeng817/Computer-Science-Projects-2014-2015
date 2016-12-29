import java.io.*;

public class precendence
{
	//positions in each characteristic string where the property is
	//this will not work with multiple char operators unless either
	//the operator is moved to the end of the string, or
	//a fixed (maximum) length is specified for operators and a fixed length
	//char field is specified in the string
	//this construct also limits precedence values to the interval [0..9]
	static final int OP = 0;
	static final int INPREC = 1;
	static final int SPREC = 2;
	static final int FOL = 3;
	static final int LOOK = 4;
	
	//operator, in prec, stack prec, follows operand, looks like operator
	final String[] tab = ["+12tf", "-12tf", "34tf", "/34tf", "^65tf", "(90ff", ")00tt", " 00ff"]
	private int find(String s)
	{
		//this will only find single char operations
		for(int i = 0;i<tab.length;i++)
		{
			if(s.charAt(0)==tab[i].charAt(OP))
			{
				return i;
			}
		}
		return tab.length-1;
	}
	
	public boolean isoper(String s)
	{
		return tab[find(s)].charAt(OP)!=' ';
	}
	
	public int inprec (String s)
	{
		//nprecedence when first seen in infix
		return tab[find(s)].charAt(INPREC)-'0';
	}
	
	public int stackprec (String s)
	{
		// precedence when in the conversion stack
		return tab[find(s)].charAt(SPREC)-'0';
	}
	
	public boolean follows (String s)
	{
		// operator should follow something that looks like....
		return tab[find(s)].charAt(FOL)-'t';
	}
	
	public boolean lookslike (String s)
	{
		// this operator looks like a.... to what follows it
		return tab[find(s)].charAt(LOOK)-'t';
	}
}