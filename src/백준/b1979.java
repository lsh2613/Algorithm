package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b1979 {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int from = 1; from <= N; from++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int to = 1; to <= N; to++) {
                int isConnected = Integer.parseInt(st.nextToken());
                if (isConnected == 1)
                    union(from, to);
            }
        }

        int[] travelCities = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        boolean canTravel = true;
        for (int i = 1; i < M; i++) {
//            if (parent[travelCities[i]] != parent[travelCities[i - 1]]) {
//                canTravel = false;
//                break;
//            }
            if (find(travelCities[i]) != find(travelCities[i - 1])) {
                canTravel = false;
                break;
            }
        }
        System.out.println(canTravel ? "YES" : "NO");
    }

    private static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        // case 1
        if (rootA > rootB) {
            parent[rootA] = rootB;
        }
        if (rootA < rootB) {
            parent[rootB] = rootA;
        }
        /* case 2
        if (rootA != rootB) {
            parent[rootA] = rootB;
        }
        */
    }

    private static int find(int n) {
        if (parent[n] != n)
            parent[n] = find(parent[n]);
        return parent[n];
    }
}
