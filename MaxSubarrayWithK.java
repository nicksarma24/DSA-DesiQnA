package DSA;
import java.util.*;
 
public class MaxSubarrayWithK{
    public static int[] maxSizeSubarray(int[] arr, int k) {
        Map<Integer, Integer> hm = new HashMap<>();
        int maxLength = 0;
        int answer[] = {-1,-1};
        int count = 0;
        int sum = 0;

        for (int i=0;i<arr.length;i++) {
            sum += arr[i];

            if(sum == k && (i+1)>maxLength){
                maxLength = i+1;
                answer[0] = 0;
                answer[1] = i;
            }else if(hm.containsKey(sum-k) && (i-hm.get(sum-k))>maxLength){
                System.out.println("Entered: "+((sum-k)+" "+arr[i]));
                maxLength = i-hm.get(sum-k);
                answer[0] = hm.get(sum-k)+1;
                answer[1] = i;
            }

            if (!hm.containsKey(sum)) {
                hm.put(sum, i);
            }
            System.out.println(hm);
        }
        
        System.out.println(hm);
        return answer;
    }
 
    public static void main(String[] args) {
        int arr[] = {3, -1, -4, 5, 2, 1};
        int k = 6;

        
        int maxSize[] = maxSizeSubarray(arr,k);
        System.out.println("MaxLength: "+(maxSize[1]-maxSize[0]+1)+" Coordinates: "+(maxSize[0]+","+maxSize[1]));
    }
}