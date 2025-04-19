import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    static int answer = Integer.MAX_VALUE;
    static List<int[]> restaurants = new ArrayList<>();
    static List<int[]> houses = new ArrayList<>();
    static int[][] map;

    void solution() throws IOException {
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int number = Integer.parseInt(st.nextToken());
                if (number == 2) {
                    restaurants.add(new int[]{i, j});
                } else if (number == 1) {
                    houses.add(new int[]{i, j});
                }
                map[i][j] = number;
            }
        }

        dfs(0, m, 0, new ArrayList<>());
        System.out.println(answer);
    }

    private void dfs(int depth, int limit, int now, List<int[]> visitRestaurants) {
        if (depth == limit) {
            int distance = 0;
            for (int i = 0; i < houses.size(); i++) {
                int[] house = houses.get(i);
                int minDistance = Integer.MAX_VALUE;
                for (int j = 0; j < visitRestaurants.size(); j++) {
                    int[] rest = visitRestaurants.get(j);
                    minDistance = Math.min(minDistance, Math.abs(house[0] - rest[0]) + Math.abs(house[1] - rest[1]));
                }
                distance += minDistance;
            }

            answer = Math.min(answer, distance);
            return;
        }

        for (int i = now; i < restaurants.size(); i++) {
            visitRestaurants.add(restaurants.get(i));
            dfs(depth + 1, limit, i + 1, visitRestaurants);
            visitRestaurants.remove(visitRestaurants.size() - 1);
        }
    }

}