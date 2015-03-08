
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
	 
	MaxHeap low ; // Support Insert, Extract-Max, Pop off Max
	MinHeap high;  // Support Insert, Extract-Min, Pop off Min
	List<Integer> median = new ArrayList<>(); 

	public void setHeap(String filename, int N){
		low = new MaxHeap(); 
		high = new MinHeap(); 
		System.out.println("==> Reading data ");
		System.out.println("==> Computing median");
		readData(filename);
	}
	
	private void readData(String filename) {
		File file = new File(filename);
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(file));
			String line;
			int num; 
			while ((line = br.readLine()) != null) {
				num = Integer.parseInt(line);  
				median.add(calMedian(num)); 
			}
		} catch (FileNotFoundException e) {
			System.err.println("File Not Found");
			System.err.println(e.getMessage());
		} catch (IOException e) {
			System.err.println("IO Error");
			System.err.println(e.toString());
		}
	}
	
	public int calMedian(int num){

			if(low.size() == 0 || num <= low.peekMax()) low.add(num);
			else high.add(num);
			
			if(low.size() - high.size() > 1) high.add(low.popMax());
			if(high.size() - low.size() > 1) low.add(high.popMin());
 
			return (low.size() >= high.size()) ? low.peekMax(): high.peekMin(); 	
	}
	
	public static void main(String[] args) {
		String filename = "Median.txt";	int N = 10_000;
		Main test = new Main();
		test.setHeap(filename, N);

		System.out.println("==> Done ");
		int count = 0; 
		for (int i : test.median) count += i;
		System.out.println("Sum: " + count);		
		System.out.println("Sum mod 10000: " + count%N);		
	}
}
