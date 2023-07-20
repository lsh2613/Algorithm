import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class s1232 {
    static StringBuilder sb = new StringBuilder();
    static String[] nodes;
    static ArrayList<ArrayList<Integer>> child = new ArrayList<>();
    static int n;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int test_case = 1; test_case <= 10; test_case++) {
            n = Integer.parseInt(br.readLine());
            nodes = new String[n + 1];
            child.clear();
            for (int i = 0; i <= n; i++) {
                child.add(new ArrayList<>());
            }

            // 트리 초기화
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int idx = Integer.parseInt(st.nextToken());
                String val = st.nextToken();
                while (st.hasMoreTokens()) {
                    child.get(idx).add(Integer.parseInt(st.nextToken()));
                }
                nodes[idx] = val;
            }

            sb.append("#" + test_case + " " + (int) cal(1, nodes[1]) + "\n");
        }
        System.out.println(sb);
    }

    static double cal(int idx, String val) {
        if (!child.get(idx).isEmpty()) {
            int leftIdx = child.get(idx).get(0);
            int rightIdx = child.get(idx).get(1);
            if (val.equals("+")) {
                return cal(leftIdx, nodes[leftIdx]) + cal(rightIdx, nodes[rightIdx]);
            }
            if (val.equals("-")) {
                return cal(leftIdx, nodes[leftIdx]) - cal(rightIdx, nodes[rightIdx]);
            }
            if (val.equals("*")) {
                return cal(leftIdx, nodes[leftIdx]) * cal(rightIdx, nodes[rightIdx]);
            }
            if (val.equals("/")) {
                return cal(leftIdx, nodes[leftIdx]) / cal(rightIdx, nodes[rightIdx]);
            }
        }
        // val이 피연산자인 경우
        return Double.parseDouble(val);
    }
}
