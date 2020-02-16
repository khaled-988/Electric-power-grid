
public class LinkedQueue <T> implements Queue<T>{
	private Node<T> head,tail;
	private int size;
	
	

	public LinkedQueue() {
		head=tail=null;
		size=0;
	}

	
	public int length() {
		// TODO Auto-generated method stub
		return size;
	}

	
	public boolean full() {
		// TODO Auto-generated method stub
		return false;
	}

	
	public void enqueue(T e) {
		if (tail == null) {
			head=tail=new Node<T>(e);
		}
		else {
			Node<T> tmp =new Node<T>(e);
			tail.next=tmp;
			tail=tmp;
			
		}
		size++;
	}

	
	public T serve() {
		T tmp=head.data;
		head=head.next;
		size--;
		if (size == 0)
			tail=null;
		return tmp;
	}
	

}
