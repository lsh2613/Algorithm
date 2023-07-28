//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.StringTokenizer;
//
//public class Solution {
//    //LCA를 구해야합니다.
//    //parent가 정해져서 나온다.
//    static ArrayList<Integer>[] tree;
//    static int[] depth;
//    static int[][] parent;
//    static int maxLevel;
//    static int[] order;
//    static int N;
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//        StringBuilder sb = new StringBuilder();
//        int T = Integer.parseInt(br.readLine());
//        for (int tt = 1; tt <= T; tt++) {
//            sb.append('#').append(tt).append(' ');
//            N = Integer.parseInt(br.readLine());
//            maxLevel = calcMaxLevel(N) + 1;
//            depth = new int[N+1];
//            parent = new int[N + 1][maxLevel];
//            tree = new ArrayList[N+1];
//            order = new int[N];
//            for (int i = 0; i < N + 1; i++) tree[i] = new ArrayList<Integer>();
//
//            st = new StringTokenizer(br.readLine());
//            for(int i= 2;i<N+1;i++){
//                int p = Integer.parseInt(st.nextToken());
//                parent[i][0] = p;
//                tree[p].add(i);
//            }
//
//            //BFS with height And parent init
//            Queue<Integer> queue = new LinkedList<Integer>();
//            queue.add(1);
//            int idx =0 ;
//            while (!queue.isEmpty()) {
//                int cur = queue.poll();
//                order[idx++] = cur;
//                //parent 배열 계산
//                for(int i =1;i<maxLevel;i++){
//                    parent[cur][i] = parent[parent[cur][i-1]][i-1];
//                }
//                for (int nxt : tree[cur]) {
//                    depth[nxt] = depth[cur] +1;
//                    queue.add(nxt);
//                }
//            }
//            //LCA  항상 i가 i+1보다 depth가 낮음. 항상 always
//            //구한 bfs순서대로 lca 질의를 통해 답을 알아내도록 합시다.
//            long ans =0;
//            for(int i =0;i<N-1;i++){
//                int lca = LCA(order[i], order[i + 1]);
//                ans += (depth[order[i]] - depth[lca]) + (depth[order[i + 1]] - depth[lca]);
//            }
//            sb.append(ans).append('\n');
//        }
//        System.out.print(sb);
//    }
//    public static int LCA(int a, int b){
//        //높이를 맞춰주어야겟죠
//        for(int i =maxLevel;i>=0;i--){
//            if(((depth[b] - depth[a])&1<<i)>0){
//                b = parent[b][i];
//            }
//        }
//        if(b==a) return a;
//        for(int i = maxLevel-1;i>=0;i--){
//            if (parent[a][i] != parent[b][i]) {
//                a = parent[a][i];
//                b = parent[b][i];
//            }
//        }
//        return parent[a][0];
//    }
//
//
//    public static int calcMaxLevel(int n) {
//        double log2 = Math.log(n)/Math.log(2);
//        return (int) Math.ceil(log2);
//    }
//}