package unl.cse.sorting;

import java.util.Arrays;

public class SortingAlgorithms {

	public static Location [] javaSort(Location list[]) {
		Location result[] = Arrays.copyOf(list, list.length);
		Arrays.sort(result);
		return result;
	}

	public static Location [] selectionSort(Location list[]) {
		Location result[] = Arrays.copyOf(list, list.length);
		for(int i=0; i<result.length; i++) {
			int minIndex = i;
			for(int j=i+1; j<result.length; j++) {
				if(result[j].compareTo(result[minIndex]) < 0)
					minIndex = j;
			}
			Location tmp = result[i];
			result[i] = result[minIndex];
			result[minIndex] = tmp;
		}
		return result;
	}

	public static Location [] insertionSort(Location list[]) {
		Location result[] = Arrays.copyOf(list, list.length);
		//TODO: implement insertion sort here

		for(int i = 1; i < result.length;i++){
			Location x = result[i];
			int j = i;

			int compareLoc = result[j-1].compareTo(x);
			while(j > 1 && compareLoc >= 1){
				result[j] = result[j-1];
				j--;
			}
			result[j] = x;
		}
		return result;
	}

	public static Location [] quickSort(Location list[]) {
		Location result[] = Arrays.copyOf(list, list.length);
		quickSortRecursive(result, 0, result.length-1);
		return result;
	}

	private static void quickSortRecursive(Location list[], int low, int high) {
		//TODO: implement quick sort here
		Location pivot = list[(low+high)/2	];
		int i = low;
		int j = high;
		if(low < high){
			while(i <= j){
				while( list[i].compareTo(pivot) <= -1){
					i++;
				}
				while( list[j].compareTo(pivot) >= 1){
					j--;
				}
				// swap ai,aj
				if(i <= j){
					Location tmp = list[i];
					list[i] = list[j];
					list[j] = tmp;
					i++;
					j--;
				}
			}// end while
			// swap ai, aj
//			Location tmp2 = list[i];
//			list[i] = list[j];
//			list[j] = tmp2;
//
//			//swap al,aj
//			Location tmp1 = list[low];
//			list[low] = list[j];
//			list[j] = tmp1;
		//	int t = partition(list,low,high);
			if(low<j)
				quickSortRecursive(list, low, j);
			if(i<high)
				quickSortRecursive(list, i, high);
		}

	}
	private static int partition(Location list[] , int low, int high ){
		Location pivot = list[(low+high)/2	];
		int i = low;
		int j = high;
		while(i <= j){
			while( list[i].compareTo(pivot) <= -1){
				i++;
			}
			while( list[j].compareTo(pivot) >= 1){
				j--;
			}
			// swap ai,aj
			if(i <= j){
				Location tmp = list[i];
				list[i] = list[j];
				list[j] = tmp;
				i++;
				j--;
			}
		}// end while

			return i;
	}


}
