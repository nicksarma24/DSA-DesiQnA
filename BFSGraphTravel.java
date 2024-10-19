import java.util.*;

public class BFSGraphTravel {
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
        System.out.println("----");
        for (int i = 1; i <= nodes; i++) {
            System.out.println("Node " + i + ": " + graph.get(i));
        }
        

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        System.out.println("-----");
        boolean visited[] = new boolean[nodes + 1];

        visited[1] = true;
        
        int level = 0;
        while (!queue.isEmpty()) {
            int top = queue.poll();
            
            System.out.println(level);
            
            for (int neighbor : graph.get(top)) {
                if (!visited[neighbor]) {
                    queue.add(neighbor);
                    visited[neighbor] = true;
                }
            }
        }               
    }
}