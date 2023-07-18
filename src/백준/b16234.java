package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
2 40 50
50 30
20 40
 */
class Point{
    int x;
    int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class b16234 {
    static int[][] population;
    static ArrayList<Point> unitedCity = new ArrayList<>();
    static boolean[][] isUnited;
    static boolean[][] visited;
    static int unionCnt, unionSum;
    static int N, L, R, moveCnt;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        // 인구수 초기화 및 지정
        population = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                population[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            unionCnt = unionSum = 0;
            isUnited = new boolean[N][N];
            visited = new boolean[N][N];
            unitedCity.clear();
            openCity(0, 0);
            if (unionCnt == 0) { // 연합 도시가 없는 경우 종류
                break;
            }
            // 연합 인구 이동
            int unionPop = unionSum / unionCnt;
            for (int i = 0; i < unitedCity.size(); i++) {
                Point point = unitedCity.get(i);
                population[point.getX()][point.getY()] = unionPop;
            }
            moveCnt++;
        }
        System.out.println(moveCnt);

    }

    // dfs를 통한 완전탐색, 상화좌우를 돌며 국경선이 열린 도시를 저장
    static void openCity(int x, int y) {
        // 좌표를 벗어나면 종료
        if (x < 0 || y < 0 || x >= N || y >= N || visited[x][y]) {
            return;
        }
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            // 상하좌우에 대한 좌표가 올바른지 체크
            if (nx < 0 || ny < 0 || nx >= N || ny >= N)
                continue;
            else{
                int diff = Math.abs(population[x][y] - population[nx][ny]);
                // 국경선이 열리는 도시에 대하여
                if (L <= diff && diff <= R) {
                    if (!isUnited[x][y]) {
                        isUnited[x][y] = true;
                        unitedCity.add(new Point(x, y));
                        unionCnt++;
                        unionSum += population[x][y];
                    }
                    if (!isUnited[nx][ny]) {
                        isUnited[nx][ny] = true;
                        unitedCity.add(new Point(nx, ny));
                        unionCnt++;
                        unionSum += population[nx][ny];
                    }
                }
            }
            openCity(nx,ny);
        }

    }
}