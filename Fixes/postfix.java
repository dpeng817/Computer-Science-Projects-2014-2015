import java.io.*;
import java.util.*;
//Author: Chris DeCarolis
//Purpose: To convert an expression from infix notation to postfix notation utilizing stacks, then evaluate the expression.

public class postfix
{
	public static void main(String[] args)
	{
	}
	public String convert(String exp)
	{
		//Converts from an expression in infix notation to an expression in postfix notation
		String[] arr = exp.split("");//Tokenizes infix expression
		precedence prec = new precedence();
		LStack operators = new LStack();//Stack to store operators
		String s = new String();//String to store evaluated postfix expression
		for(int i = 0; i <= arr.length-1; i++)
		{
			if(prec.isoper(arr[i]))
			{//Determine if current index holds operator
				while(!operators.isempty()&&prec.inprec(arr[i])<prec.stackprec(operators.peek()))
				{//If the precedence of the current operator is lower than the precedence of the first operator in the stack
					s+=operators.pop();
				}
				if(!operators.isempty()&&prec.stackprec(operators.peek())==prec.inprec(arr[i]))
				{
					operators.pop();
				}
			else
				{
					operators.push(arr[i]);
				}
			}
			else s+= arr[i];
			}
			while(!operators.isempty())
			{//Flushes last operators from stack
				s+= operators.pop();
			}
			return s;
	}
	

}
				
				
					
			
			
			
			