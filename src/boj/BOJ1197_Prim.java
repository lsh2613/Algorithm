package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1197_Prim {

    static class Node {
        int idx;
        int cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }

    static int V, E;
    static List<Node>[] tree;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        tree = new ArrayList[V + 1];
        for (int i = 1; i < V + 1; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            tree[from].add(new Node(to, cost));
            tree[to].add(new Node(from, cost));
        }

        System.out.println(prim());
    }

    static int prim() {
        int weight = 0;
        visited = new boolean[V + 1];

        Queue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.cost - n2.cost);
        pq.offer(new Node(1, 0));  // 임의의 간선부터 시작

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            int idx = now.idx;
            int cost = now.cost;

            if (visited[idx]) continue;
            // MST 간선 추가
            visited[idx] = true;
            weight += cost;

            for (Node adj : tree[idx]) {
                if (!visited[adj.idx])
                    pq.offer(adj);
            }
        }

        return weight;
    }
}
