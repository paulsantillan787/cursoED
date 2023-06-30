package cursoED.semana12;

public class SplayTree<T> {
	private BinaryNode<T> root;

	public SplayTree() {
		root = null;
	}

	/**
	 * Insert into the tree.
	 * 
	 * @param x the item to insert.
	 * @throws DuplicateItemException if x is already present.
	 */
	public void insert(Comparable<T> key) {
		BinaryNode<T> n;
		int c;
		if (root == null) {
			root = new BinaryNode<T>(key);
			return;
		}
		splay(key);
		if ((c = key.compareTo((T) root.key)) == 0) {
			// throw new DuplicateItemException(x.toString());
			return;
		}
		n = new BinaryNode<T>(key);
		if (c < 0) {
			n.left = root.left;
			n.right = root;
			root.left = null;
		} else {
			n.right = root.right;
			n.left = root;
			root.right = null;
		}
		root = n;
	}

	/**
	 * Remove from the tree.
	 * 
	 * @param x the item to remove.
	 * @throws ItemNotFoundException if x is not found.
	 */
	public void remove(Comparable<T> key) {
		BinaryNode<T> x;
		splay(key);
		if (key.compareTo((T) root.key) != 0) {
			// throw new ItemNotFoundException(x.toString());
			return;
		}
		// Now delete the root
		if (root.left == null) {
			root = root.right;
		} else {
			x = root.right;
			root = root.left;
			splay(key);
			root.right = x;
		}
	}

	/**
	 * Find the smallest item in the tree.
	 */
	public Comparable<T> findMin() {
		BinaryNode<T> x = root;
		if (root == null)
			return null;
		while (x.left != null)
			x = x.left;
		splay(x.key);
		return x.key;
	}

	/**
	 * Find the largest item in the tree.
	 */
	public Comparable<T> findMax() {
		BinaryNode<T> x = root;
		if (root == null)
			return null;
		while (x.right != null)
			x = x.right;
		splay(x.key);
		return x.key;
	}

	/**
	 * Find an item in the tree.
	 */
	public Comparable<T> find(Comparable<T> key) {
		if (root == null)
			return null;
		splay(key);
		if (root.key.compareTo((T) key) != 0)
			return null;
		return root.key;
	}

	/**
	 * Test if the tree is logically empty.
	 * 
	 * @return true if empty, false otherwise.
	 */
	public boolean isEmpty() {
		return root == null;
	}

	/**
	 * this method just illustrates the top-down method of implementing the
	 * move-to-root operation
	 */
	private void moveToRoot(Comparable<T> key) {
		BinaryNode<T> l, r, t, y;
		l = r = (BinaryNode<T>) header;
		t = root;
		header.left = header.right = null;
		for (;;) {
			if (key.compareTo((T) t.key) < 0) {
				if (t.left == null)
					break;
				r.left = t; /* link right */
				r = t;
				t = t.left;
			} else if (key.compareTo((T) t.key) > 0) {
				if (t.right == null)
					break;
				l.right = t; /* link left */
				l = t;
				t = t.right;
			} else {
				break;
			}
		}
		l.right = t.left; /* assemble */
		r.left = t.right;
		t.left = (BinaryNode<T>) header.right;
		t.right = (BinaryNode<T>) header.left;
		root = t;
	}

	private static BinaryNode<Object> header = new BinaryNode<>(null); // For splay

	/**
	 * Internal method to perform a top-down splay.
	 * 
	 * splay(key) does the splay operation on the given key. If key is in the tree,
	 * then the BinaryNode containing that key becomes the root. If key is not in
	 * the tree, then after the splay, key.root is either the greatest key < key in
	 * the tree, or the lest key > key in the tree.
	 *
	 * This means, among other things, that if you splay with a key that's larger
	 * than any in the tree, the rightmost node of the tree becomes the root. This
	 * property is used in the delete() method.
	 */

	private void splay(Comparable<T> key) {
		BinaryNode<T> l, r, t, y;
		l = r = (BinaryNode<T>) header;
		t = root;
		header.left = header.right = null;
		for (;;) {
			if (key.compareTo((T) t.key) < 0) {
				if (t.left == null)
					break;
				if (key.compareTo((T) t.left.key) < 0) {
					y = t.left; /* rotate right */
					t.left = y.right;
					y.right = t;
					t = y;
					if (t.left == null)
						break;
				}
				r.left = t; /* link right */
				r = t;
				t = t.left;
			} else if (key.compareTo((T) t.key) > 0) {
				if (t.right == null)
					break;
				if (key.compareTo((T) t.right.key) > 0) {
					y = t.right; /* rotate left */
					t.right = y.left;
					y.left = t;
					t = y;
					if (t.right == null)
						break;
				}
				l.right = t; /* link left */
				l = t;
				t = t.right;
			} else {
				break;
			}
		}
		l.right = t.left; /* assemble */
		r.left = t.right;
		t.left = (BinaryNode<T>) header.right;
		t.right = (BinaryNode<T>) header.left;
		root = t;
	}

	// test code stolen from Weiss
	public static void main(String[] args) {
		SplayTree<Integer> t = new SplayTree<>();
		final int NUMS = 40000;
		final int GAP = 307;

		System.out.println("Checking... (no bad output means success)");

		for (int i = GAP; i != 0; i = (i + GAP) % NUMS)
			t.insert(new Integer(i));
		System.out.println("Inserts complete");

		for (int i = 1; i < NUMS; i += 2)
			t.remove(new Integer(i));
		System.out.println("Removes complete");

		if (((Integer) (t.findMin())).intValue() != 2 || ((Integer) (t.findMax())).intValue() != NUMS - 2)
			System.out.println("FindMin or FindMax error!");

		for (int i = 2; i < NUMS; i += 2)
			if (((Integer) t.find(new Integer(i))).intValue() != i)
				System.out.println("Error: find fails for " + i);

		for (int i = 1; i < NUMS; i += 2)
			if (t.find(new Integer(i)) != null)
				System.out.println("Error: Found deleted item " + i);
	}

}
