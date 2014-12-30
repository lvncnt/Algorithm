import java.io.*; 
import java.util.HashMap;

/**
 * 
 * DETECTING CYCLES
 * DESCRIPTION:
 * Given a sequence, write a program to detect cycles within it.
 * 
 * INPUT
 * ("text_cases.txt": each line represents a list of integer) 
 * 
 * 2 0 6 3 1 6 3 1 6 3 1
 * 3 4 8 0 11 9 7 2 5 6 10 1 49 49 49 49
 * 1 2 3 1 2 3 1 2 3
 * 
 * OUTPUT:
 * 6 3 1
 * 49
 * 1 2 3
 * 
 **/

public class Main {

	public static void cycleDetection(String[] lineArray) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(); 
		
		for (String element : lineArray) {
			Integer parsedInteger = Integer.parseInt(element);
			
			if(!map.containsKey(parsedInteger)){
				map.put(parsedInteger, 0); 
			}
			else if(map.get(parsedInteger) == 0){
				System.out.printf("%d ", parsedInteger);
				map.put(parsedInteger, map.get(parsedInteger) + 1);
			}
		}

	}

	public static void main(String[] args) {

		File file = new File("test_cases.txt");
		try {
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line;
			while ((line = in.readLine()) != null) {
				line = line.trim();
				String[] lineArray = line.split("\\s");
				cycleDetection(lineArray);
				System.out.println();
			}

		} catch (IOException e) {
			System.out.println("File Read Error: " + e.getMessage());
		}

	}
}
