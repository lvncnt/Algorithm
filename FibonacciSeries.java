import java.io.*; 

/**
 * 
 * Input in "test_cases.txt": 
 * 5
 * 12
 * Output: 
 * 5
 * 144
 * 
 * */ 

public class Main {

	/**  O(n) runtime */
	public static int Fs(int n) {
		int[] array = { 0, 1, 0 };
		for (int i = 2; i < n + 1; i++) {
			array[i % 3] = array[(i - 1) % 3] + array[(i - 2) % 3];
		}
		return array[n % 3];
	}

	public static void main(String[] args) {
		
		File file = new File("test_cases.txt");
		try {
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line;
			while ((line = in.readLine()) != null) 
			{
				line = line.trim();
				int i = Integer.parseInt(line);
		        	System.out.println(Fs(i));
			}

		} catch (IOException e) {
			System.out.println("File Read Error: " + e.getMessage());
		}

	}
}
