package application;

public class D_Seatnum_TAVL<T extends Comparable<T>> {
	
	private D_Seatnum_TNode<T> root;
	////////////////////////////////////////////////////////////
	//Constructor
	public D_Seatnum_TAVL() {
		root = null;
	}

	private int getHeightDifference(D_Seatnum_TNode<T> node) {
	    if (node == null) {
	        return 0;
	    }
	    int leftHeight = getHeight(node.getLeft());
	    int rightHeight = getHeight(node.getRight());
	    return leftHeight - rightHeight;
	}



	// level of node
	public int getHeight() {
		if (root == null)
			return 0;
		return 1 + Math.max(getHeight(root.getLeft()), getHeight(root.getRight()));
	}

	private int getHeight(D_Seatnum_TNode<T> curr) {
		if (curr == null)
			return 0;
		if (curr.isLeaf())
			return 1;
		else
			return Math.max(1 + getHeight(curr.getLeft()), 1 + getHeight(curr.getRight()));
	}


	
	
	// insert
	public void insert(B_Student data) {
	    if (isEmpty())
	        root = new D_Seatnum_TNode<>(data);
	    else {
	        D_Seatnum_TNode<T> rootNode = root;
	        addEntry(data, rootNode);
	        root = rebalance(rootNode);
	    }
	}

	public void addEntry(B_Student data, D_Seatnum_TNode<T> rootNode) {
	    assert rootNode != null;
	    if (data.getSeat_num() < rootNode.getData().getSeat_num()) { // insert into left subtree
	        if (rootNode.hasLeft()) {
	            D_Seatnum_TNode<T> leftChild = rootNode.getLeft();
	            addEntry(data, leftChild);
	            rootNode.setLeft(rebalance(leftChild));
	        } else {
	            rootNode.setLeft(new D_Seatnum_TNode<>(data));
	        }
	    } else { // insert into right subtree
	        if (rootNode.hasRight()) {
	            D_Seatnum_TNode<T> rightChild = rootNode.getRight();
	            addEntry(data, rightChild);
	            rootNode.setRight(rebalance(rightChild));
	        } else {
	            rootNode.setRight(new D_Seatnum_TNode<>(data));
	        }
	    }
	}




	
	// delete
	public void delete(B_Student data) {
	    root = delete(root, data);
	}

	private D_Seatnum_TNode<T> delete(D_Seatnum_TNode<T> root, B_Student data) {
	    if (root == null)
	        return null;
	    if (data.getSeat_num() < root.getData().getSeat_num())
	        root.setLeft(delete(root.getLeft(), data));
	    else if (data.getSeat_num() > root.getData().getSeat_num())
	        root.setRight(delete(root.getRight(), data));
	    else {
	        if (root.getLeft() == null)
	            return root.getRight();
	        else if (root.getRight() == null)
	            return root.getLeft();
	        root.setData(findMin(root.getRight()).getData());
	        root.setRight(delete(root.getRight(), root.getData()));
	    }
	    return root;
	}

	public D_Seatnum_TNode<T> findMin(D_Seatnum_TNode<T> node) {
	    if (node == null)
	        return null;
	    else if (node.getLeft() == null)
	        return node;
	    return findMin(node.getLeft());
	}


	// search
	public D_Seatnum_TNode<T> search(int data) {
	    return search(root, data);
	}

	private D_Seatnum_TNode<T> search(D_Seatnum_TNode<T> root, int data) {
	    if (root == null || root.getData().getSeat_num() == data) {
	        return root;
	    } else if (data < root.getData().getSeat_num()) {
	        return search(root.getLeft(), data);
	    } else {
	        return search(root.getRight(), data);
	    }
	}

	// rebalanced
	private D_Seatnum_TNode<T> rebalance(D_Seatnum_TNode<T> nodeN) {
	    int diff = getHeightDifference(nodeN);
	    if (diff > 1) { // insertion was in node's left subtree
	        if (getHeightDifference(nodeN.getLeft()) > 0)
	            nodeN = rotateRight(nodeN);
	        else
	            nodeN = rotateLeftRight(nodeN);
	    } else if (diff < -1) { // insertion was in node's right subtree
	        if (getHeightDifference(nodeN.getRight()) < 0)
	            nodeN = rotateLeft(nodeN);
	        else
	            nodeN = rotateRightLeft(nodeN);
	    }
	    return nodeN;
	}

	// rotate right to left
	private D_Seatnum_TNode<T> rotateRightLeft(D_Seatnum_TNode<T> root) {
	    D_Seatnum_TNode<T> temp = root.getRight();
	    root.setRight(rotateRight(temp));
	    return rotateLeft(root);
	}

	// rotate left
	private D_Seatnum_TNode<T> rotateLeft(D_Seatnum_TNode<T> root) {
	    D_Seatnum_TNode<T> temp = root.getRight();
	    root.setRight(temp.getLeft());
	    temp.setLeft(root);
	    return temp;
	}

	// rotate left to right
	private D_Seatnum_TNode<T> rotateLeftRight(D_Seatnum_TNode<T> root) {
	    D_Seatnum_TNode<T> temp = root.getLeft();
	    root.setLeft(rotateLeft(temp));
	    return rotateRight(root);
	}

	// rotate right
	private D_Seatnum_TNode<T> rotateRight(D_Seatnum_TNode<T> root) {
	    D_Seatnum_TNode<T> temp = root.getLeft();
	    root.setLeft(temp.getRight());
	    temp.setRight(root);
	    return temp;
	}

	 public boolean isEmpty() {
	    	if(root==null) {
	    		return true;
	    	}
	    	else {
	    		return false;
	    	}
		}
	
	// to print avl
	public void print() {
		print(root);
	}

	private void print(D_Seatnum_TNode<T> root) {
		if (root == null) {
			return;
		}
		print(root.getLeft());
		System.out.print(root.getData() + " ");
		print(root.getRight());
	}

	
	// also print
	public String traverseLevel() {
	    StringBuilder sb = new StringBuilder();
	    int h = getHeight(root);
	    int i;
	    for (i = 0; i < h; i++) {
	        sb.append(printLevel(root, i, 0)).append("\n\n");
	    }
	    return sb.toString();
	}

	// print 
	private String printLevel(D_Seatnum_TNode<T> root, int i, int j) {
		if (root != null) {
			if (i == j)
				return root.data.getSeat_num()+ " ";
			if (j > i)
				return "NULL";

			return printLevel(root.getLeft(), i, j + 1) + " " + printLevel(root.getRight(), i, j + 1);
		} else
			return "NULL";

	}
	
	
	// clear
	public void clear() {
        root = null;
    }

}
