
import java.io.*;
import java.util.*;

/**
 * Compute strongly connected components
 *
 */

class Node {
	int tail;
	ArrayList<Integer> heads = new ArrayList<Integer>();

	boolean explored = false;
	int checked = 0;
	int t, s; // finish time, leader 

	Node(int tail) {
		this.tail = tail;
	}

	void addHead(int head) {
		heads.add(head);
	}
}

class Digraph {

	int t, s, N;
	Node[] nodes;

	Digraph(int N) {
		this.N = N;
		nodes = new Node[N];
	}

	void addNode(int tail, int head) {
		if (nodes[tail - 1] != null) {
			nodes[tail - 1].addHead(head);
		} else {
			Node node = new Node(tail);
			node.addHead(head);
			nodes[tail - 1] = node;
		}
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int tail = 1; tail < N; tail++) {
			sb.append(tail + "->" + nodes[tail - 1].heads).append('\n');
		}
		return sb.toString();
	}

}

class SCC {

	static int N;
	static int[] order; // search order
	static Digraph G, Grev; // forwards, reverse graph 

	void dfsLoop(Digraph G) {

		Node node;
		G.t = 0;
		G.s = 0;
		for (int i = N; i >= 1; i--) {
			node = G.nodes[order[i] - 1];
			if ((node != null) && (!node.explored)) {
				G.s = node.tail;
				dfs(G, node);
			}
		}
	}

	private void dfs(Digraph G, Node node) {
		Stack<Node> stack = new Stack<Node>();
		stack.push(node);
		node.explored = true;

		while (!stack.isEmpty()) {
			node = stack.peek();
			while (node.checked < node.heads.size()) {
				int tails = node.heads.get(node.checked);
				node.checked++;
				Node heads = G.nodes[tails - 1];
				if (!heads.explored) {
					heads.explored = true;
					stack.push(heads);
					node = heads;
				}
			}
			node = stack.pop();
			G.t++;
			node.t = G.t;
			node.s = G.s;
		}
	}

	void sortGraph(Digraph G) {
		for (int i = 1; i <= N; i++) {
			Node node = G.nodes[i - 1];
			order[node.t] = node.tail;
		}
	}

	void getSCC(Digraph G) {
		Node node;
		int[] count = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			node = G.nodes[i - 1];
			count[node.s]++;
		}
		Arrays.sort(count);
		System.out.println("----------------");
		for (int i = 0; i < 5; i++) {
			System.out.print(count[N - i] + " ");
		}
	}
}

class Main extends SCC {

	Main(int N) {
		this.N = N;
		this.order = new int[N + 1];
		G = new Digraph(N);
		Grev = new Digraph(N);

		for (int i = 0; i < N; i++) {
			order[i + 1] = i + 1;
			G.nodes[i] = new Node(i + 1);
			Grev.nodes[i] = new Node(i + 1);
		}
	}

	void readGraph(String filename) {

		File file = new File(filename);
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(file));
			String line;
			while ((line = br.readLine()) != null) {
				String[] str = line.split("\\s+");
				int tail, head;
				tail = Integer.parseInt(str[0]);
				head = Integer.parseInt(str[1]);

				G.addNode(tail, head);
				Grev.addNode(head, tail);
			}
		} catch (IOException e) {
			System.out.println("File Not Found: " + filename);
		}
	}

	public static void main(String[] args) {

		int N = 875714;
		String filename = args[0];

		Main test = new Main(N);
		test.readGraph(filename);
		System.out.println("Read graph: done.");

		test.dfsLoop(Grev);
		System.out.println("DFS 1: done.");
		test.sortGraph(Grev);
		test.dfsLoop(G);
		System.out.println("DFS 2: done.");
		test.getSCC(G);
	}
}

