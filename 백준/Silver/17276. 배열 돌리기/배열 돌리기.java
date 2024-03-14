import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (testCase-- > 0) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int rotate = Integer.parseInt(st.nextToken());
            int middle = (n + 1) / 2;

            int[][] arr = new int[n + 1][n + 1];

            for (int i = 1; i <= n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] copyArr;

            while (rotate != 0) {
                copyArr = new int[n + 1][n + 1];

                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= n; j++) {
                        copyArr[i][j] = arr[i][j];
                    }
                }

                // | -> / & | -> 역슬래쉬
                for (int i = 1; i <= middle; i++) {
                    if (rotate > 0) {
                        copyArr[i][n + 1 - i] = arr[i][middle];
                    } else {
                        copyArr[i][i] = arr[i][middle];
                    }
                }

                // / -> --- & / -> |
                for (int i = 1; i <= middle; i++) {
                    if (rotate > 0) {
                        copyArr[middle][n + 1 - i] = arr[i][n + 1 - i];
                    } else {
                        copyArr[i][middle] = arr[i][n + 1 - i];
                    }
                }

                // -> --- -> 역슬래쉬 & --- -> /
                for (int i = middle; i <= n; i++) {
                    if (rotate > 0) {
                        copyArr[i][i] = arr[middle][i];
                    } else {
                        copyArr[n + 1 - i][i] = arr[middle][i];
                    }
                }

                // 역슬래쉬 -> | & 역슬래쉬 -> ----
                for (int i = middle; i <= n; i++) {
                    if (rotate > 0) {
                        copyArr[i][middle] = arr[i][i];
                    } else {
                        copyArr[middle][i] = arr[i][i];
                    }
                }

                // | -> / & | -> 역슬래쉬
                for (int i = middle; i <= n; i++) {
                    if (rotate > 0) {
                        copyArr[i][n + 1 - i] = arr[i][middle];
                    } else {
                        copyArr[i][i] = arr[i][middle];
                    }
                }

                // / -> --- & / -> |
                for (int i = middle; i <= n; i++) {
                    if (rotate > 0) {
                        copyArr[middle][n + 1 - i] = arr[i][n + 1 - i];
                    } else {
                        copyArr[i][middle] = arr[i][n + 1 - i];
                    }
                }

                // --- -> / & --- -> 역슬래쉬
                for (int i = 1; i <= middle; i++) {
                    if (rotate > 0) {
                        copyArr[i][i] = arr[middle][i];
                    } else {
                        copyArr[n + 1 - i][i] = arr[middle][i];
                    }
                }

                for (int i = 1; i <= middle; i++) {
                    if (rotate > 0) {
                        copyArr[i][middle] = arr[i][i];
                    } else {
                        copyArr[middle][i] = arr[i][i];
                    }
                }

                if (rotate > 0) {
                    rotate = rotate - 45;
                } else {
                    rotate = rotate + 45;
                }

                arr = copyArr;
            }

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    sb.append(arr[i][j] + " ");
                }
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }
}