package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15684 {
    static int N;
    static int M;
    static int H;
    static int[][] map;

    static int RIGHT = 1;
    static int LEFT = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H + 1][N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[r][c] = RIGHT;
            map[r][c + 1] = LEFT;
        }

        for (int i = 0; i <= 3; i++) {
            dfs(1, 0, i);
        }

        System.out.println(-1);
    }

    private static void dfs(int floor, int size, int max) {
        if (size == max) {
            if (check()) {
                System.out.println(size);
                System.exit(0);
            }
            return;
        }

        for (; floor <= H; floor++) {
            for (int c = 1; c <= N - 1; c++) {
                // 사다리끼리 붙어 있으면 안 됨
                if (map[floor][c] != 0 || map[floor][c + 1] != 0)
                    continue;

                map[floor][c] = RIGHT;
                map[floor][c + 1] = LEFT;

                dfs(floor, size + 1, max);

                map[floor][c] = map[floor][c + 1] = 0;
            }
        }

    }

    private static boolean check() {
        for (int start = 1; start <= N; start++) {
            int position = start;
            for (int h = 1; h <= H; h++) {
                if (map[h][position] == RIGHT)
                    position++;
                else if (map[h][position] == LEFT)
                    position--;
            }

            if (start != position)
                return false;
        }

        return true;
    }
}
