import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        List<Integer>[] nodes = new ArrayList[n + 1];
        
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < wires.length; i++) {
            int nowNode = wires[i][0];
            int addNode = wires[i][1];
            
            nodes[nowNode].add(addNode);
            nodes[addNode].add(nowNode);
        }
        
        for (int i = 0; i < wires.length; i++) {
            int node1 = wires[i][0];
            int node2 = wires[i][1];
            
            boolean[] visited = new boolean[n + 1];
            
            nodes[node1].remove(Integer.valueOf(node2));
            nodes[node2].remove(Integer.valueOf(node1));
            
            int count = dfs(1, visited, nodes);
            int diff = Math.abs(count - (n - count));
          
            answer = Math.min(answer, diff);
            
            nodes[node1].add(node2);
            nodes[node2].add(node1);
        }
        
        
        return answer;
    }
 
    private int dfs(int node, boolean[] visited, List<Integer>[] nodes) {
        visited[node] = true;
        int count = 1;
        
        for (int now : nodes[node]) {
            if (!visited[now]) count += dfs(now, visited, nodes);
        }
        
        return count;
    }
}