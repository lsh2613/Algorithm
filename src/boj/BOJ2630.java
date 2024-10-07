package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2630 {
    static int white = 0;
    static int blue = 0;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        board = new int[n+1][n+1];
        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        halfDivision(1, n, 1, n);

        System.out.println(white);
        System.out.println(blue);
    }

    static void halfDivision(int left, int right, int up, int down) {

        if (isColorPaper(left, right, up, down)) {
            if (board[up][left]==0)
                white++;
            else
                blue++;
            return;
        }

        int midW = (right + left) / 2;
        int midH = (down + up) / 2;

        //1
        halfDivision(midW + 1, right, up, midH);
        //2
        halfDivision(left, midW, up, midH);
        //3
        halfDivision(left, midW, midH + 1, down);
        //4
        halfDivision(midW + 1, right, midH + 1, down);

    }

    static boolean isColorPaper(int left, int right, int up, int down) {
        int sample = board[up][left];

        for (int i = up; i <= down; i++) {
            for (int j = left; j <= right; j++) {
                if (board[i][j] != sample)
                    return false;
            }
        }

        return true;
    }
}
