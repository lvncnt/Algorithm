
This is the Programming Question - 3 from Algorithms: Design and Analysis, Part 1. 

# Compute the minimum number of cuts

The file, [`kargerMinCut.txt`][1], contains the adjacency list representation of a simple undirected graph. There are 200 vertices labeled 1 to 200. The first column in the file represents the vertex label, and the particular row (other entries except the first column) tells all the vertices that the vertex is adjacent to. 

The program implements the randomized contraction algorithm to compute the min cut from the above graph. The min cut is obtained by running the algorithm many times with different random seeds, and returning the smallest cut found. 


Using the java clas: 
* Compilation: `javac *.java`
* Execution: `java Main kargerMinCut.txt`
* Data file:  
````
200 vertices, 2517 edges
1: 37	79	164	155	32	87	39	113	15	18	78 ... 		
2: 123	134	10	141	13	12	43	47	3	177	101 ... 		
3: 48	123	134	109	41	17	159	49	136	16	130	
.
.
.
````

[1]: http://spark-public.s3.amazonaws.com/algo1/programming_prob/kargerMinCut.txt
