package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ6497 {

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

    static Edge[] edges;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            if (m == 0 && n == 0) {
                break;
            }
            int totalCost = 0;

            // init
            parent = new int[m];
            for (int i = 0; i < m; i++) {
                parent[i] = i;
            }
            edges = new Edge[n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                totalCost += cost;

                edges[i] = new Edge(from, to, cost);
            }

            Arrays.sort(edges, (e1, e2) -> e1.cost - e2.cost);

            int costOfMst = 0; // 가중치
            int mstEdges = 0; // 최소스패닝트리의 간선 갯수
            for (int i = 0; i < n; i++) {
                Edge edge = edges[i];
                int from = edge.from;
                int to = edge.to;
                int cost = edge.cost;

                if (union(from, to)) {
                    costOfMst += cost;
                    mstEdges++;

                    if (mstEdges == n - 1) {
                        break;
                    }
                }
            }

            System.out.println(totalCost - costOfMst);
        }

    }

    static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB)
            return false;

        parent[rootB] = rootA;
        return true;
    }

    static int find(int n) {
        if (parent[n] != n)
            parent[n] = find(parent[n]);

        return parent[n];
    }

}
