package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class b4803 {

    static List<Integer>[] graph;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = 0;
        while (true) {
            testCase++;
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            if (N==0 && M==0) break;

            //init
            visit = new boolean[N + 1];
            graph = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) {
                graph[i] = new ArrayList<>();
            }
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                graph[from].add(to);
                graph[to].add(from);
            }

            // tree 갯수 구하기
            int treeCnt = 0;
            for (int i = 1; i <= N; i++) {
                if (visit[i]) continue;

                treeVertexCnt = 0;
                treeEdgeCnt = 0;

                dfs(i);
                // 트리 성질: 간선 = (정점-1) * 2
                if (treeEdgeCnt == (treeVertexCnt - 1) * 2)
                    treeCnt++;
            }

            // 출력 형식 저장
            sb.append("Case " + testCase + ": ");
            switch (treeCnt) {
                case 0:
                    sb.append("No trees.\n");
                    break;
                case 1:
                    sb.append("There is one tree.\n");
                    break;
                default:
                    sb.append("A forest of " + treeCnt + " trees.\n");
            }

        }
        System.out.println(sb);
    }

    static int treeVertexCnt;
    static int treeEdgeCnt;
    static void dfs(int idx) {
        treeVertexCnt++;
        treeEdgeCnt += graph[idx].size();
        visit[idx] = true;

        for (int adj : graph[idx]) {
            if (visit[adj]) continue;
            dfs(adj);
        }
    }
}
