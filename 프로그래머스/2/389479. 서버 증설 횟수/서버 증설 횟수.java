import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        Queue<int[]> servers = new LinkedList<>();
        
        for (int i = 0; i < players.length; i++) {
            int player = players[i];
            
            if (player >= m) {
                int acceptServer = 0;
                
                for (int[] server : servers) acceptServer += server[0];
                int acceptPlayer = acceptServer * m;
                
                if (player > acceptPlayer) {
                    int addServer = (player - acceptPlayer) / m;
                    answer += addServer;
                    servers.offer(new int[] {addServer, k});
                }
            }
            
            int count = 0;
            int serverSize = servers.size();
            while (!servers.isEmpty() && count < serverSize) {
                int[] server = servers.poll();
                if (--server[1] > 0) servers.offer(server);
                count++;
            }
        }
        
        return answer;
    }
}