package 이코테.기출.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class C15 {
    static ArrayList<ArrayList<Integer>> g = new ArrayList<>();
    static int[] d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        // 초기화
        d = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            g.add(new ArrayList<>());
        }
        // 간선 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            g.get(Integer.parseInt(st.nextToken())).add(Integer.parseInt(st.nextToken()));
        }

        bfs(start);
        // d에 저장된 최단 경로가 k인 노드 출력
        boolean flag = false;
        for (int i = 1; i <= N; i++) {
            if (d[i] == K) {
                System.out.println(i);
                flag = true;
            }
        }
        // k인 경로가 없다면 -1 출력
        if (!flag) {
            System.out.println(-1);
        }

    }

    static void bfs(int idx) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(idx);
        while (!q.isEmpty()) {
            Integer curIdx = q.poll();
            for (int i = 0; i < g.get(curIdx).size(); i++) {
                Integer adjNodeIdx = g.get(curIdx).get(i);
                if (d[adjNodeIdx] == 0) {
                    q.offer(adjNodeIdx);
                    d[adjNodeIdx] = d[curIdx] + 1;
                }
            }
        }
    }
}
/*
4 4 2 1
1 2
1 3
2 3
2 4
 */