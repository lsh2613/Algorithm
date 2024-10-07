package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ14502 {
    static int[][] matrix,wallMatrix;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static int n, m,result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        matrix = new int[n][m];
        wallMatrix = new int[n][m];

        // n줄에 각 줄에 m개의 값들이 들어오는 경우, 스트림을 통해 값을 지정
        for (int i = 0; i < n; i++) {
            // 각 줄의 값들을 스트림으로 읽어서 배열에 저장
            matrix[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        dfs(0);
        System.out.println(result);

    }

    static void dfs(int cnt) {
        if (cnt == 3) { // 벽이 3개 세워지면
            // 바이러스가 전파되면 기존 matrix가 사라지므로 새로운 배열에서 전파하기 위한 깊은 복사
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    wallMatrix[i][j] = matrix[i][j];
                }
            }

            //바이러스 전파
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (wallMatrix[i][j] == 2) {
                        spreadVirus(i, j); //dfs를 통한 전파
                    }
                }
            }
            // 전파된 완료된 wallMatrix 중 최솟값 구함
            long cnt0 = Arrays.stream(wallMatrix)
                    .flatMapToInt(Arrays::stream)
                    .filter(value -> value == 0)
                    .count();
            result = Math.max(result, (int)cnt0);
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][j] = 1; // 벽을 세운 뒤 재귀로 넘겨주고
                    dfs(cnt + 1);
                    matrix[i][j] = 0; // 벽을 지움, 새로운 벽을 치기 위함
                }
            }
        }

    }

    // (i,j)부터 시작해서 전파 시작
    static void spreadVirus(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                if (wallMatrix[nx][ny] == 0) {
                    // 해당 위치에 바이러스 배치하고, 다시 재귀적으로 수행
                    wallMatrix[nx][ny] = 2;
                    spreadVirus(nx, ny);
                }
            }
        }
    }

}
