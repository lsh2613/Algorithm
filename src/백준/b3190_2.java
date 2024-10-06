package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class b3190_2 {
    static int[][] board;
    static int N;
    static final int APPLE = 1;
    static final int UP = 2;
    static final int RIGHT = 3;
    static final int DOWN = 4;
    static final int LEFT = 5;
    static Map<Integer, Character> timeDir = new HashMap<>();
    static Queue<int[]> snake = new LinkedList<>();

    static class Node {
        int x, y, dir;

        public Node(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N + 1][N + 1];

        StringTokenizer st;
        // 사과 저장
        int appleCnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < appleCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            board[r][c] = APPLE;
        }

        // 시간 - 방향 저장
        int dirCnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < dirCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            char dir = st.nextToken().charAt(0);
            timeDir.put(time, dir);
        }

        // 스네이크 저장 후 시작
        Node head = new Node(1, 1, RIGHT);
        snake.add(new int[]{1, 1});
        int time = 0;
        while (true) {
            time++;

            moveForward(head);
            int r = head.x;
            int c = head.y;
            if (outOfBoard(r, c) || isSnake(r, c)) {
                System.out.println(time);
                return;
            }

            snake.add(new int[]{r, c});
            if (board[r][c] == APPLE) {
                board[r][c] = 0;
            } else {
                snake.remove();
            }

            // 방향 전환 체크
            if (timeDir.containsKey(time)) {
                turn(head, timeDir.get(time));
            }

        }
    }

    static void turn(Node head, Character dir) {
        switch (dir) {
            case 'L':
                head.dir = (head.dir + 1) % 4 + 2;
                break;
            case 'D':
                head.dir = (head.dir + 3) % 4 + 2;
        }

    }

    static boolean isSnake(int r, int c) {
        return snake.stream().anyMatch(n -> n[0] == r && n[1] == c);
    }

    static boolean outOfBoard(int x, int y) {
        return x < 1 || x > N || y < 1 || y > N;
    }

    static void moveForward(Node node) {
        switch (node.dir) {
            case RIGHT:
                node.y += 1;
                break;
            case LEFT:
                node.y -= 1;
                break;
            case UP:
                node.x -= 1;
                break;
            case DOWN:
                node.x += 1;
        }
    }
}
