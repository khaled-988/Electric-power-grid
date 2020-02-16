public class Node <T>{

	public Node <T>next;
	public Node <T>til;
	public Node <T>head;
	
	public LinkedList<Node<T>> child;
	
	public T data;
	public Node(T v) {
		
		
		super();
		
		child=new LinkedList<Node<T>>();
		
		this.next = null;
		this.head = null;
		this.til = null;
		this.data=v;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public Node<T> getNext() {
		return next;
	}
	public Node<T> getTil() {
		return til;
	}
	public void setNext(Node<T> next) {
		this.next = next;
	}
	public void setTil(Node<T> til) {
		this.til = til;
	}
	
}
