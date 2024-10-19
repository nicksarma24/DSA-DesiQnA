package DSA;
import java.util.*;

public class CountOfShortestPath {
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
        int countShortestPath[] = new int[nodes+1];

        Arrays.fill(shortestPath,-1);
        Arrays.fill(countShortestPath,0);

        shortestPath[1] = 0;
        countShortestPath[1] = 1;

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);

        while(queue.size()!=0){
            int top = queue.poll();
            int size =  graph.get(top).size();

            for(int i=0;i<size;i++){
                int temp = graph.get(top).get(i);
               
                if(shortestPath[temp]==-1){                    
                    shortestPath[temp] = shortestPath[top]+1;
                    countShortestPath[temp] = 1;
                    queue.add(temp);
                }else if(shortestPath[temp] == shortestPath[top]+1){
                    countShortestPath[temp]++;
                }
            }
        }

        System.out.println(Arrays.toString(countShortestPath));
    }
}