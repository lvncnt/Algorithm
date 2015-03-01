class Digraph {

	protected int N;
	protected Node[] nodes;

	Digraph(int N) {
		this.N = N;
		nodes = new Node[N + 1];
	}

	/**
	 * @param u: vertex 
	 * @param v: vertex 
	 * @param w: length of edge uv
	 */
	protected void addNode(int u, int v, int w) {
		if (nodes[u] == null) {
			Node node = new Node(u);
			node.addEdge(v, w);
			nodes[u] = node;
		} else {
			nodes[u].addEdge(v, w);
		}
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		int line = 2;
		for (int u = 1; u <= line; u++) {
			sb.append(nodes[u].val + ":").append('\t');
			for (Integer node : nodes[u].neighbor.keySet()) {
				sb.append(node + ",").append(nodes[u].neighbor.get(node));
				sb.append('\t');
			}
			sb.append('\n');
		}
		return sb.toString();
	}
}
