package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Bus {
    int from;
    int to;
    int time;
    public Bus(int from, int to, int time) {
        this.from = from;
        this.to = to;
        this.time = time;
    }
}

public class b11657 {

    static final int INF = 500 * 10_000;
    static int N, M;
    static Bus[] buses;
    static long[] d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        //init
        d = new long[N + 1];
        Arrays.fill(d, INF);
        buses = new Bus[M + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            buses[i] = new Bus(from, to, time);
        }

        // 음의 cycle이 없는 경우
        if (bellmanFord())
            for (int i = 2; i <= N; i++)
                sb.append(d[i] == INF ? "-1\n" : d[i] + "\n");
        // 음의 cycle이 있는 경우
        else
            sb.append("-1");

            System.out.println(sb);

    }
    static boolean bellmanFord () {
        // 시작 정점
        d[1] = 0;

        // V-1번 최소경로 업데이트
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < M; j++) {
                Bus bus = buses[j];
                int from = bus.from;
                int to = bus.to;
                int time = bus.time;

                if (d[from] != INF && d[to] > d[from] + time) {
                    d[to] = d[from] + time;
                }
            }
        }

        // 다시 한번 업데이트
        for (int i = 0; i < M; i++) {
            Bus bus = buses[i];
            int from = bus.from;
            int to = bus.to;
            int time = bus.time;

            // 최소 경로가 다시 업데이트 된다면 음의 간선 사이클 존재
            if (d[from] != INF && d[to] > d[from] + time)
                return false;
        }
        return true;
    }
}
