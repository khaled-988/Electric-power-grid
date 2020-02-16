
public class LinkedList<T> {
	private Node1<T> head;
	private Node1<T> cur;

	public LinkedList() {
		head = null;
		cur = null;
	}

	public LinkedList(Node1<T> head) {
		super();
		this.head = head;
		cur = null;
	}

	public LinkedList(Node1<T> head, Node1<T> cur) {
		super();
		this.head = null;
		this.cur = null;
	}

	public void setCur(Node1<T> c) {
		cur=c;
	}
	
	public Node1<T> getCur(){
		return cur;
	}
	
	public int length() {
		Node1 <T> tmp =head;
		int x=0;
		while (tmp != null) {
			x++;
			tmp=tmp.next;
		}
		return x;
	}
	
	public boolean empty() {
		// TODO Auto-generated method stub
		return head == null;
	}

	
	public boolean full() {
		// TODO Auto-generated method stub
		return false;
	}

	
	public void findFirst() {
		cur = head;
		// TODO Auto-generated method stub

	}


	public void findNext() {
		cur = cur.getNext();
		// TODO Auto-generated method stub

	}


	public boolean last() {
		// TODO Auto-generated method stub
		return cur.getNext() == null;
	}


	public T retrieve() {
		// TODO Auto-generated method stub
		return cur.getData();
	}


	public void update(T e) {
		cur.setData(e);
		// TODO Auto-generated method stub

	}


	public void insert(T e) {
		

	    /* 1. allocate node  
	     * 2. put in the data */
	    Node1<T> new_node = new Node1<T>(e); 
	  
	    Node1<T> last = head; /* used in step 5*/
	  
	    /* 3. This new node is going to be the last node, so 
	     * make next of it as NULL*/
	    new_node.next = null; 
	  
	    /* 4. If the Linked List is empty, then make the new 
	     * node as head */
	    if (head == null) { 
	        new_node.til = null; 
	        head = new_node; 
	        return; 
	    } 
	  
	    /* 5. Else traverse till the last node */
	    while (last.next != null) 
	        last = last.next; 
	  
	    /* 6. Change the next of last node */
	    last.next = new_node; 
	  
	    /* 7. Make last node as previous of new node */
	    new_node.til = last; 
		
		/*
		if (head == null)
			cur = head = new Node1<T>(e);
		else {
			Node1<T> tmp = cur.getNext();
			Node1<T> tmp1 = head;
			while (tmp1.next != cur) {
				tmp1=tmp1.next;
			}
			tmp1.next.setNext(new Node1<T>(e));
			tmp1=tmp1.next;
			cur=cur.next;
			cur.setNext(new Node1<T>(e));
			cur = cur.getNext();
			cur.setNext(tmp);
		}*/

	}


	public void remove() {
		if (cur == head)
			head = head.getNext();
		else {
			Node1<T> tmp = head;
			while (tmp.getNext() != cur)
				tmp = tmp.getNext();
			tmp.setNext(cur.getNext());

		}
		if (cur.getNext() == null)
			cur = head;
		else
			cur = cur.getNext();
	}

	
}
