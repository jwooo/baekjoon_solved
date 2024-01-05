import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int nowFatigue = 0;
    static int increaseFatigue;
    static int decreaseFatigue;
    static int maximumFatigue;
    static int throughput;
    static int result;


    public static void main(String[] args) {
       input();
       calculateFatigue();
    }

    public static void input() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        try {
            st = new StringTokenizer(br.readLine());

            increaseFatigue = Integer.parseInt(st.nextToken());
            throughput = Integer.parseInt(st.nextToken());
            decreaseFatigue = Integer.parseInt(st.nextToken());
            maximumFatigue = Integer.parseInt(st.nextToken());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void calculateFatigue() {
        for (int i = 0; i < 24; i++) {
            if (nowFatigue + increaseFatigue <= maximumFatigue) {
                result += throughput;
                nowFatigue += increaseFatigue;
            } else {
                if (nowFatigue - decreaseFatigue >= 0) {
                    nowFatigue -= decreaseFatigue;
                } else {
                    nowFatigue = 0;
                }
            }
        }

        System.out.println(result);
    }
}

