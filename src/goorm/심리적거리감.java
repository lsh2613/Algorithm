package goorm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 심리적거리감 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // init
        List<Integer>[] g = new List[N + 1];
        boolean[] visit = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            g[i] = new ArrayList();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            g[from].add(to);
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(K);
        visit[K] = true;
        int[] dist = new int[N + 1];
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int adj : g[now]) {
                if (visit[adj]) {
                    continue;
                }

                visit[adj] = true;
                dist[adj] = dist[now] + 1;
                q.offer(adj);
            }
        }

        // K에서 모든 경로로 갈 수 없다면 -1
        if (Arrays.stream(dist).filter(d -> d == 0).count() == N + 1) {
            System.out.println(-1);
            return;
        }

        int maxIdx = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            if (dist[i] == 0) { // 이동할 수 없는 경로 or 자기 자신
                continue;
            }

            int distance = dist[i] + Math.abs(K - i);
            if (max < distance) {
                maxIdx = i;
                max = distance;
            }
            if (max == distance) {
                if (maxIdx < i) {
                    maxIdx = i;
                }
            }
        }
        System.out.println(maxIdx);
    }
}
