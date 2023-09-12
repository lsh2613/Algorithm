package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1956 {
    static int[][] graph;
    static int V, E;
    static final int INF = (int) 1e9;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        //init
        graph = new int[V + 1][V + 1];
        for (int i = 1; i < V+1; i++) {
            for (int j = 1; j < V + 1; j++) {
                if (i == j) {
                    graph[i][j] = 0;
                    continue;
                }
                graph[i][j] = INF;
            }
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[from][to] = Math.min(graph[from][to], cost); // 최소값만 저장
        }

        floydWarshall();

        // 사이클 찾기
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < V + 1; i++) {
            for (int j = 1; j < V + 1; j++) {
                if (i == j) continue;

                if (graph[i][j] != INF && graph[j][i] != INF)
                    res = Math.min(res, graph[i][j] + graph[j][i]);
            }
        }
        System.out.println(res == Integer.MAX_VALUE ? -1 : res);
    }

    static void floydWarshall() {
        for (int k = 1; k < V + 1; k++) {
            for (int i = 1; i < V + 1; i++) {
                for (int j = 1; j < V + 1; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }
    }
}
