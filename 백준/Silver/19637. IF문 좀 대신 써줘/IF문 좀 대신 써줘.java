import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] power;
    static String[] title;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        power = new int[N];
        title = new String[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            
            title[i] = st.nextToken();
            power[i] = Integer.parseInt(st.nextToken());
        }
        
        for (int i = 0; i < M; i++) {
            int key = Integer.parseInt(br.readLine());
            binarySearch(key);
        }
        
        System.out.println(sb);
        
    }

    static void binarySearch(int key) {
        int left = 0;
        int right = N;
        int index = 0;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            
            if (key <= power[mid]) {
                right = mid - 1;
                index = mid;
            } else if (key > power[mid]) {
                left = mid + 1;
            }
        }
        
        sb.append(title[index]).append("\n");
    }
    
}