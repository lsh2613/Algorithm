package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
//class Node{
//    int idx;
//    int distance;
//
//    public Node(int idx, int distance) {
//        this.idx = idx;
//        this.distance = distance;
//    }
//}
public class BOJ1504 {
    static List<Road>[] graph;
    static int N, E;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        //init()
        graph = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Road(b, c));
            graph[b].add(new Road(a, c));
        }
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int path1 = 0;
        int e1 = dijkstra(1, v1);
        int e2 = dijkstra(v2, N);
        if (e1 == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }

        if (e2 == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }

        int path2 = 0;
        int e3 = dijkstra(1, v2);
        int e4 = dijkstra(v1, N);
        if (e3 == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        if (e4 == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }

        path1 = Math.min(e1 + e2, e3 + e4);


        path2 = dijkstra(v1, v2);
        if (path2 == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }

        int result = path1 + path2;
        System.out.println(result == Integer.MAX_VALUE || result <= 0 ? -1 : result);
    }

    static int dijkstra(int start, int end) {
        int[]d = new int[N + 1];
        Arrays.fill(d, Integer.MAX_VALUE);

        Queue<Road> pq = new PriorityQueue<>((n1, n2) -> n1.distance - n2.distance);
        pq.offer(new Road(start, 0));
        d[start] = 0;

        while (!pq.isEmpty()) {
            Road now = pq.poll();
            int nowIdx = now.idx;
            int nowDist = now.distance;

            if (d[nowIdx] < nowDist) continue;

            for (Road adj : graph[nowIdx]) {
                int adjIdx = adj.idx;
                int adjDist = adj.distance;
                int cost = d[nowIdx] + adjDist;

                if (d[adjIdx] > cost) {
                    d[adjIdx] = cost;
                    pq.offer(new Road(adjIdx, cost));
                }
            }
        }
        return d[end];
    }
}
