import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;

class Point{
    int x;
    int y;
    int prior;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
        this.prior = 0;
    }

    public Point(int x, int y, int prior) {
        this.x = x;
        this.y = y;
        this.prior = prior;
    }
}
class Main {
    static int W,H;
    static char[][] board;
    static boolean[][] visit;
    static Point start = null;
    static Point end = null;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        board = new char[W][H];
        visit = new boolean[W][H];
        start = null;
        end = null;

        for (int i = 0; i < W; i++) {
            String str = br.readLine();
            for (int j = 0; j < H; j++) {
                char token = str.charAt(j);
                if (token == 'E') {
                    end = new Point(i, j);
                }
                if (token == 'S') {
                    start = new Point(i, j);
                }
                board[i][j] = token;
            }
        }

        System.out.println(bfs());


    }
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int bfs() {
        int danger = 0;
        PriorityQueue<Point> p = new PriorityQueue<>((p1, p2)->{
            if (p1.prior == p2.prior) {
                if (p1.x == p2.x) {
                    return p1.y - p2.y;
                }
                return p1.x - p2.x;
            }
            return p2.prior - p1.prior;
        });
        p.offer(start);
        visit[start.x][start.y] = true;

        while (true) {
            Point now = p.poll();
            int x = now.x;
            int y = now.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (outOfBoard(nx, ny) || visit[nx][ny]) {
                    continue;
                }

                visit[nx][ny] = true;
                if (board[nx][ny] == 'P') {
                    p.offer(new Point(nx, ny, 1));
                }
                else if (board[nx][ny] == 'E') {
                    p.offer(new Point(nx, ny, 2));
                }
                else
                    p.offer(new Point(nx, ny));

            }

            char c = board[x][y];
            if (c == 'S') {
                continue;
            }
            if (c == 'E') {
                return danger;
            }
            if (c == '0') {
                danger += getdanger(x, y);
            }
            if (c == 'P') {
                danger += getdanger(x, y) - 3;
            }
        }
    }

    private static int getdanger(int x, int y) {
        int pCnt = 0;
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y -1; j <= y +1; j++) {
                if (outOfBoard(i, j) || (x == i && y == j)) {
                    continue;
                }
                if (board[i][j] == 'P') {
                    pCnt++;
                }
            }
        }
        return pCnt;
    }

    static boolean outOfBoard(int x, int y) {
        if (x < 0 || y < 0 || x >= W || y >= H) {
            return true;
        }
        return false;
    }
}
