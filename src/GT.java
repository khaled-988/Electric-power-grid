public interface GT<T> {

	// Return true if the tree is empty
	boolean empty();

	// Return true if the tree is full
	boolean full();

	// Return the data of the current node
	T retrieve();

	// Update the data of the current node
	void update(T e);

	// If the tree is empty e is inserted as root. If the tree is not empty, e is added as a child of the current node. The new node is made current and true is returned.
	boolean insert(T e);

	// Return the number of children of the current node.
	int nbChildren();

	// Put current on the i-th child of the current node (starting from 0), if it exists, and return true. If the child does not exist, current is not changed and the method returns false.
	boolean findChild(int i);

	// Put current on the parent of the current node. If the parent does not exist, current does not change and false is returned.
	boolean findParent();

	// Put current on the root. If the tree is empty nothing happens.
	void findRoot();

	// Remove the current subtree. The parent of current, if it exists, becomes the new current.
	void remove();
}
