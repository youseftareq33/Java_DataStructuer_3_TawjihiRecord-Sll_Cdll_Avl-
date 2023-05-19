package application;

public class E_Avg_TAVL<T extends Comparable<T>> {
	
	private E_Avg_TNode<T> root;
	////////////////////////////////////////////////////////////
	//Constructor
	public E_Avg_TAVL() {
		root = null;
	}

	int getHeightDifference(E_Avg_TNode<T> node) {
		return getHeight(node.left) - getHeight(node.right);
	}

	// level of node
	public int getHeight() {
		if (root == null)
			return 0;
		return 1 + Math.max(getHeight(root.getLeft()), getHeight(root.getRight()));
	}

	private int getHeight(E_Avg_TNode<T> curr) {
		if (curr == null)
			return 0;
		if (curr.isLeaf())
			return 1;
		else
			return Math.max(1 + getHeight(curr.getLeft()), 1 + getHeight(curr.getRight()));
	}


	
	
	// insert
		public void insert(B_Student data) {
	        root = insert(root, data);
	    }
		
		private E_Avg_TNode<T> insert(E_Avg_TNode<T> root, B_Student data){
	        if (root == null) {
	        	E_Avg_TNode temp = new E_Avg_TNode(data);
	            return temp;
	        }
	        if (data.getAvg() < root.data) {
	            root.left = insert(root.left, data);
	        } else if (data.getAvg() > root.data) {
	            root.right = insert(root.right, data);
	        } else {
	            root.head.insertatlast(data);
	            return root;
	        }
	        int balance = getBalance(root);
	        if (balance > 1 && data.getAvg() < root.left.data)
	            return rotateRight(root);
	        if (balance < -1 && data.getAvg() > root.right.data)
	            return rotateLeft(root);
	        if (balance > 1 && data.getAvg() > root.left.data) {
	            root.left = rotateLeft(root.left);
	            return rotateRight(root);
	        }
	        if (balance < -1 && data.getAvg() < root.right.data) {
	            root.right = rotateRight(root.right);
	            return rotateLeft(root);
	        }
	        return root;
	    }



	
	// delete
			public void delete(B_Student data) {
		        root = delete(root, data);
		    }

		    private E_Avg_TNode delete(E_Avg_TNode root, B_Student data) {
		        if (root == null)
		            return null;
		        if (data.getAvg() < root.data)
		            root.left = delete(root.left, data);
		        else if (data.getAvg() > root.data)
		            root.right = delete(root.right, data);
		        else {
		        	  if (root.head.head.next == null) {
		                  if (root.left == null)
		                      return root.right;
		                  else if (root.right == null)
		                      return root.left;
		                  root.head.head.data = min(root.right).head.head.data;
		                  root.right = delete(root.right, root.head.head.data);
		              }else{
		                  root.head.delete(data);;
		              }
		        }
		        return root;
		    }
		    
		    public E_Avg_TNode min() {
		        return min(root);
		    }

		    private E_Avg_TNode min(E_Avg_TNode root) {
		        if (root == null) {
		            return null;
		        } else if (root.left == null) {
		            return root;
		        } else {
		            return min(root.left);
		        }
		    }

	// search
		    public F_SLinkedList search(double data) {
		        return search(root, data);
		    }

		    private F_SLinkedList search(E_Avg_TNode root, double data) {
		        if (root == null) {
		            return null;
		        } else if (data < root.data) {
		            return (search(root.left, data));
		        } else if (data > root.data) {
		            return (search(root.right, data));
		        } else {
		            return root.head;
		        }
		    }
	// rebalanced
	 private E_Avg_TNode rebalance(E_Avg_TNode nodeN){ 
		 int diff = getHeightDifference(nodeN); 
		 if ( diff > 1) { // insertition was in node's left subtree 
		 if(getHeightDifference(nodeN.left)>0) 
		 nodeN = rotateRight(nodeN); 
		 else 
		 nodeN = rotateLeftRight(nodeN); 
		 } 
		 else if ( diff < -1){ // insertition was in node's right subtree 
		 if(getHeightDifference(nodeN.right)<0) 
		 nodeN = rotateLeft(nodeN); 
		 else 
		 nodeN = rotateRightLeft(nodeN); 
		 } 
		 return nodeN; 
		}

	     
	 
	 // rotate right to left
	private E_Avg_TNode<T> rotateRightLeft(E_Avg_TNode<T> root) {
		E_Avg_TNode<T> temp = root.getRight();
		root.setRight(rotateRight(temp));
		return rotateLeft(root);
	}

	// rotate left
	private E_Avg_TNode<T> rotateLeft(E_Avg_TNode<T> root) {
		E_Avg_TNode<T> temp = root.getRight();
		root.setRight(temp.getLeft());
		temp.setLeft(root);
		return temp;
	}

	// rotate left to right
	private E_Avg_TNode<T> rotateLeftRight(E_Avg_TNode<T> root) {
		E_Avg_TNode<T> temp = root.getLeft();
		root.setLeft(rotateLeft(temp));
		return rotateRight(root);
	}

	// rotate right
	private E_Avg_TNode<T> rotateRight(E_Avg_TNode<T> root) {
		E_Avg_TNode<T> temp = root.getLeft();
		root.setLeft(temp.getRight());
		temp.setRight(root);
		return temp;
	}

	// IDK
	private int getBalance(E_Avg_TNode<T> root) {
		if (root == null) {
			return 0;
		}
		return getHeight(root.getLeft()) - getHeight(root.getRight());
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

	private void print(E_Avg_TNode<T> root) {
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
	private String printLevel(E_Avg_TNode<T> root, int i, int j) {
		if (root != null) {
			if (i == j)
				return root.getData()+ " ";
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
