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

    static int n;
    static int[] nutrition;
    static int[][] foods;
    static int answer = Integer.MAX_VALUE;
    static List<Integer> indexes = new ArrayList<>();
    static List<Integer> answerIndexes = new ArrayList<>();

    public void solution() throws IOException {
        n = Integer.parseInt(br.readLine());

        nutrition = new int[4];
        foods = new int[n][5];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            nutrition[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 5; j++) {
                foods[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] nowNutrition = new int[4];
        dfs(0, nowNutrition, 0);

        if (answer != Integer.MAX_VALUE) {
            System.out.println(answer);

            StringBuilder sb = new StringBuilder();
            for (int ai : answerIndexes) {
                sb.append(ai + 1).append(" ");
            }

            System.out.println(sb.toString().trim());
        } else {
            System.out.println(-1);
        }
    }

    private void dfs(int index, int[] nowNutrition, int cost) {
        if (isFulledNutrition(nowNutrition)) {
            if (cost < answer) {
                answer = cost;

                answerIndexes.clear();
                answerIndexes.addAll(indexes);
            }

            return;
        }

        for (int i = index; i < n; i++) {
            updateNutrition(i, nowNutrition, true);
            indexes.add(i);

            dfs(i + 1, nowNutrition, cost + foods[i][4]);

            updateNutrition(i, nowNutrition, false);
            indexes.remove(indexes.size() - 1);
        }
    }

    private boolean isFulledNutrition(int[] nowNutrition) {
        for (int i = 0; i < 4; i++) {
            if (nutrition[i] > nowNutrition[i]) {
                return false;
            }
        }

        return true;
    }

    private void updateNutrition(int index, int[] nowNutrition, boolean isAdd) {
        for (int i = 0; i < foods[index].length - 1; i++) {
            if (isAdd) {
                nowNutrition[i] += foods[index][i];
            } else {
                nowNutrition[i] -= foods[index][i];
            }
        }
    }
}