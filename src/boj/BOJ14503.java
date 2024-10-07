package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Room {
    int r;
    int c;
    int d;

    public Room(int r, int c, int d) {
        this.r = r;
        this.c = c;
        this.d = d;
    }
}
public class BOJ14503 {
    // 북No0 동Ea1 남So2 서We3
    //    0
    //  3   1
    //    2
    static final int No = 0;
    static final int Ea = 1;
    static final int So = 2;
    static final int We = 3;

    static int N, M;
    static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int cleanCnt = 0;

        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        Queue<Room> q = new LinkedList<>();
        q.offer(new Room(r, c, d));
        while (!q.isEmpty()) {
            Room now = q.poll();
            int nx = now.r;
            int ny = now.c;
            int nd = now.d;

            // 현재 좌표 청소
            if (board[nx][ny] == 0) {
                board[nx][ny] = 2;
                cleanCnt++;
            }

            if (isUnCleandRoom(nx, ny)) { // 4칸 중 0이 존재하는 경우
                for (int i = 0; i < 4; i++) {
                    nd = (nd + 3) % 4;
                    Room forward = forward(nx, ny, nd);
                    if (board[forward.r][forward.c] == 0) {
                        q.offer(new Room(forward.r, forward.c, forward.d));
                        break;
                    }
                }
            }
            else { // 4칸 중 0이 존재하지 않는 경우
                Room back = back(nx, ny, nd);
                if (board[back.r][back.c] != 1) { // 후진이 가능하면 이동
                    q.offer(new Room(back.r, back.c, back.d));
                }
                else { // 후진이 불가능하면 종료
                    break;
                }
            }
        }

        System.out.println(cleanCnt);
    }

    static Room forward(int x, int y, int d) {
        switch (d) {
            case No:
                x -= 1;
                break;
            case We:
                y -= 1;
                break;
            case So:
                x += 1;
                break;
            case Ea:
                y += 1;
        }
        return new Room(x, y, d);
    }

    static Room back(int x, int y, int d) {
        switch (d) {
            case No:
                x += 1;
                break;
            case We:
                y += 1;
                break;
            case So:
                x -= 1;
                break;
            case Ea:
                y -= 1;
        }
        return new Room(x, y, d);
    }

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static boolean isUnCleandRoom(int x, int y) { // 청소되지 않은 칸이 있으면, 0이 있으면 true
        int unCleandCnt = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (outOfBoard(nx, ny)) {
                continue;
            }
            if (board[nx][ny] == 0) {
                unCleandCnt++;
            }
        }

        return unCleandCnt > 0 ? true : false;
    }
    static boolean outOfBoard(int x, int y) {
        return x < 0 || y < 0 || x >= N || y >= M;
    }
}
