import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        boolean[] visited = new boolean[n];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        int answer = 0;
        int count = 0;
        
        visited[0] = true;
        for (int[] cost : costs) {
            if (cost[0] == 0 || cost[1] == 0) {
                pq.offer(new Edge(cost[0], cost[1], cost[2]));
            }
        }
        
        while (!pq.isEmpty() && count < n - 1) {
            Edge edge = pq.poll();
            int next = -1;
            
            if (!visited[edge.start] && visited[edge.end]) {
                next = edge.start;
            } else if (visited[edge.start] && !visited[edge.end]) {
                next = edge.end;
            } else {
                continue; 
            }
            
            visited[next] = true;
            answer += edge.weight;
            count++;
            
            for (int[] cost : costs) {
                if (cost[0] == next && !visited[cost[1]]) {
                    pq.offer(new Edge(cost[0], cost[1], cost[2]));
                } else if (cost[1] == next && !visited[cost[0]]) {
                    pq.offer(new Edge(cost[0], cost[1], cost[2]));
                }
            }
        }
        
        return answer;
    }

    static class Edge implements Comparable<Edge> {
        int start, end, weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge e) {
            return this.weight - e.weight;
        }
    }
}
