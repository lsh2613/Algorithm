package 이코테.기출분석.그래프이론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 커리큘럼 {

    static ArrayList<ArrayList<Integer>> g = new ArrayList<>();
    static int[] inDegree;
    static int[] times;
    static int N;
    static void topologySort() {
        int[] result = Arrays.copyOf(times, times.length); //결과값 저장
        Queue<Integer> q = new LinkedList<>(); // 진입차수가 0인 노드의 번호를 저장
        // 진입차수 0인 것들을 우선적으로 삽입
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i = 0; i < g.get(cur).size(); i++) {
                // 현재까지 계산된 시간 result[] VS 현재 Q에서 꺼낸 노드를 통해 계산되는 시간 중 큰 값을 선텍
                // 경로가 2개 이상 있을 시 더 큰 시간을 선택해야 모두 들을 수 있기 때문
                result[g.get(cur).get(i)]
                        = Math.max(result[g.get(cur).get(i)], result[cur] + times[g.get(cur).get(i)]);
                // 인접 노드를 탐색할 때마다 인접 노드에 대한 진입 차수 감소
                inDegree[g.get(cur).get(i)]--;
                // 감소 시 0이 됐는 지 체크
                if (inDegree[g.get(cur).get(i)] == 0)
                    q.offer(g.get(cur).get(i));
            }
        }

        System.out.println(Arrays.toString(result));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        inDegree = new int[N + 1];
        times = new int[N + 1];

        // 그래프 초기화
        for (int i = 0; i <= N; i++) {
            g.add(new ArrayList<>());
        }

        // 방향 그래프의 모든 간선 정보를 입력받기
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            // 첫 번째 수는 시간 정보를 담고 있음
            int x = Integer.parseInt(st.nextToken());
            times[i] = x;
            // 해당 강의를 듣기 위해 먼저 들어야 하는 강의들의 번호 입력
            while (true) {
                x = Integer.parseInt(st.nextToken());
                if (x == -1) break;
                inDegree[i] += 1;
                g.get(x).add(i);
            }
        }

        topologySort();
    }
}
/*
5
10 -1
10 1 -1
4 1 -1
4 3 1 -1
3 3 -1
 */