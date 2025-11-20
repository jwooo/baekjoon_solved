import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public Main() {
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    public void solution() throws IOException {
        int tc = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < tc; t++) {
            int n = Integer.parseInt(br.readLine());

            int[] arr = new int[n];
            Map<Integer, Integer> map = new HashMap<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            }

            int nowPoint = 1;
            Map<Integer, List<Integer>> point = new HashMap<>();
            for (int i = 0; i < n; i++) {
                if (map.get(arr[i]) >= 6) {
                    List<Integer> list = point.getOrDefault(arr[i], new ArrayList<>());
                    list.add(nowPoint++);

                    point.put(arr[i], list);
                }
            }

            int winner = -1;
            int minPoint = Integer.MAX_VALUE;
            int additionalPoint = Integer.MAX_VALUE;

            for (Integer key : point.keySet()) {
                int sum = 0;
                List<Integer> p = point.get(key);

                for (int i = 0; i < 4; i++) {
                    sum += p.get(i);
                }

                if (minPoint == sum) {
                    if (additionalPoint > p.get(4)) {
                        winner = key;
                        additionalPoint = p.get(4);
                    }
                } else if (minPoint > sum) {
                    winner = key;
                    minPoint = sum;
                    additionalPoint = p.get(4);
                }
            }

            sb.append(winner).append("\n");
        }

        System.out.println(sb.toString().trim());
    }

}