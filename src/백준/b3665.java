package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b3665 {
    static int N, M, inDegree[];
    static boolean children[][]; // children[i][j]=true : i는 j의 부모 노드
    static Queue<Integer> queue;
    static StringBuilder ans = new StringBuilder();
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while(testCase-->0) {
            queue = new LinkedList<>();
            N = Integer.parseInt(br.readLine());

            inDegree = new int[N + 1];
            children = new boolean[N + 1][N + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int now = Integer.parseInt(st.nextToken());
                inDegree[now] = i; // 진입 차수는 등수대로
                for (int j = 1; j <= N; j++) {
                    // 관련 간선이 없다면 만들기
                    if (j != now && !children[j][now]) children[now][j] = true;
                }
            }

            M = Integer.parseInt(br.readLine());
            for (int i=0;i<M;i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                swap(from, to); // 순위 변경
            }

            ans.append(topology()+"\n");
        }
        System.out.println(ans);
    }

    static void swap(int from, int to) {
        // [from][to]=false : from보다 to순위가 더 낮음 -> from은 높게, to는 낮게 swap
        if (!children[from][to]) {
            children[from][to] = true;
            children[to][from] = false;
            inDegree[from]--;
            inDegree[to]++;
        }
        // [from][to]=true : from보다 to순위가 더 높음 -> from은 낮게, to는 높게 swap
        else {
            children[from][to] = false;
            children[to][from] = true;
            inDegree[from]++;
            inDegree[to]--;
        }
    }

    static String topology() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        for (int i = 1; i <= N; i++) {
            // 진입차수가 0인 노드가 없어서 q가 비어있다면 -> 사이클 발생 -> IMPOSSIBLE
            if (queue.isEmpty()) {
                return "IMPOSSIBLE";
            }
            // 이동할 수 있는 정점이 여러 개 -> 나올 수 있는 최종 순위가 여러 개 -> ?
            else if (queue.size() > 1) {
                return "?";
            }

            int now = queue.poll();
            sb.append(now + " ");

            for (int j = 1; j <= N; j++) {
                if (children[now][j]) { // 이동할 수 있는 정점
                    children[now][j] = false; // 이동했다!
                    // 이동 했으니 진입차수 감소
                    inDegree[j]--;
                    if (inDegree[j] == 0) {
                        queue.add(j);
                    }
                }
            }
        }
        return sb.toString();
    }
}