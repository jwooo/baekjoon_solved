import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            String line = br.readLine();
            String[] times = line.split(" ");

            String startTimeStr = times[0];
            String endTimeStr = times[1];

            String[] startTokens = startTimeStr.split(":");
            int h1 = Integer.parseInt(startTokens[0]);
            int m1 = Integer.parseInt(startTokens[1]);
            int s1 = Integer.parseInt(startTokens[2]);

            String[] endTokens = endTimeStr.split(":");
            int h2 = Integer.parseInt(endTokens[0]);
            int m2 = Integer.parseInt(endTokens[1]);
            int s2 = Integer.parseInt(endTokens[2]);

            int count = 0;
            int currentH = h1;
            int currentM = m1;
            int currentS = s1;

            while (true) {
                if ((currentH * 10000 + currentM * 100 + currentS) % 3 == 0) {
                    count++;
                }

                if (currentH == h2 && currentM == m2 && currentS == s2) {
                    break;
                }

                currentS++;
                if (currentS == 60) {
                    currentS = 0;
                    currentM++;
                    if (currentM == 60) {
                        currentM = 0;
                        currentH++;
                        if (currentH == 24) {
                            currentH = 0;
                        }
                    }
                }
            }
            
            
            sb.append(count).append("\n");
        }

        System.out.print(sb.toString());
    }
}