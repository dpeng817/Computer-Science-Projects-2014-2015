public class tree {
	private node root = null;

	public int analyze(node n, String s) {
		for (int i = 0; i <= n.count() - 1; i++) {
			if (n.isthere(i) != false) {

				if (s.compareTo(n.getdata(i)) <= 0) {//If the data is less than or equal to, return that index
					return i;
				} else if (i != n.count() - 1 && n.getdata(i + 1) != null) {//If we have not reached the last index and the data in the next index isn't null
					if (s.compareTo(n.getdata(i)) > 0
							&& s.compareTo(n.getdata(i + 1)) < 0) {
						return i+1;
					}
				}
			}
		}
		return n.count();
	}

	public boolean isthere(node n, String s) {// Checks to see if the string is
												// within a particular node
		for (int i = 0; i <= n.count() - 1; i++) {
			if (n.getdata(i).compareTo(s) == 0 && n.isthere(i) == true)
				return true;
		}
		return false;
	}

	public void insert(String s) {
		if (root == null) {// If root is null, the initialize it and insert data
			root = new node();
			root.insertdata(s);
		} else {
			node tracker = root;// iterating reference
			node prev = null;// tracks previous reference
			while (tracker != null) {
				if (tracker.isleaf() == true) {
					if (tracker.isfull()) {
						tracker = split(tracker, prev);
					}
					else
					{break;}
				} else if (tracker.isfull()) {
					tracker = split(tracker, prev);
					int i = analyze(tracker, s);
					tracker = tracker.getchild(i);
				} else {
					int i = analyze(tracker, s);// determines where to go from here
					prev = tracker;
					tracker = tracker.getchild(i);// Go to correct child
				}
			}
			tracker.insertdata(s);
		}
	}

	public node split(node current, node prev) {// Splits 3 node into a 1 node
												// with two children, or adds
												// the middle data to the top
												// node
		node n1 = new node(current.getdata(0), current.getchild(0),
				current.getchild(1), null, null);// Stores leftmost data of 3
													// node
		n1.setflags(0, current.isthere(0));
		node n2 = new node(current.getdata(2), current.getchild(2),
				current.getchild(3), null, null);// Stores rightmost data of 3
		n2.setflags(0, current.isthere(2));	
		if (current == root) {// Directly modify root if we are at the root
			node n3 = new node(current.getdata(1), n1, n2, null, null);// Stores
																		// middle
																		// data
			n3.setflags(0, true);
			root = n3;
			current = root;
			return root;
		} else {
			String s = current.getdata(1);
			prev.insertdata(s);
			prev.insertchild(analyze(prev, n1.getdata(0)), n1);
			prev.insertchild(analyze(prev, n2.getdata(0)), n2);
			return prev;
		}
	}

	public boolean check(String s) {
		node tracker = root;
		while (tracker != null) {
			boolean b = isthere(tracker, s);
			if (b == true) {
				return true;
			} else {
				int j = analyze(tracker, s);
				tracker = tracker.getchild(j);
			}

		}
		return false;
	}

	public void print() {
		printhandler(root);
	}

	public void printhandler(node n) {
		for (int i = 0; i <= 3; i++) {
			if (n.getchild(i) != null) {
				printhandler(n.getchild(i));
			}
			if (i < n.count() && n.getdata(i) != null) {
				System.out.println(n.getdata(i));

			}
		}
	}
	
	public boolean remove(String s) {
		node tracker = root;
		boolean isfound = false;
		int i = -1;
		while (tracker != null) {
			boolean b = isthere(tracker, s);
			if (b == true) {
				isfound = true;
				i = analyze(tracker, s);
				break;
			} else {
				int j = analyze(tracker, s);
				tracker = tracker.getchild(j);
			}

		}
		if(isfound)
		{
			tracker.removedata(i);
			return true;
		}
		return false;
	}
}
