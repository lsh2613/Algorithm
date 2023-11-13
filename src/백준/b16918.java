package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class b16918 {
    static int N, M, TIME;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        TIME = Integer.parseInt(st.nextToken());

        if (TIME <= 1) {
            printOriginal();
        }
        else if (TIME % 2 == 0) {
            printFullZero();
        }
        else if (TIME % 2 == 1) {
            printBomb();
        }
    }

    static void printOriginal() throws IOException {
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                System.out.print(line.charAt(j));
            }
            System.out.println();
        }
    }

    static void printFullZero() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print('O');
            }
            System.out.println();
        }
    }

    static void printBomb() throws IOException {
        char[][] board = new char[N][M];
        Queue<Point> bombs = new LinkedList<>();

        // 폭탄 위치 저장
        for (int j = 0; j < N; j++) {
            String line = br.readLine();
            for (int k = 0; k < M; k++) {
                char c = line.charAt(k);
                if (c == 'O') {
                    bombs.offer(new Point(j, k));
                }
            }
        }

        for (int i = 2; i <= TIME; i++) {
            if (i % 2 == 1) {
                // 폭탄 설치 전 현재 폭탄 위치 저장
                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < M; k++) {
                        if (board[j][k] == 'O') {
                            bombs.add(new Point(j, k));
                        }
                    }
                }
                // 폭탄 위치 저장했으므로 1초 전 폭탄이 설치되어있다고 가정
                for (int j = 0; j < N; j++) {
                    Arrays.fill(board[j], 'O');
                }

                //폭탄 터트리기
                bomb(bombs, board);
            }
        }

        for (char[] line : board) {
            for (char c : line) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    private static void bomb(Queue<Point> bombs, char[][] board) {
        int[] dx = {0, 0, -1, 1, 0};
        int[] dy = {-1, 1, 0, 0, 0};
        while (!bombs.isEmpty()) {
            Point bomb = bombs.poll();
            for (int i = 0; i < 5; i++) {
                int x = bomb.x + dx[i];
                int y = bomb.y + dy[i];

                if (outOfBoard(x, y) || board[x][y] == '.') {
                    continue;
                }

                board[x][y] = '.';
            }
        }
    }

    static boolean outOfBoard(int x, int y) {
        return x < 0 || y < 0 || x >= N || y >= M;
    }

}
/*
6 7 7
.......
...O...
....O..
.......
OO.....
OO.....

3 3 5
OO.
OOO
OOO
 */