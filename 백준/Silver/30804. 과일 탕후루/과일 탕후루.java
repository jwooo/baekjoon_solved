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

    void solution() throws IOException {
        int n = Integer.parseInt(br.readLine());
        
        st = new StringTokenizer(br.readLine());
        int[] fruits = new int[n];
        
        for (int i = 0; i < n; i++) {
            fruits[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] count = new int[10];
        int distinct = 0;
        int maxLength = 0;
        int left = 0;
        
        for (int right = 0; right < n; right++) {
           int now = fruits[right];
           
           if (count[now] == 0) distinct++;
           count[now]++;
           
           while (distinct > 2) {
               int leftFruit = fruits[left];
               count[leftFruit]--;
               
               if (count[leftFruit] == 0) distinct--;
               left++;
           }
           
           maxLength = Math.max(maxLength, right - left + 1);
        }

        System.out.println(maxLength);
    }
    
}