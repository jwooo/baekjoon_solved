import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        List<Integer> answer = new ArrayList<>();
        List<List<Edge>> graph = new ArrayList<>();
        
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < roads.length; i++) {
            int start = roads[i][0];
            int end = roads[i][1];
            
            graph.get(start).add(new Edge(end, 1));
            graph.get(end).add(new Edge(start, 1));
        }
        
        int[] distances = new int[graph.size()];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[destination] = 0;
        
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(destination, 0));
        
        while (!pq.isEmpty()) {
            Edge now = pq.poll();
            
            if (now.weight > distances[now.node]) continue;
            
            for (Edge next : graph.get(now.node)) {
                int nextDistance = now.weight + next.weight;
                
                if (nextDistance < distances[next.node]) {
                    distances[next.node] = nextDistance;
                    pq.offer(new Edge(next.node, nextDistance));
                }
            }
        }
        
        for (int i = 0; i < sources.length; i++) {
            int node = sources[i];
            int distance = distances[node];
         
            if (distance == Integer.MAX_VALUE) answer.add(-1);
            else answer.add(distance);
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    static class Edge implements Comparable<Edge> {
        int node;
        int weight;
        
        public Edge(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
        
        @Override
        public int compareTo(Edge edge) {
            return this.weight - edge.weight;
        }
    }
}