import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int result = 0;
	static int[][] arr;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		
		visited = new boolean[m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		calculate(0, 0);
		output();
	}
	
	private static void output() {
		System.out.println(result);
	}
	
	private static void calculate(int depth, int startIndex) {
		if (depth == 3) {
			int sum = 0; 
			
			for (int i = 0; i < n; i++) {
				int temp = 0;
				
				for (int j = 0; j < m; j++) {
					if (visited[j]) temp = Math.max(temp, arr[i][j]);
				}
				
				sum += temp;
			}
			
			result = Math.max(sum, result);
			return;
		}
		
		for (int i = startIndex; i < m; i++) {
				visited[i] = true;
				calculate(depth + 1, i + 1);
				visited[i] = false;
		}
	}
}
