import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.close();

        List<Integer> bestSequence = new ArrayList<>();
        int maxLength = 0;

        for (int second = 1; second <= N; second++) {
            List<Integer> sequence = new ArrayList<>();
            sequence.add(N);
            sequence.add(second);

            while (true) {
                int next = sequence.get(sequence.size() - 2) - sequence.get(sequence.size() - 1);
                if (next < 0) break;
                sequence.add(next);
            }

            if (sequence.size() > maxLength) {
                maxLength = sequence.size();
                bestSequence = new ArrayList<>(sequence);
            }
        }

        System.out.println(maxLength);
        for (int num : bestSequence) {
            System.out.print(num + " ");
        }
    }
}
