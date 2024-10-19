package DSA;
import java.util.HashMap;

public class MaxDistanceBetweenTwo {
    public static void main(String args[]){
        int[] Arr = { 3, 2, 1, 2, 1, 4, 5, 8, 6, 7, 4, 2 }; 
        System.out.println("Maximum distance between two occurrences of same element in array:"+ maxDistanceBetweenSameElements(Arr)); 
    }

    public static int maxDistanceBetweenSameElements(int arr[]){
        int answer = 0;

        HashMap<Integer, Integer> elementIndexMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int x = arr[i];

            if(!elementIndexMap.containsKey(x))
                elementIndexMap.put(x, i);
            else{
                answer = Math.max(answer, i-elementIndexMap.get(x));
            }
        }

        return answer;
    }
}
