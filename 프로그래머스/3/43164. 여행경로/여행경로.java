import java.util.*;

class Solution {
    static boolean[] visited;
    static List<String> answers;
    static int ticketLength;
    
    public String[] solution(String[][] tickets) {
        setUp(tickets);
        
        List<String> path = new ArrayList<>();
        path.add("ICN");
        dfs("ICN", path, tickets);
        
        return answers.toArray(new String[0]);
    }
    
    private void dfs(String nowAirport, List<String> path, String[][] tickets) {
        if (path.size() == ticketLength + 1) {
            answers = new ArrayList<>(path);
            return;
        }
        
        for (int i = 0; i < ticketLength; i++) {
            if (!visited[i] && tickets[i][0].equals(nowAirport)) {
                visited[i] = true;
                path.add(tickets[i][1]);
                
                dfs(tickets[i][1], path, tickets);
                
                if (!answers.isEmpty()) {
                    return;
                }
                
                path.remove(path.size() - 1);
                visited[i] = false;
            }
        }
    }
    
    private static void setUp(String[][] tickets) {
        ticketLength = tickets.length;
        visited = new boolean[ticketLength];
        answers = new ArrayList<>();
        
        Arrays.sort(tickets, (a, b) -> {
            if (a[0].equals(b[0])) {
                return a[1].compareTo(b[1]);
            }
            
            return a[0].compareTo(b[0]);
        });
    }
}