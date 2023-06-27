package 이코테.기출분석.DFS_BFS;

import java.util.Scanner;
/*
4 5
00110
00011
11111
00000
 */
public class DFS {
    static int[][] graph;

    static boolean dfs(int x, int y) {
        // 범위를 벗어나면 바로 종료
        if (x<0 || y<0 || x>= graph.length || y>=graph[0].length)
            return false;
        // 방문하지 않았으면 1로 방문을 표시하고 true를 반환하기 전 0의 이웃한 모든 0들을 방문표시
        if (graph[x][y] == 0) {
            graph[x][y] = 1;
            dfs(x - 1, y);
            dfs(x, y - 1);
            dfs(x + 1, y);
            dfs(x, y + 1);
            return true;
        }
        // 1인 경우 종료하겠다는 의미
        else
            return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();
        graph = new int[x][y];

        for (int i = 0; i < x; i++) {
            String str = sc.next();
            for (int j = 0; j < y; j++) {
                graph[i][j] = str.charAt(j) - '0';
            }
        }

        int cnt = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (dfs(i, j) == true)
                    cnt++;
            }
        }
        System.out.println(cnt);
    }
}
