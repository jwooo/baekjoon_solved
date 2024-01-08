import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String word;
    static int n;
    static String result;

    public static void main(String[] args) {
        input();
        calculate();
        output();
    }


    public static void input() {
        try {
            word = br.readLine();
            n = Integer.parseInt(br.readLine());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void calculate() {
       result = String.valueOf(word.charAt(n-1));
    }

    public static void output() {
        System.out.println(result);
    }
}
