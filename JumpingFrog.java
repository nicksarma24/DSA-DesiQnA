package DSA;
import java.util.*;

public class JumpingFrog {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int cost[] = new int[n+1];
        
        for(int i=1;i<cost.length;i++){
            cost[i] = scn.nextInt();
        }

        int minCost[] = new int[n+1];
        
        minCost[0] = 10000;
        minCost[1] = 0;
       
        for(int i=2;i<minCost.length;i++){
            minCost[i] = Math.min(minCost[i-1]+Math.abs(cost[i]-cost[i-1]),minCost[i-2]+Math.abs(cost[i]-cost[i-2]));
        }
       
        System.out.println(minCost[minCost.length-1]);
    }
}
