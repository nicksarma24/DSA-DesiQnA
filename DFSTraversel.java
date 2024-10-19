
import java.util.*;

public class DFSTraversel {
    public static void main(String[] args) {
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

        //dfsStackTraversal(graph, 1);
        dfsRecursiveTraversal(graph, 1);
    }

    public static void dfsStackTraversal(List<List<Integer>> graph, int source){
        Set<Integer> visited = new HashSet<>();
        

        Stack<Integer> stack = new Stack();
        stack.push(source);
        while(stack.size()!=0){
            int top = stack.pop();
           
            if(!visited.contains(top)){
                visited.add(top);
                System.out.println(top);

                for(int temp: graph.get(top)){
                    if(!visited.contains(temp)){
                        stack.push(temp);
                    }
                }
            }
        }
    }

    public static void dfsRecursiveTraversal(List<List<Integer>> graph, int source){
        boolean visited[] = new boolean[graph.size()];

        dfsRecursiveTraversal(graph, source, visited);
    }

    public static void dfsRecursiveTraversal(List<List<Integer>> graph, int source, boolean[] visited) {
        if (visited[source]) {
            return;
        }
        System.out.println(source);
        visited[source] = true;
        for (int i = 0; i < graph.get(source).size(); i++) {
            dfsRecursiveTraversal(graph, graph.get(source).get(i), visited);
        }
    }    
}
