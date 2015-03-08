This is the Programming Question - 6(II) from Algorithms: Design and Analysis, Part 1. 

# Implement "Median Maintenance" algorithm 

The file, [`Median.txt`][1], a list of the integers from 1 to 10000 in unsorted order. Each row of the file represents an integer element.

The program runs heap-based implementations of the "Median Maintenance" algorithm: it reads files line by line and computes, at each time step the median of the number processed so far. For example, let `xi` denote the `i`th number of the file, then the `k`th median `mk` is defined as the median of the numbers `{x1,…,xk}`. In the end, the sum of these 10000 medians are displayed. 

[1]: http://spark-public.s3.amazonaws.com/algo1/programming_prob/Median.txt
