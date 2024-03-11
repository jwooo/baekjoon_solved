import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    Map<String, Integer> map = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        int n = Integer.parseInt(br.readLine());

        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = st.nextToken();
        }

        for (int i = 0; i < n; i++) {
            String now = arr[i];

            boolean checkPoint = false;
            StringBuilder extention = new StringBuilder();
            for (int j = 0; j < now.length(); j++) {
                char nowIndexValue = now.charAt(j);

                if (nowIndexValue == '.') {
                    checkPoint = true;
                    continue;
                }
                if (checkPoint) extention.append(nowIndexValue);
            }

            if (map.containsKey(extention.toString())) {
                Integer oldValue = map.get(extention.toString());
                map.replace(extention.toString(), oldValue + 1);
            } else {
                map.put(extention.toString(), 1);
            }
        }

        List<String> keySets = new ArrayList<>(map.keySet());
        keySets.sort((s1, s2) -> s1.compareTo(s2));

        StringBuilder result = new StringBuilder();
        for (String keySet : keySets) {
            result.append(keySet + " ");
            result.append(map.get(keySet));
            result.append("\n");
        }

        System.out.println(result.toString());
    }
}