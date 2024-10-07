package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2580 {
    static int[][] board = new int[9][9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        sudoku(0, 0);

    }

    static void sudoku(int row, int col) {
        if (col == 9){
            sudoku(row + 1, 0);
            return;
        }


        if (row == 9) {
            for (int i = 0; i < 9; i++) {
                Arrays.stream(board[i]).forEach(n -> System.out.print(n + " "));
                System.out.println();
            }
            System.exit(0);

        }

        if (board[row][col] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (canPut(row, col, i)) {
                    board[row][col] = i;
                    sudoku(row, col+1);
                }
            }
            board[row][col] = 0;
            return;
        }
        sudoku(row, col + 1);
    }

    public static boolean canPut(int row, int col, int value) {

        // 같은 행에 있는 원소들 중 겹치는 열 원소가 있는지 검사
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == value) {
                return false;
            }
        }

        // 같은 열에 있는 원소들 중 겹치는 행 원소가 있는지 검사
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == value) {
                return false;
            }
        }

        // 3*3 칸에 중복되는 원소가 있는지 검사
        int set_row = (row / 3) * 3; // value가 속한 3x3의 행의 첫 위치
        int set_col = (col / 3) * 3; // value가 속한 3x3의 열의 첫 위치

        for (int i = set_row; i < set_row + 3; i++) {
            for (int j = set_col; j < set_col + 3; j++) {
                if (board[i][j] == value) {
                    return false;
                }
            }
        }

        return true; // 중복되는 것이 없을 경우 true 반환
    }
}
