package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b14889 {
    static boolean[] visit;
    static int n;
    static int[][] mat;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        // init
        visit = new boolean[n];
        mat = new int[n][n];
        for (int i = 0; i < n; i++) {
            mat[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        dfs(0, 0);

        System.out.println(answer);
    }

    static void dfs(int cnt, int index) {
        if (cnt == n / 2) {
            int diff = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (visit[i] && visit[j]) {
                        diff += mat[i][j];
                    } else if (!visit[i] && !visit[j]) {
                        diff -= mat[i][j];
                    }
                }
            }

            answer = Math.min(answer, Math.abs(diff));
        }
        else {
            for (int i = index; i < n; i++) {
                if (!visit[i]) {
                    visit[i] = true;
                    dfs(cnt + 1, i + 1);
                    visit[i] = false;
                }
            }
        }
    }
}
