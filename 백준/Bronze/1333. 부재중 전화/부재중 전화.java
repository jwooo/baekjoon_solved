import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());  
        int l = Integer.parseInt(st.nextToken()); 
        int d = Integer.parseInt(st.nextToken());
        
        boolean[] time = new boolean[n * l + 5 * (n - 1)];  

        for (int i = 0; i < n; i++) {
            int startTime = (l + 5) * i;  
            for (int j = startTime; j < startTime + l; j++) {
                time[j] = true; 
            }
        }

        int bell = 0;
        while (bell < time.length) {
            if (!time[bell]) {
                break;
            }
            bell += d;  
        }

        System.out.println(bell);
    }
}