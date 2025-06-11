import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        int max = 0;
        List<List<Edge>> graph = new ArrayList<>();
        boolean[] visited = new boolean[edge.length + 1];
        
        for (int i = 0; i < edge.length; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 1; i <= edge.length; i++) {
            int startNode = edge[i - 1][0];
            int endNode = edge[i - 1][1];
            
            graph.get(startNode).add(new Edge(endNode, 0));
            graph.get(endNode).add(new Edge(startNode, 0));
        }
        
        Queue<Edge> queue = new LinkedList<>();
        queue.offer(new Edge(1, 0));
        visited[1] = true;
        
        while (!queue.isEmpty()) {
            Edge now = queue.poll(); 
            
            for (Edge next : graph.get(now.node)) {
                int nextWeight = now.weight + 1;
                
                if (!visited[next.node]) {
                    visited[next.node] = true;
                    
                    if (nextWeight > max) {
                        max = nextWeight;
                        answer = 1;
                    } else if (nextWeight == max) {
                        answer++;
                    }
                    
                    queue.offer(new Edge(next.node, nextWeight));
                }
            }
        }
        
        return answer;
    }
    
    static class Edge {
        int node;
        int weight;
        
        public Edge(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }
}