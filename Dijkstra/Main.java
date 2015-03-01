public class Main {
	public static void main(String[] args) {
		String filename = args[0]; 
		int N = 200, source = 1;
		Dijkstra data = new Dijkstra(N, filename);
		int[] targets = { 7, 37, 59, 82, 99, 115, 133, 165, 188, 197 };
		System.out.println(data.getSP(source, targets));
	}
}
