package DSA;
import java.util.*;

public class CountOfShortestPathPlusFives {
    public static void main(String args[] ) throws Exception {
        Scanner scanner = new Scanner(System.in);

        int nodes = scanner.nextInt();
        int edges = scanner.nextInt();
        
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= nodes; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<edges;i++){
            int n1 = scanner.nextInt();
            int n2 = scanner.nextInt();

            graph.get(n1).add(n2);
            graph.get(n2).add(n1);
        }

        int shortestPath[] = new int[nodes+1];
        int weights[] = new int[nodes+1];
        int countShortestPathHavingMax5s[][] = new int[nodes+1][2];

        for(int i=1;i<=nodes;i++){
            weights[i] = scanner.nextInt(); 
        }

        Queue<Integer> queue = new ArrayDeque();
        queue.add(1);

        Arrays.fill(shortestPath, -1);

        shortestPath[1] = 0;
        countShortestPathHavingMax5s[1][0] = 1;
        countShortestPathHavingMax5s[1][1] = (weights[1] == 5) ? 1:0;

        while(queue.size()>0){
            int size = graph.get(queue.peek()).size();
            int topElement = queue.poll();

            for(int i=0;i<size;i++){
                int currentChild = graph.get(topElement).get(i);

                if(shortestPath[currentChild]==-1){
                    shortestPath[currentChild] = shortestPath[topElement]+1;
                    countShortestPathHavingMax5s[currentChild][0] = 1;
                    countShortestPathHavingMax5s[currentChild][1] = (weights[currentChild] == 5) ? countShortestPathHavingMax5s[topElement][1]+1 : countShortestPathHavingMax5s[topElement][1];
                }else if(shortestPath[currentChild] == shortestPath[topElement]+1){
                    int numOf5IncludingCurrentChild = (weights[currentChild] == 5) ? countShortestPathHavingMax5s[topElement][1]+1 : countShortestPathHavingMax5s[topElement][1];
                    
                    if(countShortestPathHavingMax5s[currentChild][1] > numOf5IncludingCurrentChild){
                        countShortestPathHavingMax5s[currentChild][0] = countShortestPathHavingMax5s[topElement][0];
                        countShortestPathHavingMax5s[currentChild][1] = numOf5IncludingCurrentChild;
                    }else if(countShortestPathHavingMax5s[currentChild][1] == numOf5IncludingCurrentChild){
                        countShortestPathHavingMax5s[currentChild][0] += countShortestPathHavingMax5s[topElement][0];
                    }
                }
            }

        }

    }
}