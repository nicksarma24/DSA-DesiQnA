import java.util.*;

public class SDFMGraph {
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
        Arrays.fill(distances, -1); // Initialize distances to -1
        distances[sourceNode] = 0;

        boolean visited[] = new boolean[nodes+1];
        visited[sourceNode] = true;
        while(queue.size()!=0){
            int flag = 0;
            int top = queue.poll();
            int size =  graph.get(top).size();

            for(int i=0;i<size;i++){
                if(!visited[graph.get(top).get(i)]){
                    queue.add(graph.get(top).get(i));
                    visited[graph.get(top).get(i)] = true;
                    flag = 1;
                    distances[graph.get(top).get(i)] = distances[top]+1 ;
                }
            }
        }

        System.out.println(Arrays.toString(distances));
    }
}