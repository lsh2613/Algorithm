package 백준;

import java.util.Scanner;

public class b4963 {
    static int[][] graph;
    static int x=-1, y=-1;
    static boolean dfs(int nx, int ny) {
        // 범위를 벗어나면 바로 종료
        if (nx<0 || ny<0 || nx>= x || ny>=y)
            return false;
        // 방문하지 않았으면 1로 방문을 표시하고 true를 반환하기 전 0의 이웃한 모든 0들을 방문표시
        if (graph[nx][ny] == 1) {
            graph[nx][ny] = 0;
            dfs(nx - 1, ny);
            dfs(nx, ny - 1);
            dfs(nx + 1, ny);
            dfs(nx, ny + 1);
            dfs(nx + 1, ny + 1);
            dfs(nx + 1, ny - 1);
            dfs(nx - 1, ny + 1);
            dfs(nx - 1, ny - 1);
            return true;
        }
        // 1인 경우 종료하겠다는 의미
        else
            return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            y = sc.nextInt();
            x = sc.nextInt();
            if (x==0 && y ==0)
                break;

            graph = new int[x][y];
            sc.nextLine();
            for (int i = 0; i < x; i++) {
                String str = sc.nextLine();
                for (int j = 0; j < y; j++) {
                    // 공백 문자 건너 뛰고 숫자만 넣어주기 위함
                    graph[i][j] = str.charAt(j*2)-'0';
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
}
