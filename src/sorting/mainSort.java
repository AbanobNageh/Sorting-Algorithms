package sorting;

import java.util.Random;

public class mainSort {
	private static final boolean PRINT_SORTED_RESULTS = true;

	public static void main(String[] args) {
		Random random = new Random();
		sortingAlgorithm sort = new sortingAlgorithm();
		
		// create an array of a 1000 elements and place random numbers between 0 and 1000 inside it.
		int values[] = new int[1000];
		for (int i = 0; i < 1000; i++){
			values[i] = random.nextInt(1001);
		}
		
		// get the start time.
		long startingTime = System.nanoTime();
		
		// sort the array.
		values = sort.heapSort(values);
		//values = sort.quickSort(values, 0, values.length - 1);
		
		// get the end time and calculate the time taken.
		long endTime = System.nanoTime();
		long timeTaken = endTime - startingTime;
		
		// print the sorted array.
		System.out.println("time taken = " + timeTaken + " ns");
		if (PRINT_SORTED_RESULTS){
			for (int i = 0; i < values.length; i++){
				System.out.println(values[i]);
			}
		}
	}
}
