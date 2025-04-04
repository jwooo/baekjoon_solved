import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int inventory = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int minTime = Integer.MAX_VALUE;
        int resultHeight = 0;

        for (int height = 0; height <= 256; height++) {
            int time = 0;
            int nowInventory = inventory;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int diff = map[i][j] - height;
                    if(diff > 0) {
                        time += diff * 2;
                        nowInventory += diff;
                    } else if(diff < 0) {
                        time += (-diff);
                        nowInventory += diff; 
                    }
                }
            }
            
            if(nowInventory < 0) continue; 
            if(time < minTime || (time == minTime && height > resultHeight)) {
                minTime = time;
                resultHeight = height;
            }
        }
        
        System.out.println(minTime + " " + resultHeight);
    }
}
