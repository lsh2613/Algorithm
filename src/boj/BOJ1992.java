package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1992 {
    static int[][] board;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        board = new int[n+1][n+1];
        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(String.join(" ", br.readLine().split("")));
            for (int j = 1; j <= n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        quadTree(1, n, 1, n);
        System.out.println(sb);
    }

    static void quadTree(int left, int right, int up, int down) {

        if (canCompress(left, right, up, down)) {
            sb.append(board[up][left]);
            return;
        }

        int midW = (right + left) / 2;
        int midH = (down + up) / 2;

        sb.append('(');
        // 왼쪽 위
        quadTree(left, midW, up, midH);
        // 오른쪽 위
        quadTree(midW + 1, right, up, midH);
        // 왼쪽 아래
        quadTree(left, midW, midH + 1, down);
        // 오른쪽 아래
        quadTree(midW + 1, right, midH + 1, down);
        sb.append(')');

    }

    static boolean canCompress(int left, int right, int up, int down) {
        int firstValue = board[up][left]; // 첫 번째 숫자를 기준으로 설정합니다.

        for (int i = up; i <= down; i++) {
            for (int j = left; j <= right; j++) {
                if (board[i][j] != firstValue) {
                    return false; // 다른 숫자가 하나라도 있으면 압축할 수 없습니다.
                }
            }
        }

        return true; // 모든 숫자가 같다면 압축할 수 있습니다.
    }

}
