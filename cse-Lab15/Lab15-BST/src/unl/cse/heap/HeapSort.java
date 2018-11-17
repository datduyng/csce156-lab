package unl.cse.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class HeapSort {

	public static <T> void heapSort(List<T> list, Comparator<T> comp) {
		//TODO: implement this
		// copy to a new list 
		List<T> newList = new ArrayList<>();
		
		// create a heap
		Heap<T> h = new Heap<T>(100, comp);
		for(T item: list) {// add element in the array to it. 
			h.addElement(item);
		}
		// clear the list 
		list.clear();
		
		// pop out from heap and add back. 
		for(int i =0;i < 25;i++) {
			list.add(h.getTop());
		}
		return;
	}
	
	public static void main(String args[]) {
		
		int n = 25;
		Random r = new Random();
		List<Integer> A = new ArrayList<Integer>();
		List<Integer> B = new ArrayList<Integer>();
		for(int i=0; i<n; i++) {
			Integer a = r.nextInt(1000); 
			A.add(a);
			B.add(a);
		}
		Comparator<Integer> comp =  new Comparator<Integer>() {
			@Override
			public int compare(Integer arg0, Integer arg1) {
				return arg1.compareTo(arg0);
			}
		};

		heapSort(A, comp);
		Collections.sort(B, comp);
		System.out.println(A);
		System.out.println(B);
		if(!A.equals(B))
			throw new IllegalStateException("A does not appear to be sorted");
	}
}
