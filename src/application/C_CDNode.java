package application;

public class C_CDNode<T extends Comparable<T>> {

	 B_Student data;
	C_CDNode<T> next;
	C_CDNode<T> prev;
	
	////////////////////////////////////////////////
	// initialize constructor
		public C_CDNode(B_Student data) {
			this(data,null,null);
			this.data = data;
			
		}
	
	
	
	// Constructor
	
	public C_CDNode(B_Student data, C_CDNode<T> next, C_CDNode<T> prev) {
		this.data = data;
		this.next = next;
		this.prev = prev;
	}
	
	
	
	

	////////////////////////////////////////////////
	// getter and setter
	public B_Student getData() {
		return data;
	}
	
	public C_CDNode<T> getNext() {
		return next;
	}

	public C_CDNode<T> getPrev() {
		return prev;
	}
	
    /////////////////////
	public void setNext(C_CDNode<T> next) {
		this.next = next;
	}

	public void setPrev(C_CDNode<T> prev) {
		this.prev = prev;
	}

	public void setData(B_Student data) {
		this.data = data;
	}
	

}
