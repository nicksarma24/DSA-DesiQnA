import java.util.Scanner;

public class DPSubsetSumWithNoConsecutiveTwoArray{
    public static void main(String[] args) {
        
        int[] arr1 = {3, -2, 5, -10, 7};
        int[] arr2 = {-1, 5, -3, 7, -8};
        int n = arr1.length;

        int dp[] = new int[n];
        
        dp[0] = Math.max(0, Math.max(arr1[0],arr2[0]));
        dp[1] = Math.max(dp[0], Math.max(arr1[1],arr2[1]));

        for(int i=2;i<dp.length;i++){
            dp[i] = Math.max(dp[i-1], dp[i-2]+arr1[i]);
            dp[i] = Math.max(dp[i], dp[i-2]+arr2[i]);
        }

        System.out.println(dp[dp.length-1]);
    }
}