import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main{
    static int R;
    static int C;
    static int[][] board;
    static int time = 0;
    static int lastSize = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new int[R][C];
        int sizeOfC = 0;

        for (int i = 0; i < R; i++) {
            String line[] = br.readLine().split(" ");
            for (int j = 0; j < C; j++) {
                board[i][j] = Integer.parseInt(line[j]);
                if (board[i][j]==1)
                    sizeOfC++;
            }
        }

        if (sizeOfC <= 3) {
            sb.append(1).append("\n").append(sizeOfC);
            System.out.println(sb);
            return;
        }

        bfs(sizeOfC);
    }

    static int dx[] = {0, 0, -1, 1};
    static int dy[] = {-1, 1, 0, 0};

    private static void bfs(int sizeOfC) {
        boolean visit[][] = new boolean[R][C];

        if (sizeOfC == 0) {
            return;
        }
        time++;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        visit[0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[0] + dy[i];

                if (nx < 0 || ny < 0 || nx >= R || ny >= C || visit[nx][ny]) {
                    continue;
                }
                visit[nx][ny] = true;
                if(board[nx][ny] == 0) {
                    q.offer(new int[] {nx, ny});
                } else {
                    sizeOfC--;
                    board[nx][ny] = 0;
                }

            }

        }


    }

}
