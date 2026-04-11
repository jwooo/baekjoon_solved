import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    public void solution() throws IOException {
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long money = Long.parseLong(st.nextToken());

        int[] price = new int[n];
        for (int i = 0; i < n; i++) {
            price[i] = Integer.parseInt(br.readLine());
        }

        long coin = 0;
        for (int i = 0; i < n - 1; i++) {
            if (price[i] < price[i + 1]) {
                long buy = money / price[i];
                coin += buy;
                money -= buy * price[i];
            } else if (price[i] > price[i + 1]) {
                money += coin * price[i];
                coin = 0;
            }
        }

        money += coin * price[n - 1];
        System.out.println(money);
    }

}