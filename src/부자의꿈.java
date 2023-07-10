import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 부자의꿈 {
    static int[][] matrix;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 행 개수
            int M = Integer.parseInt(st.nextToken()); // 행 개수
            int Q = Integer.parseInt(st.nextToken()); // 행 개수
            matrix = new int[N + 1][M + 1]; // 행렬
            boolean[][] safeZone = new boolean[N + 1][M + 1];
            int[] maxRowIdx = new int[N + 1]; // 각 행의 최댓값
            int[] maxColIdx = new int[M + 1]; // 각 열의 최댓값
            int safeCnt = 0;

            // 행렬 값 입력, 행과 열에 대한 최댓값 측정하기 위한 초기화
            Arrays.fill(maxRowIdx,0);
            Arrays.fill(maxColIdx, 0);

            //입력 및 행과 열에 대한 최댓값 지정
            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= M; j++) {
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                    if (matrix[i][j] > matrix[i][maxRowIdx[i]]) {
                        maxRowIdx[i] = j;
                    }
                    if (matrix[i][j] > matrix[maxColIdx[j]][j]) {
                        maxColIdx[j] = i;
                    }
                }
            }
            // 바뀌기 전의 safeZone과 safeCnt 계산
            for (int r = 1; r <=N; r++) {
                for (int c = 1; c <=M; c++) {
                    if (matrix[r][maxRowIdx[r]] == matrix[maxColIdx[c]][c]) { // 각 행과 열의 최댓값이 같다면
                        safeZone[r][c] = true;
                        safeCnt++;
                    }
                }
            }

            int result = 0;
            for (int i = 0; i < Q; i++) {
                st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int value = Integer.parseInt(st.nextToken());

                boolean isSafe = safeZone[r][c];
                int prevValue = matrix[r][c];
                matrix[r][c] = value;

                if (isSafe) { // safe
                    if (prevValue <= value) { // 값이 커진 경우
                        result += safeCnt;
                        continue;
                    }
                    else { // 최댓값이었던 safeZone이 작아졌으므로 최댓값 업데이트
                        // r행의 최댓값 인덱스 찾기
                        int maxIdx = 0;
                        for (int j = 1; j <= M; j++) {
                            if (matrix[r][j] > matrix[r][maxIdx]) {
                                maxIdx = j;
                            }
                        }
                        maxRowIdx[r] = maxIdx;
                        // 찾은 행의 최댓값이 safeZone인지 판별
                        if (maxColIdx[maxRowIdx[r]] == r) {
                            safeZone[r][maxRowIdx[r]] = true;
                            safeCnt++;
                        }

                        // c열의 최댓값 인덱스 찾기
                        maxIdx = 0;
                        for (int j = 1; j <= N; j++) {
                            if (matrix[j][c] > matrix[maxIdx][c]) {
                                maxIdx = j;
                            }
                        }
                        maxColIdx[c] = maxIdx;
                        // 찾은 열의 최댓값이 safeZone인지 판별
                        if (maxRowIdx[maxColIdx[c]] == c) {
                            safeZone[c][maxColIdx[c]] = true;
                            safeCnt++;
                        }

                        // 기존 safe였던 곳의 safeZone 체크
                        if (matrix[r][maxRowIdx[r]] != matrix[maxColIdx[c]][c]) {
                            safeZone[r][c] = false;
                            safeCnt--;
                        }

                    }
                }
                else { // non-safe
                    if (value > matrix[r][maxRowIdx[r]]) { // 해당 행의 최댓값보다 커진 경우
                        if (safeZone[r][maxRowIdx[r]] == true) {
                            safeZone[r][maxRowIdx[r]] = false;
                            safeCnt--;
                        }
                        maxRowIdx[r] = c;
                    }
                    if (value > matrix[maxColIdx[c]][c]) { // 해당 열의 최댓값보다 커진 경우
                        if (safeZone[maxColIdx[c]][c] == true) {
                            safeZone[maxColIdx[c]][c] = false;
                            safeCnt--;
                        }
                        maxColIdx[c] = r;
                    }
                    if (matrix[r][maxRowIdx[r]] == matrix[maxColIdx[c]][c]) { // 해당 행과 열의 최댓값 보다 커진 경우
                        safeZone[r][c] = true;
                        safeCnt++;
                    }
                }
                result += safeCnt;
            }
            System.out.printf("#%d %d\n", tc, result);
        }
    }
}
//1
//3 3 3
//1 2 3
//4 5 6
//7 8 9
//1 1 10
//2 3 20
//1 3 15