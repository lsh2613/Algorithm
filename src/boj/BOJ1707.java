package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1707 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
            // init()
            for (int j = 0; j <= V; j++) {
                graph.add(new ArrayList<>());
            }
            for (int j = 0; j < E; j++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                graph.get(from).add(to);
                graph.get(to).add(from);
            }

            System.out.println(isBinaryTree(graph, V) ? "YES" : "NO");
        }
    }

    static final int groupA = 1;
    static final int groupB = 2;

    static boolean isBinaryTree(ArrayList<ArrayList<Integer>> graph, int V) {
        Queue<Integer> q = new LinkedList<>();
        int[] group = new int[V + 1];

        for (int i = 1; i <= V; i++) {
            if (group[i] == 0) {
                q.add(i);
                group[i] = groupA;
            }

            while (!q.isEmpty()) {
                int now = q.poll();

                for (int adj : graph.get(now)) {
                    if (group[adj] == 0) { // 방문하지 않은 인접노드는 현재 노드와 반대의 그룹으로 설정
                        q.add(adj);

                        if (group[now] == groupA)
                            group[adj] = groupB;

                        if (group[now] ==  groupB)
                            group[adj] = groupA;
                    }

                    if (group[now] == group[adj]) { // 인접노드와 그룹이 같다면 이분그래프가 아님
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
