package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ24479 {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] visit;
    static int order = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        // init()
        visit = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        // graph의 자식 노드를 오름차순으로 정렬
        for (int i = 1; i < n+1; i++) {
            graph.get(i).sort(Comparator.reverseOrder());
        }

        dfs(r);

        for (int i = 1; i < n+1; i++) {
            System.out.println(visit[i]);
        }
    }

    static void dfs(int idx) {
        visit[idx] = order++;

        for (int i = 0; i < graph.get(idx).size(); i++) {
            int adj = graph.get(idx).get(i);
            // 방문하지 않았다면
            if (visit[adj] == 0) {
                dfs(adj);
            }
        }
    }
}
