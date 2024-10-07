package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ17472 {
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Island {
        int idx;
        List<Point> area;

        public Island(int idx) {
            this.idx = idx;
        }

        public List<Point> getArea() {
            return area;
        }

        public void setArea(List<Point> area) {
            this.area = area;
        }
    }

    static class Bridge {
        int idx1;
        int idx2;
        int distance;

        public Bridge(int idx1, int idx2, int distance) {
            this.idx1 = idx1;
            this.idx2 = idx2;
            this.distance = distance;
        }
    }

    static int N, M;
    static int[][] board;
    static List<Island> islandList;
    static boolean[][] visit;
    static List<Bridge> bridgeList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // init board
        islandList = new ArrayList<>();
        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        // init islandList
        int numbering = 1;
        visit = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 1 && !visit[i][j]) {
                    insertIslandList(i, j, numbering);
                    numbering++;
                }
            }
        }

        // init bridgeList
        bridgeList = new ArrayList<>();
        for (int i = 0; i < islandList.size(); i++) {
            Island island = islandList.get(i);
            List<Point> area = island.getArea();

            for (int j = 0; j < area.size(); j++) {
                Point point = area.get(j);

                for (int dir = 0; dir < 4; dir++) {
                    findBridge(island.idx, point.x, point.y, dir, -1);
                }
            }
        }

        bridgeList.sort((b1, b2) -> b1.distance - b2.distance);
        System.out.println(kruskal());
    }

    static int[] parent;
    static int kruskal() {
        int size = islandList.size();
        parent = new int[size + 1];
        for (int i = 1; i < size+1; i++) {
            parent[i] = i;
        }

        int mstEdgeCnt = 0;
        int weight = 0;
        for (int i = 0; i < bridgeList.size(); i++) {
            Bridge bridge = bridgeList.get(i);
            int idx1 = bridge.idx1;
            int idx2 = bridge.idx2;

            if (union(idx1, idx2)) {
                mstEdgeCnt++;
                weight += bridge.distance;

                // MST의 간선 개수 == 노드 개수 - 1
                // 즉, 모든 섬을 이어주는 다리의 개수 = 섬의 개수 - - 1
                if (mstEdgeCnt == islandList.size() - 1) {
                    return weight;
                }
            }
        }
        return -1;
    }
    static boolean union(int idx1, int idx2) {
        int root1 = find(idx1);
        int root2 = find(idx2);

        if (root1 == root2) {
            return false;
        }

        parent[root2] = root1;
        return true;
    }

    static int find(int n) {
        if (parent[n] != n) {
            parent[n] = find(parent[n]);
        }
        return parent[n];
    }


    static void findBridge(int idx, int x, int y, int dir, int distance) {
        if(board[x][y] != 0 && board[x][y] != idx) { //다른 섬을 만남
            if(distance >= 2) bridgeList.add(new Bridge(idx, board[x][y], distance));
            return;
        }

        int nx = x + dx[dir];
        int ny = y + dy[dir];
        if (outOfBoardRange(nx, ny) || board[nx][ny] == idx) {
            return;
        }

        findBridge(idx, nx, ny, dir, distance + 1);
    }

    static void insertIslandList(int i, int j, int numbering) {
        Island island = new Island(numbering);
        List<Point> area = new ArrayList<>();
        // init area
        bfs(i, j, area, numbering);
        island.setArea(area);

        islandList.add(island);
    }

    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};

    static void bfs(int i, int j, List<Point> area, int numbering) {
        board[i][j] = numbering;
        visit[i][j] = true;
        area.add(new Point(i, j));

        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(i, j));
        while (!q.isEmpty()) {
            Point now = q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = now.x + dx[k];
                int ny = now.y + dy[k];

                if (outOfBoardRange(nx, ny) || visit[nx][ny] || board[nx][ny] == 0) {
                    continue;
                }
                board[nx][ny] = numbering;
                area.add(new Point(nx, ny));

                visit[nx][ny] = true;
                q.offer(new Point(nx, ny));
            }
        }
    }

    static boolean outOfBoardRange(int nx, int ny) {
        if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
            return true;
        }
        return false;
    }
}
