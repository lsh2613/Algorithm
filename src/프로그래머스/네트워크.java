package 프로그래머스;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class 네트워크 {
    static List[] nodes;
    static int answer = 0;

    public int solution(int n, int[][] computers) {
        int len = computers.length;

        nodes = new List[len];
        for (int i = 0; i < len; i++) {
            nodes[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (computers[i][j] == 1) {
                    nodes[i].add(j);
                }
            }
        }

        for (int i = 0; i < len; i++) {
            bfs(i);
        }

        return answer;
    }

    static void bfs(int n) {
        if (nodes[n].size() == 0)
            return;
        answer++;

        LinkedList<Integer> q = new LinkedList<>();
        q.offer(n);

        while (!q.isEmpty()) {
            Integer now = q.poll();
            for (int i = 0; i < nodes[now].size(); i++) {
                q.offer((Integer) nodes[now].get(i));
            }
            nodes[now].clear();
        }

    }
}