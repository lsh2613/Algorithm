package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class b1766 {
    static List<Integer>[] graph;
    static int[] inDegree;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        inDegree = new int[N + 1];
        graph = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            graph[from].add(to);
            inDegree[to]++;
        }

        topologicalSorting();
    }
    static void topologicalSorting() {
        Queue<Integer> q = new PriorityQueue<>();
        for (int i = 1; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            Integer now = q.poll();
            List<Integer> children = graph[now];
            sb.append(now + " ");

            for (int i = 0; i < children.size(); i++) {
                Integer child = children.get(i);
                inDegree[child]--;

                if (inDegree[child] == 0) {
                    q.offer(child);
                }
            }
        }

        System.out.println(sb);
    }
}
