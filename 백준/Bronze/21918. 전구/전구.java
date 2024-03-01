import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int commandNumber = Integer.parseInt(st.nextToken());
            int startIndex = Integer.parseInt(st.nextToken());
            int endIndex = Integer.parseInt(st.nextToken());

            new Command(commandNumber, startIndex, endIndex).executeCommand(arr);
        }

        for (int i = 1; i <= n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    static class Command {
        int commandNumber;
        int startIndex;
        int endIndex;

        public Command(int commandNumber, int startIndex, int endIndex) {
            this.commandNumber = commandNumber;
            this.startIndex = startIndex;
            this.endIndex = endIndex;
        }

        public void executeCommand(int[] arr) {
            if (commandNumber == 1) {
                arr[startIndex] = endIndex;
            } else if (commandNumber == 2) {
                for (int i = startIndex; i <= endIndex; i++) {
                    if (arr[i] == 1) arr[i] = 0;
                    else arr[i] = 1;
                }
            } else if (commandNumber == 3) {
                for (int i = startIndex; i <= endIndex; i++) {
                    arr[i] = 0;
                }
            } else if (commandNumber == 4) {
                for (int i = startIndex; i <= endIndex; i++) {
                    arr[i] = 1;
                }
            }
        }
    }
}
