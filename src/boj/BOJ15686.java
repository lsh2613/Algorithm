package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ15686 {
    static int N, M;
    static int[][] board;
    static List<int[]> houses = new ArrayList<>();
    static List<int[]> chickens = new ArrayList<>();
    static boolean[] open;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 1) {
                    houses.add(new int[]{i, j});
                }
                if (board[i][j] == 2) {
                    chickens.add(new int[]{i, j});
                }
            }
        }

        open = new boolean[chickens.size()];
        dfs(0, 0);

        System.out.println(result);
    }

    static void dfs(int idx, int cnt) {
        if (cnt == M) {
            int sumDistance = 0;
            for (int[] house : houses) {
                int minDistacne = Integer.MAX_VALUE;
                for (int i = 0; i < chickens.size(); i++) {
                    if (open[i]) {
                        int[] chicken = chickens.get(i);
                        int distance = Math.abs(house[0] - chicken[0]) + Math.abs(house[1] - chicken[1]);
                        minDistacne = Math.min(distance, minDistacne);
                    }

                }

                sumDistance += minDistacne;
            }

            result = Math.min(result, sumDistance);
            return;
        }

        for (int i = 0; i < chickens.size(); i++) {
            open[i] = true;
            dfs(i + 1, cnt + 1);
            open[i] = false;
        }
    }
}
