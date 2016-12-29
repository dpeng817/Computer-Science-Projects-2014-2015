import java.io.*;

public class TNode
{
	private String data;//Stores string
	private TNode leftChild;//Reference to node that is alphabetically higher than the current 
	private TNode rightChild;//Reference to node that is alphabetically lower than the current
	
	public TNode()
	{
		data = "";
		leftChild = null;
		rightChild = null;
	}
		
	public TNode(String s, TNode Yes, TNode No)
	{
		data = s;
		leftChild = Yes;
		rightChild = No;
	}
	
	public String getData()
	{
		return data;
	}
	
	public TNode getLeftChild()
	{
		return leftChild;
	}
	
	public TNode getRightChild()
	{
		return rightChild;
	}
	
	public void setLeftChild(TNode L)
	{
		leftChild = L;
	}
	
	public void setRightChild(TNode R)
	{
		rightChild = R;
	}
	
	public void setData(String s)
	{
		data = s;
	}
	
}