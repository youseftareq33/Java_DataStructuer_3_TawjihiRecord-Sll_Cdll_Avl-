package application;

public class F_SLinkedList <T extends Comparable<T> > {
     F_SNode<T> head;

	//Insert
    ///////////////////////////////--- insert first ---///////////////////////
    public void insertathead(B_Student data) {
        F_SNode<T> newnode = new F_SNode<>(data);
        if(head== null) {
            head = newnode;
        } else {
 
            newnode.setNext(head);
            head = newnode;
        }

    }
    
    //////////////////////////////--- insert any location ---//////////////
    public void insertAnyLocation(int index,B_Student data) {
		F_SNode<T> newNode=new F_SNode<>(data);
		
		if(index==0) {
			insertathead(data);
		}
		
		else {
			F_SNode<T> curr=head;
			
			for(int i=0;i<index-1;i++) {
				//System.out.println(curr.getData()+"\n");
				curr=curr.getNext();
				
			}
			
			newNode.setNext(curr.getNext());
			curr.setNext(newNode);
			
		}
	
	}
    
    //////////////////////////////--- insert at last ---/////////////////////
    public void insertatlast(B_Student data) {
        F_SNode<T> newnode = new F_SNode<T>(data);
        
        if(head==null) {
            insertathead(data);
        }
        else {
            F_SNode<T> curr = head;
            while (curr.getNext() != null) {
                curr = curr.getNext();
            }
            curr.setNext(newnode);
        }
    }

    /////////////////////////////--- insert sorted ---//////////////////////
    public void insertsorted(B_Student data) {
        F_SNode<T> newnode = new F_SNode<T>(data);
         if (head == null) { // case at empty list
            head = newnode;
        }
         else { //not empty
            F_SNode<T> curr = head;
            F_SNode<T> prev = null;
            while (curr != null && ((Comparable<T>) curr.getData()).compareTo((T) data) > 0) {
                prev = curr;
                curr = curr.getNext();
            }
            if (prev == null) { // case at head
                newnode.setNext(head);
                head = newnode;
            }
            else { // case at middle or last
                newnode.setNext(curr);
                prev.setNext(newnode);
            }
        }
    }

	 
	 
	 
	 
	 
	//Delete
    /////////////////////////////--- delete ---/////////////////////////
    public void delete(B_Student data) {
        F_SNode<T> curr = head;
        F_SNode<T> prev = null;
        while (curr != null) {
            if (curr.getData().equals(data)) { // Use equals method for comparison
                if (prev == null) { // case at head
                    head = curr.getNext();
                } else { // case at middle or last
                    prev.setNext(curr.getNext());
                }
                return; // Exit the method after deleting the element
            }
            prev = curr;
            curr = curr.getNext();
        }
    }


	 
	 
	 
	 
	 
	//Search
    public B_Student search (B_Student data) {
    	F_SNode<T> curr = head;
    	String x[];
    	//scan_x=sc_scan.nextLine().split(",");
    	while(curr != null) {
    		x=curr.getData().toString().split(",");
    		if(x[0].equals(data) ) {
    			return curr.getData();
        		
    		}
    		else {
    			curr = curr.getNext(); 	   	
    		}
    			
    	}    	
    	return null;
    }

	 
	 
	 
	 
	//Print Data
    ////////////////////////////--- show data ---////////////////////////
    public void showSL() {
		F_SNode<T> curr=head;
		while(curr != null) {
			//System.out.print(curr.getData()+" --> ");
			
			System.out.print("\n"+"                          "+curr.getData()+"\n\n"
			+ "                                     |"
			+ "\n"+"                                     V\n\n");
			
			//////////////////////////////////////////////////////////////////
			curr=curr.getNext();
			
			///////////////////////////////////////////////////////////////
		}
		System.out.print("                                    "+"null"+"\n\n\n");
	}
    
    ///////////////////////////--- to string ---///////////////////////
    @Override
    public String toString() {
    	String res="head --> ";
    	F_SNode<T> curr=head;
    	while(curr!=null) {
    		res+= curr.getData()+" --> ";
    		curr=curr.getNext();
    	}
    	
    	return res+"null";
    }

}



