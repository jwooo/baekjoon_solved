import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> sortList = createSortList(arr);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int num = arr[i];
            sb.append(binarySearch(num, sortList)).append(" ");
        }

        System.out.println(sb);
    }

    private List<Integer> createSortList(int[] arr) {
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            int now = arr[i];

            if (!set.contains(now)) {
                set.add(now);
                list.add(now);
            }
        }

        list.sort(Integer::compare);
        return list;
    }

    private int binarySearch(int target, List<Integer> list) {
        int start = 0;
        int end = list.size() - 1;

        while (start < end) {
            int mid = (start + end) / 2;

            if (target <= list.get(mid)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

}