package 이코테.기출분석.DFS_BFS;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/*
5 6
101010
111111
000001
111111
111111
 */
class Node {
    int x;
    int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class BFS {
    static int n, m;
    static int[][] graph;
    static int dx[] = {1, -1, 0, 0};
    static int dy[] = {0, 0, -1, 1};

    public static int bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));

        while (!q.isEmpty()) {
            Node node = q.poll();
            int preX = node.getX();
            int preY = node.getY();
            for (int i = 0; i < 4; i++) {
                int nx = preX + dx[i];
                int ny = preY + dy[i];

                if (nx < 0 || nx >= graph.length || ny < 0 || ny >= graph[0].length)
                    continue;
                if (graph[nx][ny]==0)
                    continue;
                if (graph[nx][ny] == 1) {
                    graph[nx][ny] = graph[preX][preY] + 1;
                    q.offer(new Node(nx, ny));
                }
            }
        }
        return graph[n - 1][m - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new int[n][m];

        for (int i = 0; i < n; i++) {
            String str = sc.next();
            for (int j = 0; j < m; j++) {
                graph[i][j] = str.charAt(j) - '0';
            }
        }

        System.out.println(bfs(0, 0));
    }
}
