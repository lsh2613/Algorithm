package goorm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Point{
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class 단풍나무 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][n];
        List<Point> zeros = new ArrayList<>();

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int token = Integer.parseInt(st.nextToken());
                board[i][j] = token;

                if (token == 0) {
                    zeros.add(new Point(i, j));
                }
            }
        }

        int day = 0;
        List<Point> tmpOfZero = new ArrayList<>();
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        while (zeros.size() != n*n) {
            day++;

            for (Point zero : zeros) {
                for (int i = 0; i < 4; i++) {
                    int x = zero.x + dx[i];
                    int y = zero.y + dy[i];

                    if (outOfBoard(x, y, n) || board[x][y] == 0) {
                        continue;
                    }

                    board[x][y]--;
                    if (board[x][y] == 0) {
                        tmpOfZero.add(new Point(x, y));
                    }
                }
            }

            zeros.addAll(tmpOfZero);
            tmpOfZero.clear();

        }

        System.out.println(day);
    }

    static boolean outOfBoard(int x, int y, int n) {
        if (x < 0 || y < 0 || x >= n || y >= n) {
            return true;
        }
        return false;
    }
}
