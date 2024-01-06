import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int k;
    static Set<Integer> result = new HashSet<>();
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) {
        input();
        calculate(0, "");
        output();
    }

    public static void input() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            n = Integer.parseInt(br.readLine());
            k = Integer.parseInt(br.readLine());

            arr = new int[n];
            visited = new boolean[n];

            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void calculate(int depth, String now) {
        if (depth == k) {
            result.add(Integer.parseInt(now));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                calculate(depth + 1, now + arr[i]);
                visited[i] = false;
            }
        }
    }

    public static void output() {
        System.out.println(result.size());
    }
}
