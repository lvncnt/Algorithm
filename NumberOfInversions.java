import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/*
 * File "IntegerArray.txt" contains all of the 100,000 integers between 1 and 100,000 (inclusive) in some order, with no integer repeated.
 * Compute the number of inversions in the file given, where the ith row of the file indicates the ith entry of an array.
 * Because of the large size of this array, you should implement the fast divide-and-conquer algorithm. 
 */
class NumberOfInversions {

	/** read numbers in file into array */
	public int[] readFile(String fileName) throws IOException {

		File file = new File(fileName);
		BufferedReader br = new BufferedReader(new FileReader(file)); 
		int size = 0; 
		String line; 
		while ((line = br.readLine()) != null ) {
			size ++; 
		}
		
		int[] array = new int[size];		
		br = new BufferedReader(new FileReader(file)); 
		int i = 0;
		while ((line = br.readLine()) != null) {
			array[i] = Integer.parseInt(line);
			i++;
		}
		return array;
	}

	/** return number of inversions */ 
	public long sortCount(int[] array, int low, int high) {
		
		if (low < high) {
			long left, right, split;
			int mid = (low + high)/2;
			left = sortCount(array, low, mid);
			right = sortCount(array, mid + 1, high);
			split = mergeCount(array, low, mid, high);
			return left + right + split;
		}
		return 0;	
	}
	
	/** return split inversions */ 
	private long mergeCount(int[] array, int low, int mid, int high){
		
		int[] mergeArray = new int[high - low + 1]; 
		
		int i = low, j = mid + 1, k = 0; 
		long count = 0; 
		while(i <= mid && j <= high){
			if(array[i] > array[j]){
				count += (mid - i + 1); 
				mergeArray[k++] = array[j++]; 
			}
			else{
				mergeArray[k++] = array[i++]; 
			}
		}
		while(i <= mid){
			mergeArray[k++] = array[i++]; 
		}
		while(j <= high){
			mergeArray[k++] = array[j++]; 
		}
		for(int m = low; m <= high; m++){
			array[m] = mergeArray[m - low]; 
		}
		return count ; 
	}

	public static void main(String[] args) {
		NumberOfInversions testCase = new NumberOfInversions();
		String fileName = "IntegerArray.txt";
		int[] array = null ;
		try {
			array = testCase.readFile(fileName);
		} catch (IOException e) {
			System.out.println("File Not found");
		}
		long count = testCase.sortCount(array, 0, array.length - 1); 
		System.out.println("Number of inversions: " + count);
	}
}
