import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public Main() {
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    public void solution() throws IOException {
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] useOrder = new int[k];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            useOrder[i] = Integer.parseInt(st.nextToken());
        }

        Set<Integer> multitap = new HashSet<>();
        int unplugCount = 0;

        for (int i = 0; i < k; i++) {
            int currentAppliance = useOrder[i];

            if (multitap.contains(currentAppliance)) {
                continue;
            }

            if (multitap.size() < n) {
                multitap.add(currentAppliance);
                continue;
            }

            unplugCount++;

            int applianceToUnplug = -1;
            int farthestUse = -1;

            for (int pluggedAppliance : multitap) {
                int nextUse = -1;

                for (int j = i + 1; j < k; j++) {
                    if (useOrder[j] == pluggedAppliance) {
                        nextUse = j;
                        break;
                    }
                }

                if (nextUse == -1) {
                    applianceToUnplug = pluggedAppliance;
                    break;
                }

                if (nextUse > farthestUse) {
                    farthestUse = nextUse;
                    applianceToUnplug = pluggedAppliance;
                }
            }

            multitap.remove(applianceToUnplug);
            multitap.add(currentAppliance);
        }

        System.out.println(unplugCount);
    }

}