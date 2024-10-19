package DSA;
import java.util.*;

    public class MaxSumNonConsecutiveTwoArray {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
    
            int n = scanner.nextInt();
            int[] a = new int[n + 1]; // using 1-based indexing
            int[] b = new int[n + 1];
            int i = 1;
            while (i <= n) {
                a[i] = scanner.nextInt();
                i++;
            }
    
            // Calculate subset with maximum sum such that no two elements are adjacent
            // Step 1: declare a dp array
            int[] dp = new int[n + 1];
            
            a[0] = 0;
            b[0] = 0;

            dp[1] = Math.max(a[1], 0);
            dp[2] = Math.max(a[1], Math.max(a[2], 0));
            
            while (i <= n) {
                dp[i] = Math.max(dp[i - 1], a[i] + dp[i - 2]);
                i++;
            }
            System.out.println(Arrays.toString(dp));
            System.out.println(dp[n]);
        }
    }
    