package DSA;
import java.util.*;
 
public class CountSubarraysSumK{
    public static int maxSizeSubarray(int[] arr, int k) {
        Map<Integer, Integer> hm = new HashMap<>();
        hm.put(0,1);

        int maxLength = 0;
        int sum = 0;
        int count = 0;
        
        for (int i=0;i<arr.length;i++) {
            sum += arr[i];
            
            if(hm.containsKey(sum-k)){
                //System.out.println(hm.get(sum-k));
               count += hm.get(sum-k);
            }

            hm.put(sum,hm.getOrDefault(sum, 0)+1);
        }
        
        //System.out.println(hm);
        return count;
    }
 
    public static void main(String[] args) {
        int arr[] = {9, 4, 20, 3, 10, 5};
        int k = 33;

        
        int maxCount = maxSizeSubarray(arr,k);
        System.out.println("Count: "+maxCount);
    }
}