package DSA;
import java.util.HashMap;
import java.util.*;

public class NumOfPairsWithMaxDiffK {
    public static void main(String args[]){
        int[] Arr = { 3, 2, 1, 2, 1, 4, 5, 8, 6, 7, 4, 2 }; 
        int k = 1;
        System.out.println("Maximum distance between two occurrences of same element in array:"+ numOfPairsWithMaxDiffK(Arr,k)); 
    }

    public static int numOfPairsWithMaxDiffK(int arr[], int k){
        int answer = 0;
        int start = 0;
        int end = 1;

        Arrays.sort(arr);

        while(end<arr.length){
            int x = arr[end]-arr[start];

            if(x<=k){
                answer += end-start;
                end++;
            }else{
                start++;

                if(end<=start)
                    end = start+1;
            }
        }

        return answer;
    }
}
