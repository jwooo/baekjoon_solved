import java.util.*;

class Solution {
    public long solution(int[] a, int[][] edges) {
        long sum = 0;
        int n = a.length;
        long[] longWeights = new long[n];
        
        for (int i = 0; i < n; i++) {
            sum += a[i];
            longWeights[i] = a[i];
        }
        
        if (sum != 0) return -1;
        
        List<Integer>[] adj = new ArrayList[n];
        int[] degree = new int[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
            degree[edge[0]]++;
            degree[edge[1]]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                queue.add(i);
            }
        }
        
        long ans = 0;
        boolean[] visited = new boolean[n];
        
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            visited[curr] = true;
            
            for (int neighbor : adj[curr]) {
                if (!visited[neighbor]) {
                    longWeights[neighbor] += longWeights[curr];
                    ans += Math.abs(longWeights[curr]);
                    
                    degree[neighbor]--;
                    if (degree[neighbor] == 1) {
                        queue.add(neighbor);
                    }
                }
            }
        }
        
        return ans;
    }
}