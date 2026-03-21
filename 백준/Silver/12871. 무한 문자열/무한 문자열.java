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
        String s = br.readLine();
        String t = br.readLine();
        
        int lenS = s.length();
        int lenT = t.length();
        
        int lcm = lcm(lenS, lenT);
        
        StringBuilder sbS = new StringBuilder();
        StringBuilder sbT = new StringBuilder();
        
        for (int i = 0; i < lcm / lenS; i++) {
            sbS.append(s);
        }
        
        for (int i = 0; i < lcm / lenT; i++) {
            sbT.append(t);
        }
        
        if (sbS.toString().equals(sbT.toString())) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
    
    static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
    
    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

}