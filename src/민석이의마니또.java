import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
1
3 4
1 2 1
3 2 1
1 3 5
2 3 2
1 3 5
 */

class Node{
    int idx;
    int cost;

    public Node(int idx, int cost) {
        this.idx = idx;
        this.cost = cost;
    }

    public int getIdx() {
        return idx;
    }

    public int getCost() {
        return cost;
    }
}
public class 민석이의마니또 {
    static int N, M, minSum;
    static ArrayList<ArrayList<Node>> graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            // 초기화
            graph = new ArrayList<>();
            visited = new boolean[N + 1];
            // 마니또 정보 저장
            for (int i = 0; i <= N; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                graph.get(from).add(new Node(to, x));
            }

            // 모든 노드에 대해
            int minCostCycle = Integer.MAX_VALUE;
            for (int i = 1; i <= N; i++) {
                minSum = Integer.MAX_VALUE;
                Arrays.fill(visited, false);
                // 1번 노드부터 시작, 이때 합은 0부터
                findMinCostCycle(i,i, 0); // 노드들에 대한 사이클의 최솟값이 minSum에 저장
                minCostCycle = Math.min(minCostCycle, minSum);
            }
            sb.append("#" + tc + " ");
            if (minCostCycle == Integer.MAX_VALUE) {
                sb.append(-1+"\n");
            }else
                sb.append(minCostCycle+"\n");

//            System.out.print("#" + tc + " ");
//            System.out.println(minCostCycle == Integer.MAX_VALUE ? -1 : minCostCycle);
        }
        System.out.println(sb);
    }

    static void findMinCostCycle(int start, int cur, int sum) {
        if (cur == start && sum != 0) { // 시작노드와 같아지면
            minSum = Math.min(minSum, sum);
            return;
        }

        if (visited[cur]) { // 방문한 노드는 종료
            return;
        }
        visited[cur] = true;

        for (Node adj : graph.get(cur)) { // 인접한 노드 순회
            findMinCostCycle(start, adj.getIdx(), sum + adj.getCost());
        }
    }
}
