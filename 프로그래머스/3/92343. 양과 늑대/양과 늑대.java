import java.util.*;

class Solution {
    static List<List<Integer>> adj; 
    static int[] info; 
    static int maxSheep = 0; 

    public int solution(int[] infoArr, int[][] edges) {
        info = infoArr;
        adj = new ArrayList<>();
        for (int i = 0; i < info.length; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
        }

        Set<Integer> visitedNodes = new HashSet<>();
        visitedNodes.add(0); 

        dfs(0, 1, 0, visitedNodes); 

        return maxSheep;
    }
    
    public void dfs(int currentNode, int sheepCount, int wolfCount, Set<Integer> visitedNodes) {
        if (wolfCount >= sheepCount) {
            return;
        }

        maxSheep = Math.max(maxSheep, sheepCount);
        List<Integer> nextPossibleNodes = new ArrayList<>();
        for (int node : visitedNodes) {
            for (int child : adj.get(node)) {
                if (!visitedNodes.contains(child)) { 
                    nextPossibleNodes.add(child);
                }
            }
        }

        for (int nextNode : nextPossibleNodes) {
            Set<Integer> nextVisitedNodes = new HashSet<>(visitedNodes);
            nextVisitedNodes.add(nextNode); 

            if (info[nextNode] == 0) { 
                dfs(nextNode, sheepCount + 1, wolfCount, nextVisitedNodes);
            } else { 
                dfs(nextNode, sheepCount, wolfCount + 1, nextVisitedNodes);
            }
        }
    }
}