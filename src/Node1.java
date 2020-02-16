
public class Node1<T> {

	public Node1<T> next;
	public Node1<T> til;
	public T data;

	public Node1(T v) {
		super();
		this.next = null;
		this.til = null;
		this.data = v;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node1<T> getNext() {
		return next;
	}

	public Node1<T> getTil() {
		return til;
	}

	public void setNext(Node1<T> next) {
		this.next = next;
	}

	public void setTil(Node1<T> til) {
		this.til = til;
	}

}
