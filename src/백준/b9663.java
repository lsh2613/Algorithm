package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Math.*;

public class b9663 {
    static int[] queenCol;
    static int n;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        queenCol = new int[n];
        dfs(0);
        System.out.println(cnt);
    }

    static void dfs(int row) {
        if (row == n) {
            cnt++;
            return;
        }
        for (int col = 0; col < n; col++) {
            queenCol[row] = col;
            if (canQueen(row))
                dfs(row+1);
            }    
    }

    static boolean canQueen(int row) {
        for (int col = 0; col < row; col++)
            if (queenCol[row] == queenCol[col]
                    || abs(row - col) == abs(queenCol[row] - queenCol[col]))
                return false;

        return true;
    }
}
