
// if arr size = 5:
// left = 0, right = 4, mid = 2
// leftSize is 2 - 0 + 1 = 3 and is [left, mid] or {0, 1, 2}
// rightSize is 4 - 2 = 2 and is [mid + 1, right] or {3, 4}

import java.security.SecureRandom;
public class MergeSort{
	private static final SecureRandom input = new SecureRandom();
	public static void main(String[] args) {
		int[] arr = new int[20];
		for (int i = 0; i < arr.length; ++i) {
			arr[i] = input.nextInt(100);
		}
		
		printArr(arr);
		mergeSort(arr, 0, arr.length - 1);
		printArr(arr);
	}
	public static void printArr(int[] arr) {
		System.out.println("Printing:");
		for (int i = 0; i < arr.length; ++i) {
			System.out.printf("%5d", arr[i]);
		}
	}
	public static void mergeSort(int[] arr, int left, int right) {
		if (left < right) {
			// int mid = (left + right) / 2; same as:
			int mid = left + (right - left) / 2;
			
			mergeSort(arr, left, mid);
			mergeSort(arr, mid + 1, right);
			
			sort(arr, left, mid, right);
			printArr(arr);
		}
	}
	public static void sort(int[] arr, int left, int mid, int right) {
		int size0 = mid - left + 1;
		int size1 = right - mid;
		
		int[] arr0 = new int[size0];
		int[] arr1 = new int[size1];
		
		// API functions do not work as well here because they don't check the index against the size before accessing the index
		for (int i = 0; i < size0; ++i) {
			arr0[i] = arr[left + i];
		}
		for (int i = 0; i < size1; ++i) {
			arr1[i] = arr[mid + 1 + i];
		}
		
		int sourceIndex = left;
		int i0 = 0;
		int i1 = 0;
		for (; i0 < size0 && i1 < size1; ++sourceIndex) {
			if (arr0[i0] <= arr1[i1]) {
				arr[sourceIndex] = arr0[i0];
				++i0;
			}
			else {
				arr[sourceIndex] = arr1[i1];
				++i1;
			}
		}
		for (; i0 < size0; ++i0, ++sourceIndex) {
			arr[sourceIndex] = arr0[i0];
		}
		for (; i1 < size1; ++i1, ++sourceIndex) {
			arr[sourceIndex] = arr1[i1];
		}
	}
}