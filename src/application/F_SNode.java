package application;

public class F_SNode <T extends Comparable<T> >{
	
     B_Student data;
     F_SNode<T> next;
    
    ////////////////////////////////////////////////
	// Constructor
    public F_SNode(B_Student data,F_SNode<T> next) {
        this.data = data;
        this.next=next;
    }
    
    // init constractour
    public F_SNode(B_Student data) {
        this(data,null);
    }
    
    ////////////////////////////////////////////////
	// getter and setter
    public B_Student getData() {
        return data;
    }
    
    public F_SNode<T> getNext() {
        return next;
    }
    
    /////////////////////
    public void setData(B_Student data) {
        this.data = data;
    }
    
    public void setNext(F_SNode<T> next) {
        this.next = next;
    }
    
    ////////////////////////////////////////////////

}
