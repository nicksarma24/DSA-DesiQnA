import java.util.Scanner;

public class DPSubsetSumWithNoAdjecent{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int arr[] = new int[n];
        
        for(int i=0;i<n;i++){
            arr[i] = scn.nextInt();
        }
        
        int dp[] = new int[arr.length];
        
        dp[0] = Math.max(arr[0],0);
        dp[1] = Math.max(dp[0], arr[1]);

        for(int i=2;i<dp.length;i++){
            dp[i] = Math.max(dp[i-1], dp[i-2]+arr[i]);
        }

        System.out.println(dp[dp.length-1]);
    }
}