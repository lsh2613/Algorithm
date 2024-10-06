package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b13460 {

    private static class Marbles {
        int[] red;
        int[] blue;
        int cnt; // 기울인 횟수

        public Marbles() {
        }

        public Marbles(int[] red, int[] blue, int cnt) {
            this.red = red;
            this.blue = blue;
            this.cnt = cnt;
        }
    }

    static int N, M;
    static char[][] map;
    static boolean[][][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M][N][M];

        Marbles marbles = new Marbles();

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                char c = line.charAt(j);
                map[i][j] = c;
                switch (c) {
                    case 'R':
                        marbles.red = new int[]{i, j};
                        break;
                    case 'B':
                        marbles.blue = new int[]{i, j};
                        break;
                }
            }
        }

        int result = bfs(marbles);
        System.out.println(result == 0 || result > 10 ? -1 : result);
    }

    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};

    private static int bfs(Marbles marbles) {
        Queue<Marbles> q = new LinkedList<>();
        q.offer(marbles);

        while (!q.isEmpty()) {
            Marbles m = q.poll();
            int[] red = m.red;
            int[] blue = m.blue;

            for (int i = 0; i < 4; i++) {
                int rx = m.red[0];
                int ry = m.red[1];
                int rd = 0;
                int bx = m.blue[0];
                int by = m.blue[1];
                int bd = 0;

                // 빨강 기울이기
                while (true) {
                    if (map[rx][ry] == 'O')
                        break;
                    if (map[rx][ry] == '#') {
                        rx -= dx[i];
                        ry -= dy[i];
                        break;
                    }
                    rx += dx[i];
                    ry += dy[i];
                    rd++;
                }

                // 파랑 기울이기
                while (true) {
                    if (map[bx][by] == 'O')
                        break;
                    if (map[bx][by] == '#') {
                        bx -= dx[i];
                        by -= dy[i];
                        break;
                    }
                    bx += dx[i];
                    by += dy[i];
                    bd++;
                }

                // 파란 구슬이 들어갔다면 다른 경우 탐색
                if (map[bx][by] == 'O')
                    continue;

                // 빨간 구슬이 들어갔다면 bfs이기 때문에 처음 발견한 값이 최소 기울인 횟수
                if (map[rx][ry] == 'O')
                    return m.cnt + 1;

                // red, blue가 같은 장소인 경우
                if (rx == bx && ry == by) {
                    // 움직인 거리가 긴 구슬을 뒤로 움직여줌
                    if (rd > bd) {
                        rx -= dx[i];
                        ry -= dy[i];
                    } else {
                        bx -= dx[i];
                        by -= dy[i];
                    }
                }

                if (!visited[rx][ry][bx][by]) {
                    visited[rx][ry][bx][by] = true;
                    if (red[0] != rx || red[1] != ry || blue[0] != bx || blue[1] != by) // 기울기 전과 후의 위치가 다른 경우만 (성능향상)
                        q.offer(new Marbles(new int[]{rx, ry}, new int[]{bx, by}, m.cnt + 1));
                }

            }
        }

        return marbles.cnt;
    }
}
