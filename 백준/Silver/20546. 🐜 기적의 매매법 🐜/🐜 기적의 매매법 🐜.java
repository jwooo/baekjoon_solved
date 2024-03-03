import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        int money = Integer.parseInt(br.readLine());

        int[] dayOfPrice = new int[15];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= 14; i++) {
            dayOfPrice[i] = Integer.parseInt(st.nextToken());
        }

        int bnfValue = calcBuyAndPray(money, dayOfPrice);
        int timingValue = calcTiming(money, dayOfPrice);

        if (bnfValue > timingValue) {
            System.out.println("BNP");
        } else if (bnfValue < timingValue) {
            System.out.println("TIMING");
        } else {
            System.out.println("SAMESAME");
        }
    }

    private static int calcBuyAndPray(int money, int[] dayOfPrice) {
        int stockCount = 0;

        for (int i = 1; i <= 14; i++) {
            if (money / dayOfPrice[i] > 0) {
                stockCount = stockCount + (money / dayOfPrice[i]);
                money = money - (dayOfPrice[i] * (money / dayOfPrice[i]));
            }
        }

        return money + (stockCount * dayOfPrice[14]);
    }

    private static int calcTiming(int money, int[] dayOfPrice) {
        int increaseCount = 0;
        int decreaseCount = 0;
        int stockCount = 0;

        for (int i = 2; i <= 14; i++) {
            if (dayOfPrice[i - 1] < dayOfPrice[i]) {
                increaseCount++;
                decreaseCount = 0;
            }
            if (dayOfPrice[i - 1] > dayOfPrice[i]) {
                decreaseCount++;
                increaseCount = 0;
            }

            if (increaseCount >= 3) {
                if (stockCount > 0) {
                    money = money + (dayOfPrice[i] * stockCount);
                    stockCount = 0;
                }
            }
            if (decreaseCount >= 3) {
                if (money / dayOfPrice[i] > 0) {
                    stockCount = stockCount + (money / dayOfPrice[i]);
                    money = money - (dayOfPrice[i] * (money / dayOfPrice[i]));
                }
            }
        }

        return money + (stockCount * dayOfPrice[14]);
    }
}
