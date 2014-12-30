public class FibonacciSeries {
	
	/** recursion */ 
	public static int F(int n){
		if(n == 0) return 0; 
		if(n == 1) return 1; 
		else return F(n - 1) + F(n - 2); 
	}
	
	/** dynamic programming: O(n) runtime */ 
	public static int Fs(int n)
	{
		int[] array = {0, 1, 0}; 
		for (int i = 2; i < n + 1; i ++ ){
			array[i%3] = array[(i-1)%3] + array[(i-2)%3]; 
		}
		return array[n%3]; 
	}

	public static void main(String[] args) {
	  int n = 40; 
		for(int i = 0; i < n; i++){
			System.out.printf("%d ", Fs(i));
			if((i + 1)%10 == 0) System.out.println();
		}
		
	}

}
