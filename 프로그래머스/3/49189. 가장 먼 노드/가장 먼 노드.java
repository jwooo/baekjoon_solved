import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        int[] distance = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        List<List<Edge>> graph = new ArrayList<>();
        
        Arrays.fill(distance, Integer.MAX_VALUE);
        
        for (int i = 0; i < edge.length; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 1; i <= edge.length; i++) {
            int startNode = edge[i - 1][0];
            int endNode = edge[i - 1][1];
            
            graph.get(startNode).add(new Edge(endNode, 1));
            graph.get(endNode).add(new Edge(startNode, 1));
        }
        
        Queue<Edge> queue = new LinkedList<>();
        queue.offer(new Edge(1, 0));
        distance[0] = distance[1] = 0;
        visited[1] = true;
        
        while (!queue.isEmpty()) {
            Edge now = queue.poll(); 
            
            if (now.weight < distance[now.node]) {
                distance[now.node] = now.weight;
            }
            
            for (Edge next : graph.get(now.node)) {
                int nextWeight = now.weight + next.weight;
                
                if (distance[next.node] > nextWeight) {
                    distance[next.node] = nextWeight;
                    queue.offer(new Edge(next.node, nextWeight));
                }
            }
        }
        
        Arrays.sort(distance);
        int max = distance[n];
        for (int i = n; i >= 0; i--) {
            if (max == distance[i]) answer++;
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