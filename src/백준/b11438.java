package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class b11438 {

    static int N, M;
    static List<Integer>[] tree;
    static int[] depths;
    static int[][] parents;
    static int heightOfTree;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        // init
        tree = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }
        heightOfTree = (int) ceil(log(N) / log(2));
        depths = new int[N + 1];
        parents = new int[N + 1][heightOfTree];

        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            tree[from].add(to);
            tree[to].add(from);
        }

        // 루트는 1번이므로 1번부터 depths[]와 해당 parents[][0]: 해당 노드의 바로 윗 단계 parent 부모 설정
        initRecur(1, 1, 0);
        fillAncestor();

        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(LCA(a, b) + "\n");
        }

        System.out.println(sb);
    }

    static void initRecur(int idx, int depth, int parent) {
        depths[idx] = depth;
        for (int adj : tree[idx]) {
            // 다시 부모로 방문하는 것을 방지, visited 역할
            if (adj != parent) {
                initRecur(adj, depth + 1, idx);
                parents[adj][0] = idx;
            }
        }
    }

    // 부모의 부모를 탐색하며 parents[][1~h]: 조상 노드값 채우기
    static void fillAncestor() {
        for (int h = 1; h < heightOfTree; h++) {
            for (int idx = 1; idx < N + 1; idx++) {
                parents[idx][h] = parents[parents[idx][h - 1]][h - 1];
            }
        }
    }

    static int LCA(int a, int b) {
        int ah = depths[a];
        int bh = depths[b];

        // ah > bh로 세팅
        if(ah < bh) {
            int tmp = a;
            a = b;
            b = tmp;
        }

        // a가 b보다 아래에 있다면 b와 같은 깊이로 올려줌
        for (int h = heightOfTree; h >= 0; h--) {
            if (pow(2, h) <= depths[a] - depths[b]) { // 트리의 성질
                a = parents[a][h];
            }
        }

        if (a == b) {
            return a; // or b
        }

        // a와 b의 부모가 같아질 때까지 a와 b를 부모 노드로 승격
        for (int h = heightOfTree - 1; h >= 0; h--) {
            if (parents[a][h] != parents[b][h]) {
                a = parents[a][h];
                b = parents[b][h];
            }
        }

        return parents[a][0]; // or parent[b][0]
    }
}
