package boj;

import java.io.*;
import java.util.*;

public class BOJ2444 {
    static List<List<Integer>> graph = new ArrayList<>();
    static int[] visit;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        //init()
        visit = new int[n+1];
        for(int i = 0; i<=n; i++)
            graph.add(new ArrayList<>());
        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        // 인접 노드 정렬
        for(int i = 1; i<=n; i++)
            Collections.sort(graph.get(i));

        bfs(r);

        for(int i = 1; i<=n; i++)
            System.out.println(visit[i]);
    }

    static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        int order = 1;

        q.offer(start);
        visit[start] = order++;

        while(!q.isEmpty()){
            int now = q.poll();

            for(int i = 0; i< graph.get(now).size(); i++){
                int adj = graph.get(now).get(i);

                // 방문하지 않은 인접 노드에 대해
                if (visit[adj] == 0) {
                    q.offer(adj);
                    visit[adj] = order++;
                }
            }
        }
    }
}
