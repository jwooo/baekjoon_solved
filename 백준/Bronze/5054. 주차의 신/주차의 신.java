import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		
		for(int i = 0;i < num; i++) {
			int sum=0;
			
			int s = Integer.parseInt(br.readLine());			
			StringTokenizer token = new StringTokenizer(br.readLine());
			
			int[] xi = new int[s];
			for(int j = 0; j < s; j++){
				xi[j] = Integer.parseInt(token.nextToken());
			}
			
			Arrays.sort(xi);
			for(int k = 0; k < s - 1; k++){
				sum += (xi[k+1]-xi[k]);
			}
			
			sum*=2;
			System.out.println(sum);
		}
	}
}