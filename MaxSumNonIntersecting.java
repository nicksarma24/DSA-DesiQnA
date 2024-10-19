package DSA;
import java.util.*;

public class MaxSumNonIntersecting {
    public static int maxNonIntersecting(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;

        int[] arr1 = new int[n]; // max sum subarrays ending at or before each index
        int[] arr2 = new int[n]; // max sum subarrays starting at or after each index

        // Compute maximum sums of subarrays ending at each index
        int globalMax = arr[0];
        int localMax = arr[0];
        arr1[0] = arr[0];
        for (int i = 1; i < n; i++) {
            localMax = Math.max(arr[i] + localMax, arr[i]);
            globalMax = Math.max(globalMax, localMax);
            arr1[i] = globalMax;
        }

        // Compute maximum sums of subarrays starting at each index
        globalMax = arr[n - 1];
        localMax = arr[n - 1];
        arr2[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            localMax = Math.max(arr[i] + localMax, arr[i]);
            globalMax = Math.max(globalMax, localMax);
            arr2[i] = globalMax;
        }

        // Find the maximum sum of two non-intersecting subarrays
        int answer = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            answer = Math.max(answer, arr1[i - 1] + arr2[i]);
        }

        return answer;
    }

    public static void main(String[] args) {
        int arr[] = {5,8,10,2,5,5};
        int maxSum = maxNonIntersecting(arr);
        System.out.println("Maximum sum of two non-intersecting subarrays: " + maxSum);
    }
}
