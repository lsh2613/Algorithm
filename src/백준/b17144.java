package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class b17144 {
    static int N, M, TIME;
    static int[][] board;
    static int[] airPurifierUp;
    static int[] airPurifierDown;
    static Queue<Dust> dusts = new LinkedList<>();

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Dust {
        int x;
        int y;
        int val;

        public Dust(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        TIME = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        int purifierCnt = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == -1 && purifierCnt == 0) {
                    airPurifierUp = new int[]{i, j};
                    purifierCnt++;
                } else if (board[i][j] == -1 && purifierCnt == 1) {
                    airPurifierDown = new int[]{i, j};
                }

            }
        }

        while (TIME-- > 0) {
            // 먼지 위치 저장
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (board[i][j] >= 5) { // 4이하인 미세먼지는 확산X
                        dusts.add(new Dust(i, j, board[i][j]));
                    }
                }
            }

            // 먼지 확산
            while (!dusts.isEmpty()) {
                Dust now = dusts.poll();
                int spreadCnt = 4;
                int spreadVal = now.val / 5;
                for (int i = 0; i < 4; i++) {
                    int nx = now.x + dx[i];
                    int ny = now.y + dy[i];
                    if (outOfBoard(nx, ny) || board[nx][ny] == -1) {
                        spreadCnt--;
                        continue;
                    }
                    board[nx][ny] += spreadVal;
                }
                board[now.x][now.y] -= spreadVal * spreadCnt;
            }

            airPurifierUpOn();
            airPurifierDownOn();
        }

        System.out.println(Arrays.stream(board)
                .flatMapToInt(row -> Arrays.stream(row).filter(val -> val > 0))
                .sum());
    }

    static int[] upDx = {0, -1, 0, 1};
    static int[] upDy = {1, 0, -1, 0};
    static int[] downDx = {0, 1, 0, -1};
    static int[] downDy = {1, 0, -1, 0};

    static void airPurifierUpOn() { // 우 상 좌 하
        int x = airPurifierUp[0];
        int y = airPurifierUp[1];

        purifieUp(0, x + upDx[0], y + upDy[0], 0);
    }

    static void airPurifierDownOn() { // 우 상 좌 하
        int x = airPurifierDown[0];
        int y = airPurifierDown[1];

        purifieDown(0, x + downDx[0], y + downDy[0], 0);
    }

    static void purifieUp(int prev, int x, int y, int dir) {
        if (outOfBoard(x, y)) { // 범위 밖까지 나갔다면 방향 전환
            // 범위밖 나가기 전 값 얻기
            x -= upDx[dir];
            y -= upDy[dir];

            dir++;
            x += upDx[dir];
            y += upDy[dir];
            purifieUp(prev, x, y, dir);
            return;
        }

        if (board[x][y] == -1) { // 제자리로 돌아왔다면 공기 청정 끝
            return;
        }

        int now = board[x][y];
        board[x][y] = prev;

        x += upDx[dir];
        y += upDy[dir];
        purifieUp(now, x, y, dir);
    }

    static void purifieDown(int prev, int x, int y, int dir) {
        if (outOfBoard(x, y)) { // 범위 밖까지 나갔다면 방향 전환
            // 범위밖 나가기 전 값 얻기
            x -= downDx[dir];
            y -= downDy[dir];

            dir++;
            x += downDx[dir];
            y += downDy[dir];
            purifieDown(prev, x, y, dir);
            return;
        }

        if (board[x][y] == -1) { // 제자리로 돌아왔다면 공기 청정 끝
            return;
        }

        int now = board[x][y];
        board[x][y] = prev;

        x += downDx[dir];
        y += downDy[dir];
        purifieDown(now, x, y, dir);
    }

    static boolean outOfBoard(int x, int y) {
        return x < 0 || y < 0 || x >= N || y >= M;
    }
}
