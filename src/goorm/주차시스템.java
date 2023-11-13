package goorm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Poi{
    int x;
    int y;

    public Poi(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class 주차시스템 {
    static int N, M;
    static List<Poi> zeros = new ArrayList<>();
    static int[][] board;
    static int max = Integer.MIN_VALUE;

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
                if (board[i][j] == 0) {
                    zeros.add(new Poi(i, j));
                }
            }
        }

        if (zeros.size() == 0) {
            System.out.println(0);
            return;
        }
        if (zeros.size() == N * M) {
            System.out.println(N * M);
            return;
        }

        for (Poi zero : zeros) {
            if (board[zero.x][zero.y] == 0) {
                max = Math.max(max, bfs(zero.x, zero.y));
            }
        }

        System.out.println(max <= 0 ? "0" : max);
    }

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int bfs(int x, int y) {
        Queue<Poi> q = new LinkedList<>();
        q.offer(new Poi(x, y));
        board[x][y] = 3;
        int score = 1;

        while (!q.isEmpty()) {
            Poi now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (outOfBoard(nx, ny) || board[nx][ny] == 1) {
                    continue;
                }

                if (board[nx][ny] == 2) {
                    score -= 2;
                }

                if (board[nx][ny] == 0) {
                    score++;
                }
                board[nx][ny] = 1;
                q.offer(new Poi(nx, ny));
            }
        }
        return score;
    }

    static boolean outOfBoard(int x, int y) {
        return x < 0 || y < 0 || x >= N || y >= M;
    }
}
