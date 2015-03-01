This is the Programming Question - 5 from Algorithms: Design and Analysis, Part 1. 

# Compute the minimum number of cuts

The file, [`dijkstraData.txt`][1], contains the adjacency list representation of an undirected weighted graph with 200 vertices labeled 1 to 200. Each row consists of the node tuples that are adjacent to that particular vertex along with the length of that edge.

The program runs Dijkstra's shortest-path algorithm on this graph, and computes the shortest-path distances between 1 and every other vertex *v* of the graph using the vertex 1 as the source vertex. If there is no path between a vertex *v* and vertex 1, the shortest-path distance between 1 and *v* is set to be 1000000. It will print out the shortest-path distances to these following ten vertices: 7,37,59,82,99,115,133,165,188,197. 

Using the java clas: 
* Compilation: `javac *.java`
* Execution: `java Main dijkstraData.txt`
* Data file:  
````
200 vertices
1	80,982	163,8164	170,2620	145,648	200,8021	...	
2	42,1689	127,9365	5,8026	170,9342	131,7005	...	
...
...
...
````

[1]: http://spark-public.s3.amazonaws.com/algo1/programming_prob/dijkstraData.txt
