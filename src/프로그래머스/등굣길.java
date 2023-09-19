package 프로그래머스;

class 등굣길 {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] maps = new int[m+1][n+1];

        // 웅덩이 추가
        for (int i = 0; i < puddles.length; i++) {
            maps[puddles[i][0]][puddles[i][1]] = -1;
        }

        // 맨 왼쪽 열에 대해 웅덩이가 나오기 전까지 갈 수 있는 경로의 수를 1로
        for (int i = 1; i <= m && maps[i][1] != -1; i++) {
            maps[i][1] = 1;
        }

        // 맨 위 행에 대해 웅덩이가 나오기 전까지 갈 수 있는 경로의 수를 1로
        for (int i = 1; i <= n && maps[1][i] != -1; i++) {
            maps[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= m; j++) {
                if(maps[i][j]==-1) continue;

                if (maps[i][j - 1] == -1)
                    maps[i][j] = maps[i-1][j];
                else if (maps[i-1][j] == -1)
                    maps[i][j] = maps[i][j-1];
                else
                    maps[i][j] = maps[i][j-1] + maps[i-1][j];

            }
        }

        return maps[n][m];
    }

    public static void main(String[] args) {
        System.out.println(new 등굣길().solution(4,3,new int[][]{{2,2},{1,3}}));

    }
}