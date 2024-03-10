import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static char[] quack = {'q', 'u', 'a', 'c', 'k'};
    static char[] map;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        String quackInput = br.readLine();
        int nowIndex = 0;
        int count = 0;

        map = new char[quackInput.length()];
        visited = new boolean[quackInput.length()];

        for (int i = 0; i < map.length; i++) {
            map[i] = quackInput.toCharArray()[i];
        }

        for (int i = 0; i < map.length; i++) {
            List<Character> list = new ArrayList<>();

            if (!visited[i]) {
                for (int j = i; j < map.length; j++) {
                    if (map[j] == quack[nowIndex] && !visited[j]) {
                        visited[j] = true;
                        list.add(quack[nowIndex]);
                        nowIndex = (nowIndex + 1) % 5;
                    }
                }

                if (list.size() % 5 != 0 || list.size() == 0 || !visited[i]) {
                    System.out.println(-1);
                    return;
                }

                count++;
                nowIndex = 0;
            }
        }

        System.out.println(count);
    }
}