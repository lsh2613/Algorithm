package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;



public class BOJ1167 {
    static class Node{
        int idx;
        int distance;

        public Node(int idx, int distance) {
            this.idx = idx;
            this.distance = distance;
        }
    }

    static List<Node>[] tree;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        tree = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }
        //init
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());

            while (true) {
                int to = Integer.parseInt(st.nextToken());
                if (to == -1) break;

                int cost = Integer.parseInt(st.nextToken());
                tree[from].add(new Node(to, cost));
            }
        }
        visit = new boolean[N + 1];

        dfs(1,0 );
        visit = new boolean[N + 1];

        dfs(maxDistanceIdx, 0);

        System.out.println(maxDistance);
    }

    static boolean visit[];
    static int maxDistance = 0;
    static int maxDistanceIdx = 0;
    public static void dfs(int idx, int distance) {

        if(distance > maxDistance) {
            maxDistance = distance;
            maxDistanceIdx = idx;
        }
        visit[idx] = true;

        for(int i = 0; i < tree[idx].size(); i++) {
            Node adj = tree[idx].get(i);
            int adjIdx = adj.idx;
            if(visit[adjIdx] == false) {
                dfs(adjIdx, adj.distance + distance);
                visit[adjIdx] = true;
            }
        }

    }
}
