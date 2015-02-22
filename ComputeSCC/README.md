
This is the Programming Question - 4 from Algorithms: Design and Analysis, Part 1. 

# Compute the strongly connected components 

The file, [`SCC.txt`][1], contains the edges of a directed graph. Vertices are labeled as positive integers from 1 to 875714. Every row indicates an edge, the vertex label in first column is the tail and the vertex label in second column is the head.  

The program implements the Kosaraju's algorithm to compute the top five strongly connected components in the above graph. 

Using the java clas: 
* Compilation: `javac Main.java`
* Execution: `java Main SCC.txt`
* Data file:  
````
875714 vertices
1 1 
1 2 
1 5 
1 6 
1 7 
1 3 
1 8 
1 4 
2 47646 
2 47647	
.
.
.
````
* Test case: 
```` 
1 4
2 8
3 6
4 7
5 2
6 9
7 1
8 5
8 6
9 3
9 7
````
Returns `3 3 3 0 0 `.



[1]: http://spark-public.s3.amazonaws.com/algo1/programming_prob/SCC.txt
