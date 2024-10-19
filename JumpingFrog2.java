package DSA;
import java.util.*;

public class JumpingFrog2 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int cost[] = new int[n+1];
        
        for(int i=1;i<cost.length;i++){
            cost[i] = scn.nextInt();
        }
        int k = scn.nextInt();

        int minCost[] = new int[n+1];
        minCost[1] = 0;
       
        for(int i=2;i<minCost.length;i++){
            int j = 1;
            int min = Integer.MAX_VALUE;

            while(j<=k && i-j>=1){
                min = Math.min(min, minCost[i-j]+Math.abs(cost[i]-cost[i-j]));
                j++;
            }

            minCost[i] = min;
        }
       
        System.out.println(minCost[minCost.length-1]);
    }
}
