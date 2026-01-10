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

    public void solution() throws IOException {
        int n = Integer.parseInt(br.readLine());

        List<Integer> capacities = new ArrayList<>();
        Set<Integer> uniqueCapacities = new HashSet<>();

        for (int i = 0; i < n; i++) {
            int capacity = Integer.parseInt(br.readLine());

            capacities.add(capacity);
            uniqueCapacities.add(capacity);
        }

        int maxRun = calculateLongestRun(capacities);

        for (int capacityToRemove : uniqueCapacities) {
            List<Integer> tempList = new ArrayList<>();
            for (int capacity : capacities) {
                if (capacity != capacityToRemove) {
                    tempList.add(capacity);
                }
            }

            maxRun = Math.max(maxRun, calculateLongestRun(tempList));
        }

        System.out.println(maxRun);
    }

    private static int calculateLongestRun(List<Integer> list) {
        if (list.isEmpty()) {
            return 0;
        }

        int maxRun = 1;
        int currentRun = 1;

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).equals(list.get(i - 1))) {
                currentRun++;
            } else {
                maxRun = Math.max(maxRun, currentRun);
                currentRun = 1;
            }
        }

        return Math.max(maxRun, currentRun);
    }

}
