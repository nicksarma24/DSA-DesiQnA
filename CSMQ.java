package DSA;
import java.util.*;

class CSUMQ
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Read N: the number of integers in the list
        int N = sc.nextInt();
        
        // Read the list of N integers
        int[] list = new int[N];
		int preFixSum [] = new int[N];
		        
        for (int i = 0; i < N; i++) {
            list[i] = sc.nextInt();
        }
        
        preFixSum[0] = list[0];
        
        for (int i = 1; i < N; i++) {
            preFixSum[i] = list[i]+preFixSum[i-1];
        }
        
        //System.out.println(Arrays.toString(preFixSum));
        
        // Read Q: the number of queries
        int Q = sc.nextInt();
        
        // Read and process each query
        for (int q = 0; q < Q; q++) {
            int i = sc.nextInt();  // Start index of query
            int j = sc.nextInt();  // End index of query

            int sum1 = 0;
            int sum2 = preFixSum[j];
            
            if(i-1>=0)
            	sum1 = preFixSum[i-1];
            
                //System.out.println(i+" "+j);
            System.out.println(sum2-sum1);
        }
        
        sc.close();
    }
}