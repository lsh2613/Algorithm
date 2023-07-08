package 이코테.기출분석.그래프이론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {

    private int distance;
    private int nodeA;
    private int nodeB;

    public Edge(int distance, int nodeA, int nodeB) {
        this.distance = distance;
        this.nodeA = nodeA;
        this.nodeB = nodeB;
    }

    public int getDistance() {
        return this.distance;
    }

    public int getNodeA() {
        return this.nodeA;
    }

    public int getNodeB() {
        return this.nodeB;
    }

    // 거리(비용)가 짧은 것이 높은 우선순위를 가지도록 설정
    @Override
    public int compareTo(Edge other) {
        if (this.distance < other.distance) {
            return -1;
        }
        return 1;
    }
}
public class 도시분할계획 {

    static int[] p;
    static ArrayList<Edge> edges = new ArrayList<>();
    private static int find(int x) {
        if (p[x] == x) {
            return x;
        }
        return p[x] = find(p[x]);
    }

    private static void union(int a, int b) {
        int p1 = find(a);
        int p2 = find(b);

        if (p1 > p2)
            p[p1] = p2;
        else
            p[p2] = p1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        p = new int[V + 1];
        for (int i = 1; i <=V; i++) {
            p[i] = i;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges.add(new Edge(cost, from, to));
        }

        Collections.sort(edges);

        int result = 0;
        int lastCost = 0;
        for (int i = 0; i < E; i++) {
            Edge curEdge = edges.get(i);
            int pa = find(curEdge.getNodeA());
            int pb = find(curEdge.getNodeB());

            if (pa != pb) {
                union(pa, pb);
                int cost = curEdge.getDistance();
                result += cost;
                lastCost = cost;
            }
        }
        System.out.println(result-lastCost);

    }
}
/*
7 12
1 2 3
1 3 2
3 2 1
2 5 2
3 4 4
7 3 6
5 1 5
1 6 2
6 4 1
6 5 3
4 5 3
6 7 4
 */