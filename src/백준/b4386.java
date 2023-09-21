//package 백준;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.StringTokenizer;
//
//import static java.lang.Math.*;
//
//class Star {
//    int idx;
//    double x;
//    double y;
//
//    public Star(int idx, double x, double y) {
//        this.idx = idx;
//        this.x = x;
//        this.y = y;
//    }
//}
//class Edge {
//    int from;
//    int to;
//    double cost;
//
//    public Edge(int from, int to, double cost) {
//        this.from = from;
//        this.to = to;
//        this.cost = cost;
//    }
//}
//public class b4386 {
//    static Star[] stars;
//    static List<Edge> edges;
//    static int[] parent;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
//        parent = new int[N];
//        for (int i = 0; i < N; i++) {
//            parent[i] = i;
//        }
//        stars = new Star[N];
//        edges = new ArrayList<>();
//
//        // 정점(Star) 추가
//        StringTokenizer st;
//        for (int i = 0; i < N; i++) {
//            st = new StringTokenizer(br.readLine());
//            double from = Double.parseDouble(st.nextToken());
//            double to = Double.parseDouble(st.nextToken());
//
//            stars[i] = new Star(i, from, to);
//        }
//
//        // Star를 통해 가능한 모든 간선 추가
//        for (int i = 0; i < N; i++) {
//            Star star1 = stars[i];
//            int idx1 = star1.idx;
//            double x1 = star1.x;
//            double y1 = star1.y;
//
//            for (int j = i + 1; j < N; j++) {
//                Star star2 = stars[j];
//                int idx2 = star2.idx;
//                double x2 = star2.x;
//                double y2 = star2.y;
//
//                double cost = sqrt(pow(x1 - x2, 2) + pow(y1 - y2, 2));
//                edges.add(new Edge(idx1, idx2, cost));
//            }
//        }
//
//        // MST 구하기, Kruskal
//        edges.sort((e1, e2) -> (int) (e1.cost - e2.cost));
//        double mstWeight = 0;
//        int mstEdgeCnt = 0;
//        for (int i = 0; i < edges.size(); i++) {
//            Edge edge = edges.get(i);
//            int from = edge.from;
//            int to = edge.to;
//
//            if (union(from, to)) {
//                mstWeight += edge.cost;
//                mstEdgeCnt++;
//
//                if (mstEdgeCnt == edges.size() - 1) {
//
//                }
//            }
//        }
//
//        System.out.println(String.format("%.2f", mstWeight));
//
//    }
//
//    static boolean union(int a, int b) {
//        int rootA = find(a);
//        int rootB = find(b);
//
//        if (rootA == rootB)
//            return false;
//
//        parent[rootB] = rootA;
//        return true;
//    }
//
//    static int find(int n) {
//        if (parent[n] != n)
//            parent[n] = find(parent[n]);
//
//        return parent[n];
//    }
//}
