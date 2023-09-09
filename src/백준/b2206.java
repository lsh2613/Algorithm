package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Point{
    int x;
    int y;
    int depth = 0;
    boolean canBreakWall = false;

    public Point(int x, int y, int depth, boolean canBreakWall) {
        this.x = x;
        this.y = y;
        this.depth = depth;
        this.canBreakWall = canBreakWall;
    }
}

public class b2206 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        //init()
        int[][] board = new int[n][m];
        for (int i = 0; i < n; i++) {
            board[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        int result = bfs(n, m, board);
        System.out.println(result);
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static public int bfs(int n, int m, int[][] board) {
        final int NOT_BROKEN = 0;
        final int BROKEN = 1;

        boolean[][][] visit = new boolean[n][m][2];
        visit[0][0][NOT_BROKEN] = true;

        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0, 0, 1, true));

        while (!q.isEmpty()) {
            Point now = q.poll();

            if (now.x == n - 1 && now.y == m - 1)
                return now.depth;

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (outOfBoard(nx, ny, n, m))
                    continue;

                if (board[nx][ny] == 0) {
                    if (now.canBreakWall && !visit[nx][ny][NOT_BROKEN]) {
                        visit[nx][ny][NOT_BROKEN] = true;
                        q.offer(new Point(nx, ny, now.depth + 1, now.canBreakWall));
                    }
                    else if (!now.canBreakWall && !visit[nx][ny][BROKEN]){
                        q.offer(new Point(nx, ny, now.depth + 1, now.canBreakWall));
                        visit[nx][ny][BROKEN] = true;
                    }
                }

                if (board[nx][ny] == 1 && now.canBreakWall) {
                    q.offer(new Point(nx, ny, now.depth + 1, false));
                }

            }
        }
        return -1;
    }

    static boolean outOfBoard(int nx, int ny, int n, int m) {
        if (nx < 0 || ny < 0 || nx >= n || ny >= m)
            return true;
        return false;
    }
}
