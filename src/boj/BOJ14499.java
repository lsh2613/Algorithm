package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ14499 {

    static int N, M;
    static int X, Y;
    static int[][] map;
    static int[] dice = new int[6];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            int dir = Integer.parseInt(st.nextToken()) - 1;
            turn(dir);
        }

        System.out.println();
    }

    // 동 서 남 북
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    private static void turn(int dir) {
        int nx = X + dx[dir];
        int ny = Y + dy[dir];

        if (nx < 0 || nx >= N || ny < 0 || ny >= M)
            return;

        int tmp = dice[5];
        switch (dir) {
            // 동
            case 0:
                dice[5] = dice[2];
                dice[2] = dice[0];
                dice[0] = dice[3];
                dice[3] = tmp;
                break;
            // 서
            case 1:
                dice[5] = dice[3];
                dice[3] = dice[0];
                dice[0] = dice[2];
                dice[2] = tmp;
                break;
            // 남
            case 2:
                dice[5] = dice[4];
                dice[4] = dice[0];
                dice[0] = dice[1];
                dice[1] = tmp;
                break;

            // 북
            default:
                dice[5] = dice[1];
                dice[1] = dice[0];
                dice[0] = dice[4];
                dice[4] = tmp;
        }

        System.out.println(dice[0]);

        X = nx;
        Y = ny;

        if (map[X][Y] == 0) {
            map[X][Y] = dice[5];
        } else {
            dice[5] = map[X][Y];
            map[X][Y] = 0;
        }
    }
}
