import java.util.LinkedList;

/**
 * A stack class implemented as a wrapper around a java.util.LinkedList.
 * All stack methods simply delegate to LinkedList methods.
 */
 
public class SimpleStack {
    private LinkedList<Integer[]> list = new LinkedList<Integer[]>();
	public void push(Integer[] item) {list.addFirst(item);}
    public Integer[] pop() {return list.removeFirst();}
    public Integer[] peek() {return list.getFirst();}
    public int size() {return list.size();}
    public boolean isempty() {return list.isEmpty();}
	public void print ()
	{
	System.out.print("{");
	while (!isempty())
	{
		System.out.println(pop());
	}
	System.out.println("}");
	}
}