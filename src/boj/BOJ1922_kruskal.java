package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1922_kruskal {
    static class Edge {
        int from;
        int to;
        int cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        ArrayList<Edge> edges = new ArrayList<>();

        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges.add(new Edge(from, to, cost));
        }

        parents = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            parents[i] = i;
        }

        edges.sort((e1, e2) -> e1.cost - e2.cost);
        int totalCost = 0;
        int pick = 0;

        for (int i = 0; i < M; i++) {
            Edge edge = edges.get(i);
            if (union(edge.from, edge.to)) {
                totalCost += edge.cost;
                pick++;
            }
            if (pick == N - 1)
                break;
        }

        System.out.println(totalCost);
    }

    static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB)
            return false;

        parents[rootB] = rootA;
        return true;
    }

    static int find(int n) {
        if (parents[n] != n)
            parents[n] = find(parents[n]);
        return parents[n];
    }
}
