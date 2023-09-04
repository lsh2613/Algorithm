package groom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class quiz1 {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visit;
    static int group = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        //init()
        visit = new boolean[n + 1];
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            graph.get(from).add(to);
        }

        // 방문하지 않은 모든 노드에 대해
        for (int i = 1; i <= n; i++) {
            if (!visit[i])
                bfs(i);
        }

        System.out.println(group);
    }

    // idx에서 시작하는 인접노드의 순환관계를 모두 방문처리
    static void bfs(int idx) {
        visit[idx]=true;
        group++;
        Queue<Integer> q = new LinkedList<>();
        q.offer(idx);
        while (!q.isEmpty()) {
            int now = q.poll(); // 현재 노드
            for (int i = 0; i < graph.get(now).size(); i++) {
                int adj = graph.get(now).get(i); // 인접 노드
                // 방문하지 않은 인접 노드와 순환 관계를 이룬다면
                if (!visit[adj] && graph.get(adj).contains(now)) {
                    // 연결된 간선을 제거하고 다시 인접 노드에 대해 이 과정을 반복
                    visit[adj] = true;
                    q.offer(adj);
                    graph.get(now).remove(Integer.valueOf(adj));
                    graph.get(adj).remove(Integer.valueOf(now));
                }
            }
        }
    }
}

