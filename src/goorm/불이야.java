package goorm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Place {
    int x;
    int y;
    int time;

    public Place(int x, int y, int time) {
        this.x = x;
        this.y = y;
        this.time = time;
    }
}
class 불이야 {

    static char[][] board;
    static boolean[][] visit;
    static int n, m;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        n = Integer.parseInt(split[0]);
        m = Integer.parseInt(split[1]);
        board = new char[n][m];
        visit = new boolean[n][m];
        Place start = null;
        Queue<Place> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = line.charAt(j);
                if (board[i][j] == '@') {
                    q.offer(new Place(i, j, 0));
                    visit[i][j] = true;
                }
            }
        }
        System.out.println(bfs(q));
    }

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int bfs(Queue<Place> q) {
        while (!q.isEmpty()) {
            Place now = q.poll();
            for (int i = 0; i < 4; i++) {
                int x = now.x + dx[i];
                int y = now.y + dy[i];

                if (outOfBoard(x, y) || visit[x][y] || board[x][y] == '#') {
                    continue;
                }
                if (board[x][y] == '&') {
                    return now.time;
                }

                visit[x][y] = true;
                q.offer(new Place(x, y, now.time + 1));
            }
        }

        return -1;
    }

    static boolean outOfBoard(int x, int y) {
        if (x < 0 || y < 0 || x >= n || y >= m) {
            return true;
        }
        return false;
    }
}