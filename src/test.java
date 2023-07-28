//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//class UserSolution {
//    private static int[][] map;
//    private static int mapSize;
//
//    void bfs_init(int map_size, int[][] map) {
//        mapSize = map_size;
//        UserSolution.map = map;
//    }
//
//    int bfs(int y1, int x1, int y2, int x2) {
//        // 1-based 좌표를 0-based로 변환
//        x1--;
//        y1--;
//        x2--;
//        y2--;
//
//        if (x1 == x2 && y1 == y2) {
//            // 시작점과 도착점이 같은 경우
//            return 0;
//        }
//
//        boolean[][] visited = new boolean[mapSize][mapSize];
//        int[] dx = {-1, 0, 1, 0}; // 상, 우, 하, 좌
//        int[] dy = {0, 1, 0, -1};
//
//        int[][] queue = new int[mapSize * mapSize][3]; // (x, y, distance)
//        int front = 0;
//        int rear = 1;
//
//        queue[front][0] = x1;
//        queue[front][1] = y1;
//        queue[front][2] = 0;
//
//        visited[x1][y1] = true;
//
//        while (front < rear) {
//            int x = queue[front][0];
//            int y = queue[front][1];
//            int distance = queue[front][2];
//            front++;
//
//            for (int i = 0; i < 4; i++) {
//                int newX = x + dx[i];
//                int newY = y + dy[i];
//
//                if (newX >= 0 && newX < mapSize && newY >= 0 && newY < mapSize &&
//                        map[newX][newY] == 0 && !visited[newX][newY]) {
//                    if (newX == x2 && newY == y2) {
//                        // 도착점에 도달한 경우
//                        return distance + 1;
//                    }
//                    queue[rear][0] = newX;
//                    queue[rear][1] = newY;
//                    queue[rear][2] = distance + 1;
//                    rear++;
//                    visited[newX][newY] = true;
//                }
//            }
//        }
//
//        // 도착점에 도달할 수 없는 경우
//        return -1;
//    }
//}
//
//public class Solution {
//
//    private final static UserSolution usersolution = new UserSolution();
//
//    private static BufferedReader br;
//
//    private static int cmd_bfs() throws Exception {
//
//        int score = 100;
//        int N, M, x1, y1, x2, y2, dist, ans;
//        int[][] map = new int[10][10];
//        String str;
//        StringTokenizer st;
//
//        br = new BufferedReader(new InputStreamReader(System.in));
//        str = br.readLine();
//        N = Integer.parseInt(str);
//
//        for(int i = 0; i < N; i++) {
//            str = br.readLine();
//            st = new StringTokenizer(str, " ");
//            for(int j = 0; j < N; j++) {
//                map[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }
//
//        usersolution.bfs_init(N, map);
//
//        str = br.readLine();
//        M = Integer.parseInt(str);
//
//        for(int i = 1; i <= M; i++) {
//            str = br.readLine();
//            st = new StringTokenizer(str, " ");
//            y1 = Integer.parseInt(st.nextToken());
//            x1 = Integer.parseInt(st.nextToken());
//            y2 = Integer.parseInt(st.nextToken());
//            x2 = Integer.parseInt(st.nextToken());
//            ans = Integer.parseInt(st.nextToken());
//
//            dist = usersolution.bfs(y1, x1, y2, x2);
//
//            if(dist != ans) {
//                score = 0;
//            }
//        }
//        return score;
//    }
//
//    public static void main(String[] args) throws Exception {
//        System.out.println("#total score : " + cmd_bfs());
//    }
//}
