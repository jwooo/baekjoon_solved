import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    static int[] arr = new int[9];
    static boolean isFind = false;

    public void solution() throws IOException {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        combination(0, 0, 0, new ArrayList<>());
    }

    private void combination(int depth, int index, int value, List<Integer> choices) {
        if (isFind) {
            return;
        }
        if (depth == 7) {
            if (value == 100) {
                isFind = true;
                choices.forEach(System.out::println);
            }

            return;
        }

        for (int i = index; i < arr.length; i++) {
            choices.add(arr[i]);
            combination(depth + 1, i + 1, value + arr[i], choices);
            choices.remove(choices.size() - 1);
        }
    }
}
