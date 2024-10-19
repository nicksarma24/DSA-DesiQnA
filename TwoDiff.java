package DSA;
import java.util.*;

public class TwoDiff{
  public static void main(String[] args) {
    int arr[] = {-1, 0, 1, 2};
int k = 1;

    
    countPairs(arr,k);
}

public static void countPairs(int arr[], int k){
  HashMap<Integer,Integer> hm = new HashMap<>();
  int count = 0;
  
  for(int i=0;i<arr.length;i++){
    int x = arr[i];
    
    int element1 = k+arr[i];
    int element2 = arr[i]-k;
    
    count += hm.getOrDefault(element1,0)+hm.getOrDefault(element2,0);
    hm.put(x, hm.getOrDefault(x,0)+1);
  }
  
  System.out.println(count);
}
}

