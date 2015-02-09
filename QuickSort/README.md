
This is the Programming Question - 2 from Algorithms: Design and Analysis, Part 1. 

# Compute the number of comparisons

The file, `QuickSort.txt`, contains all of the integers between 1 and 10,000 (inclusive, with no repeats) in unsorted order. The integer in the ith row of the file gives you the ith entry of an input array. 

The program will compute under three different pivoting rules, the total number of comparisons used to sort the given input file by QuickSort. The three different pivoting rules are: 

* The partition subroutine will use use the first element of the array as the pivot element.
* It will use the final element of the given array as the pivot element.
* It will use the "median-of-three" pivot rule. The pivot will be chosen by considering the first, middle, and final elements of the given array. If the array has odd length it should be clear what the "middle" element is; for an array with even length 2k, use the kth element as the "middle" element. Identify which of these three elements is the median (i.e., the one whose value is in between the other two), and use this as the pivot. 
Note: the total of comparisons will not count the comparisons made in identifying the median of the three candidate elements. 

To run the java class, use `java QuickSort`. 
