package application;

public class D_Seatnum_TNode<T extends Comparable<T>> {
	
	B_Student data;
	D_Seatnum_TNode<T> left;
	D_Seatnum_TNode<T> right;

    ////////////////////////////////////////////////
	// Constructor
	public D_Seatnum_TNode(B_Student data) {
		this.data = data;
	}

    ////////////////////////////////////////////////
	// getter and setter
	
	public B_Student getData() {
		return data;
	}

	public D_Seatnum_TNode getLeft() {
		return left;
	}

	public D_Seatnum_TNode getRight() {
		return right;
	}
	
    /////////////////////
	public void setData(B_Student data) {
		this.data = data;
	}

	public void setLeft(D_Seatnum_TNode left) {
		this.left = left;
	}

	public void setRight(D_Seatnum_TNode right) {
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
		return data.getSeat_num()+"";
	}
	
    ////////////////////////////////////////////////
	
}
