package unl.cse.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Heap<T> {

	private final PriorityQueue<T> pq;
	private final Comparator<T> comparator;
	
	public Heap(int initialCapacity, Comparator<T> comparator) {
		this.pq = new PriorityQueue<T>(initialCapacity, comparator);
		this.comparator = comparator;
	}
	
	public T getTop() {
		//TODO: implement this
		T result = pq.poll();
		return result;
	}

	public void addElement(T item) {
		pq.offer(item);
		//TODO: implement this
	}
	
	public int size() {
		
		//TODO: implement this
		return pq.size();
	}
	
	
}
