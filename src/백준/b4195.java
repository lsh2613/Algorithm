package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class b4195 {
    static int[] parent; // 유니온 파인드 루트 노드 배열
    static int[] groupCnt; // 그룹의 인원

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            int N = Integer.parseInt(br.readLine());

            parent = new int[N * 2];
            groupCnt = new int[N * 2];
            for (int i = 0; i < N * 2; i++) {
                parent[i] = i;
                groupCnt[i] = 1;
            }

            int idx = 0;
            Map<String, Integer> parentMap = new HashMap<>();

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                String friendA = st.nextToken();
                String friendB = st.nextToken();

                if (!parentMap.containsKey(friendA))
                    parentMap.put(friendA, idx++);
                if (!parentMap.containsKey(friendB))
                    parentMap.put(friendB, idx++);

                sb.append(union(parentMap.get(friendA), parentMap.get(friendB)) + "\n");
            }
        }

        System.out.println(sb);
    }

    public static int union(int friendA, int friendB) {
        int rootA = find(friendA);
        int rootB = find(friendB);

        /* case1
        if (rootA > rootB) {
            parent[rootA] = rootB;
            groupCnt[rootB] += groupCnt[rootA];
        }
        if (rootA < rootB) {
            parent[rootB] = rootA;
            groupCnt[rootA] += groupCnt[rootB];
        }
        */

        // case2
        if (rootA != rootB) {
            parent[rootB] = rootA;
            groupCnt[rootA] += groupCnt[rootB];
        }

        return groupCnt[rootA]; // or return groupCnt(rootB);
    }

    public static int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }
}