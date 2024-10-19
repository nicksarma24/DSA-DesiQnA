import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class SPFENHM5 {

    class Node{
        int vertex, weight;

        Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }    
    }

     public static void main(String args[] ) throws Exception {
        Scanner scanner = new Scanner(System.in);

        int nodes = scanner.nextInt();
        int edges = scanner.nextInt();
        
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= nodes; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<edges;i++){
            int n1 = scanner.nextInt();
            int n2 = scanner.nextInt();
            int weight = scanner.nextInt();

            graph.get(n1).add(new Node(n2, weight));
            graph.get(n2).add(new Node(n1, weight));
        }
        int sourceNode = scanner.nextInt();
        
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(sourceNode);
        
        int[] distances = new int[nodes+1];
        int[] numOfFives = new int[nodes+1];

        Arrays.fill(distances, -1); // Initialize distances to -1
        distances[sourceNode] = 0;

        boolean visited[] = new boolean[nodes+1];
        visited[sourceNode] = true;
        
        numOfFives[sourceNode] = 0;

        while(queue.size()!=0){
            int top = queue.poll();
            int size =  graph.get(top).size();

            for(int i=0;i<size;i++){
                int neighbourVertex = graph.get(top).get(i).vertex;

                if(!visited[neighbourVertex]){
                    queue.add(neighbourVertex);
                    visited[neighbourVertex] = true;
                    distances[neighbourVertex] = distances[top]+1 ;

                    if(graph.get(top).get(i).weight==5)
                        numOfFives[neighbourVertex] = numOfFives[top]+1;
                }else if(distances[neighbourVertex] == distances[top]+1 && (graph.get(top).get(i).weight==5 && numOfFives[neighbourVertex] < numOfFives[top]+1)){
                    numOfFives[neighbourVertex] = numOfFives[top]+1;
                }
            }
        }

        System.out.println(Arrays.toString(distances));
    }
}
