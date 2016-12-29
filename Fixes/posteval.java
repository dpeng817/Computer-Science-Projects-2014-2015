import java.io.*;
import java.util.*;
import java.lang.*;

public class posteval
{
	public double evaluate(String d) throws Exception
	{//Evaluates postfix expression
		postfix p = new postfix();
		String data = p.convert(d);
		System.out.println(data);
		precedence prec = new precedence();
		Stack numbers = new Stack();//Stores numbers
		double op1;//operand
		double op2;//operand
		String[] arr = data.split("");
		int i = 0;
		while(i<arr.length)
		{
			if(prec.isoper(arr[i]))
			{//if the character at specified index is an operator
				op1 = numbers.pop();
				op2 = numbers.pop();
				switch(arr[i])
				{
					case "+":
						numbers.push(op1+op2 +0.0);
						break;
					case "-":
						numbers.push(op2-op1+0.0);
						break;
					case "*":
						numbers.push(op2*op1+0.0);
						break;
					case "/":
						if(op1 == 0)
						{
							throw new Exception("Undefined: Divide By 0");
						}
						numbers.push(op2/op1 + 0.0);
						break;
					case "^":
						if(op2<0)
						{
							throw new Exception("Undefined: Negative fractional exponent");
						}
						if(op1 == 0 && op2 == 0)
						{
							throw new Exception("Undefined:0^0 is undefined");
						}
						numbers.push(Math.pow(op2, op1)+0.0);
						break;
				}
					
			}
			else
			{
				int q = Integer.parseInt(arr[i]);
				numbers.push((double)q);
			}
			i++;
		}
		return numbers.pop();
	}
}