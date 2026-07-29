import java.util.*;

class Solution {

    int[] dx={1,-1,0,0};
    int[] dy={0,0,1,-1};

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int[][] map = new int[102][102];

        for(int[] r : rectangle){
            int x1 = r[0] * 2;
            int y1 = r[1] * 2;
            int x2 = r[2] * 2;
            int y2 = r[3] * 2;

            for(int i = x1; i <= x2; i++){
                for(int j = y1; j <= y2; j++){
                    map[i][j] = 1;
                }
            }
        }

        for(int[] r : rectangle){
            int x1 = r[0] * 2;
            int y1=r[1] * 2;
            int x2=r[2] * 2;
            int y2=r[3] * 2;

            for(int i = x1 + 1; i < x2; i++){
                for(int j = y1 + 1; j < y2; j++){
                    map[i][j] = 0;
                }
            }
        }

        Queue<Node> q = new LinkedList<>();
        boolean[][] visit = new boolean[102][102];

        q.offer(new Node(characterX * 2, characterY * 2, 0));
        visit[characterX * 2][characterY * 2]=true;

        while(!q.isEmpty()){
            Node cur = q.poll();

            if(cur.x == itemX * 2 && cur.y == itemY * 2)
                return cur.d / 2;

            for(int i = 0; i < 4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= 102 || ny >= 102)
                    continue;

                if(visit[nx][ny])
                    continue;

                if(map[nx][ny] == 0)
                    continue;

                visit[nx][ny] = true;
                q.offer(new Node(nx, ny, cur.d + 1));
            }
        }

        return 0;
    }
    
    static class Node{
        int x, y, d;

        public Node(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
}