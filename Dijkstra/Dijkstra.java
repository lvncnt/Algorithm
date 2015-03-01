import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Dijkstra extends Digraph {

	/**
	 * Construct undirected weighted graph from data file
	 * @param N: number of vertices 
	 * @param filename
	 */
	Dijkstra(int N, String filename) {
		super(N);
		readGraph(filename);
	}

	private void readGraph(String filename) {

		File file = new File(filename);
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(file));
			String line;
			while ((line = br.readLine()) != null) {
				String[] str = line.split("\\s+");
				int u, v, w;
				u = Integer.parseInt(str[0]);
				for (int i = 1; i < str.length; i++) {
					v = Integer.parseInt(str[i].split(",")[0]);
					w = Integer.parseInt(str[i].split(",")[1]);
					addNode(u, v, w);
				}
			}
		} catch (IOException e) {
			System.out.println("File Not Found: " + filename);
		}
	}

	/**
	 * Return shortest distance from source to selected targets
	 * @param source
	 * @param targets
	 * @return
	 */
	String getSP(int source, int[] targets) {
		StringBuilder sb = new StringBuilder(); 
		sb.append("Source").append('\t').append("Target").append('\t').append("Shortest Distance"); 
		int[] dist = dijkstraSP(source);
		for (int i : targets) {
			sb.append('\n'); 
			sb.append(source).append('\t').append(i).append('\t').append(dist[i]); 			
		}
		return sb.toString(); 
	}

	/**
	 * Find shortest distances from source to all vertices
	 * @param source
	 * @return
	 */
	private int[] dijkstraSP(int source) {

		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		queue.add(source);
		int[] dist = new int[N + 1];
		Arrays.fill(dist, 1_000_000);
		dist[source] = 0; 

		while (!queue.isEmpty()) {
			int u = queue.poll();
			for (Integer v : nodes[u].neighbor.keySet()) {
				int uvDist = nodes[u].neighbor.get(v);

				if (dist[v] > dist[u] + uvDist) {
					dist[v] = dist[u] + uvDist;
					queue.add(v);
				}
			}
		}
		return dist;
	}
}

