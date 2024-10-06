package 프로그래머스;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class 섬연결하기 {

    public static void main(String[] args) throws IOException {
        int n = 4;
        int[][] costs = {
                {0, 1, 1},
                {0, 2, 2},
                {1, 2, 5},
                {1, 3, 1},
                {2, 3, 8}
        };
        int result = solution(n, costs);
        System.out.println(result);
    }

    static int[] parents;

    public static int solution(int n, int[][] costs) throws IOException {
        Arrays.sort(costs, (i1, i2) -> i1[2] - i2[2]);
//        Arrays.sort(costs, Comparator.comparingInt(o -> o[2]));

        parents = IntStream.range(0, n).toArray();

        int maxEdge = n - 1;
        int edge = 0;

        int totalCost = 0;
        for (int i = 0; i < costs.length; i++) {
            int from = costs[i][0];
            int to = costs[i][1];
            int cost = costs[i][2];

            if (union(from, to)) {
                edge++;
                totalCost += cost;
            }

            if (edge == maxEdge)
                break;
        }


        return totalCost;
    }

    static int find(int n) {
        if (parents[n] != n)
            parents[n] = find(parents[n]);
        return parents[n];
    }

    static boolean union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);

        if (parentA == parentB)
            return false;

        parents[parentA] = parentB;
        return true;
    }
}
