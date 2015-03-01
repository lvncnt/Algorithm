import java.util.HashMap;
import java.util.Map;

class Node {
	int val;
	Map<Integer, Integer> neighbor = new HashMap<Integer, Integer>();

	Node(int val) {
		this.val = val;
	}

	void addEdge(int val, int weight) {
		neighbor.put(val, weight);
	}
}
