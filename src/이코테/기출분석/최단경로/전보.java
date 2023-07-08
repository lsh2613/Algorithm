package 이코테.기출분석.최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 전보 {
    public static final int INF = (int) 1e9; // 무한을 의미하는 값으로 10억을 설정
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static int[] dp; // 각 노드별 최단 거리를 저장

    static void dijkstra(int start) {
        PriorityQueue<Node> p = new PriorityQueue();
        p.offer(new Node(start, 0));
        dp[start] = 0;
        while (!p.isEmpty()) {
            Node currentNode = p.poll();
            int currentIdx = currentNode.getIndex();
            int currentDis = currentNode.getDistance();
            if (dp[currentIdx] < currentDis) {
                continue;
            }

            for (int i = 0; i < graph.get(currentIdx).size(); i++) {
                int cost = dp[currentIdx] + graph.get(currentIdx).get(i).getDistance();
                if (cost < dp[graph.get(currentIdx).get(i).getIndex()]) {
                    dp[graph.get(currentIdx).get(i).getIndex()] = cost;
                    p.offer(new Node(graph.get(currentIdx).get(i).getIndex(), cost));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        dp = new int[n+1];

        // 그래프 초기화
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 모든 간선 정보를 입력받기
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            // X번 노드에서 Y번 노드로 가는 비용이 Z라는 의미
            graph.get(x).add(new Node(y, z));
        }
        // 최단 거리 테이블을 모두 무한으로 초기화
        Arrays.fill(dp, INF);

        // 다익스트라 알고리즘을 수행
        dijkstra(c);

        // 도달할 수 있는 노드의 개수
        int count = 0;
        // 도달할 수 있는 노드 중에서, 가장 멀리 있는 노드와의 최단 거리
        int maxDistance = 0;
        for (int i = 1; i <= n; i++) {
            // 도달할 수 있는 노드인 경우
            if (dp[i] != INF) {
                count += 1;
                maxDistance = Math.max(maxDistance, dp[i]);
            }
        }

        // 시작 노드는 제외해야 하므로 count - 1을 출력
        System.out.println((count - 1) + " " + maxDistance);
    }
}
/*
3 2 1
1 2 4
1 3 2
 */