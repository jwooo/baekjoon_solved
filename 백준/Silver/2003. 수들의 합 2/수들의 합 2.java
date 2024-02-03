import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int i = 0;
        int j = 0;
        int result = 0;

        int[] a = new int[n];

        st = new StringTokenizer(br.readLine());

        for(int k = 0; k < a.length; k++) {
            a[k] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;

        while(true) {
            if(sum >= m) sum -= a[i++];
            else if(j == n) break;
            else sum += a[j++];

            if(sum == m) result++;
        }

        System.out.println(result);

    }
}

