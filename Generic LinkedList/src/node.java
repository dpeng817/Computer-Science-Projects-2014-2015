public class node <T extends Comparable <T>> {
	private T data;
	private node<T> next;

	public node(T _data) {
		next = null;
		data = _data;
	}

	public T getData() {
		return data;
	}

	public void setData(T _data) {
		data = _data;
	}

	public void setNext(node<T> _next) {
		next = _next;
	}

	public node<T> getNext() {
		return next;
	}
}

