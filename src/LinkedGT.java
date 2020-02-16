
public class LinkedGT<T> implements GT<T> {

	Node<T> root, cur, tail;

	public LinkedGT() {
		root=cur=tail= null;
	}

	@Override
	public boolean empty() {
		return root == null;
	}

	@Override
	public boolean full() {
		return false;
	}

	@Override
	public T retrieve() {
		// TODO Auto-generated method stub
		return cur.data;
	}

	@Override
	public void update(T e) {
		cur.data = e;
		// TODO Auto-generated method stub

	}

	@Override
	public boolean insert(T e) {
		if (e == null)
			return false;
		if (root == null) {
			tail = cur = root = new Node<T>(e);
			return true;
		} else {
			Node<T> Nawaf = new Node<T>(e);
			Node<T> tmp;
			// cur.til=cur;
			// findParent();
			tmp = cur;
			cur.child.insert(Nawaf);
			cur = Nawaf;
			cur.head = tmp;
			// cur=cur.child.getCur();
			return true;
		}

		// TODO Auto-generated method stub

	}

	@Override
	public int nbChildren() {
if (cur == null||cur.child==null)
	return -1;
		return cur.child.length();
	}

	@Override
	public boolean findChild(int i) {
		/*
		 * Node<T> q=null; // LinkedList<T> tmp=cur.child; // tmp.findFirst(); int x=0;
		 * while (tmp.getCur() != null) { if (x==i) { this.tail=this.cur; //
		 * this.cur=tmp.getCur(); return true; } if (tmp.getCur() != null)
		 * tmp.findNext();
		 * 
		 * x++; }
		 */
		// TODO Auto-generated method stub
		if (cur == null)
			return false;
		Node<T> tmp = null;
		int x = nbChildren();
		cur.child.findFirst();
		for (int j = 0; j < x; j++) {
			Node<T> tmp2 = cur.child.retrieve();
			if (j == i) {
				// cur.til=cur;
				cur = tmp2;
				return true;
			}
			//if (cur.next != null)
				cur.child.findNext();
		}
		return false;
	}

	@Override
	public boolean findParent() {
		if (cur.head != null) {
			cur = cur.head;
			return true;
		}
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void findRoot() {
		if (root != null)
			cur = root;
		// TODO Auto-generated method stub

	}

	@Override
	public void remove() {
		if (cur == null)
			return;
		if (cur ==root) {
			cur=root=null;
			return;
		}
		
		if (cur != null) {
			
			cur.child = null;
			Node<T> ch=cur;
			if (findParent()) {
				int x=cur.child.length();
				cur.child.findFirst();
				for (int i=0;i<x;i++) {
					if (cur.child.retrieve().equals(ch)) {
						cur.child.remove();
					return;
					}
					cur.child.findNext();
				}
			}
			cur=null;
		}
		
		// TODO Auto-generated method stub

	}

}
