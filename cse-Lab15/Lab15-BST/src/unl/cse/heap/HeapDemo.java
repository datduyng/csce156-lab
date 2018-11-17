package unl.cse.heap;

import java.util.Comparator;

public class HeapDemo {

	public static void main(String args[]) {
		
		Heap<Integer> h = new Heap<Integer>(100, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}} );
		for(int i=0; i<30; i++)
			h.addElement(100-i);
		System.out.println(h.toString());

		for(int i=0; i<30; i++) {
			System.out.println("max = "+h.getTop());
			System.out.println(h);
		}
	}
}
