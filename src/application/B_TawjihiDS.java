package application;

public class B_TawjihiDS {
	
	public C_CDLinkedList cdll;
	public D_Seatnum_TAVL S_AVL;
	public E_Avg_TAVL Avg_AVL;

	
	////////////////////////////////////////////////
	// Constructor
	public B_TawjihiDS() {
		cdll= new C_CDLinkedList();
		S_AVL= new D_Seatnum_TAVL();
		Avg_AVL= new E_Avg_TAVL();
	}

	
	
	
	////////////////////////////////////////////////
	// The Method
	
	// to insert a new Student Record
	public void insertStudentRecord(B_Student data) {
		cdll.insertAtLast(data);
		S_AVL.insert(data);
		Avg_AVL.insert(data);
	}
	
	// to update a Student Record
	public void updateStudentRecord(B_Student data) {
	    B_Student x = S_AVL.search(data.getSeat_num()).data;
	    x.setBranch(data.getBranch());

	    if (data.getAvg() != x.getAvg()) {
	        double temp = x.getAvg();
	        x.setAvg(data.getAvg());

	        F_SLinkedList temp1 = Avg_AVL.search(temp);
	        temp1.delete(x);
	        Avg_AVL.insert(x);
	    }
	}


	
	// to delete a Student Record
	public void deleteStudentRecord(B_Student data) {
		cdll.delete(data);
		S_AVL.delete(data);
	}
	
	// to search/find a Student Record
	public B_Student findStudentRecord(int data) {
		D_Seatnum_TNode temp=S_AVL.search(data);
		if(temp==null){
			return null;
		}
		return temp.data;
	}
	
	// to Student Record for all who have specific avg
	public F_SLinkedList getAllStudentRecord_SpAvg(double data) {
		F_SLinkedList temp=Avg_AVL.search(data);
		if(temp==null){
			return null;
		}
		return temp;
	}
	
	
	// to clear all data
	public void clearAllData(B_Student data) {
		cdll.clear();
		S_AVL.clear();
		Avg_AVL.clear();
	}
	
	
	
	// to print the double linked list and two avls traversal level
	public String printdoublelinkedlist() {
		return cdll.showCDL();
	}
	
	public String printSeatnum_Avltrav() {
		return S_AVL.traverseLevel();
	}
	public String printAVG_Avltrav() {
		return Avg_AVL.traverseLevel();
	}
	
	
	
	// to print the height of the two avls
	public int printSeatnum_Avlheight() {
		return S_AVL.getHeight();
	}
	
	public int printAVG_Avlheight() {
		return Avg_AVL.getHeight();
	}

	
}
