package 백준.graph;

import java.util.*;

public class b1260 {
    static ArrayList<Integer>[] g;
    static Queue<Integer> q = new LinkedList<>();
    static boolean visited[];
    static void dfs(int n) {
        // 방문 체크 후 출력
        visited[n] = true;
        System.out.print(n + " ");

        // 인접한 노드들에 대해 작은 노드부터 출력해주기 위함
        Collections.sort(g[n]);
        // 방문하지 않은 인접 노드들 방문
        for (int i = 0; i < g[n].size(); i++) {
            Integer node = g[n].get(i);
            if (visited[node] == false) {
                dfs(node);
            }
        }
    }
    static void bfs(int n) {
        visited[n] = true;
        q.offer(n);
        System.out.print(n + " ");

        // 인접한 노드들에 대해 작은 노드부터 출력해주기 위함
        Collections.sort(g[n]);
        while (!q.isEmpty()) {
            Integer node = q.poll();

            // 인접한 노드들에 대해 작은 노드부터 출력해주기 위함
            Collections.sort(g[node]);
            // 방문하지 않은 인접 노드들 방문
            for (int i = 0; i < g[node].size(); i++) {
                Integer adjacent = g[node].get(i);
                if (visited[adjacent] == false) {
                    visited[adjacent] = true;
                    q.offer(adjacent);
                    System.out.print(adjacent + " ");
                }
            }
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int node = sc.nextInt();
        int n = sc.nextInt();
        int start = sc.nextInt();

        // 0 번은 사용하지 않기 때문에 1~n까지 생성
        visited = new boolean[node + 1];
        g = new ArrayList[node + 1];
        for (int i = 1; i <= node; i++) {
            g[i] = new ArrayList<>();
        }

        // 그래프 값 지정
        for (int i = 0; i < n; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();

            g[from].add(to);
            g[to].add(from);
        }

        dfs(start);
        System.out.println();

        // 방문 체크 초기화
        visited = new boolean[node + 1];
        bfs(start);

    }




}
