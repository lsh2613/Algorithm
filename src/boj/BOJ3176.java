/**
 * 못풀겠다 다음에 풀어보자
 */

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
//class City {
//    int to;
//    int distance;
//
//    public City(int to, int distance) {
//        this.to = to;
//        this.distance = distance;
//    }
//}
//
//public class BOJ3176 {
//    static int N;
//    static List<City>[] tree;
//    static int heightOfTree;
//    static int[] depths;
//    static int[][] parents;
//    static StringBuilder sb = new StringBuilder();
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        N = Integer.parseInt(br.readLine());
//
//        //init
//        tree = new ArrayList[N + 1];
//        for (int i = 1; i <= N; i++) {
//            tree[i] = new ArrayList<>();
//        }
//        heightOfTree = (int) ceil(log(N) / log(2));
//        depths = new int[N + 1];
//        parents = new int[N + 1][heightOfTree];
//
//        StringTokenizer st;
//        for (int i = 0; i < N - 1; i++) {
//            st = new StringTokenizer(br.readLine());
//            int from = Integer.parseInt(st.nextToken());
//            int to = Integer.parseInt(st.nextToken());
//            int dist = Integer.parseInt(st.nextToken());
//
//            tree[from].add(new City(to, dist));
//            tree[to].add(new City(from, dist));
//        }
//        initDepthsAndParents(1, 1, 0);
//        fillAncestor();
//
//        int K = Integer.parseInt(br.readLine());
//        for (int i = 0; i < K; i++) {
//            st = new StringTokenizer(br.readLine());
//            int D = Integer.parseInt(st.nextToken());
//            int E = Integer.parseInt(st.nextToken());
//
//            appendMinAndMax(D, E);
//        }
//
//        System.out.println(sb);
//    }
//
//    static void appendMinAndMax(int d, int e) {
//        int lca = getLCA(d, e);
//        int min = Integer.MAX_VALUE;
//        int max = Integer.MIN_VALUE;
//
//        // d와 e를 인덱스로 가지는 노드부터 시작하여 LCA로 이동할 때까지의 최솟값과 최댓값을 구해줘
//        // d에서 LCA로 이동
//        while (d != lca) {
//            for (City city : tree[d]) {
//                if (city.to == parents[d][0]) {
//                    min = Math.min(min, city.distance);
//                    max = Math.max(max, city.distance);
//                    break;
//                }
//            }
//            d = parents[d][0];
//        }
//
//        // e에서 LCA로 이동
//        while (e != lca) {
//            for (City city : tree[e]) {
//                if (city.to == parents[e][0]) {
//                    min = Math.min(min, city.distance);
//                    max = Math.max(max, city.distance);
//                    break;
//                }
//            }
//            e = parents[e][0];
//        }
//
//        // 최솟값과 최댓값 출력
//        sb.append(min).append(" ").append(max).append("\n");
//    }
//
//    static int getLCA(int d, int e) {
//        int dh = depths[d];
//        int eh = depths[e];
//
//        // ah > bh로 세팅
//        if (dh < eh) {
//            int tmp = d;
//            d = e;
//            e = tmp;
//        }
//
//        // a가 b보다 아래에 있다면 b와 같은 깊이로 올려줌
//        for (int h = heightOfTree; h >= 0; h--) {
//            if (pow(2, h) <= depths[d] - depths[e]) { // 트리의 성질
//                d = parents[d][h];
//            }
//        }
//
//        if (d == e) {
//            return d; // or b
//        }
//
//        // a와 b의 부모가 같아질 때까지 a와 b를 부모 노드로 승격
//        for (int h = heightOfTree - 1; h >= 0; h--) {
//            if (parents[d][h] != parents[e][h]) {
//                d = parents[d][h];
//                e = parents[e][h];
//            }
//        }
//
//        return parents[d][0]; // or parent[b][0]
//    }
//
//    static void fillAncestor() {
//        for (int h = 1; h < heightOfTree; h++) {
//            for (int idx = 1; idx <= N; idx++) {
//                parents[idx][h] = parents[parents[idx][h - 1]][h - 1];
//            }
//        }
//    }
//
//    static void initDepthsAndParents(int idx, int depth, int parent) {
//        depths[idx] = depth;
//        for (City adjCity : tree[idx]) {
//            int adjIdx = adjCity.to;
//            if (adjIdx != parent) { // 재방문 방지
//                initDepthsAndParents(adjCity.to, depth + 1, idx);
//                parents[adjIdx][0] = idx;
//            }
//        }
//    }
//}


package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Math.*;

class City {
    int to;
    int distance;

    public City(int to, int distance) {
        this.to = to;
        this.distance = distance;
    }
}

public class BOJ3176 {
    static int N;
    static int[][] tree;
    static int heightOfTree;
    static int[] depths;
    static int[][] parents;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        //init
        tree = new int[N + 1][N + 1];
        heightOfTree = (int) ceil(log(N) / log(2));
        depths = new int[N + 1];
        parents = new int[N + 1][heightOfTree];

        StringTokenizer st;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            tree[from][to] = dist;
            tree[to][from] = dist;
        }
        initDepthsAndParents(1, 1, 0);
        fillAncestor();

        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int D = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            appendMinAndMax(D, E);
        }

        System.out.println(sb);
    }

    static void appendMinAndMax(int d, int e) {
        int lca = getLCA(d, e);
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        // d와 e를 인덱스로 가지는 노드부터 시작하여 LCA로 이동할 때까지의 최솟값과 최댓값을 구해줘
        while (d != lca) {
            min = Math.min(min, tree[d][parents[d][0]]);
            max = Math.max(max, tree[d][parents[d][0]]);
            d = parents[d][0];
        }
        while (e != lca) {
            min = Math.min(min, tree[e][parents[e][0]]);
            max = Math.max(max, tree[e][parents[e][0]]);
            e = parents[e][0];
        }

        // 최솟값과 최댓값 출력
        sb.append(min).append(" ").append(max).append("\n");
    }

    static int getLCA(int d, int e) {
        int dh = depths[d];
        int eh = depths[e];

        // ah > bh로 세팅
        if (dh < eh) {
            int tmp = d;
            d = e;
            e = tmp;
        }

        // a가 b보다 아래에 있다면 b와 같은 깊이로 올려줌
        for (int h = heightOfTree; h >= 0; h--) {
            if (pow(2, h) <= depths[d] - depths[e]) { // 트리의 성질
                d = parents[d][h];
            }
        }

        if (d == e) {
            return d; // or b
        }

        // a와 b의 부모가 같아질 때까지 a와 b를 부모 노드로 승격
        for (int h = heightOfTree - 1; h >= 0; h--) {
            if (parents[d][h] != parents[e][h]) {
                d = parents[d][h];
                e = parents[e][h];
            }
        }

        return parents[d][0]; // or parent[b][0]
    }

    static void fillAncestor() {
        for (int h = 1; h < heightOfTree; h++) {
            for (int idx = 1; idx <= N; idx++) {
                parents[idx][h] = parents[parents[idx][h - 1]][h - 1];
            }
        }
    }

    static void initDepthsAndParents(int idx, int depth, int parent) {
        depths[idx] = depth;
        for (int i = 1; i < N + 1; i++) {
            if (tree[idx][i] != 0 && i != parent) { // 재방문 방지
                initDepthsAndParents(i, depth + 1, idx);
                parents[i][0] = idx;
            }
        }
    }
}
