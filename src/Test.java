//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//public class b1992 {
//    static int[][] board;
//    static StringBuilder sb = new StringBuilder();
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int n = Integer.parseInt(br.readLine());
//        board = new int[n][n];
//
//        for (int i = 0; i < n; i++) {
//            String line = br.readLine();
//            for (int j = 0; j < n; j++) {
//                board[i][j] = line.charAt(j) - '0'; // 문자를 정수로 변환
//            }
//        }
//
//        quadTree(0, n, 0, n);
//        System.out.println(sb);
//    }
//
//    static void quadTree(int left, int right, int up, int down) {
//
//        if (canCompress(left, right, up, down)) {
//            sb.append(board[up][left]);
//            return;
//        }
//
//        int midW = (left + right) / 2;
//        int midH = (up + down) / 2;
//
//        sb.append('(');
//        // 왼쪽 위
//        quadTree(left, midW, up, midH);
//        // 오른쪽 위
//        quadTree(midW, right, up, midH);
//        // 왼쪽 아래
//        quadTree(left, midW, midH, down);
//        // 오른쪽 아래
//        quadTree(midW, right, midH, down);
//        sb.append(')');
//    }
//
//    static boolean canCompress(int left, int right, int up, int down) {
//        int sample = board[up][left];
//
//        for (int i = up; i < down; i++) {
//            for (int j = left; j < right; j++) {
//                if (board[i][j] != sample)
//                    return false;
//            }
//        }
//
//        return true;
//    }
//}
