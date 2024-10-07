package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Tomato {
    int x;
    int y;
    int z;
    public Tomato(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

public class BOJ7569 {
    static int N, M, H;
    static int[][][] board;
    static Queue<Tomato> ripeTomatoes = new LinkedList<>();
    static int emptyCnt = 0;
    static int fullSize;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        board = new int[N][M][H];

        // init()
        for (int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    int now = Integer.parseInt(st.nextToken());
                    board[i][j][k] = now;

                    if (now == 1)
                        ripeTomatoes.offer(new Tomato(i, j, k));
                    if (now == -1)
                        emptyCnt++;
                }
            }
        }
        fullSize = N * M * H;
        System.out.println(ripeTomatoes.size() == fullSize ? "0" : bfs());
    }

    static int[] dx = { -1, 0, 1, 0, 0, 0 }; //상하좌우위아래
    static int[] dy = { 0, 1, 0, -1, 0, 0 }; //상하좌우위아래
    static int[] dz = { 0, 0, 0, 0, 1, -1 }; //상하좌우위아래
    static int bfs() {
        int depth = -1; // 맨 처음 익은 토마토를 꺼내는 행위는 기존에 있던 토마토를 꺼내기 때문에 -1부터 시작
        int ripeTomatoesSize = ripeTomatoes.size(); // 익은 토마토 갯수 카운트

        while (!ripeTomatoes.isEmpty()) {
            depth++;
            int size = ripeTomatoes.size(); // for문 안의 ripeTomatoes에 요소를 추가하는 ripeTomatoes.offer가 있기 때문에
            // for 조건문의 바로 size()메소드를 쓰면 연산 횟수가 꼬임

            for (int i = 0; i < size; i++) {
                Tomato now = ripeTomatoes.poll();
                for (int j = 0; j < 6; j++) {
                    int nx = now.x + dx[j];
                    int ny = now.y + dy[j];
                    int nz = now.z + dz[j];

                    // 범위를 벗어나거나, 0이 아닌 경우는 제외
                    if (outOfScope(nx, ny, nz) || board[nx][ny][nz] != 0)
                        continue;

                    board[nx][ny][nz] = 1;
                    ripeTomatoesSize++;
                    ripeTomatoes.offer(new Tomato(nx, ny, nz));
                }
            }
        }
        return ripeTomatoesSize == fullSize - emptyCnt ? depth : -1;
    }

    static boolean outOfScope(int nx, int ny, int nz) {
        if (nx < 0 || ny < 0 || nz < 0 || nx >= N || ny >= M || nz >= H)
            return true;
        return false;
    }
}
