import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    public void solution() throws IOException {
        int testCase = Integer.parseInt(br.readLine());

        for (int t = 0; t < testCase; t++) {
            String[] recordedSound = br.readLine().split(" ");
            List<String> allSounds = new ArrayList<>(Arrays.asList(recordedSound));

            Set<String> otherAnimalSounds = new HashSet<>();

            while (true) {
                String line = br.readLine();

                if (line.equals("what does the fox say?")) {
                    break;
                }

                String[] parts = line.split(" goes ");
                otherAnimalSounds.add(parts[1]);
            }

            List<String> foxSounds = new ArrayList<>();
            for (String sound : allSounds) {
                if (!otherAnimalSounds.contains(sound)) {
                    foxSounds.add(sound);
                }
            }

            StringJoiner sj = new StringJoiner(" ");
            for (String sound : foxSounds) {
                sj.add(sound);
            }

            System.out.println(sj);
        }
    }
}
