package DSA;
import java.util.*;
 
public class CountSubarrayswithXorK{
    public static int subarrayWIthXorK(int[] arr, int k) {
        Map<Integer, Integer> hm = new HashMap<>();
        hm.put(0,1);

        int xor = 0;
        int count = 0;
        
        for (int i=0;i<arr.length;i++) {
            xor ^= arr[i];
            
            if(hm.containsKey(xor^k)){
               count += hm.get(xor^k);
            }

            hm.put(xor,hm.getOrDefault(xor, 0)+1);
        }
        return count;
    }
 
    public static void main(String[] args) {
        int arr[] = {4, 2, 2, 6, 4};
        int k = 6;

        
        int maxCount = subarrayWIthXorK(arr,k);
        System.out.println("Count: "+maxCount);
    }
}