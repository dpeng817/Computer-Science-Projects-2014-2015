public class LLNode {
	private String data;
	private LLNode next;

	public LLNode(String _data) {
		next = null;
		data = _data;
	}

	public String getData() {
		return data;
	}

	public void setData(String _data) {
		data = _data;
	}

	public void setNext(LLNode _next) {
		next = _next;
	}

	public LLNode getNext() {
		return next;
	}
}
