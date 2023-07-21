//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//class Node{
//    int parent = -1, left = -1, right = -1;
//}
//public class s1248 {
//    static StringBuilder sb = new StringBuilder();
//    static Node[] nodes;
//    static int subTreeSize = 0;
//    public static void main(String args[]) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//        int T = Integer.parseInt(br.readLine());
//        for (int test_case = 1; test_case <= T; test_case++) {
//            st = new StringTokenizer(br.readLine());
//            int N = Integer.parseInt(st.nextToken());
//            int E = Integer.parseInt(st.nextToken());
//            int a = Integer.parseInt(st.nextToken());
//            int b = Integer.parseInt(st.nextToken());
//
//            // init()
//            nodes = new Node[N + 1];
//            for (int i = 0; i <= N; i++) {
//                nodes[i] = new Node();
//            }
//
//            // 트리 초기화
//            st = new StringTokenizer(br.readLine());
//            while (st.hasMoreTokens()) {
//                int from = Integer.parseInt(st.nextToken());
//                int to = Integer.parseInt(st.nextToken());
//
//                if (nodes[from].left == -1) {
//                    nodes[from].left = to;
//                }
//                else
//                    nodes[from].right = to;
//
//                nodes[to].parent = from;
//            }
//            int commonAncestor = findCommonAncestor(a, b);
//            subTreeSize = 0;
//            getTreeSize(commonAncestor); // 전역 변수 subTreeSize에 할당
//            sb.append("#" + test_case + " " + commonAncestor + " " + subTreeSize + "\n");
//
//        }
//        System.out.println(sb);
//    }
//
//    // up의 조상 중 fix가 있는지 확인하고, 없으면 fix를 올림
//    // 위 과정을 반복
//    static int findCommonAncestor(int fix, int up) {
//        // fix가 1(루트노드)까지 왔다면 공통 조상은 루트노드임
//        while (fix != 1) {
//            int upTmp = up;
//            while (upTmp != -1) { // up이 -1이 왔다는 것은 조상이 없는 루트노드까지 도달했다는 뜻
//                if (fix != upTmp) {
//                    upTmp = nodes[upTmp].parent;
//                }
//                else {
//                    return upTmp;
//                }
//            }
//            fix = nodes[fix].parent;
//        }
//        return 1;
//    }
//
//    static void getTreeSize(int idx) {
//        subTreeSize++;
//        if (nodes[idx].left != -1) {
//            getTreeSize(nodes[idx].left);
//        }
//        if (nodes[idx].right != -1) {
//            getTreeSize(nodes[idx].right);
//        }
//    }
//}