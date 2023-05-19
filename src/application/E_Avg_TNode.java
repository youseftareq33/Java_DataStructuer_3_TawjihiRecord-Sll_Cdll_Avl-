package application;

public class E_Avg_TNode<T extends Comparable<T>> {
	
	double data;
	E_Avg_TNode<T> left;
	E_Avg_TNode<T> right;
	F_SLinkedList head;
    ////////////////////////////////////////////////
	// Constructor
	public E_Avg_TNode(B_Student data) {
		this.data = data.getAvg();
		this.head=new F_SLinkedList();
		head.insertatlast(data);
	}

    ////////////////////////////////////////////////
	// getter and setter
	
	public double getData() {
		return data;
	}

	public E_Avg_TNode getLeft() {
		return left;
	}

	public E_Avg_TNode getRight() {
		return right;
	}
	
    /////////////////////
	public void setData(double data) {
		this.data = data;
	}

	public void setLeft(E_Avg_TNode left) {
		this.left = left;
	}

	public void setRight(E_Avg_TNode right) {
		this.right = right;
	}

    ////////////////////////////////////////////////
	//// Checker Method in Tree Node
	
	// if it's leaf or not
	public boolean isLeaf() {
		return (left == null && right == null);
	}
	// if it has left or not
	public boolean hasLeft() {
		return left != null;
	}
	// if it has right or not
	public boolean hasRight() {
		return right != null;
	}

    ////////////////////////////////////////////////
	// print data
	public String toString() {
		return getData()+" ";
	}
	
    ////////////////////////////////////////////////
	
}
