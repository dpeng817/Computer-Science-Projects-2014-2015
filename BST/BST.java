import java.io.*;

public class BST
{
	private TNode head;
	public void Insert(String s)
	{//Inserts a new string into the tree
		if(head == null)
		{
			head = new TNode(s, null, null);
			//System.out.println(head.getData());
			//Print(head);
		}
		else
		{
		TNode Tracker = head;
		TNode Prev = null;
		while(Tracker != null)
		{
			if(s.compareTo(Tracker.getData()) <= 0) 
			{
				Prev = Tracker;
				Tracker = Tracker.getLeftChild();
			}
			else
			{
				Prev = Tracker;
				Tracker = Tracker.getRightChild();
			}
		}
		if(s.compareTo(Prev.getData()) <= 0)
		{
			Prev.setLeftChild(new TNode(s, null, null));
		}
		else
		{
			Prev.setRightChild(new TNode(s, null, null));
		}	
		}
	}
	
	public boolean Check(String s)
	{
		TNode tracker = head;
		//if (tracker!=null)System.out.println(tracker.getData());
		while(tracker!=null)
		{
			if(s.compareTo(tracker.getData())<0)
			{
				tracker = tracker.getLeftChild();
			}
			else if(s.compareTo(tracker.getData())>0)
			{
				tracker = tracker.getRightChild();
			}
			else if(s.compareTo(tracker.getData()) == 0)
			{
				//System.out.println("Entered if");
				return true;
			}
		}
		return false;
	}

	public void PrintHandler()
	{
		Print(head);
	}
	
	public void Print(TNode T)
	{//Prints entire tree
		if (T!=null)
		{
			if(T.getLeftChild()!=null)
			{
			Print(T.getLeftChild());
			}
			System.out.println(T.getData());
			if(T.getRightChild()!=null)
			{
			Print(T.getRightChild());
			}
		}
		
	}
	
	public void Delete(String s)
	{//Removes a node containing data in string s from tree, the re orders tree accordingly
		if(head.getData().compareTo(s) == 0)
		{//Special case: if head reference points to node with data equivalent to s, changes must be made directly to head
			if(head.getLeftChild() == null && head.getRightChild() == null)
			{//first case: head has no children
				head = null;//Since there are no subtrees, just point to null
			}
			else if(head.getLeftChild() != null && head.getRightChild() == null)
			{//second case: head has one child (subcase: that child is on the left)
				head = head.getLeftChild();//Set head equal to the child of head, effectively removing the original head reference from the tree
			}
			else if(head.getLeftChild() == null && head.getRightChild() != null)
			{//second case: head has one child (subcase: that child is on the right)
				head = head.getRightChild();//Set head equal to the child of head, effectively removing the original head reference from the tree
			}
			else if(head.getLeftChild() != null && head.getRightChild() != null)
			{//Third case: head has two children
				TNode T = minFind(head);//Goes once to right subtree, then finds the leftmost value of the right subtree
				T.setLeftChild(head.getLeftChild());//Set left reference to head's left reference
				T.setRightChild(head.getRightChild());//Set right reference to head's right reference
				//System.out.println(head.getRightChild().getData());
				//System.out.println(T.getRightChild().getData());
				head = T;//Changes head to T
			}
		}
		else//Assumes that head does not contain the data we are searching for, we much search the rest of the tree
		{
				TNode Tracker = head;//Iterating reference, goes throughout tree
				TNode Prev = null;//Stores parent node of head
				while(Tracker!=null)
				{//As long as we have not reached the end of the tree and still have not found tracker, continue iterating
					if(s.compareTo(Tracker.getData())<0)
					{//if s is alphabetically closer to a than Tracker's data, go to left
						Prev = Tracker;
						Tracker = Tracker.getLeftChild();
					}
					else if(s.compareTo(Tracker.getData())>0)
					{//if s is alphabetically closer to z than Tracker's data, go to right
						Prev = Tracker;
						Tracker = Tracker.getRightChild();
					}
					else//Only other case is if we have found the string we are looking for, in which case we stop looping and begin removing
					{
						break;
					}
				}
				if(Tracker == null)
				{//Special case: node was not in the tree, comes first to prevent any of the other cases from being reached
					System.out.println(s + " is not in the tree");
				}	
				else if(Tracker.getLeftChild() == null && Tracker.getRightChild() == null)
				{//First case: node we found has no children (leaf)
					if(Prev.getLeftChild() == Tracker)
					{//If the reference to tracker is the left child of previous
						Prev.setLeftChild(null);//Set reference to null, removing tracker from tree
					}
					else
					{//The only other possibility is that the reference to tracker is the right child of the previous
						Prev.setRightChild(null);//Set reference to null, removing tracker from tree
					}
				}
				else if(Tracker.getLeftChild() != null && Tracker.getRightChild() == null)
				{//Second case: node we found has one child (subcase: child is on the left)
					if(Prev.getLeftChild() == Tracker)
					{//Previous' left reference is tracker
						Prev.setLeftChild(Tracker.getLeftChild());//Relink previous to child of tracker, effectively removing tracker from tree
					}
					else
					{//Only other possibility is that reference to tracker is on the right side
						Prev.setRightChild(Tracker.getRightChild());//Relink previous to child of tracker, effectively removing tracker from tree
					}
				}
				else if(Tracker.getLeftChild() == null && Tracker.getRightChild() != null)
				{//Second case: node we found has one child (subcase: child is on the right)
					if(Prev.getLeftChild() == Tracker)
					{//Previous' left reference is tracker
						Prev.setLeftChild(Tracker.getRightChild());//Relinks previous to child of tracker such that tracker is removed from tree
					}
					else
					{//Only other possibility is that reference to tracker is on the right
						Prev.setRightChild(Tracker.getRightChild());
					}
				}
				else if(Tracker.getLeftChild() != null && Tracker.getRightChild() != null)
				{//Third case: node we found has 2 children
					TNode T = minFind(Tracker);//Goes to right subtree, and finds leftmost value. Removes leftmost value from tree and returns it
					T.setLeftChild(Tracker.getLeftChild());//Set left reference of T to tracker's left child
					T.setRightChild(Tracker.getRightChild());//Set right reference of T to tracker's right child
					if(Prev.getLeftChild() == Tracker)
					{//If tracker is the left reference to previous
						Prev.setLeftChild(T);//Relink tree such that tracker is no longer there
					}
					else
					{//Only other possibility is that tracker is the right child of previous node
						Prev.setRightChild(T);//Relink tree such that tracker is no longer there
					}
				}
			}
		}
			
			public TNode minFind(TNode T)
			{//Iterate to end of left subtree
				TNode Next = T.getRightChild();//Iterating reference, where T is the previous reference
				while(Next.getLeftChild() != null)
				{//As long as we have not reached the leftmost node
					T = Next;
					Next = Next.getLeftChild();
				}
				if(Next.getRightChild() != null)
				{//If Next has a right child, set the left child of T to Next's right child, thereby removing next from the tree
					if(T.getLeftChild() == Next)
					{//If reference to Next is the left child of T
						T.setLeftChild(Next.getRightChild());
					}
					else
					{//Only other possibility is Next is the right child of T
						T.setRightChild(Next.getRightChild());
					}
				}
				else
				{//Only other possibility is that we have reached a leaf and there is no right reference
					if(T.getLeftChild() == Next)
					{//Assuming that the left child of t is next
						T.setLeftChild(null);
					}
					else
					{//Right child of t is next
						T.setRightChild(null);
					}
					
					//System.out.println(T.getLeftChild().getData());
				}
				return Next;//return the leftmost child of right subtree
			}			
}
							
						
	