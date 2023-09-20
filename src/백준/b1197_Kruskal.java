//package 백준;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.StringTokenizer;
//
//class Edge{
//    int from;
//    int to;
//    int cost;
//
//    public Edge(int from, int to, int cost) {
//        this.from = from;
//        this.to = to;
//        this.cost = cost;
//    }
//}
//
//public class b1197_Kruskal {
//    static Edge[] edges;
//    static int[] parent;
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        int V = Integer.parseInt(st.nextToken());
//        int E = Integer.parseInt(st.nextToken());
//
//        edges = new Edge[E];
//        parent = new int[V + 1];
//        for (int i = 0; i < V + 1; i++) {
//            parent[i] = i;
//        }
//
//        for (int i = 0; i < E; i++) {
//            st = new StringTokenizer(br.readLine());
//            int from = Integer.parseInt(st.nextToken());
//            int to = Integer.parseInt(st.nextToken());
//            int cost = Integer.parseInt(st.nextToken());
//
//            edges[i] = new Edge(from, to, cost);
//        }
//
//        Arrays.sort(edges, (e1, e2) -> e1.cost - e2.cost);
//
//        int weight = 0; // 가중치
//        int mstEdges = 0; // 최소스패닝트리의 간선 갯수
//        for (int i = 0; i < E; i++) {
//            Edge edge = edges[i];
//            int from = edge.from;
//            int to = edge.to;
//            int cost = edge.cost;
//
//            if (union(from, to)) {
//                weight += cost;
//                mstEdges++;
//
//                if (mstEdges == E - 1) {
//                    break;
//                }
//            }
//        }
//
//        System.out.println(weight);
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
