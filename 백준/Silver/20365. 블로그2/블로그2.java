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
        int n = Integer.parseInt(br.readLine());
        String colors = br.readLine();
        
        int r = 0;
        int b = 0;
        
        if (colors.charAt(0) == 'R') r++;
        else b++;
        
        for (int i = 1; i < n; i++) {
            char now = colors.charAt(i);
            char prev = colors.charAt(i - 1);
            
            if (now != prev) {
                if (now == 'R') {
                    r++;
                } else {
                    b++;
                }
            }
        }
        
        int result = Math.min(r, b) + 1;
        System.out.println(result);
    }

}