package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class b14891 {
    static final int MIN_IDX = 0; // 톱니바퀴 최소 idx
    static final int MAX_IDX = 3; // 톱니바퀴 최대 idx
    static final int LEFT = 6; // 톱니바퀴가 겹쳐질 때 왼쪽값
    static final int RIGHT = 2; // 톱니바퀴가 겹쳐질 때 오른쪽값
    static final int S = 1; // S극
    static List<Integer>[] cogwheels = new ArrayList[4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        //init
        for (int i = 0; i < 4; i++) {
            String line = br.readLine();
            cogwheels[i] = new ArrayList<>();
            for (int j = 0; j < 8; j++) {
                cogwheels[i].add(line.charAt(j) - '0');
            }
        }

        int rotateCnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < rotateCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken());

            turnLeft(idx, dir); // 좌측 연쇄
            turnRight(idx, dir); // 우측 연쇄
            rotate(idx, dir);
        }

        // 점수 계산
        int score = 0;
        for (int i = 0; i < 4; i++) {
            if (cogwheels[i].get(0) == S) {
                score += Math.pow(2, i);
            }
        }
        System.out.println(score);
    }

    static void turnLeft(int now, int dir) {
        int leftIdx = now - 1;
        if (leftIdx < MIN_IDX) {
            return;
        }

        // 좌측 톱니바퀴와 겹치는 부분의 극이 다르다면 좌측 톱니바퀴로 재귀
        if (cogwheels[now].get(LEFT) != cogwheels[leftIdx].get(RIGHT)) {
            turnLeft(leftIdx, -dir);
            rotate(leftIdx, -dir);
        }

    }

    static void rotate(int now, int dir) {
        // 1:시계, -1:반시계
        if (dir == 1) {
            for (int i = 0; i < 7; i++) {
                int remove = cogwheels[now].remove(0);
                cogwheels[now].add(remove);
            }
        }
        if (dir == -1) {
            int remove = cogwheels[now].remove(0);
            cogwheels[now].add(remove);
        }
    }

    static void turnRight(int now, int dir) {
        int rightIdx = now + 1;
        if (rightIdx > MAX_IDX) {
            return;
        }

        // 좌측 톱니바퀴와 겹치는 부분의 극이 다르다면 좌측 톱니바퀴로 재귀
        if (cogwheels[now].get(RIGHT) != cogwheels[rightIdx].get(LEFT)) {
            turnRight(rightIdx, -dir);
            rotate(rightIdx, -dir);
        }
    }
}
