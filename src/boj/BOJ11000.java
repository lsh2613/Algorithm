package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class lecture {
    int start;
    int end;
    public lecture(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
public class BOJ11000 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        List<lecture> lectures = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            lectures.add(new lecture(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        // start 타임을 기준으로 오름차순, start가 같을 시 end를 기준으로 오름차순 정렬
        Collections.sort(lectures, new Comparator<lecture>() {
            @Override
            public int compare(lecture o1, lecture o2) {
                if (o1.start == o2.start) {
                    return o1.end - o2.end;
                }
                return o1.start - o2.start;
            }
        });
        /*
        // end 타임을 기준으로 먼저 정렬하면 안되는 반례
        8
        1 8
        9 16
        3 7
        8 10
        10 14
        5 6
        6 11
        11 12
        Collections.sort(lectures, new Comparator<lecture>() {
            @Override
            public int compare(lecture o1, lecture o2) {
                if (o1.end == o2.end) {
                    return o1.start - o2.start;
                }
                return o1.end - o2.end;
            }
        });
         */

        // 우선순위 큐에는 종료 시간만 들어가며, 오름차순으로 자동 정렬된다.
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(lectures.get(0).end);

        for (int i = 1; i < n; i++) {
            // 우선순위 큐에서 가장 작은 종료 시간과
            // 현재 lectures[i]의 시작 시간을 비교한다.
            if (pq.peek() <= lectures.get(i).start) {
                pq.poll();
            }
            pq.offer(lectures.get(i).end);
        }
        System.out.println(pq.size());
    }
}
