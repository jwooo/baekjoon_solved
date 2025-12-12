import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    public void solution() throws IOException {
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); 
        int w = Integer.parseInt(st.nextToken()); 
        int l = Integer.parseInt(st.nextToken()); 

        int[] trucks = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            trucks[i] = Integer.parseInt(st.nextToken());
        }

        int nowTime = 1;
        int nowWeight = trucks[0];
        int index = 1;

        Queue<int[]> bridge = new LinkedList<>();
        bridge.offer(new int[]{trucks[0], 1});

        while (!bridge.isEmpty()) {
            bridge.forEach(i -> {
                i[1] += 1;
            });

            if (!bridge.isEmpty() && bridge.peek()[1] > w) {
                nowWeight -= bridge.poll()[0];
            }

            if (index < n && trucks[index] + nowWeight <= l) {
                nowWeight += trucks[index];
                bridge.offer(new int[]{trucks[index++], 1});
            }

            nowTime++;
        }

        System.out.println(nowTime);
    }
}
