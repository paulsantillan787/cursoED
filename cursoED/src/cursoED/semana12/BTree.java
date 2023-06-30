package cursoED.semana12;

//Java program to illustrate the sum of two numbers

//A BTree
class Btree {
	public BTreeNode root; // Pointer to root node
	public int t; // Minimum degree

	// Constructor (Initializes tree as empty)
	Btree(int t) {
		this.root = null;
		this.t = t;
	}

	// function to traverse the tree
	public void traverse() {
		if (this.root != null)
			this.root.traverse();
		System.out.println();
	}

	// function to search a key in this tree
	public BTreeNode search(int k) {
		if (this.root == null)
			return null;
		else
			return this.root.search(k);
	}
}