
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Compute the number of target values t in the interval [-10000,10000] (inclusive) 
 * such that there are distinct numbers x, y in the input file that satisfy x + y=t. 
 */
class MainHash {
	long num[];
	int sum[], max, min;
	Hashtable<Long, ArrayList<Long>> tableNeg = new Hashtable<>();
	Hashtable<Long, ArrayList<Long>> tablePos = new Hashtable<>();

	/**
	 * Read data into array
	 * 
	 * @param filename
	 */
	private void readData(String filename) {
		File file = new File(filename);
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(file));
			String line;
			int i = 0;
			while ((line = br.readLine()) != null) {
				long temp = Long.parseLong(line);
				num[i++] = temp;
			}
		} catch (FileNotFoundException e) {
			System.err.println("File Not Found");
			System.err.println(e.getMessage());
		} catch (IOException e) {
			System.err.println("IO Error");
			System.err.println(e.toString());
		}
	}

	/**
	 * Set up Hash table: first (digit# - 4) digits as key last 4 digits as
	 * value
	 */
	private void buildHashtable() {
		Hashtable<Long, ArrayList<Long>> table;
		for (long i : num) {
			long key = i / max, val = i % max;
			table = (i > 0) ? tablePos : tableNeg;
			if (table.containsKey(key)) {
				table.get(key).add(val);
			} else {
				ArrayList<Long> list = new ArrayList<>();
				list.add(val);
				table.put(key, list);
			}
		}
	}

	private void hashing(Hashtable<Long, ArrayList<Long>> table, long key,
			long val, int shift) {
		if (table.containsKey(key)) {
			for (int j = 0; j < table.get(key).size(); j++) {
				long t = val + table.get(key).get(j) + shift;
				if (t <= max && t >= min) {
					sum[((int) t) + max] = 1;
				}
			}
		}
	}

	public void setHash(String filename, int N, int min, int max) {
		this.max = max;
		this.min = min;
		sum = new int[max - min + 1];
		num = new long[N];
		System.out.println("==> Reading data ");
		readData(filename);
		System.out.println("==> Building hash");
		buildHashtable();
	}

	public void twoSum() {
		System.out.println("==> Hashing ");
		Hashtable<Long, ArrayList<Long>> table;
		for (int i = 0; i < num.length; i++) {
			long key = -num[i] / max, val = num[i] % max;
			table = (num[i] > 0) ? tableNeg : tablePos;
			hashing(table, key, val, 0);
			hashing(table, key + 1, val, max);
			hashing(table, key - 1, val, min);
		}
	}

	public static void main(String[] args) {
		String filename = "2sum.txt";
		int N = 1_000_000, max = 10_000, min = -10_000, count = 0;
		MainHash test = new MainHash();
		test.setHash(filename, N, min, max);
		test.twoSum();
		System.out.println("==> Done ");
		for (int i : test.sum)
			count += i;
		System.out.println(count);
	}
}
