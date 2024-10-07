package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Head {
    int x;
    int y;
    int d;

    public Head(int x, int y, int d) {
        this.x = x;
        this.y = y;
        this.d = d;
    }
}

public class BOJ3190 {
    static int[][] board;
    static Map<Integer, Character> timeToDir = new HashMap<>();
    static List<int[]> snake = new ArrayList<>();
    static int N;

    static int APPLE = 1;

    static final int UP = 3;
    static final int RIGHT = 4;
    static final int DOWN = 5;
    static final int LEFT = 6;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        board = new int[N + 1][N + 1];
        snake.add(new int[]{1, 1});

        int appleCnt = Integer.parseInt(br.readLine());
        StringTokenizer st;
        // 사과 저장
        for (int i = 0; i < appleCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            board[r][c] = APPLE;
        }
        // 시간방향 저장
        int directionCnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < directionCnt; i++) {
            st = new StringTokenizer(br.readLine());
            timeToDir.put(Integer.parseInt(st.nextToken()), st.nextToken().charAt(0));
        }
        // 뱀 시작
        Head head = new Head(1, 1, RIGHT);
        int time = 0;
        while (true) {
            time++;

            moveForward(head);
            // 종료 조건
            if (outOfBoard(head.x, head.y) || isSnake(head.x, head.y)) {
                System.out.println(time);
                return;
            }

            // 스네이크 추가 및 사과 여부체크
            snake.add(new int[]{head.x, head.y}); // 머리 추가
            if (board[head.x][head.y] == APPLE) {
                board[head.x][head.y] = 0; // 사과 삭제
            }
            else if (board[head.x][head.y] != APPLE) {
                snake.remove(0); // 꼬리 삭제
            }

            // 방향 전환 체크
            if (timeToDir.containsKey(time)) {
                turn(head, timeToDir.get(time));
            }
        }

    }

    static void moveForward(Head node) {
        switch (node.d) {
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

    static void turn(Head node, char dir) {
        switch (dir) {
            case 'D':
                node.d = (node.d + 2) % 4 + 3;
                break;
            case 'L':
                node.d = node.d % 4 + 3;
        }
    }

    static boolean outOfBoard(int x, int y) {
        return x < 1 || y < 1 || x > N || y > N;
    }

    static boolean isSnake(int x, int y) {
        for (int[] ints : snake) {
            if (ints[0] == x && ints[1] == y) {
                return true;
            }
        }
        return false;
    }


}
