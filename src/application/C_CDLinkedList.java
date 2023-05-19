package application;

public class C_CDLinkedList <T extends Comparable<T>>{
	 private C_CDNode<T> head;
	 
	 // Initialize Constractour
	 public C_CDLinkedList() {
		 head=null;
	 }
	 //Insert
	 ///////////////////////////////--- insert at head ---///////////////////////
	 public void insertAtHead(B_Student data) {
		 C_CDNode newNode = new C_CDNode(data);

	        if (head == null) {
	            head = newNode;
	            newNode.next = head;
	            newNode.prev = head;
	        } else {
	            C_CDNode last = head.prev;
	            newNode.next = head;
	            head.prev = newNode;
	            newNode.prev = last;
	            last.next = newNode;
	            head = newNode;
	        }

	    }
	 
	 //////////////////////////////--- insert at last ---/////////////////////	 
	 public void insertAtLast(B_Student data) {

		 C_CDNode<T> newNode = new C_CDNode<T>(data);
			if (head == null) {
				head = newNode;
				head.next = head;
				head.prev = head;
			} else {
				C_CDNode<T> last = head.prev;
				newNode.next = head;
				newNode.prev = last;
				last.next = newNode;
				head.prev = newNode;
			}

	    }

	 /////////////////////////////--- insert sorted ---//////////////////////
	 public void insertSorted(B_Student data) {
		    C_CDNode<T> newNode = new C_CDNode<>(data);
		    C_CDNode<T> curr=head;
		    if (curr == null) {
		        head = newNode;
		        newNode.setNext(head);
		        newNode.setPrev(head);
		    }
		    else {
		        while (curr.getNext() != head && ((Comparable<T>) curr.getData()).compareTo((T) data) < 0) {
		            curr = curr.getNext();
		        }
		        newNode.setNext(curr.getNext());
		        newNode.setPrev(curr);
		        curr.getNext().setPrev(newNode);
		        curr.setNext(newNode);
		    }
		}

	 
	 
	 
	 
	 
	 //Delete
	 /////////////////////////////--- delete from head ---/////////////////////////
	 public void deleteFromHead() {
	        C_CDNode<T> curr=head;
	        if (curr == null) {
	            return;
	        }
	        else {
	            curr.getPrev().setNext(curr.getNext());
	            curr.getNext().setPrev(curr.getPrev());
	            head = curr.getNext();
	        }
	    }

	 /////////////////////////////--- delete from last ---/////////////////////////
	 public void deleteFromLast() {
	        C_CDNode<T> curr=head;
	        if (curr == null) {
	            return;
	        }
	        else {
	            curr.setPrev(curr.getPrev().getPrev());
	            curr.getPrev().setNext(curr);
	        }
	    }
	 /////////////////////////////--- delete ---/////////////////////////
	 public void delete(B_Student data) {
	        C_CDNode<T> curr=head;
	        if (curr == null) {
	            return;
	        }
	        while(curr.getData() != data) {
	            curr = curr.getNext();
	            if (curr == head) {
	                System.out.println("Data not found");
	                return;
	            }
	        }
	        curr.getPrev().setNext(curr.getNext());
	        curr.getNext().setPrev(curr.getPrev());
	        if(curr == head) {
	            head = curr.getNext();
	        }
	    }
	 
	 /////////////////////////////--- delete At Index ---/////////////////////////
	 public void deleteAtIndex(int index) {
	        C_CDNode<T> curr=head;
	        if (curr == null) {
	            return;
	        }

	        int count = 0;
	        while (count < index) {
	            curr = curr.getNext();
	            count++;
	        }

	        curr.getPrev().setNext(curr.getNext());
	        curr.getNext().setPrev(curr.getPrev());
	        if (index == 0) {
	            head = curr.getNext();
	        }
	    }
	 
	 /////////////////////////////--- clear data ---///////////////////////////
	 public void clear() {
		    if (head == null) {
		        // List is already empty
		        return;
		    }

		    C_CDNode<T> curr = head;
		    C_CDNode<T> next = head.getNext();

		    while (next != head) {
		        curr.setNext(null);
		        curr.setPrev(null);
		        curr = next;
		        next = next.getNext();
		    }

		    // Clear the last node
		    curr.setNext(null);
		    curr.setPrev(null);

		    head = null;
		}

	 
	 
	 
	 //Search
	 public B_Student search(B_Student data) {
		    C_CDNode<T> curr=head;
		    if (curr == null) {
		        return null;
		    } else {
		        while(curr != head) {
		            if (curr.getData().equals(data)) {
		                return curr.getData();
		            }
		            curr = curr.getNext();
		        }
		    }
		    return null;
		}

	 
	 
	 
	 
	 
	 //Print Data
	 ////////////////////////////--- show data ---////////////////////////
	 public String showCDL() {
		    StringBuilder sb = new StringBuilder();
		    C_CDNode<T> curr = head;
		    if (curr == null) {
		        sb.append("There is no data");
		        return sb.toString();
		    }
		    sb.append("head --> ");
		    do {
		        sb.append(curr.getData()).append(" --> "+"\n");
		        curr = curr.getNext();
		    } while (curr != head);
		    sb.append("null");
		    return sb.toString();
		}
	 
	 ///////////////////////////--- to string ---///////////////////////
	 @Override
	 public String toString() {
	    	String res="head --> ";
	    	C_CDNode<T> curr=head;
	    	while(curr!=null) {
	    		res+= curr.getData()+" --> ";
	    		curr=curr.getNext();
	    	}
	    	
	    	return res+"null";
	    }

}
