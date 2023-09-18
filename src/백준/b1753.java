package 백준;

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
//        this.cost = distance;
//    }
//}

public class b1753 {
    static List<List<Road>> graph = new ArrayList<>();
    static int[] d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());

        //init()
        d = new int[V + 1];
        Arrays.fill(d, Integer.MAX_VALUE);
        for (int i = 0; i < V + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            graph.get(from).add(new Road(to, dist));
        }

        dijkstra(start);

        // 결과 출력
        for (int i = 1; i < d.length; i++) {
            System.out.println(d[i] == Integer.MAX_VALUE ? "INF" : d[i]);
        }
    }

    static void dijkstra(int start) {
        Queue<Road> pq = new PriorityQueue<>((n1, n2) -> n1.distance - n2.distance);
        pq.offer(new Road(start, 0));
        d[start] = 0;

        while (!pq.isEmpty()) {
            Road now = pq.poll();
            int nowDist = now.distance;
            int nowIdx = now.idx;

            if (d[nowIdx] < nowDist) continue; // 굳이 안 써줘도 되지만 d[nowIdx]로 이미 최솟값을 가지고 있는데 더 큰 값의 nowDist가 밑의
                                                // for문(최소 비용 업데이트 로직)을 실행해봤자 최소 비용을 가질 수 없기 때문에 불필요한 연산을 제거하기 위함이다.

            for (Road adj : graph.get(nowIdx)) {
                int adjIdx = adj.idx;
                int cost = d[nowIdx] + adj.distance;

                if (d[adjIdx] > cost) {
                    d[adjIdx] = cost;
                    pq.offer(new Road(adjIdx, cost));
                }
            }
        }

    }
}
