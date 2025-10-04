import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    public void solution() throws IOException {
        String[] colorList = new String[5]; 
        int[] numList = new int[5]; 
        int colorCount = 1; 
        int[] numCount = new int[10]; 

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());

            String color = st.nextToken();
            int num = Integer.parseInt(st.nextToken());

            colorList[i] = color;
            numList[i] = num;

            if (i >= 1 && colorList[i - 1].equals(colorList[i])) {
                colorCount++;
            }
            numCount[num]++;
        }
        Arrays.sort(numList);

        int continuedNumCount = 1; 

        for (int i = 0; i < 5; i++) {
            if (i >= 1 && numList[i] == numList[i - 1] + 1) {
                continuedNumCount++;
            }
        }

        int fourSameNum = 0;
        int threeSameNum = 0;
        int twoSameNum = 0;
        int twoOtherSameNum = 0;

        for (int i = 1; i <= 9; i++) {
            if (numCount[i] == 4) {
                fourSameNum = i;
                break;
            } else if (numCount[i] == 3) {
                threeSameNum = i;
            } else if (numCount[i] == 2) {
                if (twoSameNum == 0) {
                    twoSameNum = i;
                } else {
                    twoOtherSameNum = i;
                }
            }
        }

        int max = numList[4]; 
        int score;

        if (colorCount == 5 && continuedNumCount == 5) { 
            score = max + 900;
        } else if (fourSameNum > 0) {
            score = fourSameNum + 800;
        } else if (threeSameNum > 0 && twoSameNum > 0) { 
            score = threeSameNum * 10 + twoSameNum + 700;
        } else if (colorCount == 5) {
            score = max + 600;
        } else if (continuedNumCount == 5) { 
            score = max + 500;
        } else if (threeSameNum > 0) { 
            score = threeSameNum + 400;
        } else if (twoSameNum > 0 && twoOtherSameNum > 0) { 
            score = Math.max(twoSameNum, twoOtherSameNum) * 10 + Math.min(twoSameNum, twoOtherSameNum) + 300;
        } else if (twoSameNum > 0) { 
            score = twoSameNum + 200;
        } else { 
            score = max + 100;
        }

        System.out.println(score);
    }
}