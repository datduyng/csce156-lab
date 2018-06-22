package unl.cse.trucks;

public class TruckListNode {

    private TruckListNode next;
    private Truck item;

    public TruckListNode(Truck item) {
        this.item = item;
        this.next = null;
    }

    
    public Truck getItem() {
		return item;
	}


	public void setItem(Truck item) {
		this.item = item;
	}


	public Truck getTruck() {
        return item;
    }

    public TruckListNode getNext() {
        return next;
    }

    public void setNext(TruckListNode next) {
        this.next = next;
    }
}
