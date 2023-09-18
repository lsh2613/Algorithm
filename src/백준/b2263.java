package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b2263 {

    static int n;
    static int[] inorder, postorder, preorder;
    static int preIdx;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        inorder = new int[n];
        postorder = new int[n];
        preorder = new int[n];

        inorder = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        postorder = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        getPreOrder(0, n - 1, 0, n - 1);

        Arrays.stream(preorder).forEach(i -> sb.append(i + " "));
        System.out.println(sb);
    }

    public static void getPreOrder(int inStart, int inEnd, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd)
            return;

        // 1. 루트 노드 탐색
        preorder[preIdx++] = postorder[postEnd]; // 포스트 오더의 가장 오른쪽은(post[postEnd]) 루트 노드이다.

        int pos = inStart;
        for (int i = inStart; i <= inEnd; i++) { // 인오더에서 루트 노드의 위치를 찾음
            if (inorder[i] == postorder[postEnd]) {
                pos = i;
                break;
            }
        }

        // 2. 왼쪽 서브트리 탐색
        getPreOrder(inStart, pos - 1, postStart, postStart + pos - inStart - 1);

        // 3. 오른쪽 서브트리 탐색
        getPreOrder(pos + 1, inEnd, postStart + pos - inStart, postEnd - 1);
    }
}