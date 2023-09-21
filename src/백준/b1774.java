import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

class Position {
    int idx;
    int x;
    int y;

    public Position(int idx, int x, int y) {
        this.idx = idx;
        this.x = x;
        this.y = y;
    }
}

class Edge {
    int idx1;
    int idx2;
    double distance;

    public Edge(int idx1, int idx2, double distance) {
        this.idx1 = idx1;
        this.idx2 = idx2;
        this.distance = distance;
    }
}

public class b1774 {
    static Position[] positions;
    static List<Edge> edgeList;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // init
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
        positions = new Position[N];
        edgeList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            positions[i] = new Position(i + 1, x, y);
        }

        // 가능한 모든 간선에 대해 edgeList 추가
        for (int i = 0; i < N; i++) {
            Position pos1 = positions[i];
            int idx1 = pos1.idx;
            int x1 = pos1.x;
            int y1 = pos1.y;
            for (int j = i + 1; j < N; j++) {
                Position pos2 = positions[j];
                int idx2 = pos2.idx;
                int x2 = pos2.x;
                int y2 = pos2.y;

                double distance = sqrt(pow(x1 - x2, 2) + pow(y1 - y2, 2));
                edgeList.add(new Edge(idx1, idx2, distance));
            }
        }

        int mstEdgeCnt = 0;
        double mstWeight = 0;

        // 이미 연결된 간선 union
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            if (union(from, to)) {
                mstEdgeCnt++;
            }
        }

        // 나머지 간선 추가
        edgeList.sort((e1, e2) -> Double.compare(e1.distance, e2.distance)); // 오름차순
        for (int i = 0; i < edgeList.size(); i++) {
            Edge edge = edgeList.get(i);
            int idx1 = edge.idx1;
            int idx2 = edge.idx2;
            double dist = edge.distance;

            if (union(idx1, idx2)) {
                mstWeight += dist;
                mstEdgeCnt++;
                if (mstEdgeCnt == N - 1) {
                    break;
                }
            }
        }

        System.out.println(String.format("%.2f", mstWeight));
    }

    static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB)
            return false;

        parent[rootB] = rootA;
        return true;
    }

    static int find(int n) {
        if (parent[n] != n)
            parent[n] = find(parent[n]);

        return parent[n];
    }
}
