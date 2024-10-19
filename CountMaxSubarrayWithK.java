package DSA;
import java.util.*;
 
public class CountMaxSubarrayWithK{
    public static int maxSizeSubarray(int[] arr, int k) {
        Map<Integer, Integer> hm = new HashMap<>();
        hm.put(0,-1);

        int maxLength = 0;
        int sum = 0;
        int count = 0;
        
        for (int i=0;i<arr.length;i++) {
            sum += arr[i];
            
            if(hm.containsKey(sum-k)){
                maxLength = Math.max(maxLength, i - hm.get(sum - k));
                System.out.println(i+"th iteration "+maxLength);
            }

            if (!hm.containsKey(sum)) {
                hm.put(sum, i);
            }
        }
        System.out.println(hm);
        //System.out.println(hm);
        return maxLength;
    }
 
    public static void main(String[] args) {
        int arr[] = {4,1,3,2,-2};
        //int k = 6;

        
        int maxCount = maxSizeSubarray(arr,4);
        System.out.println("Max Length: "+maxCount);
    }
}