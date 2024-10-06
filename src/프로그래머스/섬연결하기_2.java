//package 프로그래머스;
//
//import java.io.IOException;
//import java.util.Arrays;
//import java.util.stream.IntStream;
//
//public class 섬연결하기_2 {
//
//    public static void main(String[] args) throws IOException {
//        int n = 4;
//        int[][] costs = {
//                {0, 1, 1},
//                {0, 2, 2},
//                {1, 2, 5},
//                {1, 3, 1},
//                {2, 3, 8}
//        };
//        int result = solution(n, costs);
//        System.out.println(result);  // Expected output: 4
//    }
//
//    public static int solution(int n, int[][] costs) throws IOException {
//        Arrays.sort(costs, (i1, i2) -> i1[2] - i2[2]);
//
//    }
//
//}
