import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    static int n;
    static Set<String> shortcuts = new HashSet<>();

    public void solution() throws IOException {
        n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String now = br.readLine();

            int index = findPossibleIndex(now.split(" "));
            if (index == -1) {
                index = findIndexFromFirst(now);
            }

            appendShortcut(index, now, sb);
        }

        System.out.println(sb);
    }

    private int findPossibleIndex(String[] event) {
        int size = 0;

        for (int i = 0; i < event.length; i++) {
            String firstWord = String.valueOf(event[i].charAt(0));

            if (!shortcuts.contains(firstWord.toLowerCase())) {
                shortcuts.add(firstWord.toLowerCase());
                return size;
            }

            size += event[i].length() + 1;
        }

        return -1;
    }

    private int findIndexFromFirst(String event) {
        for (int i = 0; i < event.length(); i++) {
            String now = String.valueOf(event.charAt(i)).toLowerCase();

            if (now.isBlank()) {
                continue;
            }
            if (!shortcuts.contains(now)) {
                shortcuts.add(now);
                return i;
            }
        }

        return -1;
    }

    private void appendShortcut(int index, String event, StringBuilder sb) {
        if (index == -1) {
            sb.append(event).append("\n");
            return;
        }

        for (int i = 0; i < event.length(); i++) {
            char now = event.charAt(i);

            if (index == i) {
                sb.append("[").append(now).append("]");
            } else {
                sb.append(now);
            }
        }

        sb.append("\n");
    }
}
