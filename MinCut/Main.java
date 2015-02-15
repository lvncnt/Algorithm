/**
 * Compilation: javac *.java
 * Execution: java Main kargerMinCut.txt
 * Data file: http://spark-public.s3.amazonaws.com/algo1/programming_prob/kargerMinCut.txt
 * 200 vertices, 2517 edges 
 */
public class Main {

	int min = Integer.MAX_VALUE;

	Main(String filename) {
		int minCut;
		// Run MinCut with different random seeds
		for (int i = 1; i < 201; i++) {
			Graph graph = new Graph(filename);
			MinCut cut = new MinCut(graph);
			cut.setSeed(i);
			minCut = cut.minCut();
			System.out.print(minCut + "...");
			if (i % 15 == 0)
				System.out.println();
			if (minCut < min) {
				min = minCut;
			}
		}
	}

	public static void main(String[] args) {
		System.out.println("Compute the Min Cut from " + args[0]);
		Main main = new Main(args[0]);
		System.out.println();
		System.out.println("------------");
		System.out.println("Min Cut from 200 Runs: " + main.min);
	}
}
