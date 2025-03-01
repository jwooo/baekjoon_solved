import java.util.*;

class Solution {
    static class Node implements Comparable<Node> {
        int vertex;
        int distance;
        
        public Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
        
        @Override
        public int compareTo(Node other) {
            return this.distance - other.distance;
        }
    }
    
    public int solution(int N, int[][] road, int K) {
        List<Node>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] r : road) {
            int a = r[0], b = r[1], c = r[2];
            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }
        
        int[] distance = new int[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[1] = 0;
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));
        
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int curVertex = current.vertex;
            int curDist = current.distance;
            
            if (curDist > distance[curVertex]) continue;
            
            for (Node next : graph[curVertex]) {
                int nextVertex = next.vertex;
                int nextDistance = curDist + next.distance;
                if (nextDistance < distance[nextVertex]) {
                    distance[nextVertex] = nextDistance;
                    pq.offer(new Node(nextVertex, nextDistance));
                }
            }
        }
        
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (distance[i] <= K) count++;
        }
        
        return count;
    }
}
