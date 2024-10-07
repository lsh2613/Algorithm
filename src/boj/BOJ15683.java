package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ15683 {
    static int N, M;
    static int[][] board;
    static List<int[]> cctvs = new ArrayList<>();
    static final int wall = 6;
    static int result = Integer.MAX_VALUE;
    static final int ON = -1;
    static final int OFF = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (1 <= board[i][j] && board[i][j] <= 5) {
                    cctvs.add(new int[]{i, j});
                }
            }
        }
        fullSearch(1);

        System.out.println(result);
    }

    static void fullSearch(int now) {
        if (now > cctvs.size()) {
            int blindSpots = 0;
            for (int[] line : board) {
                int zeros = (int) Arrays.stream(line).filter(i -> i == 0).count();
                blindSpots += zeros;
            }
            result = Math.min(result, blindSpots);
            return;
        }

        int[] cctv = cctvs.get(now);
        switch (board[cctv[0]][cctv[1]]) {
            case 1:
                for (int i = 0; i < 4; i++) { // 상 우 하 좌
                    cctvSwitch(cctv, i, ON);
                    fullSearch(now + 1);
                    cctvSwitch(cctv, i, OFF);
                }
                break;
            case 2:
                for (int i = 0; i < 2; i++) { // 상하 우좌
                    cctvSwitch(cctv, i, ON);
                    cctvSwitch(cctv, i + 2, ON);
                    fullSearch(now + 1);
                    cctvSwitch(cctv, i, OFF);
                    cctvSwitch(cctv, i + 2, OFF);
                }
                break;
            case 3:
                for (int i = 0; i < 4; i++) { // 상우 우하 하좌 좌상
                    cctvSwitch(cctv, i, ON);
                    cctvSwitch(cctv, (i + 1) % 4, ON);
                    fullSearch(now + 1);
                    cctvSwitch(cctv, i, OFF);
                    cctvSwitch(cctv, (i + 1) % 4, OFF);
                }
                break;
            case 4:
                for (int i = 0; i < 4; i++) { // 상우하 우하좌 하좌상 좌상우
                    cctvSwitch(cctv, i, ON);
                    cctvSwitch(cctv, (i + 1) % 4, ON);
                    cctvSwitch(cctv, (i + 2) % 4, ON);
                    fullSearch(now + 1);
                    cctvSwitch(cctv, i, OFF);
                    cctvSwitch(cctv, (i + 1) % 4, OFF);
                    cctvSwitch(cctv, (i + 2) % 4, OFF);
                }
                break;
            case 5:
                for (int i = 0; i < 4; i++) {
                    cctvSwitch(cctv, i, ON);
                }
                fullSearch(now + 1);
                for (int i = 0; i < 4; i++) {
                    cctvSwitch(cctv, i, OFF);
                }
        }
    }

    // dir 값에 따라 상:0 우:1 하:2 좌:3
    // 그 값에 해당하는 dx dy 선언
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};

    // cctv가 켜지면 0 이하인 곳만 -1씩 감소 (1보다 큰 곳은 cctv OR 벽이기 때문에)
    // cctv가 꺼지면 +1
    static void cctvSwitch(int[] cctv, int dir, int switchFlag) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{cctv[0], cctv[1]});
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int nx = now[0] + dx[dir];
            int ny = now[1] + dy[dir];

            if (nx < 0 || nx >= N || ny < 0 || ny >= M || board[nx][ny] == wall) {
                break;
            }

            if (board[nx][ny] <= 0) {
                board[nx][ny] += switchFlag;
            }
            q.offer(new int[]{nx, ny});
        }
    }

}
