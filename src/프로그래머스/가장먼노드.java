package 프로그래머스;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class 가장먼노드 {
    static class Node{
        int idx;
        int depth;

        public Node(int idx, int depth) {
            this.idx = idx;
            this.depth = depth;
        }
    }
    static List<ArrayList<Integer>> nodes = new ArrayList<>();
    static boolean[] visited;
    static int maxDepth = -1;
    static int[][] edges;
    static int answer = 0;

    public int solution(int n, int[][] edge) {

        // init
        edges = edge;
        visited = new boolean[n + 1];
        for (int i = 0; i < n + 1; i++) {
            nodes.add(new ArrayList<>());
        }
        for (int[] ints : edge) {
            nodes.get(ints[0]).add(ints[1]);
            nodes.get(ints[1]).add(ints[0]);
        }

        bfs(1);

        return answer;
    }

    static void bfs(int start) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(start, 0));
        visited[start] = true;

        while (!q.isEmpty()) {
            Node now = q.poll();

            if (now.depth == maxDepth) answer++;

            if (now.depth > maxDepth) {
                maxDepth = now.depth;
                answer = 1;
            }


            for (Integer adj : nodes.get(now.idx)) {
                if (visited[adj]) continue;
                visited[adj] = true;
                q.offer(new Node(adj, now.depth + 1));
            }
        }

    }
}
