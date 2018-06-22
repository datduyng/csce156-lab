package unl.cse.trucks;

public class TruckList {

	private TruckListNode start;
	private TruckListNode end;
	private int size;
	
    public void clear() {
    	// there is nothing in the list.
    	if(size <= 0) {
    		return;
    	}else {
    		TruckListNode current = start; 
    		
    		for(int i = 1;i<= size;i++) {
    			current.setItem(null);
    			current = current.getNext();
    		}	
    		
    	}
    	//throw new UnsupportedOperationException("Not yet implemented.");
    }

    public void addToStart(Truck t) {
    	//throw new UnsupportedOperationException("Not yet implemented.");
    	// there is nothing in the list 
    	TruckListNode current = new TruckListNode(t);
    	if(start == null) {
    		start = current;
    		end = current;
    	}
    	// if there is something in the list already 
    	else {
    		current.setNext(start);
    		start = current;
    	}
    	size++;
    }
    

    public void addToEnd(Truck t) {
    	//throw new UnsupportedOperationException("Not yet implemented.");
    	TruckListNode current = new TruckListNode(t);
    	
    	// check to see. are there anything in the list
    	if(start == null) {
    		start = current;
    		end = start;

    	}
    	//if there are something in the list
    	else {
    		end.setNext(current);
    		end = current;
    	}
    	size++;
    }

    public void remove(int position) {
    	
    	if(size <=0 || position > size || position <= 0) {
    		System.out.println("pos or index out of bound error");
    		return;
    	}else if(position == 1){// remove at start 
    		TruckListNode current = start;
    		start = current.getNext();
    		
    		//set current to null
    		current.setNext(null);
    		
    	}else if(position == size) {// remove at end.
    		TruckListNode current = start;
    		
    		for(int i =1;i<size-1;i++) {
    			current = current.getNext();
    		}
    		end = current.getNext();
    		current.setNext(null);
    	}else {
    		TruckListNode current = start;
    		
    		for(int i = 1;i < position-1;i++) {
    			current = current.getNext();
    		}
    		current.setNext(current.getNext().getNext());
    		
    		// then set the node wanted to remove to zero.
    		current.getNext().setNext(null);
    		current.getNext().setItem(null);
    	}
    	//throw new UnsupportedOperationException("Not yet implemented.");
    }
    
    private TruckListNode getTruckListNode(int position) {
    	//throw new UnsupportedOperationException("Not yet implemented.");
    	
    }
    
    public Truck getTruck(int position) {
    	throw new UnsupportedOperationException("Not yet implemented.");    	
    }

    public void print() {
    	throw new UnsupportedOperationException("Not yet implemented.");
    }

}

