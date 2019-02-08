package sorting;

import java.util.Arrays;
import java.util.Random;

public class sortingAlgorithm {

	public sortingAlgorithm(){

	}
	
	// bubble sort.
	int[] bubbleSort(int values[]){
		int temp = 0, n = values.length;
		// loop over the array.
		for (int i = 0; i < n - 1; i++){
			// check each two succssive elements and swap if nessasary.
			for (int j = 0; j < n - i - 1; j++){
				if (values[j] > values[j + 1]){
					temp = values[j];
					values[j] = values[j + 1];
					values[j + 1] = temp;
				}
			}
		}
		return values;
	}


	// selection sort.
	int[] selectionSort(int values[]){
		int min = 0, temp = 0, n = values.length;
		// loop over array.
		for (int i = 0; i < n - 1; i++){
			// set minimum number to first number in the array.
			min = i;
			// compare each element in the array with the minimum and change if nessasary.
			for (int j = i + 1; j < n ; j++){
				if (values[min] > values[j]){
					min = j;
				}
			}
			// if minimum changed swap.
			if (min != i){
				temp = values[i];
				values[i] = values[min];
				values[min] = temp;
			}			}
		return values;
	}



	// insertion sort
	int[] insertionSort(int values[]){
		int temp = 0, n = values.length;;
		// loop over array.
		for (int i = 1; i <= n - 1; i++) {
			// compare the elements and insert each one in its correct position.
			for (int j = i; j > 0; j--){
				if (values[j] < values[j-1]){
					temp = values[j];
					values[j] = values[j - 1];
					values[j - 1] = temp;
				}
			}
		}			
		return values;
	}
	
	//merge sort.
	int[] mergeSort (int values[]){
		//if the length of the array is less than or equal one then return the array because it is already sorted.
		if (values.length <= 1){
			return values;
		}
		
		// divide the array into 2 parts.
		int firstHalf[] = Arrays.copyOfRange(values, 0, values.length / 2);
		int secondHalf[] = Arrays.copyOfRange(values, values.length / 2, values.length);
		
		// sort each part of the array.
		mergeSort(firstHalf);
		mergeSort(secondHalf);
		
		// merge the array back together.
		merge(firstHalf, secondHalf, values);
		return values;
	}
	
	private void merge(int[] firstHalf, int[] secondHalf, int[] values){
		int indexFirstHalf = 0, indexSecondHalf = 0, inputLocation = 0;
		
		// as long as both of the arrays have elements take the smaller one.
		while(indexFirstHalf < firstHalf.length && indexSecondHalf < secondHalf.length){
			if (firstHalf[indexFirstHalf] < secondHalf[indexSecondHalf]){
				values[inputLocation] = firstHalf[indexFirstHalf];
				indexFirstHalf++;
			}
			else{
				values[inputLocation] = secondHalf[indexSecondHalf];
				indexSecondHalf++;
			}
			inputLocation++;
		}
		
		// copy any remaining numbers.
		System.arraycopy(firstHalf, indexFirstHalf, values, inputLocation, firstHalf.length - indexFirstHalf);
		System.arraycopy(secondHalf, indexSecondHalf, values, inputLocation, secondHalf.length - indexSecondHalf);
	}
	
	int[] quickSort(int arr[], int left, int right) {
		
		// divides the array into two halves around the pivot.
		int index = partition(arr, left, right);
		
		// use quick sort to sort the two halves od the array recursively.
		if (left < index - 1){
			quickSort(arr, left, index - 1);
		}
		if (index < right){
			quickSort(arr, index, right);
		}
		return arr;
	}
	
	private int partition(int arr[], int left, int right)
	{
		Random random = new Random();
		int i = left, j = right;
		int tmp;
		
		// get a random pivot.
		int randomIndex = left + random.nextInt(right - left);
		int pivot = arr[randomIndex];
		
		// move from the left and right and swap the numbers if needed.
		while (i <= j) {
			while (arr[i] < pivot)
				i++;
			while (arr[j] > pivot)
				j--;
			if (i <= j) {
				tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
				i++;
				j--;
			}
		}
		
		return i;
	}
	
	public int[] heapSort(int data[]) {
		int size = data.length;
	
		// build a heap.
		for (int i = size / 2 - 1; i >= 0; i--) {
			heapify(i, data, size);
		}
		
		// remove elements one by one and then heapify.
		for(int i=data.length-1;i>=0;i--){
			int temp = data[0];
			data[0]=data[i];
			data[i]=temp;
			
			//reduce the heap window by 1
			size  = size-1;

			//call max heapify on the reduced heap
			heapify(0, data, size);
		}
		return data;
	}

	private void heapify(int i, int[] data, int size) {
		int largestElementIndex = i;

		// find the largest of the three nodes.
		int leftChildIndex = 2 * i + 1;
		if (leftChildIndex < size && data[leftChildIndex] > data[largestElementIndex]) {
			largestElementIndex = leftChildIndex;
		}

		int rightChildIndex = 2 * i + 2;
		if (rightChildIndex < size && data[rightChildIndex] > data[largestElementIndex]) {
			largestElementIndex = rightChildIndex;
		}

		// if the largest is not i then swap it.
		if (largestElementIndex != i) {
			int swap = data[i];
			data[i] = data[largestElementIndex];
			data[largestElementIndex] = swap;

			// Recursively heapify the affected sub-tree
			heapify(largestElementIndex, data, size);
		}
	}
}
