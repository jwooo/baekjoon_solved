import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public Main() {
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    public void solution() throws IOException {
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Gem[] gems = new Gem[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int weight = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());

            gems[i] = new Gem(weight, price);
        }

        int[] bags = new int[k];
        for (int i = 0; i < k; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(gems, Comparator.comparingInt(g -> g.weight));
        Arrays.sort(bags);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        long totalPrice = 0;
        int index = 0;

        for (int i = 0; i < k; i++) {
            while (index < n && gems[index].weight <= bags[i]) {
                pq.offer(gems[index].price);
                index++;
            }

            if (!pq.isEmpty()) {
                totalPrice += pq.poll();
            }
        }

        System.out.println(totalPrice);
    }

    static class Gem {
        int weight;
        int price;

        public Gem(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }
    }
}