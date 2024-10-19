import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class NSPFANGraph {
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
        int sourceNode = scanner.nextInt();

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(sourceNode);
        
        int[] distances = new int[nodes+1];
        int ways[] = new int[nodes+1];
        ways[sourceNode] = 1;
        Arrays.fill(distances, -1);
        distances[sourceNode] = 0;

        boolean visited[] = new boolean[nodes+1];
        visited[sourceNode] = true;
        while(queue.size()!=0){
            int top = queue.poll();
            int size =  graph.get(top).size();

            for(int i=0;i<size;i++){
                if(!visited[graph.get(top).get(i)]){
                    queue.add(graph.get(top).get(i));
                    visited[graph.get(top).get(i)] = true;
                    distances[graph.get(top).get(i)] = distances[top]+1 ;
                    ways[graph.get(top).get(i)] = ways[top];
                }else{
                    if(distances[top]+1 < distances[graph.get(top).get(i)]){
                        ways[graph.get(top).get(i)] = ways[top];
                        distances[graph.get(top).get(i)] = distances[top]+1;
                    }else if(distances[top]+1 == distances[graph.get(top).get(i)]){
                        ways[graph.get(top).get(i)]++;
                    }
                }
            }
        }

        System.out.println(Arrays.toString(ways));
    }
}
