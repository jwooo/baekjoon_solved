import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    public void solution() throws IOException {
        int n = Integer.parseInt(br.readLine());

        List<Town> towns = new ArrayList<>();
        long totalPopulation = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int location = Integer.parseInt(st.nextToken());
            int population = Integer.parseInt(st.nextToken());

            towns.add(new Town(location, population));
            totalPopulation += population;
        }

        Collections.sort(towns);

        long medianPopulation = (totalPopulation + 1) / 2;

        long cumulativePopulation = 0;
        for (Town town : towns) {
            cumulativePopulation += town.population;

            if (cumulativePopulation >= medianPopulation) {
                System.out.println(town.location);
                break;
            }
        }
    }

    static class Town implements Comparable<Town> {
        int location;
        int population;

        public Town(int location, int population) {
            this.location = location;
            this.population = population;
        }

        @Override
        public int compareTo(Town o) {
            return Integer.compare(this.location, o.location);
        }
    }

}