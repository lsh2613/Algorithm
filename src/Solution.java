import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node{
    int parent, left = -1, right;
}
class Solution {
    static StringBuilder sb = new StringBuilder();
    static Node[] nodes;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            nodes = new Node[N + 1];

            // 트리 초기화
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                if (nodes[from].left == -1) {
                    nodes[from].left = to;
                }
                else
                    nodes[from].right = to;

                nodes[to].parent = from;
            }
            findCommonAncestor(a, b);

            sb.append("#" + test_case + " "  + "\n");
        }
        System.out.println(sb);
    }

    // fix의 조상 중 up이 있는지 확인하고, 없으면 up을 올림
    // 위 과정을 반복
    static void findCommonAncestor(int up, int fix) {

    }
}