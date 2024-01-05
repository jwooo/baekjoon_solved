import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int k;
    static int[] arr;
    static int result = 0;

    public static void main(String[] args) {
       input();
       calculate(0);
       output();
    }

    public static void input() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        try {
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            arr = new int[k];

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < k; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void calculate(int num) {
        if (num > n) return;
        if (result < num) result = num;

        for (int i = 0; i < k; i++) {
            calculate(num * 10 + arr[i]);
        }
    }

    public static void output() {
        System.out.println(result);
    }
}
