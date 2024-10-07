package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Road {
    int idx;
    int distance;

    public Road(int idx, int distance) {
        this.idx = idx;
        this.distance = distance;
    }
}

public class BOJ9370 {
    static int V,E,T,start,g, h;
    static List<List<Road>> graph = new ArrayList<>();
    static int[] d;
    static int[] candidate;
    static List<Integer> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int tc = 0; tc < testCase; tc++) {
            result = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            T = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            //init()
            graph.clear();
            for (int i = 0; i < V + 1; i++) {
                graph.add(new ArrayList<>());
            }
            int ghDist = 0;
            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int dist = Integer.parseInt(st.nextToken());

                graph.get(from).add(new Road(to, dist));
                graph.get(to).add(new Road(from, dist));

                if ((from == g && to == h )|| (from == h && to == g))
                    ghDist = dist;
            }
            candidate = new int[T];
            for (int i = 0; i < T; i++) {
                candidate[i] = Integer.parseInt(br.readLine());
            }

            for (int candi : candidate) {
                int path1 = dijkstra(start, g) + ghDist + dijkstra(h, candi);
                int path2 = dijkstra(start, h) + ghDist + dijkstra(g, candi);
                int realPath = dijkstra(start, candi);

                if (path1 == realPath || path2 == realPath)
                    result.add(candi);
            }

            // 정렬 후 출력
            Collections.sort(result);
            result.forEach(i -> System.out.print(i + " "));
        }

    }

    static int dijkstra(int start, int end) {
        d = new int[V + 1];
        Arrays.fill(d, Integer.MAX_VALUE);

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
        return d[end];
    }
}

