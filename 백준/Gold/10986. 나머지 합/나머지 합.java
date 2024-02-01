import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        long[] s = new long[n];
        long[] c = new long[m];
        
        long answer = 0;
        
        st = new StringTokenizer(br.readLine());
        s[0] = Long.parseLong(st.nextToken());
        for(int i = 1; i < n; i++) {
            s[i] = s[i-1] + Long.parseLong(st.nextToken());
        }
        
        for(int i = 0; i < n; i++) {
            int result = (int)(s[i]%m);
            if(result == 0) answer++;
            c[result]++;
        }
        
        for(int i = 0; i < m; i++) {
            if(c[i] > 1) {
                answer = answer + (c[i]*(c[i]-1)/2);
            }
        }
        System.out.println(answer);
    }
}