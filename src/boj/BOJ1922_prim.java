package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1922_prim {
    static class Node {
        int idx;
        int cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        ArrayList<Node>[] nodes = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            nodes[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            nodes[from].add(new Node(to, cost));
            nodes[to].add(new Node(from, cost));
        }

        System.out.println(prim(N, M, nodes));
    }

    static private int prim(int N, int M, ArrayList<Node>[] edges) {
        boolean[] visit = new boolean[N + 1];
        PriorityQueue<Node> q = new PriorityQueue<>((p1, p2) -> p1.cost - p2.cost);
        int start = 1;
        q.offer(new Node(start, 0));

        int pick = 0;
        int totalCost = 0;
        while (pick != N) {
            Node cur = q.poll();

            if (visit[cur.idx]) continue;

            visit[cur.idx] = true;
            pick++;
            totalCost += cur.cost;

            edges[cur.idx].forEach(adj -> q.offer(new Node(adj.idx, adj.cost)));
        }

        return totalCost;
    }

}
