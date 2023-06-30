package cursoED.semana12;

class BinaryNode<T> {
	BinaryNode(Comparable<T> theKey) {
		key = theKey;
		left = right = null;
	}

	Comparable<T> key; // The data in the node
	BinaryNode<T> left; // Left child
	BinaryNode<T> right; // Right child
}
